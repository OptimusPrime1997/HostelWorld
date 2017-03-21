package com.nju.service.impl;

import com.nju.dao.BankaccountDao;
import com.nju.entity.Bankaccount;
import com.nju.service.BankaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
@Service
@Transactional
public class BankaccountServiceImpl implements BankaccountService {
//	public BankaccountServiceImpl() {
//		this.bankaccountDaoImpl = DaoFactory.getBankaccountDao();
//	}

	@Autowired
	private BankaccountDao bankaccountDaoImpl;

	public BankaccountDao getBankaccountDaoImpl() {
		return bankaccountDaoImpl;
	}

	public void setBankaccountDaoImpl(BankaccountDao bankaccountDaoImpl) {
		this.bankaccountDaoImpl = bankaccountDaoImpl;
	}

	public void add(Bankaccount u) {
		bankaccountDaoImpl.add(u);
	}

	public void delete(String uid) {
		bankaccountDaoImpl.delete(uid);
	}

	public void update(Bankaccount u) {
		bankaccountDaoImpl.update(u);
	}

	public Bankaccount get(String uid) {
		return bankaccountDaoImpl.get(uid);
	}

	public List<Bankaccount> findAll() {
		return bankaccountDaoImpl.findAll();
	}
}
