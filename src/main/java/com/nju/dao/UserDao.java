package com.nju.dao;


import com.nju.entity.User;

import java.util.List;

/**
 * Created by mark on 4/24/15.
 */
public interface UserDao {
	public void add(User u);

	public void delete(String uid);

	public void update(User u);

	public User get(String uid);

	public List<User> findAll();

}
