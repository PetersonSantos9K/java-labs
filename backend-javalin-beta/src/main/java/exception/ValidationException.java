package exception;
import api.message.error.validation.ValidationMessage;

public class ValidationException extends AppException{

    private final int status;

    public ValidationException(ValidationMessage vm){
        super(vm.getStatus(), vm.getMessage());
        this.status = vm.getStatus();
    }

    public ValidationException(ValidationMessage vm, Throwable cause){
        super(vm.getStatus(), vm.getMessage(), cause);
        this.status = vm.getStatus();
    }


    public int getStatus(){
        return this.status;
    }

}

