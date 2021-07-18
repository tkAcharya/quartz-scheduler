package com.schedulerDemo.timer.configuration;

public class TimerConfig {
	
	private int totalFireCount;
	private boolean runForever;
	private int repeatIntervalMs;
	private long initialOffsetMs;
	private String callbackData;
	
	public int getTotalFireCount() {
		return totalFireCount;
	}
	public void setTotalFireCount(int totalFireCount) {
		this.totalFireCount = totalFireCount;
	}
	public boolean isRunForever() {
		return runForever;
	}
	public void setRunForever(boolean runForever) {
		this.runForever = runForever;
	}
	public int getRepeatIntervalMs() {
		return repeatIntervalMs;
	}
	public void setRepeatIntervalMs(int repeatIntervalMs) {
		this.repeatIntervalMs = repeatIntervalMs;
	}
	public long getInitialOffsetMs() {
		return initialOffsetMs;
	}
	public void setInitialOffsetMs(long initialOffsetMs) {
		this.initialOffsetMs = initialOffsetMs;
	}
	public String getCallbackData() {
		return callbackData;
	}
	public void setCallbackData(String callbackData) {
		this.callbackData = callbackData;
	}
	
	
}
