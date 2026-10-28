package api.request;

public class ApiRequest {
    public boolean status;
    public String message;

    public ApiRequest(boolean status, String message){
        this.status = status;
        this.message = message;
    }
}
