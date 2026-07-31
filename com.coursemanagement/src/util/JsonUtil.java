package util;

import java.math.BigDecimal;
import java.util.List;

public class JsonUtil {
    public static String readString(String body, String key) {
        String search = "\"" + key + "\"";
        int start = body.indexOf(search);

        if (start == -1) {
            return null;
        }

        start = body.indexOf(":", start);
        start = body.indexOf("\"", start) + 1;
        int end = body.indexOf("\"", start);

        return body.substring(start, end);
    }

    public static int readInt(String body, String key) {
        String search = "\"" + key + "\"";
        int start = body.indexOf(search);

        if (start == -1) {
            throw new IllegalArgumentException(key + " not found");
        }

        start = body.indexOf(":", start) + 1;

        while (Character.isWhitespace(body.charAt(start))) {
            start++;
        }

        int end = start;

        while (end < body.length()
                && Character.isDigit(body.charAt(end))) {
            end++;
        }

        return Integer.parseInt(body.substring(start, end));
    }

    public static BigDecimal readDecimal(String body, String key) {
        String search = "\"" + key + "\"";
        int start = body.indexOf(search);

        if (start == -1) {
            throw new IllegalArgumentException(key + " not found");
        }

        start = body.indexOf(":", start) + 1;

        while (Character.isWhitespace(body.charAt(start))) {
            start++;
        }

        int end = start;

        while (end < body.length() &&
                (Character.isDigit(body.charAt(end))
                        || body.charAt(end) == '.')) {
            end++;
        }

        return new BigDecimal(body.substring(start, end));
    }

    public static Enum readEnum(String body, String key) {
        return null;
    }

    public static void requireField(String body, String key) {
        String value = readString(body, key);

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(key + " is required");
        }
    }

    public static String escape(String text) {
        if (text == null) {
            return "";
        }

        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    public static String toJson(List<?> list) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            json.append(list.get(i).toString());

            if (i < list.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");

        return json.toString();
    }

    public static String errorJson(String message) {
        return "{\"message\":\"" + escape(message) + "\"}";
    }
}
