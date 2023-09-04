package com.semi_5makase.restaurant.model.vo;

public class Menu {
	
	private int restNo;
	private int fileNo;
	private String menu;
	private String price;
	private int menuGrade;
	
	public Menu() {}

	public Menu(int restNo, int fileNo, String menu, String price, int menuGrade) {
		super();
		this.restNo = restNo;
		this.fileNo = fileNo;
		this.menu = menu;
		this.price = price;
		this.menuGrade = menuGrade;
	}
	
	public Menu(int restNo, String menu, String price, int menuGrade) {
		super();
		this.restNo = restNo;
		this.menu = menu;
		this.price = price;
		this.menuGrade = menuGrade;
	}

	public int getRestNo() {
		return restNo;
	}

	public void setRestNo(int restNo) {
		this.restNo = restNo;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getMenuGrade() {
		return menuGrade;
	}

	public void setMenuGrade(int menuGrade) {
		this.menuGrade = menuGrade;
	}

	@Override
	public String toString() {
		return "Menu [restNo=" + restNo + ", fileNo=" + fileNo + ", menu=" + menu + ", price=" + price + ", menuGrade="
				+ menuGrade + "]";
	};
	
	
	
}
