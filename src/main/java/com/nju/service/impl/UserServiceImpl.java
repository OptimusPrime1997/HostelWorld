package com.nju.service.impl;

import com.nju.dao.RoomDao;
import com.nju.dao.UserDao;
import com.nju.entity.Room;
import com.nju.entity.User;
import com.nju.service.UserService;
import com.nju.util.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mark on 4/24/15.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
//	public UserServiceImpl() {
//		this.userDaoImpl = DaoFactory.getUserDao();
//	}

	@Autowired
	private UserDao userDaoImpl;
	@Autowired
	private RoomDao roomDaoImpl;

	public RoomDao getRoomDaoImpl() {
		return roomDaoImpl;
	}

	public void setRoomDaoImpl(RoomDao roomDaoImpl) {
		this.roomDaoImpl = roomDaoImpl;
	}

	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	public void save(User u) {
		userDaoImpl.add(u);
	}

	public String add(User u) {
		int userType = u.getUserType();
		if (userType == 0) {
			userType = 2;
		}
		List<User> userList = userDaoImpl.findList(userType);
		List<User> unUserList = userDaoImpl.findList(0);

		int newSize = 0;
		newSize += (userList.size() + 1);
		if (unUserList != null) {
			newSize += unUserList.size();
		}
		String userno = "18" + userType + String.format("%04d", newSize);
		if (userno != null) {
			u.setUserno(userno);
			System.out.println(u.toString());
			userDaoImpl.add(u);
		} else {
			System.out.println("UserServiceImpl->getUserno is null!");
		}
		if(userType==2){
			Room r1=new Room(userno,"1001", RoomType.STANDARD,null);
			Room r2=new Room(userno,"2001",RoomType.BIG,null);
			roomDaoImpl.add(r1);
			roomDaoImpl.add(r2);
		}
		return userno;
	}

	public void delete(String uid) {
		userDaoImpl.delete(uid);
	}

	public void update(User u) {
		userDaoImpl.update(u);
	}

	public User get(String uid) {
		return userDaoImpl.get(uid);
	}

	public List<User> findAll() {
		return userDaoImpl.findAll();
	}

	public User checkLogin(String uid, String passwd) {
		User u = get(uid);
		if (u == null) {
			System.out.println("UserServiceImpl->get failed!no uid");
			return null;
		} else {
			System.out.println("my password:" + passwd + "---" + u.toString());
			if (u.getPassword().equals(passwd)) {
				return u;
			} else {
				return null;
			}
		}
	}

	public List<User> findToPay() {
		return userDaoImpl.findToPay();
	}

	public List<User> findList(int userType) {
		return userDaoImpl.findList(userType);
	}
}
