package enums;

public enum StatusCodes {

    CODE_200(200, "OK"),
    CODE_500(500, "Internal Server Error"),
    CODE_404(404, "Not Found");

    public final int code;
    public final String message;

    StatusCodes(int code, String message){
        this.code = code;
        this.message = message;
    }

}
