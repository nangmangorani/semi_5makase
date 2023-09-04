package com.semi_5makase.restaurant.model.vo;

public class Review {
	
	private int reviewNo;
	private int restNo;
	private String reviewContent;
	private int rating;
	private String reviewDate; // String 으로 받음
	// private String Taste; 일단 빼고 하기
	private int memNo;

	private String nickName;
	
	public Review() {}

	public Review(int reviewNo, int restNo, String reviewContent, int rating, String reviewDate, int memNo, int likes) {
		super();
		this.reviewNo = reviewNo;
		this.restNo = restNo;
		this.reviewContent = reviewContent;
		this.rating = rating;
		this.reviewDate = reviewDate;
		this.memNo = memNo;
	}

	public Review(int reviewNo, String reviewContent, String reviewImg, int rating, String nickName) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.rating = rating;
		this.nickName = nickName;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getRestNo() {
		return restNo;
	}

	public void setRestNo(int restNo) {
		this.restNo = restNo;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", restNo=" + restNo + ", reviewContent=" + reviewContent + ", rating="
				+ rating + ", reviewDate=" + reviewDate + ", memNo=" + memNo + "]";
	}

	
	
	
}
