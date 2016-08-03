package com.leftproject.daotest;
import java.util.List;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.leftproject.dao.*;
import com.leftproject.model.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class RoomDaoTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private RoomDao roomDao;
	
	@Test
	public void getRoomTest()
	{
		Room room = null;
		try{
			room = roomDao.getRoom("RS001");
		} catch(Exception ex) {
			System.out.println("Fail");
		}
		assertEquals(room.getRoomCode(),"RS001");
	}
	
	public void getRoomListTest()
	{
		List<Room> room = null;
		try{
			room = roomDao.getRoomList();
		} catch(Exception ex) {
			System.out.println("Fail");
		}
		assertEquals(room.size(),5);
	}
	
	
	@Test
	public void getReservationRoomTest()
	{
		List<Room> room = null;
		try{
			room = roomDao.getReservationRoom();
		} catch(Exception ex) {
			System.out.println("Fail");
		}
		assertEquals(room.size(),5);
	}
	
	@Test
	public void getRentRoomByCategoryTest()
	{
		List<Room> room = null;
		try{
			room = roomDao.getRentRoomByCategory("S");
		} catch(Exception ex) {
			System.out.println("Fail");
		}
		assertEquals(room.size(),1);
	}
	
	
	
}
