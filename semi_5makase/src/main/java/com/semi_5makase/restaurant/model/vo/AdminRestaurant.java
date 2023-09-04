package com.semi_5makase.restaurant.model.vo;

public class AdminRestaurant {
	private int restNo;
	private String category;
	private String tv;
	private String restName;
	private String restAddress;
	private String restPhone;
	private String parking;
	private String intro;
	private int restViews;
	private String status;
	
	private String openingTime;
	private String restTime;
	private String breakTime;
	
	private String menu;
	private int price;
	private int menu_grade;
	
	public AdminRestaurant() {}

	public AdminRestaurant(int restNo, String category, String tv, String restName, String restAddress,
			String restPhone, String parking, String intro, int restViews, String status, String openingTime,
			String restTime, String breakTime, String menu, int price, int menu_grade) {
		super();
		this.restNo = restNo;
		this.category = category;
		this.tv = tv;
		this.restName = restName;
		this.restAddress = restAddress;
		this.restPhone = restPhone;
		this.parking = parking;
		this.intro = intro;
		this.restViews = restViews;
		this.status = status;
		this.openingTime = openingTime;
		this.restTime = restTime;
		this.breakTime = breakTime;
		this.menu = menu;
		this.price = price;
		this.menu_grade = menu_grade;
	}


	public AdminRestaurant(int restNo, String restName, String restAddress, String restPhone, String category, String status) {
		super();
		this.restNo = restNo;
		this.restName = restName;
		this.restAddress = restAddress;
		this.restPhone = restPhone;
		this.category = category;
		this.status = status;
	}
	
	public AdminRestaurant(int restNo, String category, String tv, String restName, String restAddress,
			String restPhone, String parking, String intro, String status, String menu, int price, int menu_grade,
			String openingTime, String restTime, String breakTime) {
		super();
		this.restNo = restNo;
		this.category = category;
		this.tv = tv;
		this.restName = restName;
		this.restAddress = restAddress;
		this.restPhone = restPhone;
		this.parking = parking;
		this.intro = intro;
		this.status = status;
		this.menu = menu;
		this.price = price;
		this.menu_grade = menu_grade;
		this.openingTime = openingTime;
		this.restTime = restTime;
		this.breakTime = breakTime;
	}
	
	public AdminRestaurant(int restNo, String menu, int price, int menu_grade) {
		super();
		this.restNo = restNo;
		this.menu = menu;
		this.price = price;
		this.menu_grade = menu_grade;
	}

	public int getRestNo() {
		return restNo;
	}

	public void setRestNo(int restNo) {
		this.restNo = restNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
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

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMenu_grade() {
		return menu_grade;
	}

	public void setMenu_grade(int menu_grade) {
		this.menu_grade = menu_grade;
	}

	@Override
	public String toString() {
		return "AdminRestaurant [restNo=" + restNo + ", category=" + category + ", tv=" + tv + ", restName=" + restName
				+ ", restAddress=" + restAddress + ", restPhone=" + restPhone + ", parking=" + parking + ", intro="
				+ intro + ", restViews=" + restViews + ", status=" + status + ", openingTime=" + openingTime
				+ ", restTime=" + restTime + ", breakTime=" + breakTime + ", menu=" + menu + ", price=" + price
				+ ", menu_grade=" + menu_grade + "]";
	}
	
	
	
}
