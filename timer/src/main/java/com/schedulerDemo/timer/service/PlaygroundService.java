package com.schedulerDemo.timer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedulerDemo.timer.configuration.TimerConfig;
import com.schedulerDemo.timer.jobs.FirstJobHelloWorld;

@Service
public class PlaygroundService {
	
	private final SchedulerService scheduler;
	
	@Autowired
	public PlaygroundService(SchedulerService scheduler) {
		this.scheduler=scheduler;
	}
	
	public void runHelloWorldJob() {
		TimerConfig info = new TimerConfig();
		info.setCallbackData("YIPEE!!! First Cron");
		info.setInitialOffsetMs(1000);
		info.setRepeatIntervalMs(2000);
		info.setTotalFireCount(5);
		
		scheduler.schedule(FirstJobHelloWorld.class,info);
	}
}
