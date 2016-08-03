package com.leftproject.daotest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
   ReservationDaoTest.class,
   RoomDaoTest.class
})
public class JUnitTestSuite {
}