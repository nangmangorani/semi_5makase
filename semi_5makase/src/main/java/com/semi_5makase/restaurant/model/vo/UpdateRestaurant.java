package com.semi_5makase.restaurant.model.vo;

public class UpdateRestaurant {
	
	private int updateNo;
	private String updateContent;
	private int restNo;
	
	public UpdateRestaurant() {}

	public UpdateRestaurant(int updateNo, String updateContent, int restNo) {
		super();
		this.updateNo = updateNo;
		this.updateContent = updateContent;
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

	public int getRestNo() {
		return restNo;
	}

	public void setRestNo(int restNo) {
		this.restNo = restNo;
	}

	@Override
	public String toString() {
		return "UpdateRestaurant [updateNo=" + updateNo + ", updateContent=" + updateContent + ", restNo=" + restNo
				+ "]";
	}
	
}
