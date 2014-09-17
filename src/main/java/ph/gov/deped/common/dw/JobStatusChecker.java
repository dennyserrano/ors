package ph.gov.deped.common.dw;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by ej on 9/10/14.
 */
public class JobStatusChecker {

    private @Autowired JobRepository jobRepository;

    public JobStatus check(String jobName, JobParameters jobParameters) {
        JobExecution jobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
        return new JobStatus(jobExecution);
    }

    public static class JobStatus implements Serializable {

        private static final long serialVersionUID = -8070440269745292030L;

        private final JobExecution jobExecution;

        public JobStatus(JobExecution jobExecution) {
            this.jobExecution = jobExecution;
        }

        public boolean hasFailed() {
            return jobExecution == null || jobExecution.getStatus() == BatchStatus.FAILED;
        }
    }
}
