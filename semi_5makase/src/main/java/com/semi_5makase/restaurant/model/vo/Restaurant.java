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
	private int restViews;
	private String status;
	
	private String mainAddress;
	private String openingTime;
	private String restTime;
	private String breakTime;
	private double avg2;
	
	
	// 관우님꺼
	private String tvName;
	private String categoryName;
	private int avg;
	private int count;
	private int fcount;
	private String titleImg;
	
	public Restaurant() {}

	public Restaurant(int restNo, int categoryNo, int tvNo, String restName, String restAddress, String restPhone,
			String parking, String intro, int restViews, String status) {
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
	
	public Restaurant(String restName, String mainAddress, String tvName, String categoryName, double avg2) {
		super();
		this.restName = restName;
		this.mainAddress = mainAddress;
		this.tvName = tvName;
		this.categoryName = categoryName;
		this.avg2 = avg2;
	}

	public Restaurant(int restNo, String restName, String restAddress, String restPhone, String parking, String intro,
			int restViews, String openingTime, String restTime, String breakTime) {
		super();
		this.restNo = restNo;
		this.restName = restName;
		this.restAddress = restAddress;
		this.restPhone = restPhone;
		this.parking = parking;
		this.intro = intro;
		this.restViews = restViews;
		this.openingTime = openingTime;
		this.restTime = restTime;
		this.breakTime = breakTime;
	}
	
	// 관우님꺼
	public Restaurant(int restNo, int categoryNo, int tvNo, String tvName, String restName, String restAddress,
			String restPhone, String parking, String intro, int restViews, String status, String categoryName, int avg,
			int count, int fcount, String titleImg) {
		super();
		this.restNo = restNo;
		this.categoryNo = categoryNo;
		this.tvNo = tvNo;
		this.tvName = tvName;
		this.restName = restName;
		this.restAddress = restAddress;
		this.restPhone = restPhone;
		this.parking = parking;
		this.intro = intro;
		this.restViews = restViews;
		this.status = status;
		this.categoryName = categoryName;
		this.avg = avg;
		this.count = count;
		this.fcount = fcount;
		this.titleImg = titleImg;
	}
	
	public Restaurant(String titleImg) {
		super();
		this.titleImg = titleImg;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public Restaurant(int restNo, int categoryNo, int tvNo, String tvName, String restName, String restAddress,
			String restPhone, String parking, String intro, int restViews, String status, String categoryName, int fcount) {
		super();
		this.restNo = restNo;
		this.categoryNo = categoryNo;
		this.tvNo = tvNo;
		this.tvName = tvName;
		this.restName = restName;
		this.restAddress = restAddress;
		this.restPhone = restPhone;
		this.parking = parking;
		this.intro = intro;
		this.restViews = restViews;
		this.status = status;
		this.categoryName = categoryName;
		this.fcount=fcount;
	}

	public int getFcount() {
		return fcount;
	}

	public void setFcount(int fcount) {
		this.fcount = fcount;
	}

	public Restaurant(int restNo, int categoryNo, int tvNo, String tvName, String restName, String restAddress,
			String restPhone, String parking, String intro, int restViews, String status, String categoryName, int avg,
			int count, int fcount) {
		super();
		this.restNo = restNo;
		this.categoryNo = categoryNo;
		this.tvNo = tvNo;
		this.tvName = tvName;
		this.restName = restName;
		this.restAddress = restAddress;
		this.restPhone = restPhone;
		this.parking = parking;
		this.intro = intro;
		this.restViews = restViews;
		this.status = status;
		this.categoryName = categoryName;
		this.avg = avg;
		this.count = count;
		this.fcount = fcount;
	}
	
	public Restaurant(int restNo, int categoryNo, int tvNo, String tvName, String restName, String restAddress,
			String restPhone, String parking, String intro, int restViews, String status, String categoryName, int avg,
			int count) {
		super();
		this.restNo = restNo;
		this.categoryNo = categoryNo;
		this.tvNo = tvNo;
		this.tvName = tvName;
		this.restName = restName;
		this.restAddress = restAddress;
		this.restPhone = restPhone;
		this.parking = parking;
		this.intro = intro;
		this.restViews = restViews;
		this.status = status;
		this.categoryName = categoryName;
		this.avg = avg;
		this.count = count;
	}

	public String getTvName() {
		return tvName;
	}

	public void setTvName(String tvName) {
		this.tvName = tvName;
	}

	public Restaurant(int restNo, int categoryNo, int tvNo, String restName, String restAddress, String restPhone,
			String parking, String intro, int restViews, String status, String categoryName, int avg, int count) {
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
		this.categoryName = categoryName;
		this.avg = avg;
		this.count = count;
	}

	public Restaurant(int restNo, int categoryNo, int tvNo, String restName, String restAddress, String restPhone,
			String parking, String intro, int restViews, String status, String categoryName) {
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
		this.categoryName=categoryName;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public int getRestViews() {
		return restViews;
	}

	public void setRestViews(int restViews) {
		this.restViews = restViews;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getRestTime() {
		return restTime;
	}

	public void setRestTime(String restTime) {
		this.restTime = restTime;
	}

	public String getBreakTime() {
		return breakTime;
	}

	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}
	
	public double getAvg2() {
		return avg2;
	}

	public void setAvg2(double avg2) {
		this.avg2 = avg2;
	}
	
	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	@Override
	public String toString() {
		return "Restaurant [restNo=" + restNo + ", categoryNo=" + categoryNo + ", tvNo=" + tvNo + ", restName="
				+ restName + ", restAddress=" + restAddress + ", restPhone=" + restPhone + ", parking=" + parking
				+ ", intro=" + intro + ", restViews=" + restViews + ", status=" + status + ", openingTime="
				+ openingTime + ", restTime=" + restTime + ", breakTime=" + breakTime + "]";
	}

	
	
	
}
