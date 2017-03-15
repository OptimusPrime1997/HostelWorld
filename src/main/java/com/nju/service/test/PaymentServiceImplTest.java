package com.nju.service.test;

import com.nju.entity.Payment;
import com.nju.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
public class PaymentServiceImplTest {
	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	private Timestamp timestamp = new Timestamp(new Date().getTime());

	public String getpayno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmms");
		return "1720001" + sdf.format(timestamp.getTime());
	}

	public PaymentServiceImplTest() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		paymentServiceImpl = (PaymentServiceImpl) factory.getBean("paymentServiceImpl");
	}

	public PaymentServiceImpl getPaymentServiceImpl() {
		return paymentServiceImpl;
	}

	public void setPaymentServiceImpl(PaymentServiceImpl paymentServiceImpl) {
		this.paymentServiceImpl = paymentServiceImpl;
	}

	//	@Test
	public void Aadd() throws Exception {
//		172000120170310111754	2017-03-10 11:17:54.000000	10000	0.01	100	9900	1720001
		Payment u = new Payment(getpayno(), "1720001", timestamp, 10000, 0.01, 100, 9900);
		paymentServiceImpl.add(u);
		System.out.println("add member payment successfully!id:" + u.getPayno());
	}

	//	@Test
	public void Ddelete() throws Exception {
		paymentServiceImpl.delete(getpayno());
		System.out.println("delete member payment successfully!id:" + "1710100");
	}

	//	@Test
	public void Bupdate() throws Exception {
		Payment u = new Payment(getpayno(), "1720001", timestamp, 10000, 0.02, 200, 9800);
		paymentServiceImpl.update(u);
		System.out.println("update member payment successfully!id:" + u.getHostelno());
	}

	//	@Test
	public void Cget() throws Exception {
		String uid = getpayno();
		Payment payment = paymentServiceImpl.get(uid);
		if (payment != null) {
			System.out.println(payment.toString());
		} else {
			System.out.println("get payment failed!");
		}

	}

	//	@Test
	public void EfindAll() throws Exception {
		List<Payment> paymentList = paymentServiceImpl.findAll();
		for (Payment u : paymentList) {
			System.out.println("List:" + u.toString());
		}
	}

	public static void main(String[] args) {
		PaymentServiceImplTest usit = new PaymentServiceImplTest();
		try {
//			usit.Aadd();
//			usit.Bupdate();
//			usit.Cget();
			usit.Ddelete();
			usit.EfindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}