package hexlet.code.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KeyDiffBuilder {

    public static Map<String, Object> keyDiffBuild(
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

    public static List<String> getKeysSorted(Set<String> key1, Set<String> key2) {
        Set<String> keys = new HashSet<>(key1);
        keys.addAll(key2);

        return new ArrayList<>(keys).stream().sorted().toList();
    }
}
