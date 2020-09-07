package by.tms.dao;

public class NoResultExceptions extends RuntimeException {
    public NoResultExceptions() {
    }

    public NoResultExceptions(String message) {
        super(message);
    }

    public NoResultExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public NoResultExceptions(Throwable cause) {
        super(cause);
    }

    public NoResultExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
