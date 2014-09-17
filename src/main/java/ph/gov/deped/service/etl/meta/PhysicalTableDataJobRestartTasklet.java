package ph.gov.deped.service.etl.meta;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import ph.gov.deped.common.dw.JobRestartEvent;
import ph.gov.deped.service.etl.ds.DefaultDatasetsBatchSpringConfig;

/**
 * Created by ej on 9/10/14.
 */
public class PhysicalTableDataJobRestartTasklet implements Tasklet, StepExecutionListener, ApplicationEventPublisherAware {

    private StepExecution stepExecution;

    private ApplicationEventPublisher applicationEventPublisher;

    public void beforeStep(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        JobParameters jobParameters = stepExecution.getJobExecution().getJobParameters();
        JobRestartEvent event = new JobRestartEvent(this, DefaultDatasetsBatchSpringConfig.DEFAULT_DATASETS_JOB, jobParameters.getParameters());
        applicationEventPublisher.publishEvent(event);
        return RepeatStatus.FINISHED;
    }

    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }
}
