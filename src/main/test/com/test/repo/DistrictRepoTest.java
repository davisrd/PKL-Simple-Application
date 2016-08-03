package com.test.repo;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.model.District;
import com.repo.DistrictRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class DistrictRepoTest {

	@Autowired
	DistrictRepo districtRepo;
	
	@Test
	public void getAllDistrictTest(){
		List<District> listDistrict = districtRepo.getAllDistrict();
		
		assertTrue(listDistrict.size()>0);
	}
}
