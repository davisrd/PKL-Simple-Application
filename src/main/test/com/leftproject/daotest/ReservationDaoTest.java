package com.leftproject.daotest;
import static org.junit.Assert.*;

import java.util.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.leftproject.dao.*;
import com.leftproject.model.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class ReservationDaoTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Test
	public void testGetProposedReservation(){
		int result = reservationDao.getProposedReservation().size();
		assertTrue(result>0);
	}
	
	@Test
	public void testGetAllReservation(){
		User user = userDao.getUser("UEX000001");
		int result = reservationDao.getAllReservation(user).size();
		assertTrue(result>0);
	}
	
	@Test
	public void testGetReservation()
	{
		Reservation reservation = reservationDao.getReservation("RS1302005");
		assertEquals("HIMAS", reservation.getBorrower());
	}
	
	@Test
	public void testGetReservationByCode()
	{
		Reservation reservation = reservationDao.getReservationByCode("RS1302006");
		assertEquals("HME", reservation.getBorrower());
	}
	
	@Test
	public void testSaveReservation()
	{
		User user = userDao.getUser("UEX000001");
		assertEquals("Davis", user.getUserName());
		Room room = roomDao.getRoom("RG003");
		assertEquals("Student Center", room.getRoomName());
		Reservation reservation = new Reservation();
		reservation.setUser(user);
		reservation.setRoom(room);
		Date date = new Date();
		reservation.setCreatedDate(date);
		reservation.setBorrower("Bambang");
		int count = reservationDao.getAllReservation(user).size();
		reservationDao.saveReservation(reservation);
		reservationDao.sessionFlush();
		List<Reservation> hasil = reservationDao.getAllReservation(user);
		assertEquals(count+1, hasil.size());
	}
	
	@Test
	public void getProposedMovementReservation()
	{
		List<Reservation> reservations = reservationDao.getProposedMovementReservation();
		assertTrue(reservations.size()>0);
	}
	
	@Test
	public void testDeleteReservationById(){
		boolean status = reservationDao.deleteReservationById("RS1606002");
		assertEquals(true,status);
		
		
	}
	
	@Test
	public void testApproveReservationByKaSubbagTU()
	{
		Reservation reservation = reservationDao.getReservation("RS1302002");
		assertTrue(reservationDao.approveReservationByKaSubbagTU(reservation));
		reservation = reservationDao.getReservation("RS1302002");
		assertEquals("3", reservation.getReservationPhase());
	}
	
	@Test
	public void testApproveReservationByRoomManager()
	{
		Reservation reservation = reservationDao.getReservation("RS1302002");
		boolean res = reservationDao.approveReservationByRoomManager(reservation);
		reservationDao.sessionFlush();
		assertTrue(res);
		assertTrue(res);
		reservation = reservationDao.getReservation("RS1302002");
		assertEquals("4", reservation.getReservationPhase());
	}
	
	@Test
	public void TestDenyReservationByKaSubbagTU()
	{
		Reservation reservation = reservationDao.getReservation("RS1302002");
		boolean res = reservationDao.denyReservationByKasubbagTU(reservation);
		reservationDao.sessionFlush();
		assertTrue(res);
		reservation = reservationDao.getReservation("RS1302002");
		assertEquals("6", reservation.getReservationPhase());
	}
	
	@Test
	public void TestDenyReservationByRoomManager()
	{
		Reservation reservation = reservationDao.getReservation("RS1302002");
		boolean res = reservationDao.denyReservationByKasubbagTU(reservation);
		reservationDao.sessionFlush();
		assertTrue(res);
		reservation = reservationDao.getReservation("RS1302002");
		assertEquals("5", reservation.getReservationPhase());
	}
//	@Test
//	public void testcancelReservation(){
//		Reservation reservation = reservationDao.getReservation("RS1606002");
//		boolean status = reservationDao.cancelReservation(reservation);
//		assertEquals(true,status);
//		
//		
//	}
}
