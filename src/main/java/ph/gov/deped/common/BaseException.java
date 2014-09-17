package ph.gov.deped.common;

/**
 * Created by ej on 8/20/14.
 */
public abstract class BaseException extends RuntimeException {

    private static final String DEFAULT_ERROR_CODE = "exception.base.ors.error";

    private static final long serialVersionUID = -2469310853447731232L;

    private final String errorCode;

    public BaseException() {
        this(DEFAULT_ERROR_CODE);
    }

    public BaseException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BaseException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BaseException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
