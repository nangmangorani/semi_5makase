package com.semi_5makase.board.model.vo;

import java.sql.Date;

public class Qna {
	
	private int qnaNo;
	private String boardTitle;
	private String boardContent;
	private int qnaViews;
	private Date createDate; 
	private String status;
	private String open;
	private String reply;
	private String boardWriter;
	
	public Qna() {}
	
	
	

	public Qna(String boardTitle, String boardContent, String boardWriter, String open) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.open = open;
		
	}




	public Qna(int qnaNo, String boardTitle, String boardContent, int qnaViews, Date createDate, String open,
			String reply, String boardWriter) {
		super();
		this.qnaNo = qnaNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.qnaViews = qnaViews;
		this.createDate = createDate;
		this.open = open;
		this.reply = reply;
		this.boardWriter = boardWriter;
	}



	public Qna(int qnaNo, String boardTitle, Date createDate, String open, String reply, String boardWriter) {
		super();
		this.qnaNo = qnaNo;
		this.boardTitle = boardTitle;
		this.createDate = createDate;
		this.open = open;
		this.reply = reply;
		this.boardWriter = boardWriter;
	}



	public Qna(int qnaNo, String boardTitle, String boardContent, int qnaViews, Date createDate, String status,
			String open, String reply, String boardWriter) {
		super();
		this.qnaNo = qnaNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.qnaViews = qnaViews;
		this.createDate = createDate;
		this.status = status;
		this.open = open;
		this.reply = reply;
		this.boardWriter = boardWriter;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getQnaViews() {
		return qnaViews;
	}

	public void setQnaViews(int qnaViews) {
		this.qnaViews = qnaViews;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", qnaViews="
				+ qnaViews + ", createDate=" + createDate + ", status=" + status + ", open=" + open + ", reply=" + reply
				+ ", boardWriter=" + boardWriter + "]";
	}
	
	

}
