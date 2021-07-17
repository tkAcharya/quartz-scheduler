package com.schedulerDemo.timer.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class FirstJobHelloWorld implements Job { //implements Quartz Job
	
	private static final Logger logs = org.slf4j.LoggerFactory.getLogger(FirstJobHelloWorld.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logs.info("Hello World");
	}

}
