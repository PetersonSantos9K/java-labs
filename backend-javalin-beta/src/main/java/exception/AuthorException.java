package exception;

import api.message.error.business.AuthorBusinessMessage;

public class AuthorException extends AppException {

    private final int status;

    public AuthorException(AuthorBusinessMessage author){
        super(author.getStatus(), author.getMessage());
        this.status = author.getStatus();
    }

    public AuthorException(AuthorBusinessMessage author, Throwable cause){
        super(author.getStatus(), author.getMessage(), cause);
        this.status = author.getStatus();
    }

    public int getStatus(){
        return this.status;
    }

}
