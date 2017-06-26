package ph.gov.deped.service.etl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ph.gov.deped.config.ApplicationSpringConfig;
import ph.gov.deped.data.source.ApplicationDataSourceSpringConfig;
import ph.gov.deped.service.config.BatchSpringConfig;
import static org.junit.Assert.assertNotNull;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {
//        ApplicationSpringConfig.class,
//        ApplicationDataSourceSpringConfig.class,
//        BatchSpringConfig.class
//})
public class BatchSpringConfigTest {

    private @Autowired @Lazy BatchSpringConfig batchSpringConfig;

    private @Autowired @Lazy Job metadataSyncJob;

    public @Test @Ignore void shouldInjectJob() {
        assertNotNull(batchSpringConfig);
        assertNotNull(metadataSyncJob);
    }
}