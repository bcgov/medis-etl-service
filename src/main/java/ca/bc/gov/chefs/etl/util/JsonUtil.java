package ca.bc.gov.chefs.etl.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static <T> T parseJsonString(String json, Class<T> clazz) throws Exception {
        return mapper.readValue(json, clazz);
    }

    public static String preProcess(String payload) {
        // The following code aims to replace occurences of "subTypeX":"" with
        // "subTypeX":{}, as "subTypeX" is expected to be
        // an object (can be empty) and not a String.
        return payload.replaceAll("\"(subType\\d*)\":\"\"", "\"$1\":{}");
    }

    public static String getPeriodicField(Object o, String name, Integer index)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
            SecurityException {
        // The following code aims to make it possible to dynamically access a field
        // with
        // a Period suffix. For example, if the name is "uniquePatients" and the period
        // is "P1",
        // the code will access the field "uniquePatientsP1" of the object.
        if (o.getClass().getDeclaredField(name + "P" + index).get(o) == null) {
            return null;
        }
        return o.getClass().getDeclaredField(name + "P" + index).get(o).toString();
    }

    public static String normalizeEmptyStringArrays(String payload) {
        // The following code aims to replace occurences of "nppcc":"[{}]" with
        // "nppcc":[], as "nppcc" is expected to be
        // a String array and not an object.
        String NppccPattern = "\"nppccName\":\\[\\{\\}\\]";
        String NppccReplacement = "\"nppccName\": []";

        String pcnPattern = "\"pcnNames\":\\[\\{\\}\\]";
        String pcnReplacement = "\"pcnNames\": []";

        String upccPattern = "\"upccName\":\\[\\{\\}\\]";
        String upccReplacement = "\"upccName\": []";

        String chcPattern = "\"chcName\":\\[\\{\\}\\]";
        String chcReplacement = "\"chcName\": []";

        String fnpccPattern = "\"fnpccName\":\\[\\{\\}\\]";
        String fnpccReplacement = "\"fnpccName\": []";

        String result = payload.replaceAll(NppccPattern, NppccReplacement);
        result = result.replaceAll(pcnPattern, pcnReplacement);
        result = result.replaceAll(upccPattern, upccReplacement);
        result = result.replaceAll(chcPattern, chcReplacement);
        result = result.replaceAll(fnpccPattern, fnpccReplacement);
        return result;
    }

    public static String ltcYTDBackwardCompatibility(String payload) {
        for (Map.Entry<String, String> entry : Constants.LTC_YTD_OLD_KEYS_COMPATIBILITY
                .entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            payload = payload.replace(key, value);
        }
        return payload;
    }

    public static String roundDigitsNumber(String payload) {

        // Regular expression pattern to match numbers with at least one digit before
        // the decimal point and at least three digits after the decimal point.
        String pattern = "\\b\\d+\\.\\d{3,}\\b";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(payload);

        // Iterate over matches and replace with numbers with 2 decimal places
        StringBuffer output = new StringBuffer();
        while (matcher.find()) {
            // String matchedNumber = matcher.group();
            BigDecimal matchedNumber = new BigDecimal(matcher.group());
            BigDecimal roundedNumber = matchedNumber.setScale(2, RoundingMode.HALF_UP);
            String roundedString = roundedNumber.toString();
            matcher.appendReplacement(output, roundedString);
        }
        matcher.appendTail(output);

        return output.toString();
    }

    public static String fixExpenseItemAndSubType(String payload) {
        // The following code aims to replace occurrences of "expenseItem": {} with
        // "expenseItem": "", as "expenseItem"
        // is expected to be a String and not an object.
        String result = payload.replaceAll("(\"expenseItem\":\\s*)\\{\\}", "$1\"\"");
        // The following code aims to replace occurrences of "expenseItemSubType": {}
        // with "expenseItemSubType": "", as "expenseItemSubType"
        // is expected to be a String and not an object.
        result = result.replaceAll("(\"expenseItemSubType\":\\s*)\\{\\}", "$1\"\"");
        return result;
    }

    public static String ltcFacilityBackwardCompatibility(String payload) {
        String regexOwnerAddress = "\"ownerAddress\":\\s*\"([^\"]*)\"";
        String replacementOwnerAddress =
                "\"ownerAddress\": {\"geometry\": {\"coordinates\": [0, 0]}, \"properties\": {\"fullAddress\": \"$1\"}}";
        String regexOperatorAddress = "\"operatorAddress\":\\s*\"([^\"]*)\"";
        String replacementOperatotAddress =
                "\"operatorAddress\": {\"geometry\": {\"coordinates\": [0, 0]}, \"properties\": {\"fullAddress\": \"$1\"}}";
        return payload.replaceAll(regexOwnerAddress, replacementOwnerAddress)
                .replaceAll(regexOperatorAddress, replacementOperatotAddress);
    }

    public static String fixPcnName(String payload) {
        // The following code aims to replace occurences of "pcn":"[]" with "pcn": "",
        // as "pcn" is expected to be
        // a String array and not an array
        String pcnPattern = "\"pcnName\":\\[\\]";
        String pcnReplacement = "\"pcnName\": \"\"";

        String result = payload.replaceAll(pcnPattern, pcnReplacement);
        return result;
    }

    /**
     * Does some basic cleanup/conversion of common Unicode characters which aren't allowed in the
     * target ASCII database.
     * 
     * @param payload
     * @return
     */
    public static String fixUnicodeCharacters(String payload) {
        // The following chars are common in copy/paste from Word/Excel
        String result = StringUtils.replaceChars(payload, "‘", "'");
        result = StringUtils.replaceChars(result, "’", "'");
        result = RegExUtils.replaceAll(result, "“", "\\\\\"");
        result = RegExUtils.replaceAll(result, "”", "\\\\\"");
        result = RegExUtils.replaceAll(result, "•", "*");
        result = RegExUtils.replaceAll(result, "–", "-");

        // Handle accented characters
        // TODO (weskubo-cgi) Confirm this approach is approved
        result = StringUtils.stripAccents(result);

        if (!StringUtils.isAsciiPrintable(result)) {
            logger.warn("submission has non-ASCII characters");
        }

        return result;
    }

}
