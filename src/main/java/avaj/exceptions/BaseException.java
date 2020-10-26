package avaj.exceptions;

public class BaseException extends Throwable {

    private String message;

    public BaseException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
