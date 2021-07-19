package com.schedulerDemo.timer.jobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.schedulerDemo.timer.configuration.TimerConfig;

@Component
public class FirstJobHelloWorld implements Job { //implements Quartz Job
	
	private static final Logger logs = org.slf4j.LoggerFactory.getLogger(FirstJobHelloWorld.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//logs.info("Hello World");
		JobDataMap jmap = context.getJobDetail().getJobDataMap();
		TimerConfig info = (TimerConfig) jmap.get(FirstJobHelloWorld.class.getSimpleName());
		String callbackData = info.getCallbackData();
		logs.info(callbackData);
	}

}
