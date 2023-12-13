package ca.bc.gov.chefs.etl.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;

public class JsonUtil {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static <T> T parseJsonString(String json, Class<T> clazz) throws Exception {
        return mapper.readValue(json, clazz);
    }
	
	public static String preProcess(String payload){
		// The following code aims to replace occurences of "subTypeX":"" with "subTypeX":{}, as "subTypeX" is expected to be
		// an object (can be empty) and not a String. 
		String result = payload.replaceAll("\"(subType\\d*)\":\"\"", "\"$1\":{}");
		return result;
	}

	public static String normalizeEmptyStringArrays(String payload){
		// The following code aims to replace occurences of "nppcc":"[{}]" with "nppcc":[], as "nppcc" is expected to be
		// a String array and not an object. 
        String NppccPattern = "\"nppccName\":\\[\\{\\}\\]";
        String NppccReplacement = "\"nppccName\": []";

        String pcnPattern =  "\"pcnNames\":\\[\\{\\}\\]";
        String pcnReplacement = "\"pcnNames\": []";

        String upccPattern =  "\"upccName\":\\[\\{\\}\\]";
        String upccReplacement = "\"upccName\": []";

        String chcPattern =  "\"chcName\":\\[\\{\\}\\]";
        String chcReplacement = "\"chcName\": []";

        String fnpccPattern =  "\"fnpccName\":\\[\\{\\}\\]";
        String fnpccReplacement = "\"fnpccName\": []";

		String result = payload.replaceAll(NppccPattern, NppccReplacement);
        result = result.replaceAll(pcnPattern, pcnReplacement);
        result = result.replaceAll(upccPattern, upccReplacement);
        result = result.replaceAll(chcPattern, chcReplacement);
        result = result.replaceAll(fnpccPattern, fnpccReplacement);
		return result;
	}

    public static String ltcYTDBackwardCompatibility(String payload){
        for (Map.Entry<String, String> entry : Constants.LTC_YTD_OLD_KEYS_COMPATIBILITY.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            payload = payload.replace(key, value);
        }
        return payload;
    }

	public static String roundDigitsNumber(String payload){

        // Regular expression pattern to match numbers with at least one digit before the decimal point and at least three digits after the decimal point.
        String pattern = "\\b\\d+\\.\\d{3,}\\b";
        
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(payload);

        // Iterate over matches and replace with numbers with 2 decimal places
        StringBuffer output = new StringBuffer();
        while (matcher.find()) {
            //String matchedNumber = matcher.group();
            BigDecimal matchedNumber = new BigDecimal(matcher.group());
            BigDecimal roundedNumber = matchedNumber.setScale(2, RoundingMode.HALF_UP);
            String roundedString = roundedNumber.toString();
            matcher.appendReplacement(output, roundedString);
        }
        matcher.appendTail(output);

		return output.toString();
	}
}
