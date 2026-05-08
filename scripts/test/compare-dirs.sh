#!/usr/bin/env zsh

# -e, exit immediately upon non-zero status
# -u, treat unset variables as an error
# -o pipefail, return error code of first command in a pipeline
set -euo pipefail

# Throw an error if 2 directories are not specified
if (( $# != 2)); then
	echo "Usage: $0 <directory-a> <directory-b>" >&2
	exit 2
fi

# Verify directories exist
dir_a="$1"
dir_b="$2"

directories=($dir_a $dir_b)
for dir in ${directories[@]}; do
	if [[ ! -d "$dir" ]]; then
		echo "Directory \"$dir\" does not exist" >&2
	exit 2
	fi
done

# Removes columns which would never match
# These columns typically contain an id that is randomly generated each request
remove_columns() {
	column_names=(
		"EXPENSE_ID"
		"BUDGET_ID"
		"PC_PATIENT_SERVICES_RECORD_ID"
		"HR_RECORD_ID"
		"PRAC_ROLE_RECORD_ID"
		"COMMENT_ID"
		"COMMUNITY_ID"
		"CLINIC_ID"
		"PRIMARY_CARE_NETWORK_ID"
		"PRIMARY_CARE_INITIATIVE_ID"
		"ST_UPCC_ID"
		"ST_CHC_ID"
		"ISSUE_ID"
		"ST_FNPCC_ID"
		"ST_PCN_ID"
		"ST_NPPCC_ID"
	)
	file="$1"
	silent="$2"

	file_content="$(cat "$file")"
	for column_name in ${column_names[@]}; do
		header=$(echo "$file_content" | head -n 1)

		# Search for the column to be removed in the header of the file
		column_index=$(echo "$header" | awk -F, -v target="$column_name" '
		{
			for (i = 1; i <= NF; i++) {
				field = $i
				gsub(/^"|"$/, "", field)
				gsub(/\r$/, "", field)

				if (field == target) {
					print i
					exit
				}
			}
		}')

		column_count=$(echo "$header" | awk -F, '{ printf NF }')

		# Make sure there is a column index and columns before attempting to remove a column.
		if [ ! -z "$column_index" ] && [ "$column_count" -ge 1 ]; then
			if [ "$column_count" -eq 1 ]; then
				# If there is only one column and a column index was found then the resulting file would be empty.
				echo "Only one column, emptying: ${file##*/}" >&2
				file_content=(echo "")
			else
				if [ "$silent" = false ]; then
					echo "REMOVING COLUMN: $column_name from ${file##*/}" >&2
				fi

				# Perform the cut operation to remove the undesired column
				if [ "$column_index" -eq 1 ]; then
					fields="2-"
				elif [ "$column_index" -eq "$column_count" ]; then
					fields="1-$(($column_count - 1))"
				else
					fields="1-$(($column_index-1)),$(($column_index+1))-"
				fi
				file_content="$(echo "$file_content" | cut -d , -f "$fields")"
			fi
		fi	
	done

	echo "$file_content"
}

# Determine which hashing command to use
hash_file() {
	local file="$1"

	if (( $+commands[sha256sum] )); then
		remove_columns "$file" false | sha256sum | awk '{ print $1 }'
	else
		remove_columns "$file" false | shasum -a 256 | awk '{ print $1 }'
	fi
}

# Create temporary file and delete it when the script exits
tmp_index_b="$(mktemp)"
tmp_index_a="$(mktemp)"
trap 'rm -f "$tmp_index_b" "$tmp_index_a"' EXIT

# Store the file hashes in an index file for fast lookup
index_files() {
	index="$1"
	dir="$2"

	echo "Indexing files in $dir"

	while IFS= read -r -d '' file; do
		hash="$(hash_file "$file")"
		echo "$hash\t$file" >> "$index"
	done < <(find "$dir" -type f -name "*.txt" -print0)
}

# Compare the files between the two directories
# Print the number of files and the number of matches
compare_files() {
	index="$1"
	dir="$2"
	match_num=0

	while IFS= read -r -d '' file; do
		file_hash="$(hash_file "$file")"

		matches=()

		# Search for a hash in the index which matches the current files hash
		while IFS= read -r tmp_file; do
			matches+=("$tmp_file")
		done < <(awk -F '\t' -v h="$file_hash" '$1 == h { print $2 }' "$index")

		if (( ${#matches[@]} == 0)); then
			echo "NO MATCH FOR: ${file##*/}" >&2
			continue
		fi

		# Verify that not only do the hashes match, but that the diff matches as well
		for tmp_file in "${matches[@]}"; do
			diff_output=""
			if ! diff_output="$(diff -u -- <(remove_columns $file true) <(remove_columns $tmp_file true))"; then
				echo "Hashes match but diff detected (${file##*/}, ${tmp_file##*/})" >&2
				diff "$file" "$tmp_file" >&2
			else
				echo "MATCH: (${file##*/}, ${tmp_file##*/})" >&2
				match_num=$((match_num + 1))
			fi
		done
	done < <(find "$dir" -type f -name "*.txt" -print0)

	echo "TOTAL FILES: $(find "$dir" -type f -name "*.txt" | wc | awk '{ print $1 }')"
	echo "TOTAL MATCHES: $match_num"
}

file_comparison() {
	index="$1"
	dir_1="$2"
	dir_2="$3"

	echo "Comparing text files in $dir_1 and $dir_2"
	compare_files "$index" "$dir_1"
}

# Begin the directory comparison process
echo "-----"
index_files "$tmp_index_b" "$dir_b"
echo ""
file_comparison "$tmp_index_b" "$dir_a" "$dir_b"
echo "-----"

echo "-----"
index_files "$tmp_index_a" "$dir_a"
echo ""
file_comparison "$tmp_index_a" "$dir_b" "$dir_a"
echo "-----"
