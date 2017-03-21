package com.nju.dao.impl;

import com.nju.dao.BankaccountDao;
import com.nju.entity.Bankaccount;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.11.
 */
@Repository
public class BankaccountDaoImpl implements BankaccountDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Bankaccount item) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.save(item);
		trans.commit();
	}

	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createSQLQuery("delete from bankaccount where bankAccount ='" + id + "'");
//		query.setString(0,id);
		query.executeUpdate();
		trans.commit();
	}

	public void update(Bankaccount u) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.update(u);
		trans.commit();
	}

	public Bankaccount get(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Bankaccount item = (Bankaccount) session.get(Bankaccount.class, id);
		trans.commit();
		return item;
	}

	public List<Bankaccount> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(Bankaccount.class);
		List<Bankaccount> list = criteria.list();
		trans.commit();
		return list;
	}
}
