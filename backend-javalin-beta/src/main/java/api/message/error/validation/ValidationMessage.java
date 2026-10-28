package api.message.error.validation;

public enum ValidationMessage {
    REQUIRED_VALUE(400,"A required value was not provided."),
    INVALID_VALUE(400,"Invalid value provided."),

    VALUE_TOO_SHORT(422,"Value is too short."),
    VALUE_TOO_LONG(422,"Value is too long."),

    INVALID_ID(400,"Invalid id.");

    private final int status;
    private final String message;

    ValidationMessage(int status, String msg){
        this.status = status;
        this.message = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
