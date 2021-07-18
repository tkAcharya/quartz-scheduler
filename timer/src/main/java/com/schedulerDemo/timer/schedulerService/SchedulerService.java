package com.schedulerDemo.timer.schedulerService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedulerDemo.timer.configuration.TimerConfig;
import com.schedulerDemo.timer.utils.TimerUtils;

@Service
public class SchedulerService {
	
	private static final Logger logs = org.slf4j.LoggerFactory.getLogger(SchedulerService.class);
	
	private final Scheduler scheduler;
	
	@Autowired
	public SchedulerService(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	@PostConstruct
	public void init() {
		try {
			scheduler.start();
		} catch (Exception e) {
			logs.error("Scheduler start failed e:"+e.getMessage());
		}
	}
	
	@PreDestroy
	public void destroy() {
		try {
			scheduler.shutdown();
		} catch (Exception e) {
			logs.error("Scheduler could not be shutdown e:"+e.getMessage());
		}
	}
	
	public void schedule(final Class jobClass , final TimerConfig info) {
		
		//building a jobDetail first
		final JobDetail jobDetail = TimerUtils.buildJobDetail(jobClass, info);
		//building a trigger 
		final Trigger trigger = TimerUtils.buildTrigger(jobClass, info);
		
		try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			logs.error("Error in triggering scheduler e:"+e.getMessage());
		}
		
	}
}
