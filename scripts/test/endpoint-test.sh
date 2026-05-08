#!/usr/bin/env zsh

PORT_1="$1"
PORT_2="$2"
ENDPOINT="$3"
BODY="$4"

# Print the body passed for the user to review
echo "-----Request Body-----"
echo "$BODY"

# Iterate over both endpoints and query each
URIS=("http://localhost:$PORT_1$ENDPOINT" "http://localhost:$PORT_2$ENDPOINT")
RESPONSES=()
for URI in ${URIS[@]}; do
    echo "-----$URI-----"
    RAW="$(curl -s -X POST -H "Content-type: application/json" -d "$BODY" "$URI")"
    if [[ -z "$RAW" ]]; then
        echo "Empty response from $URI"
        continue
    fi
    RESPONSE="$(echo "$RAW" | python3 -m json.tool)"
    echo "$RESPONSE"
    RESPONSES+=("$RESPONSE")
done

# Print the difference between the two responses
if [ ${#RESPONSES[@]} -eq 2 ]; then
    echo "-----diff-----"
    diff <(echo ${RESPONSES[1]}) <(echo ${RESPONSES[2]})
fi