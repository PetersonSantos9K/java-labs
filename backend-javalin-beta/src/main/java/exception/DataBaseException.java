package exception;

import api.message.error.database.DataBaseMessage;

public class DataBaseException extends AppException {

    private final int status;

    public DataBaseException(DataBaseMessage dbm){
        super(dbm.getCode(), dbm.getMessage());
        this.status = dbm.getCode();
    }

    public DataBaseException(DataBaseMessage dbm, Throwable cause){
        super(dbm.getCode(), dbm.getMessage(), cause);
        this.status = dbm.getCode();
    }


    public int getStatus(){
        return this.status;
    }

}
