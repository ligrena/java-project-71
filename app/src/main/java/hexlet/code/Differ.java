package hexlet.code;

import hexlet.code.utils.FormatUtils;
import hexlet.code.utils.ParserUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> content1 = ParserUtils.parse(getData(filepath1), FormatUtils.getFileFormat(filepath1));
        Map<String, Object> content2 = ParserUtils.parse(getData(filepath2), FormatUtils.getFileFormat(filepath1));
        TreeMap<String, Map<String, Object>> keyDiff = buildDifference(content1, content2);

        return FormatUtils.format(keyDiff, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String getData(String filepath) throws Exception {
        return Files.readString(Paths.get(filepath).toAbsolutePath()).replaceAll("\r", "");
    }

    public static TreeMap<String, Map<String, Object>> buildDifference(
            Map<String, Object> value1, Map<String, Object> value2) {
        TreeMap<String, Map<String, Object>> keyDiff = new TreeMap<>();

        List<String> keysList = getKeysSorted(value1.keySet(), value2.keySet());
        keysList.forEach(x -> keyDiff.put(x, buildKeyDiff(value1, value2, x)));

        return keyDiff;
    }

    public static List<String> getKeysSorted(Set<String> key1, Set<String> key2) {
        Set<String> keys = new HashSet<>(key1);
        keys.addAll(key2);

        return new ArrayList<>(keys).stream().sorted().toList();
    }

    private static Map<String, Object> buildKeyDiff(
            Map<String, Object> contents1, Map<String, Object> contents2, String key) {
        Object value1 = contents1.get(key);
        Object value2 = contents2.get(key);

        if (!contents1.containsKey(key)) {
            return new HashMap<>() {
                {
                    put("operation", "add");
                    put("value", value2);
                }
            };
        }

        if (!contents2.containsKey(key)) {
            return new HashMap<>() {
                {
                    put("operation", "remove");
                    put("value", value1);
                }
            };
        }

        if (value1 == null & value2 == null) {
            return new HashMap<>() {
                {
                    put("operation", "add");
                    put("value", "null");
                }
            };
        }

        if (value1 != null) {
            if (value1.equals(value2)) {
                return new HashMap<>() {
                    {
                        put("operation", "same");
                        put("value", value1);
                    }
                };
            }
        }

        return new HashMap<>() {
            {
                put("operation", "replace");
                put("oldValue", value1);
                put("newValue", value2);
            }
        };
    }
}
