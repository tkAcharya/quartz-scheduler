package com.schedulerDemo.timer.utils;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import com.schedulerDemo.timer.configuration.TimerConfig;

public final class TimerUtils {
	
	public TimerUtils() {
	}
	
	// the following method creates JobDetail for the scheduler
	public static JobDetail buildJobDetail(final Class jobClass ,final TimerConfig info) {
		JobDataMap jmap = new JobDataMap();
		jmap.put(jobClass.getSimpleName(), info);
		
		return JobBuilder
				.newJob(jobClass)
				.setJobData(jmap)
				.withIdentity(jobClass.getSimpleName())
				.build();
	}
	
	//Building a trigger for the helloWorld Job
	public static Trigger buildTrigger(final Class jobClass ,final TimerConfig info) {
		SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule()
															.withIntervalInMilliseconds(info.getRepeatIntervalMs());
		
		builder = info.isRunForever()?builder.repeatForever():builder.withRepeatCount(info.getTotalFireCount()-1);
		
		return TriggerBuilder
				.newTrigger()
				.withIdentity(jobClass.getSimpleName())
				.withSchedule(builder)
				.startAt(new Date(info.getInitialOffsetMs()+System.currentTimeMillis()))
				.build();
	}
	
	
}
