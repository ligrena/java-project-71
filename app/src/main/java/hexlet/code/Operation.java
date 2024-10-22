package hexlet.code;

public final class Operation {

    public static final String ADD = "add";
    public static final String REMOVE = "remove";
    public static final String SAME = "same";
    public static final String REPLACE = "replace";

    private String operation;
    private Object oldValue;
    private Object newValue;

    public Operation(String operation, Object oldValue, Object newValue) {
        this.operation = operation;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getOperation() {
        return operation;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }
}
