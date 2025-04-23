package ca.bc.gov.chefs.etl.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.core.model.IModel;

public class CSVUtil {

	public static Map<String, List<List<String>>> provider(List<IModel> items) {
		Map<String, List<List<String>>> map = new HashMap<>();
		for (IModel item : items) {
			Queue<IModel> children = new LinkedList<>();
			children.addAll(item.getObjects());
			List<List<String>> parentLs = map.getOrDefault(item.getFormType(), new ArrayList<>());
			parentLs.add(item.getCsvElements());
			map.put(item.getFormType(), parentLs);
			while (!children.isEmpty()) {
				IModel model = children.poll();
				List<List<String>> ls = map.getOrDefault(model.getFormType(), new ArrayList<>());
				ls.add(model.getCsvElements());
				map.put(model.getFormType(), ls);
				List<IModel> nestedChildren = model.getObjects();
				if (nestedChildren.size() == 0) {
					continue;
				}
				children.addAll(nestedChildren);
			}
		}
		return map;
	}

	public static Map<String, List<List<String>>> removeAllNullKeys(Map<String, List<List<String>>> map) {
		Iterator<Map.Entry<String, List<List<String>>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, List<List<String>>> entry = iterator.next();
			if (entry.getKey() == null) {
				iterator.remove();
			}
		}
		return map;
	}

	/**
	 * Replaces any found line breaks with a whitespace
	 * 
	 * @deprecated
	 *             This method isn't null safe and doesn't handle all possible
	 *             characters.
	 *             Use {@link CSVUtil#replaceCarriageReturnLineFeed(String)}
	 *             instead.
	 */
	@Deprecated
	public static String replaceLineBreaks(String data) {
		return data.replaceAll("\\R", " ");
	}

	public static String replaceCarriageReturnLineFeed(String data) {
		if (StringUtils.isEmpty(data)) {
			return data;
		}
		return data.replaceAll("\\r\\n|\\r|\\n", " ");
	}

	/**
	 * Replaces any found line breaks with a whitespace
	 * 
	 * @deprecated
	 *             This method swallows errors and doesn't handle all possible CHEFS
	 *             formats.
	 *             Use {@link CSVUtil#formatDate(String)} instead.
	 */
	@Deprecated
	public static String getFormattedDate(String date) {
		if (StringUtils.isBlank(date)) {
			return date;
		}
		try {
			// String isoDate = date;
			// SimpleDateFormat isoFormat = new
			// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			// SimpleDateFormat targetFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			// String targetDate = targetFormat.format(isoFormat.parse(isoDate));
			// System.out.println(targetDate);
			String dateTimeString = date;
			// if dateTimeString is in the format '2024-03-31' convert to ISO
			if (dateTimeString.length() == 10) {
				dateTimeString = dateTimeString + "T12:00:00.000Z";
			}
			OffsetDateTime dateTime = OffsetDateTime.parse(dateTimeString);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			String formattedDateTime = dateTime.format(formatter);
			return formattedDateTime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String formatDate(String date) {
		if (StringUtils.isBlank(date)) {
			return date;
		}

		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		// Handle dates without time component. E.g. 2018-10-25
		if (date.length() == 10) {
			LocalDateTime dateTime = LocalDate.parse(date).atTime(0, 0);
			return dateTime.format(outputFormatter);
		} else if (date.length() == 22) {
			// Handle dates without time zone offset. E.g. 2024-06-30 12:00:00 AM
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
			LocalDateTime dateTime = LocalDateTime.parse(date, inputFormatter);
			return dateTime.format(outputFormatter);
		} else {
			OffsetDateTime dateTime = OffsetDateTime.parse(date);
			return dateTime.format(outputFormatter);
		}

	}

	/*
	 * This method takes a date string in the format "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
	 * and remove the timestamp part, returning only the date in the format "yyyy-MM-dd".
	 */
	public static String formatDateRemoveTime(String date) {
		if (StringUtils.isBlank(date)) {
			return date;
		}
		String[] parts = date.split("T");
		if (parts.length > 0) {
			return parts[0];
		}
		return date;
	}

	/*
	 * This method takes fiscal year in the format 2025/26 and convert it into 2025.2026
	 */
	public static String formatFiscalYearPOLY(String fiscalYear) {
		if (StringUtils.isBlank(fiscalYear)) {
			return fiscalYear;
		}
		String[] parts = fiscalYear.split("/");
		if (parts.length > 1) {
			int firstYear = Integer.parseInt(parts[0]);
			int secondYear = Integer.parseInt(parts[1]);
			// If second year is less than first year's last two digits, it's in the next century
			int century = (secondYear < firstYear % 100) ? (firstYear / 100 + 1) * 100 : (firstYear / 100) * 100;
			return parts[0] + "." + (century + secondYear);
		}
		return fiscalYear;
	}

	public static BigDecimal parseBigDecimal(String number) {
		return StringUtils.isNotBlank(number) ? new BigDecimal(number) : BigDecimal.ZERO;
	}

	public static String formatBigDecimal(BigDecimal decimal) {
		return Objects.toString(decimal, "");
	}
	
	public static Boolean isNonZero(String number) {
		return StringUtils.isNotBlank(number) && new BigDecimal(number).compareTo(BigDecimal.ZERO) > 0;
	}

}
