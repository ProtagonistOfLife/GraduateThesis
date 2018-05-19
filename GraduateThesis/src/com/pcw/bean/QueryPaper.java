package com.pcw.bean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class QueryPaper {
	private Long paperid;
	private String papername;
	private Date removetime;
	private Long userid;
	private String resultmessage;
	private Date enddate;
	private List<Question> questions = new LinkedList<>();
	
	public QueryPaper() {}

	public Long getPaperid() {
		return paperid;
	}

	public void setPaperid(Long paperid) {
		this.paperid = paperid;
	}

	public String getPapername() {
		return papername;
	}

	public void setPapername(String papername) {
		this.papername = papername;
	}

	public Date getRemovetime() {
		return removetime;
	}

	public void setRemovetime(Date removetime) {
		this.removetime = removetime;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getResultmessage() {
		return resultmessage;
	}

	public void setResultmessage(String resultmessage) {
		this.resultmessage = resultmessage;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
}
