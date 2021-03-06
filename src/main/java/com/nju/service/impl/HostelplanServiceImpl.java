package com.nju.service.impl;

import com.nju.dao.HostelplanDao;
import com.nju.entity.Hostelplan;
import com.nju.service.HostelplanService;
import com.nju.util.PlanState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
@Service
@Transactional
public class HostelplanServiceImpl implements HostelplanService {
//	public HostelplanServiceImpl() {
//		this.hostelplanDaoImpl= DaoFactory.getHostelplanDao();
//	}

	@Autowired
	private HostelplanDao hostelplanDaoImpl;

	public HostelplanDao getHostelplanDaoImpl() {
		return hostelplanDaoImpl;
	}

	public void setHostelplanDaoImpl(HostelplanDao hostelplanDaoImpl) {
		this.hostelplanDaoImpl = hostelplanDaoImpl;
	}

	public void add(Hostelplan u) {
		hostelplanDaoImpl.add(u);
	}

	public void delete(String uid) {
		hostelplanDaoImpl.delete(uid);
	}

	public void update(Hostelplan u) {
		hostelplanDaoImpl.update(u);
	}

	public Hostelplan get(String uid) {
		return hostelplanDaoImpl.get(uid);
	}

	public List<Hostelplan> findAll() {
		return hostelplanDaoImpl.findAll();
	}

	public List<Hostelplan> findList(String hostelno) {
		return hostelplanDaoImpl.findList(hostelno);
	}

	public List<Hostelplan> findList(String hostelno, PlanState planState) {
		return hostelplanDaoImpl.findList(hostelno,planState);
	}
}
