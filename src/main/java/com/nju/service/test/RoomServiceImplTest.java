package com.nju.service.test;

import com.nju.entity.Room;
import com.nju.service.impl.RoomServiceImpl;
import com.nju.util.RoomType;
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
public class RoomServiceImplTest {
	@Autowired
	private RoomServiceImpl roomServiceImpl;
	private Timestamp timestamp = new Timestamp(new Date().getTime());

	public String getpayno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmms");
		return "1720001" + sdf.format(timestamp.getTime());
	}

	public RoomServiceImplTest() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		roomServiceImpl = (RoomServiceImpl) factory.getBean("roomServiceImpl");
	}

	public RoomServiceImpl getRoomServiceImpl() {
		return roomServiceImpl;
	}

	public void setRoomServiceImpl(RoomServiceImpl roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}

	//	@Test
	public void Aadd() throws Exception {
//		1720001	1001	STANDARD
		Room u = new Room("1720001","1002", RoomType.STANDARD,"");
		roomServiceImpl.add(u);
		System.out.println("add member room successfully!id:" + u.getRoomno());
	}

	//	@Test
	public void Ddelete() throws Exception {
		roomServiceImpl.delete("1720001","1002");
		System.out.println("delete member room successfully!id:" + "1710100");
	}

	//	@Test
	public void Bupdate() throws Exception {
		Room u = new Room("1720001","1002", RoomType.BIG,"");
		roomServiceImpl.update(u);
		System.out.println("update member room successfully!id:" + u.getHostelno());
	}

	//	@Test
	public void Cget() throws Exception {
		String uid = getpayno();
		Room room = roomServiceImpl.get("1720001","1001");
		if (room != null) {
			System.out.println(room.toString());
		} else {
			System.out.println("get room failed!");
		}

	}

	//	@Test
	public void EfindAll() throws Exception {
		List<Room> roomList = roomServiceImpl.findAll();
		for (Room u : roomList) {
			System.out.println("List:" + u.toString());
		}
	}

	public static void main(String[] args) {
		RoomServiceImplTest usit = new RoomServiceImplTest();
		try {
//			usit.Aadd();
//			usit.Bupdate();
			usit.Cget();
//			usit.Ddelete();
//			usit.EfindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}