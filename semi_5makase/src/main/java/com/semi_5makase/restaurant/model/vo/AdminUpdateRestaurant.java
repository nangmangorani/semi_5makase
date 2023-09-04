package com.semi_5makase.restaurant.model.vo;

public class AdminUpdateRestaurant {
	
	private int updateNo;
	private String updateContent;
	private String rest;
	private int restNo;
	
	public AdminUpdateRestaurant() {}

	public AdminUpdateRestaurant(int updateNo, String updateContent, String rest) {
		super();
		this.updateNo = updateNo;
		this.updateContent = updateContent;
		this.rest = rest;
	}
	
	public AdminUpdateRestaurant(int updateNo, String updateContent, int restNo, String rest) {
		super();
		this.updateNo = updateNo;
		this.updateContent = updateContent;
		this.restNo = restNo;
		this.rest = rest;
	}

	public final int getRestNo() {
		return restNo;
	}

	public final void setRestNo(int restNo) {
		this.restNo = restNo;
	}

	public int getUpdateNo() {
		return updateNo;
	}

	public void setUpdateNo(int updateNo) {
		this.updateNo = updateNo;
	}

	public String getUpdateContent() {
		return updateContent;
	}

	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent;
	}

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	@Override
	public String toString() {
		return "AdminUpdateRestaurant [updateNo=" + updateNo + ", updateContent=" + updateContent + ", rest=" + rest
				+ ", restNo=" + restNo + "]";
	}
	
}
