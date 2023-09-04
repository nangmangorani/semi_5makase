package com.semi_5makase.restaurant.model.vo;

public class AdminRequestRestaurant {
	private int rtempNo;
	private String rtempName;
	private String rtempInfo;
	public AdminRequestRestaurant(int rtempNo, String rtempName, String rtempInfo) {
		super();
		this.rtempNo = rtempNo;
		this.rtempName = rtempName;
		this.rtempInfo = rtempInfo;
	}
	public int getRtempNo() {
		return rtempNo;
	}
	public void setRtempNo(int rtempNo) {
		this.rtempNo = rtempNo;
	}
	public String getRtempName() {
		return rtempName;
	}
	public void setRtempName(String rtempName) {
		this.rtempName = rtempName;
	}
	public String getRtempInfo() {
		return rtempInfo;
	}
	public void setRtempInfo(String rtempInfo) {
		this.rtempInfo = rtempInfo;
	}
	@Override
	public String toString() {
		return "AdminRequestRestaurant [rtempNo=" + rtempNo + ", rtempName=" + rtempName + ", rtempInfo=" + rtempInfo
				+ "]";
	}
	
}
