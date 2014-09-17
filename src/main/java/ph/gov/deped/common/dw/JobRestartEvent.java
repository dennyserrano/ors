package ph.gov.deped.common.dw;

import org.springframework.batch.core.JobParameter;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by ej on 9/10/14.
 */
public class JobRestartEvent extends ApplicationEvent implements Serializable {

    private static final long serialVersionUID = -3330712051457744858L;

    private final String jobName;

    private final Map<String, JobParameter> jobParameterMap;

    public JobRestartEvent(Object source, String jobName, Map<String, JobParameter> jobParameterMap) {
        super(source);
        this.jobName = jobName;
        this.jobParameterMap = jobParameterMap;
    }

    public String getJobName() {
        return jobName;
    }

    public Map<String, JobParameter> getJobParameterMap() {
        return jobParameterMap;
    }
}
