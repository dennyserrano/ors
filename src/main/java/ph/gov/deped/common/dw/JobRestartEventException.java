package ph.gov.deped.common.dw;

/**
 * Created by ej on 9/10/14.
 */
public class JobRestartEventException extends RuntimeException {

    private static final long serialVersionUID = -1628965705879377228L;

    private final String jobName;

    public JobRestartEventException(String jobName) {
        this.jobName = jobName;
    }

    public JobRestartEventException(Throwable cause, String jobName) {
        super(cause);
        this.jobName = jobName;
    }

    public String getJobName() {
        return jobName;
    }
}
