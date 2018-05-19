package com.pcw.dao;

import java.util.List;

import com.pcw.bean.User;

public interface UserDao {
	void addUser(User user);
	void deleteById(long id);
	void updateUser(User user);
	User findById(long id);
	User findByName(String username);
	User findByPhone(String phonenum);
	User findByEmail(String email);
	List<User> findByPattern(String pattern);
}
