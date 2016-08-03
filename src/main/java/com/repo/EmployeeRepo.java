package com.repo;

import java.util.List;

import com.model.Employee;

public interface EmployeeRepo {
	
	public List<Employee> getAllEmployee();
	
	public boolean saveEmployee(Employee employee);
	
	public boolean deleteEmployee(String employeeCode);
	
	
}
