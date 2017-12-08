package ph.gov.deped.service.config;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Service;

import ph.gov.deped.common.command.Command;

import java.util.concurrent.Executor;

/**
 * Created by ej on 8/7/14.
 */
@Configuration
@ComponentScan(basePackages = {"ph.gov.deped.service"},
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(value = {Service.class, Command.class}, type = FilterType.ANNOTATION),
        }
)
@EnableAsync
@EnableScheduling
@Import({
//        JpaTransactionManagerSpringConfig.class,
//        ExporterSpringConfig.class,
//        ExporterExcelSpringConfig.class
})
public class ServicesSpringConfig implements SchedulingConfigurer, AsyncConfigurer {
    
//    public @Bean Environment reactorEnv() {
//        return new Environment();
//    }

	@Override
	public Executor getAsyncExecutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub
		
	}

	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}
    
//    public @Bean ThreadPoolTaskScheduler taskScheduler() {
//        ThreadPoolTaskScheduler s = new ThreadPoolTaskScheduler();
//        s.setPoolSize(8);
//        return s;
//    }
//
//    public Executor getAsyncExecutor() {
//        RingBufferAsyncTaskExecutor t = new RingBufferAsyncTaskExecutor(reactorEnv());
//        t.setName("RingBufferAsyncTaskExecutor");
//        t.setBacklog(8);
//        t.setWaitStrategy(new BusySpinWaitStrategy());
//        /*ThreadPoolTaskExecutor t = new ThreadPoolTaskExecutor();
//        t.setAllowCoreThreadTimeOut(true);
//        t.setAwaitTerminationSeconds(10);
//        t.setCorePoolSize(4);
//        t.setMaxPoolSize(10);
//        t.setQueueCapacity(4);*/
//        return t;
//    }
//
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.setTaskScheduler(taskScheduler());
//    }
}
