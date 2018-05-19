package com.pcw.bean;

import java.util.Date;

public class BTable {
	private long paperid;
	private long questionid;
	private Date filltime;
	private String pastresult;
	public long getPaperid() {
		return paperid;
	}
	public void setPaperid(long paperid) {
		this.paperid = paperid;
	}
	public long getQuestionid() {
		return questionid;
	}
	public void setQuestionid(long questionid) {
		this.questionid = questionid;
	}
	public Date getFilltime() {
		return filltime;
	}
	public void setFilltime(Date filltime) {
		this.filltime = filltime;
	}
	public String getPastresult() {
		return pastresult;
	}
	public void setPastresult(String pastresult) {
		this.pastresult = pastresult;
	}
}
