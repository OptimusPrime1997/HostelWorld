package com.nju.dao.impl;

import com.nju.dao.RoomdisplayDao;
import com.nju.entity.Room;
import com.nju.entity.RoomPK;
import com.nju.entity.Roomdisplay;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.17.
 */
@Repository
//@Transactional
public class RoomdisplayDaoImpl implements RoomdisplayDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public com.nju.entity.Roomdisplay get(String hostelno, String roomno) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		RoomPK r = new RoomPK();
		r.setHostelno(hostelno);
		r.setRoomno(roomno);
		Roomdisplay item = (Roomdisplay) session.get(Roomdisplay.class, r);
		trans.commit();
		return item;
	}

	public List<com.nju.entity.Roomdisplay> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(Roomdisplay.class);
		List<Roomdisplay> list = criteria.list();
		trans.commit();
		return list;
	}
}
