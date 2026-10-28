package api.message.error.business;

public enum AuthorBusinessMessage {
    ALREADY_REGISTERED(
            "AUTHOR_001",
            "Author already registered.",
            409
    ),

    NOT_FOUND(
            "AUTHOR_002",
            "Author not found.",
            404
    ),

    OPERATION_FAILED(
            "AUTHOR_003",
            "Unable to complete the operation.",
            400
    );


    private final String code;
    private final String message;
    private final int status;
    AuthorBusinessMessage(String code, String message, int status){
        this.code = code;
        this.message = message;
        this.status = status;
    }
    public String getCode() {
        return code;
    }
    public String getMessage(){
        return message;
    }

    public int getStatus() {
        return status;
    }
}
