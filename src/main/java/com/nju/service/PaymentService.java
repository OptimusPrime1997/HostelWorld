package com.nju.service;

import com.nju.entity.Payment;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public interface PaymentService {


	public void add(Payment payment);

	public void delete(String payno);

	public void update(Payment payment);

	public Payment get(String payno);

	public List<Payment> findAll();
}
