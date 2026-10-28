package exception;

import api.exception.AppException;

public class UserException extends AppException {
    public UserException(String message) {
        super(message);
    }
}
