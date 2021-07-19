package com.schedulerDemo.timer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedulerDemo.timer.service.PlaygroundService;

@RestController
@RequestMapping("/api/timer")
public class APIController {
	
	@Autowired
	private PlaygroundService playgroundService;
	
	//or
	// another way to do autowiring
//	@Autowired
//	public APIController(PlaygroundService playgroundService) {
//		this.playgroundService=playgroundService;
//	}
	
	@PostMapping("/runhelloworld")
	public void runHelloWorldJob() {
		playgroundService.runHelloWorldJob();
	}
}
