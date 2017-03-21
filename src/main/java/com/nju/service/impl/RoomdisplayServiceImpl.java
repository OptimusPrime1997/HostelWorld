package com.nju.service.impl;

import com.nju.dao.RoomdisplayDao;
import com.nju.entity.Roomdisplay;
import com.nju.service.RoomdisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.17.
 */
@Service
public class RoomdisplayServiceImpl implements RoomdisplayService {
	@Autowired
	private RoomdisplayDao roomdisplayDaoImpl;

	public RoomdisplayDao getRoomdisplayDaoImpl() {
		return roomdisplayDaoImpl;
	}

	public void setRoomdisplayDaoImpl(RoomdisplayDao roomdisplayDaoImpl) {
		this.roomdisplayDaoImpl = roomdisplayDaoImpl;
	}

	public Roomdisplay get(String hostelno, String roomno) {
		return roomdisplayDaoImpl.get(hostelno, roomno);
	}

	public List<Roomdisplay> findAll() {
		return roomdisplayDaoImpl.findAll();
	}
}
