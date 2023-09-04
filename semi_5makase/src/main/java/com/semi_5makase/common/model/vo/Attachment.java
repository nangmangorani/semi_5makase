package com.semi_5makase.common.model.vo;

import java.sql.Date;

public class Attachment {
	private int fileNo;
	private int refBno;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private String status;
	private String category;
	private int fileLevel;
	
	private String reviewImgs;
	
	public Attachment() {}

	public Attachment(int fileNo, int refBno, String originName, String changeName, String filePath,
			Date uploadDate, String status, String category, int fileLevel) {
		super();
		this.fileNo = fileNo;
		this.refBno = refBno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
		this.category = category;
		this.fileLevel = fileLevel;
	}
	
	public Attachment(String reviewImgs) {
		super();
		this.reviewImgs = reviewImgs;
	}
	
	public Attachment(String reviewImgs, int refBno) {
		super();
		this.reviewImgs = reviewImgs;
		this.refBno = refBno;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getrefBno() {
		return refBno;
	}

	public void setrefBno(int refBno) {
		this.refBno = refBno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getReviewImgs() {
		return reviewImgs;
	}

	public void setReviewImgs(String reviewImgs) {
		this.reviewImgs = reviewImgs;
	}
	
	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", refBno=" + refBno + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", status="
				+ status + ", category=" + category + "]";
	}

	
}
