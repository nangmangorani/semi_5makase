package com.semi_5makase.restTemp;

public class RestaurantTemp {
	private String restName;
	private String restInfo;
	
	public RestaurantTemp() {}
	
	public RestaurantTemp(String restName, String restInfo) {
		super();
		this.restName = restName;
		this.restInfo = restInfo;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getRestInfo() {
		return restInfo;
	}
	public void setRestInfo(String restInfo) {
		this.restInfo = restInfo;
	}
	@Override
	public String toString() {
		return "RestaurantTemp [restName=" + restName + ", restInfo=" + restInfo + "]";
	}
	
	
}
