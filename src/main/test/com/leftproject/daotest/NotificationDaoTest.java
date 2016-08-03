 package com.leftproject.daotest;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.test.context.ContextConfiguration;
 import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
 import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 import org.springframework.test.context.support.AnnotationConfigContextLoader;
 import org.junit.Test;
 import org.junit.runner.RunWith;

 import com.leftproject.model.User;
import com.leftproject.dao.*;
import com.leftproject.model.Notification;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class NotificationDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	NotificationDao notificationDao;
	@Autowired
	UserDao userDao;
	
	@Test
	public void sendNotification ()
	{
		@SuppressWarnings("unused")
		User user = userDao.getUser("UEX000001");
		Notification notification = new Notification();
		notification.setNotificationSubject("cincau hijau");
		
		notificationDao.sendNotification(notification);
		
		//int count = notificationDao.getsendNotification(user).size();
		//List<Notification> hasil = notificationDao.getsendNotification(user));
		//assertEquals(count+1, hasil.size());
		
		
	}
	
		
}
