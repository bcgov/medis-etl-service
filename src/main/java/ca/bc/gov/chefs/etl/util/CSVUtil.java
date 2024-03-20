package ca.bc.gov.chefs.etl.util;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.core.model.IModel;

public class CSVUtil {

	public static void main(String[] args) {
			}

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

	public static Map<String, List<List<String>>> removeAllNullKeys(Map<String, List<List<String>>> map){
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
	 *  Replaces any found line breaks with a whitespace
	 *  
	 *  @deprecated
	 *  This method isn't null safe and doesn't handle all possible characters.
	 *  Use {@link CSVUtil#replaceCarriageReturnLineFeed(String)} instead.
	 */
	@Deprecated
	public static String replaceLineBreaks(String data){
		return data.replaceAll("\\R", " ");
	}
	
	public static String replaceCarriageReturnLineFeed(String data) {
	    if (StringUtils.isBlank(data)) {
	        return data;
	    }
	    return data.replaceAll("\\r\\n|\\r|\\n", " ");
	}

	public static String getFormattedDate(String date) {
	    if (StringUtils.isBlank(date)) {
	        return date;
	    }
		try {
//		String isoDate = date;
//		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		SimpleDateFormat targetFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//		String targetDate = targetFormat.format(isoFormat.parse(isoDate));
//		System.out.println(targetDate);
		
    		String dateTimeString = date;
            OffsetDateTime dateTime = OffsetDateTime.parse(dateTimeString);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String formattedDateTime = dateTime.format(formatter);
    		return formattedDateTime;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
