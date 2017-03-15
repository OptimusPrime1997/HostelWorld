package com.nju.service;

import com.nju.entity.Room;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public interface RoomService {


	public void add(Room u);

	public void delete(String hostelno, String roomno);

	public void update(Room u);

	public Room get(String hostelno, String roomno);

	public List<Room> findAll();
}
