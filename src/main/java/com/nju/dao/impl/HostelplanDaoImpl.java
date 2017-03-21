package com.nju.dao.impl;

import com.nju.dao.HostelplanDao;
import com.nju.entity.Hostelplan;
import com.nju.entity.Hostelplan;
import com.nju.entity.Order;
import com.nju.util.PlanState;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.11.
 */
@Repository
public class HostelplanDaoImpl implements HostelplanDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Hostelplan item) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.save(item);
		trans.commit();
	}

	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createSQLQuery("delete from hostelplan where hostelplanno ='" + id + "'");

//		query.setString(0, id);
		query.executeUpdate();
		trans.commit();
	}

	public void update(Hostelplan u) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.update(u);
		trans.commit();
	}

	public Hostelplan get(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Hostelplan item = (Hostelplan) session.get(Hostelplan.class, id);
		trans.commit();
		return item;
	}

	public List<Hostelplan> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(Hostelplan.class);
		List<Hostelplan> list = criteria.list();
		trans.commit();
		return list;
	}

	public List<Hostelplan> findList(String hostelno) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from Hostelplan where hostelno=?");
		query.setParameter(0, hostelno);
		List list = query.list();
		List<Hostelplan> hostelplanList = new ArrayList<Hostelplan>();
		Hostelplan o = null;
		for (int i = 0; i < list.size(); i++) {
			o = (Hostelplan) list.get(i);
			hostelplanList.add(o);
		}
		trans.commit();
		return hostelplanList;
	}

	public List<Hostelplan> findList(String hostelno, PlanState planState) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from Hostelplan where hostelno=? and planState=?");
		query.setParameter(0, hostelno);
		query.setParameter(1, planState);
		List list = query.list();
		List<Hostelplan> hostelplanList = new ArrayList<Hostelplan>();
		Hostelplan o = null;
		for (int i = 0; i < list.size(); i++) {
			o = (Hostelplan) list.get(i);
			hostelplanList.add(o);
		}
		trans.commit();
		return hostelplanList;
	}
}
