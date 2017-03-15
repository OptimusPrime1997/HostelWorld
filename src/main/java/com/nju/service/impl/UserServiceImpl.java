package com.nju.service.impl;

import com.nju.dao.UserDao;
import com.nju.entity.User;
import com.nju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mark on 4/24/15.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDaoImpl;

	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	public void add(User u) {
		userDaoImpl.add(u);
	}

	public void delete(String uid) {
		userDaoImpl.delete(uid);
	}

	public void update(User u) {
		userDaoImpl.update(u);
	}

	public User get(String uid) {
		return userDaoImpl.get(uid);
	}

	public List<User> findAll() {
		return userDaoImpl.findAll();
	}

	public boolean checkLogin(String uid, String passwd) {
		User u = get(uid);
		if (u == null) {
			System.out.println("UserServiceImpl->get failed!no uid");
			return false;
		} else {
			if (!u.getPassword().equals(passwd)) {
				return false;
			} else {
				return true;
			}
		}
	}
}
