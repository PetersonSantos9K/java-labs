package exception;

public class DataBaseException extends AppException {

    private final int status;

    public DataBaseException(int status, String msg){
        super(status, msg);
        this.status = status;
    }

    public DataBaseException(int status, String msg, Throwable cause){
        super(status, msg, cause);
        this.status = status;
    }


    public int getStatus(){
        return this.status;
    }

}
