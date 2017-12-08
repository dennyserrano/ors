package ph.gov.deped.service.meta.api;

import ph.gov.deped.common.BaseException;

/**
 * Created by ej on 8/20/14.
 */
public class MetadataSynchronizationException extends BaseException {

    public static final String ERROR_CODE = "exception.ors.metadata.synchronization";

    private static final long serialVersionUID = -1486798638738605839L;

    public MetadataSynchronizationException() {
        super(ERROR_CODE);
    }

    public MetadataSynchronizationException(String message) {
        super(message, ERROR_CODE);
    }

    public MetadataSynchronizationException(Throwable cause) {
        super(cause, ERROR_CODE);
    }
}
