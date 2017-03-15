package com.nju.service.test;

import com.nju.entity.Deposit;
import com.nju.service.impl.DepositServiceImpl;
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
public class DepositServiceImplTest {
	@Autowired
	private DepositServiceImpl depositServiceImpl;
	private Timestamp timestamp = new Timestamp(new Date().getTime());
	public DepositServiceImplTest() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		depositServiceImpl = (DepositServiceImpl) factory.getBean("depositServiceImpl");
	}

	public DepositServiceImpl getDepositServiceImpl() {
		return depositServiceImpl;
	}

	public void setDepositServiceImpl(DepositServiceImpl depositServiceImpl) {
		this.depositServiceImpl = depositServiceImpl;
	}

	public String getDepositno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmms");
		String str = "1710001" + sdf.format(timestamp.getTime());
		return str;
	}

	//	@Test
	public void Aadd() throws Exception {
//		@Autowired	123456	1	吴会员	18256781238	10000	江苏省南京市鼓楼区珠江路5号	6212261234567890005	NORMAL


		Deposit u = new Deposit(getDepositno(), "6212261234567890005", timestamp, 10000);
		depositServiceImpl.add(u);
		System.out.println("add member deposit successfully!id:" + u.getTime());
	}

	//	@Test
	public void Ddelete() throws Exception {
		depositServiceImpl.delete(getDepositno());
		System.out.println("delete member deposit successfully!id:" + "1710001");
	}

	//	@Test
	public void Bupdate() throws Exception {
		Deposit u = new Deposit(getDepositno(), "6212261234567890005", timestamp, 100);
		depositServiceImpl.update(u);
		System.out.println("update member deposit successfully!id:" + u.getTime());
	}

	//	@Test
	public void Cget() throws Exception {
//		String uid = "6212261234567890101";
		Deposit deposit = depositServiceImpl.get(getDepositno());
		if (deposit != null) {
			System.out.println(deposit.toString());
		} else {
			System.out.println("get deposit failed!");
		}
	}

	//	@Test
	public void EfindAll() throws Exception {
		List<Deposit> depositList = depositServiceImpl.findAll();
		for (Deposit u : depositList) {
			System.out.println("List:" + u.toString());
		}
//		System.out.println("toString:" + timestamp.toString().substring(0, 19));
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmms");
//		System.out.println(sdf.format(timestamp.getTime()));
	}

	public static void main(String[] args) {
		DepositServiceImplTest item = new DepositServiceImplTest();
		try {
			item.Aadd();
			item.Bupdate();
			item.Cget();
			item.Ddelete();
			item.EfindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}