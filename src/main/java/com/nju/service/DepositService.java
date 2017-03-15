package com.nju.service;

import com.nju.entity.Deposit;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public interface DepositService {


	public void add(Deposit u);

	public void delete(String depositno);

	public void update(Deposit d);

	public Deposit get(String depositno);

	public List<Deposit> findAll();
}
