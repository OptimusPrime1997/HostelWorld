package com.nju.dao.impl;

import com.nju.dao.UserDao;
import com.nju.entity.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mark on 4/24/15.
 */

@Repository
public class UserDaoImpl implements UserDao {

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
		session.save(u);
		trans.commit();
	}

	public void delete(String uid) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createSQLQuery("delete from user where userno = ?");
		query.setString(0, uid);
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
}
