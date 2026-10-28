package exception;

public class LivroException extends AppException {

    private final int status;

    public LivroException(int status, String message) {
        super(status, message);
        this.status = status;
    }

    public LivroException(int status, String msg, Throwable cause){
        super(status, msg, cause);
        this.status = status;
    }

    public int getStatus(){
        return this.status;
    }

}
