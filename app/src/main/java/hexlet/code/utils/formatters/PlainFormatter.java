package hexlet.code.utils.formatters;

import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

public class PlainFormatter {

    public static String plainFormat(
            TreeMap<String, Map<String, Object>> keysParams) throws RuntimeException {
        StringJoiner sj = new StringJoiner("\n");

        keysParams
                .navigableKeySet()
                .stream()
                .filter(key -> !keysParams
                        .get(key)
                        .get("operation")
                        .equals("same"))
                .forEach(key -> {
                    try {
                        sj.add(plainFormatOperation(key, keysParams.get(key)));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        return sj.toString();
    }

    private static String plainFormatOperation(String key, Map<String, Object> params) throws Exception {
        String operation = params.get("operation").toString();

        return switch (operation) {
            case "add" -> String.format("Property '%s' was added with value: %s",
                    key,
                    transformerValue(params.get("value")));
            case "remove" -> String.format("Property '%s' was removed", key);
            case "same" -> null;
            case "replace" -> String.format("Property '%s' was updated. From %s to %s",
                    key, transformerValue(params.get("oldValue")), transformerValue(params.get("newValue")));
            default -> throw new Exception("Unknown operation to format");
        };
    }

    private static String transformerValue(Object value) {
        if (value == null) {
            return "null";
        }

        if (value.toString().startsWith("{") & value.toString().endsWith("}")
                | value.toString().startsWith("[") & value.toString().endsWith("]")) {
            return "[complex value]";
        }

        if (value.toString().equals("true") | value.toString().equals("false")) {
            return value.toString();
        }

        try {
            Double.parseDouble(value.toString());
            return value.toString();
        } catch (java.lang.NumberFormatException e) {
            return String.format("'%s'", value);
        }
    }
}
