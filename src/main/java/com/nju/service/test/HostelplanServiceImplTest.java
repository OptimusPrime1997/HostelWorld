package com.nju.service.test;

import com.nju.entity.Hostelplan;
import com.nju.entity.Room;
import com.nju.service.impl.HostelplanServiceImpl;
import com.nju.util.RoomType;
import com.nju.util.State;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
public class HostelplanServiceImplTest {
	@Autowired
	private HostelplanServiceImpl hostelplanServiceImpl;

	public HostelplanServiceImplTest() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		hostelplanServiceImpl = (HostelplanServiceImpl) factory.getBean("hostelplanServiceImpl");
	}

	public HostelplanServiceImpl getHostelplanServiceImpl() {
		return hostelplanServiceImpl;
	}

	public void setHostelplanServiceImpl(HostelplanServiceImpl hostelplanServiceImpl) {
		this.hostelplanServiceImpl = hostelplanServiceImpl;
	}

	//	@Test
	public void Aadd() throws Exception {
//		@Autowired	123456	1	吴会员	18256781238	10000	江苏省南京市鼓楼区珠江路5号	6212261234567890005	NORMAL
		Hostelplan u = new Hostelplan("17200031",
				"1720003",new Date(
				2017-1900,0,1),
				new Date(2018-1900,0,1),
				RoomType.STANDARD,155);
		hostelplanServiceImpl.add(u);
		System.out.println("add member hostelplan successfully!id:" + u.getHostelplanno());
	}

	//	@Test
	public void Ddelete() throws Exception {
		hostelplanServiceImpl.delete("17200031");
		System.out.println("delete member hostelplan successfully!id:" + "1710100");
	}

	//	@Test
	public void Bupdate() throws Exception {
		Hostelplan u = new Hostelplan("17200031",
				"1720003",new Date(
				2017-1900,0,1),
				new Date(2018-1900,0,1),
				RoomType.STANDARD,185);
		hostelplanServiceImpl.update(u);
		System.out.println("update member hostelplan successfully!id:" + u.getHostelplanno());
	}

	//	@Test
	public void Cget() throws Exception {
		String uid = "17200031";
		Hostelplan hostelplan = hostelplanServiceImpl.get(uid);
		if (hostelplan != null) {
			System.out.println(hostelplan.toString());
		} else {
			System.out.println("get hostelplan failed!");
		}

	}

	//	@Test
	public void EfindAll() throws Exception {
		List<Hostelplan> hostelplanList = hostelplanServiceImpl.findAll();
		for (Hostelplan u : hostelplanList) {
			System.out.println("List:" + u.toString());
		}
	}

	public static void main(String[] args) {
		HostelplanServiceImplTest usit = new HostelplanServiceImplTest();
		try {
			usit.Aadd();
			usit.Bupdate();
			usit.Cget();
			usit.Ddelete();
			usit.EfindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}