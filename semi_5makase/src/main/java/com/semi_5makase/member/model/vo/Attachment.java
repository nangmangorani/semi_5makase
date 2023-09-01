package com.semi_5makase.member.model.vo;

import java.util.Date;

public class Attachment {
	
	private int fileNo;
	private int refMemNo;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private String status;
	private String category;

	
	public Attachment() {}


	public Attachment(int fileNo, int refMemNo, String originName, String changeName, String filePath, Date uploadDate,
			String status, String category) {
		super();
		this.fileNo = fileNo;
		this.refMemNo = refMemNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
		this.category = category;
	}


	public int getFileNo() {
		return fileNo;
	}


	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}


	public int getRefMemNo() {
		return refMemNo;
	}


	public void setRefMemNo(int refMemNo) {
		this.refMemNo = refMemNo;
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


	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", refMemNo=" + refMemNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", status="
				+ status + ", category=" + category + "]";
	}
	
	
}
