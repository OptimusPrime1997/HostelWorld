package com.nju.service.impl;

import com.nju.dao.PaymentDao;
import com.nju.entity.Payment;
import com.nju.entity.Payment;
import com.nju.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
@Service("paymentService")
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDaoImpl;

	public PaymentDao getPaymentDaoImpl() {
		return paymentDaoImpl;
	}

	public void setPaymentDaoImpl(PaymentDao paymentDaoImpl) {
		this.paymentDaoImpl = paymentDaoImpl;
	}

	public void add(Payment u) {
		paymentDaoImpl.add(u);
	}

	public void delete(String paymentno) {
		paymentDaoImpl.delete(paymentno);
	}

	public void update(Payment d) {
		paymentDaoImpl.update(d);
	}

	public Payment get(String paymentno) {
		return paymentDaoImpl.get(paymentno);
	}

	public List<Payment> findAll() {
		return paymentDaoImpl.findAll();
	}
}
