package hexlet.code.utils.formatters;

import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

public class StylishFormatter {

    public static String stylishFormat(
            TreeMap<String, Map<String, Object>> keysParams) throws RuntimeException {
        StringJoiner sj = new StringJoiner("\n", "{\n", "\n}");

        keysParams.navigableKeySet().forEach(key -> {
            try {
                sj.add(stylishFormatOperation(key, keysParams.get(key)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return sj.toString();
    }

    private static String stylishFormatOperation(String key, Map<String, Object> params) throws Exception {
        String operation = params.get("operation").toString();

        return switch (operation) {
            case "add" -> String.format("  + %s: %s", key, params.get("value"));
            case "remove" -> String.format("  - %s: %s", key, params.get("value"));
            case "same" -> String.format("    %s: %s", key, params.get("value"));
            case "replace" ->
                    String.format("  - %s: %s\n  + %s: %s", key, params.get("oldValue"), key, params.get("newValue"));
            default -> throw new Exception("Unknown operation to format");
        };
    }
}
