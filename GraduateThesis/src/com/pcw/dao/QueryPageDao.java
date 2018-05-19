package com.pcw.dao;

import java.util.List;

import com.pcw.bean.QueryPaper;

public interface QueryPageDao {
	void addQueryPage(QueryPaper querypage);
	void deleteByID(Long id);
	void update(QueryPaper querypage);
	QueryPaper findById(Long id);
	List<QueryPaper> findByUser(Long userid);
	List<QueryPaper> findAll();
}
