package api.response;

public class ApiResponse <T> {

    public boolean sucess;
    public String message;
    public T data;

    public ApiResponse(boolean sucess, String message, T data){
        this.sucess = sucess;
        this.message = message;
        this.data = data;
    }



}
