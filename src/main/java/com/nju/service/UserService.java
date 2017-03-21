package com.nju.service;


import com.nju.entity.User;

import java.util.List;

/**
 * Created by mark on 4/24/15.
 */
public interface UserService {
	public void save(User u);

	public String add(User u);

	public void delete(String uid);

	public void update(User u);

	public User get(String uid);

	public List<User> findAll();

	/**
	 * false:0
	 * true:1 2 3
	 *
	 * @param uid
	 * @param passwd
	 * @return
	 */
	public User checkLogin(String uid, String passwd);

	public List<User> findToPay();

	public List<User> findList(int userType);
}
