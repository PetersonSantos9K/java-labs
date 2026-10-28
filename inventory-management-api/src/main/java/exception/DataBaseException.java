package exception;

import api.exception.AppException;

public class DataBaseException extends AppException {
    public DataBaseException(String message) {
        super(message);
    }
}
