package com.nju.service;

import com.nju.entity.Bankaccount;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public interface BankaccountService {

	public void add(Bankaccount b);

	public void delete(String account);

	public void update(Bankaccount u);

	public Bankaccount get(String account);

	public List<Bankaccount> findAll();
}
