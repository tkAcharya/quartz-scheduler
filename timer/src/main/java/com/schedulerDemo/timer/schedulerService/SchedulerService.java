package com.schedulerDemo.timer.schedulerService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
