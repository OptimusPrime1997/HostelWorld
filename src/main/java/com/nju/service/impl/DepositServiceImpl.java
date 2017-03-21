package com.nju.service.impl;

import com.nju.dao.DepositDao;
import com.nju.entity.Deposit;
import com.nju.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
@Service
@Transactional
public class DepositServiceImpl implements DepositService {
//	public DepositServiceImpl() {
//		this.depositDaoImpl= DaoFactory.getDepositDao();
//	}

	@Autowired
	private DepositDao depositDaoImpl;

	public DepositDao getDepositDaoImpl() {
		return depositDaoImpl;
	}

	public void setDepositDaoImpl(DepositDao depositDaoImpl) {
		this.depositDaoImpl = depositDaoImpl;
	}

	public void add(Deposit u) {
		depositDaoImpl.add(u);
	}

	public void delete(String depositno) {
		depositDaoImpl.delete(depositno);
	}

	public void update(Deposit d) {
		depositDaoImpl.update(d);
	}

	public Deposit get(String depositno) {
		return depositDaoImpl.get(depositno);
	}

	public List<Deposit> findAll() {
		return depositDaoImpl.findAll();
	}
}
