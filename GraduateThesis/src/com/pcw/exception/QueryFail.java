package com.pcw.exception;

public class QueryFail extends Exception{
	private static final long serialVersionUID = 8464424538397689212L;

	public QueryFail() {
		super("调查果获取失败,请先进行一段时间的调查");
	}
	
}
