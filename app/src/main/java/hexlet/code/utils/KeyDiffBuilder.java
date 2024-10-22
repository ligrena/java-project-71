package hexlet.code.utils;

import hexlet.code.Operation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class KeyDiffBuilder {

    public static Map<String, Operation> buildDifference(Map<String, Object> value1, Map<String, Object> value2) {
        List<String> keysList = KeyDiffBuilder.getKeysSorted(value1.keySet(), value2.keySet());

        Map<String, Operation> keyDiff = new LinkedHashMap<>();

        for (String key : keysList) {
            if (!value1.containsKey(key)) {
                keyDiff.put(key, new Operation(Operation.ADD, null, value2.get(key)));
            } else if (!value2.containsKey(key)) {
                keyDiff.put(key, new Operation(Operation.REMOVE, value1.get(key), null));
            } else if (Objects.equals(value1.get(key), value2.get(key))) {
                keyDiff.put(key, new Operation(Operation.SAME, value1.get(key), value1.get(key)));
            } else if (!Objects.equals(value1.get(key), value2.get(key))) {
                keyDiff.put(key, new Operation(Operation.REPLACE, value1.get(key), value2.get(key)));
            } else {
                throw new RuntimeException(String.format("Unknown status: %s", key));
            }
        }
        return keyDiff;
    }

    public static List<String> getKeysSorted(Set<String> key1, Set<String> key2) {
        Set<String> keys = new HashSet<>(key1);
        keys.addAll(key2);
        return new ArrayList<>(keys).stream().sorted().toList();
    }
}
