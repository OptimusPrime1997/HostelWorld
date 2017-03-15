package com.nju.dao.impl;

import com.nju.dao.DepositDao;
import com.nju.entity.Deposit;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.11.
 */
@Repository
public class DepositDaoImpl implements DepositDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Deposit item) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.save(item);
		trans.commit();
	}

	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createSQLQuery("delete from deposit where depositno = ?");
		query.setString(0, id);
//		query.setString(1, timestamp.toString().substring(0,19));
		query.executeUpdate();
		trans.commit();
	}

	public void update(Deposit u) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createSQLQuery("update deposit set  bankAccount=? , depositAmount=? where depositno = ? and time = ?");
		query.setString(0, u.getBankAccount());
		query.setDouble(1, u.getDepositAmount());
		query.setString(2, u.getDepositno());
		query.setString(3, u.getTime().toString().substring(0, 19));
		query.executeUpdate();
		trans.commit();
	}

	public Deposit get(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Deposit item=(Deposit) session.get(Deposit.class,id);
//		Query query = session.createSQLQuery("select * from deposit where depositno = ?");
//		query.setString(0, id);
//		Deposit item = (Deposit) query.uniqueResult();
		trans.commit();
		return item;
	}

	public List<Deposit> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(Deposit.class);
		List<Deposit> list = criteria.list();
		trans.commit();
		return list;
	}
}
