package exception;

public class AutorException extends AppException{

    private int status;

    public AutorException(int status, String msg){
        super(status, msg);
        this.status = status;
    }

    public AutorException(int status, String msg, Throwable cause){
        super(status, msg, cause);
        this.status = status;
    }

    public int getStatus(){
        return this.status;
    }

}
