package com.leftproject.servicetest;

import java.util.List;

import com.leftproject.dao.RoomDao;
import com.leftproject.daotest.TestConfiguration;
import com.leftproject.model.Room;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class RoomServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private RoomDao roomDao;
	
	@Test
	public void getRoomListTest()
	{
		List<Room> room = roomDao.getRoomList();
		assertEquals(5,room.size());
	}

	@Test
	public void getReservationRoomTest()
	{
		List<Room> room = roomDao.getReservationRoom();
		assertEquals(2,room.size());
	}

	@Test
	public void getRentRoomByCategoryTest()
	{
		List<Room> room = roomDao.getRentRoomByCategory("S");
		assertEquals(1,room.size());
		
	}
	
	@Test
	public void getRoomTest()
	{
		Room room = roomDao.getRoom("RS001");
		assertEquals("Gedung Kuliah Bersama",room.getRoomName());
	}
}
