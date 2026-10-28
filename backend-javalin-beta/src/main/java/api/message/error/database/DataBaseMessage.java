package api.message.error.database;

public enum DataBaseMessage {
    ERROR_QUERY(404,"Unable to perform the query."),
    ERROR_INSERT(500,"Unable to save the record."),
    ERROR_UPDATE(500,"Unable to update the record."),
    ERROR_DELETE(500,"Unable to delete the record."),
    ERROR_NOT_EXIST(404,"Record not found in the database.");

    private final int code;
    private final String message;

    DataBaseMessage(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode () {
        return code;
    }

    public String getMessage(){
        return message;
    }



}
