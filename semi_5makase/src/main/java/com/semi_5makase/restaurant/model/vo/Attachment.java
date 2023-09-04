package com.semi_5makase.restaurant.model.vo;

import java.sql.Date;

public class Attachment {
	
	private int fileNo;
	private int refBoardNo;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private String status;
	private String category;
	
	public Attachment() {}

	public Attachment(int fileNo, int refBoardNo, String originName, String changeName, String filePath,
			Date uploadDate, String status, String category) {
		super();
		this.fileNo = fileNo;
		this.refBoardNo = refBoardNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
		this.category = category;
	}

	public final int getFileNo() {
		return fileNo;
	}

	public final void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public final int getRefBoardNo() {
		return refBoardNo;
	}

	public final void setRefBoardNo(int refBoardNo) {
		this.refBoardNo = refBoardNo;
	}

	public final String getOriginName() {
		return originName;
	}

	public final void setOriginName(String originName) {
		this.originName = originName;
	}

	public final String getChangeName() {
		return changeName;
	}

	public final void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public final String getFilePath() {
		return filePath;
	}

	public final void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public final Date getUploadDate() {
		return uploadDate;
	}

	public final void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final String getCategory() {
		return category;
	}

	public final void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", refBoardNo=" + refBoardNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", status="
				+ status + ", category=" + category + "]";
	}

	
}

