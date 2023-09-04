package com.semi_5makase.restaurant.model.vo;

public class Time {
	
	private int restNo;
	private String openTime;
	private String restTime;
	private String breakTime;
	
	public Time() {}

	public Time(int restNo, String openTime, String restTime, String breakTime) {
		super();
		this.restNo = restNo;
		this.openTime = openTime;
		this.restTime = restTime;
		this.breakTime = breakTime;
	}

	public final int getRestNo() {
		return restNo;
	}

	public final void setRestNo(int restNo) {
		this.restNo = restNo;
	}

	public final String getOpenTime() {
		return openTime;
	}

	public final void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public final String getRestTime() {
		return restTime;
	}

	public final void setRestTime(String restTime) {
		this.restTime = restTime;
	}

	public final String getBreakTime() {
		return breakTime;
	}

	public final void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}

	@Override
	public String toString() {
		return "Time [restNo=" + restNo + ", openTime=" + openTime + ", restTime=" + restTime + ", breakTime="
				+ breakTime + "]";
	}
	
	
}
