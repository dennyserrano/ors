package ph.gov.deped.security;

import ph.gov.deped.common.BaseException;

/**
 * Created by ej on 8/20/14.
 */
public class SecurityException extends BaseException {

    public static final String ERROR_CODE = "exception.ors.security";

    private static final long serialVersionUID = 3376624025623995113L;

    public SecurityException(Throwable cause) {
        super(cause, ERROR_CODE);
    }
}
