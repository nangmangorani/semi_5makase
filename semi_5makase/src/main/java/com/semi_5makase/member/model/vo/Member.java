package com.semi_5makase.member.model.vo;

import java.sql.Date;


public class Member {
	private int memNo;
	private String memGrade;
	private String memId;
	private String memPwd;
	private String memName;
	private String gender;
	private int age;
	private String nickname;
	private String email;
	private String phone;
	private String address;
	private Date enrollDate;
	private String status;
	private String quitReason;
	private String selfIntroduction;
	
	public Member() {}
	
	

	public Member(int memNo, String memGrade, String memId, String memPwd, String memName, String gender, int age,
			String nickname, String email, String phone, String address, Date enrollDate, String status,
			String quitReason, String selfIntroduction) {
		super();
		this.memNo = memNo;
		this.memGrade = memGrade;
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.gender = gender;
		this.age = age;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.enrollDate = enrollDate;
		this.status = status;
		this.quitReason = quitReason;
		this.selfIntroduction = selfIntroduction;
	}



	public Member(int memNo, String memGrade, String memId, String memPwd, String memName, String gender, int age,
			String nickname, String email, String phone, String address, Date enrollDate, String status,
			String quitReason) {
		super();
		this.memNo = memNo;
		this.memGrade = memGrade;
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.gender = gender;
		this.age = age;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.enrollDate = enrollDate;
		this.status = status;
		this.quitReason = quitReason;
	}
	
	public Member(int memNo, String memName, String gender, String phone, String address) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}
	
	
	

	public Member(String memId, String nickname, String email, String phone, String address, String selfIntroduction) {
		super();
		this.memId = memId;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.selfIntroduction = selfIntroduction;
	}



	public Member(String memId, String memPwd, String memName, String gender, int age, String nickname, String email,
			String phone, String address) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.gender = gender;
		this.age = age;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	
	
	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemGrade() {
		return memGrade;
	}

	public void setMemGrade(String memGrade) {
		this.memGrade = memGrade;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuitReason() {
		return quitReason;
	}

	public void setQuitReason(String quitReason) {
		this.quitReason = quitReason;
	}

	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", memGrade=" + memGrade + ", memId=" + memId + ", memPwd=" + memPwd
				+ ", memName=" + memName + ", gender=" + gender + ", age=" + age + ", nickname=" + nickname + ", email="
				+ email + ", phone=" + phone + ", address=" + address + ", enrollDate=" + enrollDate + ", status="
				+ status + ", quitReason=" + quitReason + ", selfIntroduction=" + selfIntroduction + "]";
	}



	
}

