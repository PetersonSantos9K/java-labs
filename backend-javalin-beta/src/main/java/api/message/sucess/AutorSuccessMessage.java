package api.message.sucess;

public enum AutorSuccessMessage {

    SUCCESS("Operation completed successfully."),

    RESOURCE_FOUND("Resource found successfully."),
    RESOURCES_FOUND("Resources found successfully."),

    RESOURCE_CREATED("Resource created successfully."),
    RESOURCE_DELETED("Resource deleted successfully.");
    private final String message;
    AutorSuccessMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
