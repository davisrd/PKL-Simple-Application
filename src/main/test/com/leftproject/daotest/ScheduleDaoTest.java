package com.leftproject.daotest;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.leftproject.dao.*;
import com.leftproject.model.Room;
import com.leftproject.model.Schedule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class ScheduleDaoTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	ScheduleDao scheduleDao;
	
	@Autowired
	RoomDao roomDao;
	
	@Test
	public void getRoomEmptyStatusTest()
	{
		Room room = roomDao.getRoom("RG003");
		assertEquals("Student Center", room.getRoomName());
		
		Date date = new Date();
		int status = scheduleDao.getListSchedule(room.getRoomCode(), date, date).size();
		assertEquals(status, 0);
	}
	
	@Test
	public void getScheduleByIdTest() throws ParseException
	{
		Schedule sc = scheduleDao.getSchedule(1);
		
		assertEquals(sc.getRoom().getRoomCode(), "RG001");
	}

	@Test
	public void getRoomUsedStatusTest() throws ParseException
	{
		Room room = roomDao.getRoom("RG001");
//		assertEquals("Student Center", room.getRoomName());

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		int status = scheduleDao.getListSchedule(room.getRoomCode(), df.parse("2016-05-18T17:00:00.000Z"), df.parse("2016-06-18T17:00:00.000Z")).size();
		assertEquals(status, 1);
	}
	
	@Test
	public void getScheduleTest()
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Schedule schedule = null;
		try{
			schedule = scheduleDao.getSchedule("RG002", df.parse("2016-06-03 00:00:00"), df.parse("2016-06-04 00:00:00"));
		} catch(Exception ex) {
			System.out.println("Fail");
		}
		assertEquals(schedule.getRoom().getRoomCode(), "RG002");
	}
	
	@Test
	public void saveScheduleTest()
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Room room = roomDao.getRoom("RG002");
		Schedule schedule = null;
		Schedule getSchedule = null;
		try{
			schedule = new Schedule();

			schedule.setIdSchedule(3);
			schedule.setRoom(room);
			schedule.setUsageStatus("1");
			schedule.setDateStart(df.parse("2016-07-03 00:00:00"));
			schedule.setDateEnd(df.parse("2016-07-04 00:00:00"));
			
			scheduleDao.saveSchedule(schedule);
			scheduleDao.sessionFlush();
			
			getSchedule = scheduleDao.getSchedule("RG002", df.parse("2016-07-03 00:00:00"), df.parse("2016-07-04 00:00:00"));
			System.out.println("Success");
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Fail");
		}
		assertEquals(schedule.getRoom().getRoomCode(), getSchedule.getRoom().getRoomCode());
		System.out.println("asd"  + schedule.getRoom().getRoomCode());
	}

}
