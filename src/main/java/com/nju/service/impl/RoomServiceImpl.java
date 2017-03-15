package com.nju.service.impl;

import com.nju.dao.RoomDao;
import com.nju.entity.Room;
import com.nju.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao roomDaoImpl;

	public RoomDao getRoomDaoImpl() {
		return roomDaoImpl;
	}

	public void setRoomDaoImpl(RoomDao roomDaoImpl) {
		this.roomDaoImpl = roomDaoImpl;
	}

	public void add(Room u) {
		roomDaoImpl.add(u);
	}

	public void delete(String hostelno, String roomno) {
		roomDaoImpl.delete(hostelno, roomno);
	}

	public void update(Room d) {
		roomDaoImpl.update(d);
	}

	public Room get(String hostelno, String roomno) {
		return roomDaoImpl.get(hostelno, roomno);
	}

	public List<Room> findAll() {
		return roomDaoImpl.findAll();
	}
}
