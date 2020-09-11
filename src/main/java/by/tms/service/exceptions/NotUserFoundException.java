package by.tms.service.exceptions;

public class NotUserFoundException extends  RuntimeException{
    public NotUserFoundException() {
        super();
    }

    public NotUserFoundException(String message) {
        super(message);
    }

    public NotUserFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUserFoundException(Throwable cause) {
        super(cause);
    }

    protected NotUserFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
