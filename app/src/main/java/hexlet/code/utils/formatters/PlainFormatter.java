package hexlet.code.utils.formatters;

import hexlet.code.Operation;

import java.util.Map;
import java.util.StringJoiner;

public class PlainFormatter {

    public static String plainFormat(Map<String, Operation> keysParams) throws RuntimeException {
        StringJoiner sj = new StringJoiner("\n");

        for (var entry : keysParams.entrySet()) {
            String key = entry.getKey();
            Operation operation = entry.getValue();
            var oldValue = operation.getOldValue();
            var newValue = operation.getNewValue();
            var operationType = operation.getOperation();

            switch (operationType) {
                case Operation.ADD -> sj.add(String.format("Property '%s' was added with value: %s",
                        key, transformerValue(newValue)));
                case Operation.REMOVE -> sj.add(String.format("Property '%s' was removed", key));
                case Operation.SAME -> {
                }
                case Operation.REPLACE -> sj.add(String.format("Property '%s' was updated. From %s to %s",
                        key, transformerValue(oldValue), transformerValue(newValue)));
                default -> throw new RuntimeException("Unknown operation to format");
            }
        }
        return sj.toString();
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
