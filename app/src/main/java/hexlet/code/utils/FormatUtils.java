package hexlet.code.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

public class FormatUtils {

    public static String format(
            TreeMap<String, Map<String, Object>> keysParams, String format) throws Exception {
        switch (format) {
            case "stylish" -> {
                return stylishFormat(keysParams);
            }
            case "plain" -> {
                return plainFormat(keysParams);
            }
            case "json" -> {
                return jsonFormat(keysParams);
            }
            default -> throw new Exception("Unknown format");
        }
    }

    public static String getFileFormat(String filepath) {
        Path absFilepath = Paths.get(filepath).toAbsolutePath();

        if (absFilepath.toString().endsWith("json")) {
            return "json";
        } else if (absFilepath.toString().endsWith("yaml") || absFilepath.toString().endsWith("yml")) {
            return "yaml";
        } else {
            return "other";
        }
    }

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

    public static String jsonFormat(
            TreeMap<String, Map<String, Object>> keysParams) throws RuntimeException, IOException {
        return new ObjectMapper().writeValueAsString(keysParams);
    }

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

    private static String stylishFormatOperation(String key, Map<String, Object> params) throws Exception {
        String operation = params.get("operation").toString();

        return switch (operation) {
            case "add" -> String.format("+ %s: %s", key, params.get("value"));
            case "remove" -> String.format("- %s: %s", key, params.get("value"));
            case "same" -> String.format(" %s: %s", key, params.get("value"));
            case "replace" ->
                    String.format("- %s: %s\n+ %s, %s", key, params.get("oldValue"), key, params.get("newValue"));
            default -> throw new Exception("Unknown operation to format");
        };
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
