package com.nju.dao.impl;

import com.nju.dao.RoomDao;
import com.nju.entity.Room;
import com.nju.entity.RoomPK;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.11.
 */
@Repository
public class RoomDaoImpl implements RoomDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Room item) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.save(item);
		trans.commit();
	}

	public void delete(String id, String roomno) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createSQLQuery("delete from room where hostelno = '"
				+ id + "' and roomno = '" + roomno + "'");
//		query.setString(0, id);
//		query.setString(1, roomno);
		query.executeUpdate();
		trans.commit();
	}

	public void update(Room u) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.update(u);
		trans.commit();
	}

	public Room get(String id, String roomno) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		RoomPK r = new RoomPK();
		r.setHostelno(id);
		r.setRoomno(roomno);
//		Query query = session.createSQLQuery("select * from room where hostelno = ? and roomno = ?");
//		query.setString(0, id);
//		query.setString(1, roomno);
		Room item = (Room) session.get(Room.class, r);
		trans.commit();
		return item;
	}

	public List<Room> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(Room.class);
		List<Room> list = criteria.list();
		trans.commit();
		return list;
	}
}
