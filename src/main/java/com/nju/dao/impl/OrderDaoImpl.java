package com.nju.dao.impl;

import com.nju.dao.OrderDao;
import com.nju.entity.Order;
import com.nju.entity.Order;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.11.
 */
@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Order item) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.save(item);
		trans.commit();
	}

	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createSQLQuery("delete from `order` where orderno ='"+id+"'");
//		query.setString(0, id);
		query.executeUpdate();
		trans.commit();
	}

	public void update(Order u) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.update(u);
		trans.commit();
	}

	public Order get(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Order item = (Order) session.get(Order.class, id);
//		Query query = session.createSQLQuery("select * from order where orderno = ?");
//		query.setString(0, id);
//		Order item = (Order) query.uniqueResult();
		trans.commit();
		return item;
	}

	public List<Order> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(Order.class);
		List<Order> list = criteria.list();
		trans.commit();
		return list;
	}
}
