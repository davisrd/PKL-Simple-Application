package com.test.repo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

import com.model.District;
import com.model.Employee;
import com.repo.EmployeeRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class EmployeeRepoTest {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Test
	public void getAllEmployee(){
		
		List<Employee> listEmployee = employeeRepo.getAllEmployee();
		assertEquals(1, listEmployee.size());
	}
	
	@Test
	public void deleteEmployee(){
		
		assertEquals(true,employeeRepo.deleteEmployee("EMP0000000001"));
	}
	
	@Test
	public void saveEmployee(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Employee employee = new Employee();
		try {
			employee.setEmployeeCode("EMP000000000X");
			employee.setEmployeeName("Pratama");
			employee.setBirthDate(df.parse("1995-11-17 06:00:00"));
			employee.setJoinDate(df.parse("2016-07-04 00:00:00"));
			employee.setEmployeeAddress("wololo");
			employee.setGender("L");
			District district = new District();
			district.setDistrictCode("BD001");
			district.setDistrictName("Cikutra Barat I");
			employee.setDistrict(district);
			assertEquals(true,employeeRepo.saveEmployee(employee));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
