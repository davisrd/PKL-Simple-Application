package com.leftproject.servicetest;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.leftproject.model.User;
import com.leftproject.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfigurationService.class, loader=AnnotationConfigContextLoader.class)

public class UserServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private UserService userDao;
	
	@Test
	public void testfindById() {
		User user = userDao.findById("UEX000001");
		assertEquals("UEX000001", user.getUserName());
	}
	
	@Test
	public void testfindByName(){
		User user = userDao.findByName("Davis");
		assertEquals("Davis", user.getUserName());
	}
	//private User findById(String id) {
		// TODO Auto-generated method stub
		//return null;
//	}

}