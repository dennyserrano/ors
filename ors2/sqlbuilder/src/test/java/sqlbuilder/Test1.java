package sqlbuilder;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.repo.meta.DatasetRepository;
import com.util.builders.config.Configuration;
import com.util.builders.services.HelloService;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
		Configuration.class
})
public class Test1 {

	
	@Autowired
	private DatasetRepository dr;
	
	@Test
	public void t1()
	{
		
		System.out.println();
	}
	
}
