package com.nju.dao.impl;

import com.nju.dao.PaymentDao;
import com.nju.entity.Payment;
import com.nju.entity.Payment;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.11.
 */
@Repository
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Payment item) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.save(item);
		trans.commit();
	}

	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createSQLQuery(
				"delete from payment where payno ='" + id + "'");
//		query.setString(0, id);
		query.executeUpdate();
		trans.commit();
	}

	public void update(Payment u) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.update(u);
		trans.commit();
	}

	public Payment get(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
//		Query query = session.createSQLQuery("select * from payment where orderno = ?");
//		query.setString(0, id);
		Payment item = (Payment) session.get(Payment.class, id);
		trans.commit();
		return item;
	}

	public List<Payment> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(Payment.class);
		List<Payment> list = criteria.list();
		trans.commit();
		return list;
	}
}
