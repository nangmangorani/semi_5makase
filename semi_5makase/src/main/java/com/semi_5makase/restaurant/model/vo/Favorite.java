package com.semi_5makase.restaurant.model.vo;

public class Favorite {
	
	private int memNo;
	private int restNo;
	
	public Favorite() {}

	public Favorite(int memNo, int restNo) {
		super();
		this.memNo = memNo;
		this.restNo = restNo;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getRestNo() {
		return restNo;
	}

	public void setRestNo(int restNo) {
		this.restNo = restNo;
	}

	@Override
	public String toString() {
		return "Favorite [memNo=" + memNo + ", restNo=" + restNo + "]";
	};
	
	
}
