package com.leftproject.daotest;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.leftproject.dao.*;
import com.leftproject.model.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class RentDaoTest {
	@Autowired
	RentDao rentDao;
	
	String userCode = "UEX000001";
	String roomCode = "RG003";
	
	@Test
	public void setRentPhaseTest()
	{
		Rent rent = rentDao.getRentByCode("RE1606001");
		if(rent.getRentPhase()=="1")
		{
			rentDao.setRentPhase(rent, "3");
			rent = rentDao.getRentByCode("RE1606001");
			assertEquals("3", rent.getRentPhase());
		}
		else
		{
			rentDao.setRentPhase(rent, "1");
			rent = rentDao.getRentByCode("RE1606001");
			assertEquals("1", rent.getRentPhase());
		}
			
	}
	
	private Rent rentDataTest()
	{
		Date dateTest = new Date();
		Rent rent = new Rent();
		User user = new User();
		user.setUserCode(userCode);
		Room room = new Room();
		room.setRoomCode(roomCode);
		rent.setUser(user);
		rent.setRoom(room);
		rent.setCreatedDate(dateTest);
		rent.setEventCategory("1");
		rent.setEventName("Bersenang-senang");
		rent.setRentDateStart(dateTest);
		rent.setRentDateEnd(dateTest);
		rent.setRentOperationalPrice(200000);
		rent.setRentPrice(400000);
		rent.setRentPhase("N");
		rent.setRentStatus("1");
		rent.setRenter("Bambang");
		return rent;
	}
	
	@Test
	public void saveRentTest()
	{
		User user = new User();
		user.setUserCode(userCode);
		Rent rent = rentDataTest();
		int count = rentDao.getAllRentsByUser(user).size();
		rentDao.saveRent(rent);
		rentDao.sessionFlush();
		assertEquals(count+1, rentDao.getAllRentsByUser(user).size());
	}
	
	@Test
	public void updateRentTest()
	{
		Rent rent = rentDao.getRentByCode("RE1606001");
		Rent updatedRent = rent;
		if(rent.getRenter()=="Bambang")
		{
			updatedRent.setRenter("Budi");
		}
		else
		{
			updatedRent.setRenter("Bambang");
		}
		rentDao.updateRent(updatedRent);
		rentDao.sessionFlush();
		rent = rentDao.getRentByCode(updatedRent.getRentCode());
		assertEquals(updatedRent.getRenter(), rent.getRenter());
	}
	
	@Test 
	public void getAllMinRentTest()
	{
		User user = new User();
		user.setUserCode(userCode);
		List<Rent> rent = rentDao.getAllMinRent(user);
		assertNotNull(rent);
		assertNotEquals(0, rent.size());
	}
	
	@Test
	public void getAllRentsByUserTest()
	{
		User user = new User();
		user.setUserCode(userCode);
		List<Rent> rents = rentDao.getAllRentsByUser(user);
		assertNotNull(rents);
		assertTrue(rents.size()>0);
	}
	
	@Test
	public void getProposedRent()
	{
		List<Rent> rents = rentDao.getProposedRent();
		assertNotNull(rents);
		assertTrue(rents.size()>0);
		
	}
	
	@Test
	public void getRentByCode()
	{
		Rent rent = rentDao.getRentByCode("RE1606001");
		assertNotNull(rent);
	}
	
}
