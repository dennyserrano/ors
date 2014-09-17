package ph.gov.deped.data.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ph.gov.deped.config.ApplicationSpringConfig;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        ApplicationSpringConfig.class,
        DataSpringConfig.class
})
public class DataSpringConfigTest {

    private @Autowired DataSpringConfig config;

    public @Test void shouldInjectConfig() {
        assertNotNull(config);
    }
}