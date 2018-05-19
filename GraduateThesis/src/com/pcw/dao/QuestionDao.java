package com.pcw.dao;

import java.util.List;

import com.pcw.bean.Question;

public interface QuestionDao {
	void addQuestion(Question question);
//	≤ª¥ÚÀ„∆Ù”√
	void update(Question question);
	Question findById(Long id);
	List<Question> findAll();
	List<Question> findByPattern(String pattern);
	List<Question> findByQuery(Long queryid);
}

