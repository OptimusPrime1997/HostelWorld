package com.nju.dao.impl;

import com.nju.dao.UserDao;
import com.nju.entity.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mark on 4/24/15.
 */

@Repository
public class UserDaoImpl implements UserDao {
//	public UserDaoImpl() {
//		Configuration cfg = new Configuration();
//		cfg = cfg.configure("applicationContext.xml");
//		// 获取sessionFactory
//		this.sessionFactory = cfg.buildSessionFactory();
//	}

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(User u) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(u);
		trans.commit();
	}

	public void delete(String uid) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createSQLQuery("delete from user where userno = '" + uid + "'");
//		query.setString(0, uid);
		query.executeUpdate();
		trans.commit();
	}

	public void update(User u) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.update(u);
		trans.commit();
	}

	public User get(String uid) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		User u = (User) session.get(User.class, uid);
		trans.commit();
		return u;
	}

	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		List<User> userList = criteria.list();
//		User u = (User) session.get(User.class, uid);
		trans.commit();
		return userList;
	}

	//
	public String getUserno(int userType) {
		List<User> userList = findAll();
		String newUserStr = null;
		if (userList != null) {
			int newU = userList.size() + 1;
			newUserStr = "17" + userType + String.format("%04d", newU);
		} else {
			System.out.println("UserDaoImpl->getUserno:get newUserno failed!" + newUserStr);
		}
		return newUserStr;
	}

	public List<User> findToPay() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from User where usertype=? and balance>?");
		query.setParameter(0, 2);
		query.setParameter(1, 0.0);

		List list = query.list();
		List<User> orderList = new ArrayList<User>();
		User o = null;
		for (int i = 0; i < list.size(); i++) {
			o = (User) list.get(i);
			orderList.add(o);
		}

		trans.commit();
		return orderList;
	}

	public List<User> findList(int userType) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from User where usertype=?");
		query.setParameter(0, userType);
		List list = query.list();
		List<User> orderList = new ArrayList<User>();
		User o = null;
		for (int i = 0; i < list.size(); i++) {
			o = (User) list.get(i);
			orderList.add(o);
		}

		trans.commit();
		return orderList;
	}
}
