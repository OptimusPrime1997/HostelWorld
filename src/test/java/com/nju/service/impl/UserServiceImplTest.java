package com.nju.service.impl;

import com.nju.dao.UserDao;
import com.nju.entity.User;
import com.nju.util.State;
import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by OptimusPrime on 2017.3.11.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {
	@Autowired
	private UserServiceImpl userServiceImpl;

	public UserServiceImplTest() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		userServiceImpl = (UserServiceImpl) factory.getBean("userServiceImpl");
	}

	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Test
	public void Aadd() throws Exception {
//		@Autowired	123456	1	吴会员	18256781238	10000	江苏省南京市鼓楼区珠江路5号	6212261234567890005	NORMAL
		User u = new User("1710100", "123456",
				1, "张会员", "18256781239",
				10000, "江苏省南京市鼓楼区珠江路10号",
				"6212261234567890009", State.NORMAL);
		userServiceImpl.add(u);
		System.out.println("add member user successfully!id:" + u.getUserno());
	}

	@Test
	public void Ddelete() throws Exception {
		userServiceImpl.delete("1710100");
		System.out.println("delete member user successfully!id:" + "1710100");
	}

	@Test
	public void Bupdate() throws Exception {
		User u = new User("1710100", "123456",
				1, "张会员", "18256781239",
				10000, "江苏省南京市鼓楼区珠江路100号",
				"6212261234567890009", State.NORMAL);
		userServiceImpl.update(u);
		System.out.println("update member user successfully!id:" + u.getUserno());
	}

	@Test
	public void Cget() throws Exception {
		String uid = "170100";
		User user = userServiceImpl.get(uid);
		System.out.println(user.toString());
	}

	@Test
	public void EfindAll() throws Exception {
		List<User> userList = userServiceImpl.findAll();
		for (User u : userList) {
			System.out.println("List:" + u.toString());
		}
	}

}