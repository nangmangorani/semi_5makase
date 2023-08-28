package com.semi_5makase.restaurant.model.vo;

public class Restaurant {
	
	private int restNo;
	private int categoryNo;
	private int tvNo;
	private String restName;
	private String restAddress;
	private String restPhone;
	private String parking;
	private String intro;
	private String restViews;
	private String status;
	
	public Restaurant() {}

	public Restaurant(int restNo, int categoryNo, int tvNo, String restName, String restAddress, String restPhone,
			String parking, String intro, String restViews, String status) {
		super();
		this.restNo = restNo;
		this.categoryNo = categoryNo;
		this.tvNo = tvNo;
		this.restName = restName;
		this.restAddress = restAddress;
		this.restPhone = restPhone;
		this.parking = parking;
		this.intro = intro;
		this.restViews = restViews;
		this.status = status;
	}

	public int getRestNo() {
		return restNo;
	}

	public void setRestNo(int restNo) {
		this.restNo = restNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getTvNo() {
		return tvNo;
	}

	public void setTvNo(int tvNo) {
		this.tvNo = tvNo;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getRestAddress() {
		return restAddress;
	}

	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}

	public String getRestPhone() {
		return restPhone;
	}

	public void setRestPhone(String restPhone) {
		this.restPhone = restPhone;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getRestViews() {
		return restViews;
	}

	public void setRestViews(String restViews) {
		this.restViews = restViews;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Restaurant [restNo=" + restNo + ", categoryNo=" + categoryNo + ", tvNo=" + tvNo + ", restName="
				+ restName + ", restAddress=" + restAddress + ", restPhone=" + restPhone + ", parking=" + parking
				+ ", intro=" + intro + ", restViews=" + restViews + ", status=" + status + "]";
	}
	
	
}
