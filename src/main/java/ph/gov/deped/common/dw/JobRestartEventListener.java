package ph.gov.deped.common.dw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

/**
 * Created by ej on 9/10/14.
 */
public class JobRestartEventListener implements ApplicationListener<JobRestartEvent>, ApplicationContextAware {

    private static final Logger log = LogManager.getLogger(JobRestartEventListener.class);

    private @Autowired JobRegistry jobRegistry;

    private @Autowired JobLauncher jobLauncher;

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void onApplicationEvent(JobRestartEvent event) {
        final String jobName = event.getJobName();
        final JobParameters jobParameters = new JobParameters(event.getJobParameterMap());
        try {
            Job job;
            if (event.getSource() instanceof JobRestartEventListener) {
                job = applicationContext.getBean(jobName, Job.class);
            }
            else {
                job = jobRegistry.getJob(jobName);
            }
            log.info("Restarting Job [{}]...", jobName);
            jobLauncher.run(job, jobParameters);
        }
        catch (NoSuchJobException ex) {
            applicationContext.publishEvent(new JobRestartEvent(this, jobName, event.getJobParameterMap()));
        }
        catch (Exception ex) {
            log.error(new ParameterizedMessage("Failed to restart Job [{}].", new Object[] {jobName}, ex), ex);
            throw new JobRestartEventException(ex, jobName);
        }
    }
}
