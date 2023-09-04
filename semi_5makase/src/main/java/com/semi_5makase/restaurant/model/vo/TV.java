package com.semi_5makase.restaurant.model.vo;

public class TV {
	private int tv_no;
	private String tv_name;
	
	public TV() {}

	public TV(int tv_no, String tv_name) {
		super();
		this.tv_no = tv_no;
		this.tv_name = tv_name;
	}
	
	public void setTv_no(int tv_no) {
		this.tv_no = tv_no;
	}

	public void setTv_name(String tv_name) {
		this.tv_name = tv_name;
	}

	public int getTv_no() {
		return tv_no;
	}

	public String getTv_name() {
		return tv_name;
	}

	@Override
	public String toString() {
		return "TV [tv_no=" + tv_no + ", tv_name=" + tv_name + "]";
	}
	
}
