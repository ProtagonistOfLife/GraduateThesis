package com.pcw.bean;

import java.util.Date;

public class Question {
	private Long questionid;
	private String question;//����
	private String choose;//ѡ��
	private String info;//������Ϣ
	private String result;//�������
	private Date create_date;//��������
	
	public Question(){}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getChoose() {
		return choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Long id) {
		this.questionid = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
