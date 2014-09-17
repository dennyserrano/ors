package ph.gov.deped.service.etl.ds;

public class EtlDataStreamingException extends RuntimeException {

    private static final long serialVersionUID = -3521304578114351649L;

    public EtlDataStreamingException() {
        super();
    }

    public EtlDataStreamingException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EtlDataStreamingException(String message, Throwable cause) {
        super(message, cause);
    }

    public EtlDataStreamingException(String message) {
        super(message);
    }

    public EtlDataStreamingException(Throwable cause) {
        super(cause);
    }
}
