package com.nju.service.test;

import com.nju.entity.Bankaccount;
import com.nju.service.impl.BankaccountServiceImpl;
import com.nju.util.State;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
public class BankaccountServiceImplTest {

	@Autowired
	private BankaccountServiceImpl bankaccountServiceImpl;

	public BankaccountServiceImplTest() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		bankaccountServiceImpl = (BankaccountServiceImpl) factory.getBean("bankaccountServiceImpl");
	}

	public BankaccountServiceImpl getBankaccountServiceImpl() {
		return bankaccountServiceImpl;
	}

	public void setBankaccountServiceImpl(BankaccountServiceImpl bankaccountServiceImpl) {
		this.bankaccountServiceImpl = bankaccountServiceImpl;
	}

	//	@Test
	public void Aadd() throws Exception {
//		@Autowired	123456	1	吴会员	18256781238	10000	江苏省南京市鼓楼区珠江路5号	6212261234567890005	NORMAL
		Bankaccount u = new Bankaccount("6212261234567890101",10000, "123456");
		bankaccountServiceImpl.add(u);
		System.out.println("add member bankaccount successfully!id:" + u.getBankAccount());
	}

	//	@Test
	public void Ddelete() throws Exception {
		bankaccountServiceImpl.delete("6212261234567890101");
		System.out.println("delete member bankaccount successfully!id:" + "6212261234567890101");
	}

	//	@Test
	public void Bupdate() throws Exception {
		Bankaccount u =new Bankaccount("6212261234567890101",1000000, "123456");
		bankaccountServiceImpl.update(u);
		System.out.println("update member bankaccount successfully!id:" + u.getBankAccount());
	}

	//	@Test
	public void Cget() throws Exception {
		String uid = "6212261234567890101";
		Bankaccount bankaccount = bankaccountServiceImpl.get(uid);
		if (bankaccount != null) {
			System.out.println(bankaccount.toString());
		} else {
			System.out.println("get bankaccount failed!");
		}

	}

	//	@Test
	public void EfindAll() throws Exception {
		List<Bankaccount> bankaccountList = bankaccountServiceImpl.findAll();
		for (Bankaccount u : bankaccountList) {
			System.out.println("List:" + u.toString());
		}
	}

	public static void main(String[] args) {
		BankaccountServiceImplTest item = new BankaccountServiceImplTest();
		try {
//			item.Aadd();
//			item.Bupdate();
//			item.Cget();
			item.Ddelete();
			item.EfindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		6212261234567890001	10000	123456
//		6212261234567890002	10000	123456
//		6212261234567890003	10000	123456
//		6212261234567890004	10000	123456
//		6212261234567890005	10000	123456
	}

}