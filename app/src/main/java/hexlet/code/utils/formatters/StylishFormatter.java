package hexlet.code.utils.formatters;

import hexlet.code.Operation;

import java.util.Map;
import java.util.StringJoiner;

public class StylishFormatter {

    public static String stylishFormat(Map<String, Operation> keysParams) throws RuntimeException {
        StringJoiner sj = new StringJoiner("\n", "{\n", "\n}");

        for (var entry : keysParams.entrySet()) {
            String key = entry.getKey();
            Operation operation = entry.getValue();
            var oldValue = operation.getOldValue();
            var newValue = operation.getNewValue();
            var operationType = operation.getOperation();

            switch (operationType) {
                case Operation.ADD -> sj.add(String.format("  + %s: %s", key, newValue));
                case Operation.REMOVE -> sj.add(String.format("  - %s: %s", key, oldValue));
                case Operation.SAME -> sj.add(String.format("    %s: %s", key, oldValue));
                case Operation.REPLACE ->
                        sj.add(String.format("  - %s: %s\n  + %s: %s", key, oldValue, key, newValue));
                default -> new RuntimeException("Unknown operation to format");
            }
        }
        return sj.toString();
    }
}
