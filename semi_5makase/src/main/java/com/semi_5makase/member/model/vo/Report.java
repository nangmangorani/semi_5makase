package com.semi_5makase.member.model.vo;

import java.sql.Date;

public class Report {
	
	private int reportNo;
	private String reporter;
	private String suspect;
	private String reportContent;
	private Date reportDate;
	private String result;
	
	public Report() {}

	public Report(int reportNo, String reporter, String suspect, String reportContent, Date reportDate, String result) {
		super();
		this.reportNo = reportNo;
		this.reporter = reporter;
		this.suspect = suspect;
		this.reportContent = reportContent;
		this.reportDate = reportDate;
		this.result = result;
	}

	public final int getReportNo() {
		return reportNo;
	}

	public final void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public final String getReporter() {
		return reporter;
	}

	public final void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public final String getSuspect() {
		return suspect;
	}

	public final void setSuspect(String suspect) {
		this.suspect = suspect;
	}

	public final String getReportContent() {
		return reportContent;
	}

	public final void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public final Date getReportDate() {
		return reportDate;
	}

	public final void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public final String getResult() {
		return result;
	}

	public final void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Report [reportContent=" + reportContent + ", reportDate=" + reportDate + ", reporter=" + reporter
				+ ", reportNo=" + reportNo + ", result=" + result + ", suspect=" + suspect + "]";
	}
	
}
