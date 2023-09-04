package com.semi_5makase.restaurant.model.vo;

public class ReviewNo {
	
	private int reviewNo;
	
	public ReviewNo() {}

	public ReviewNo(int reviewNo) {
		super();
		this.reviewNo = reviewNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	@Override
	public String toString() {
		return "ReviewNo [reviewNo=" + reviewNo + "]";
	}
	
	

}
