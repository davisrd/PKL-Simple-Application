package com.repo;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository("EmployeeRepo")
public class EmployeeRepoImpl extends AbstractDao<Integer,Employee> implements EmployeeRepo{
	
	public List<Employee> getAllEmployee(){
		Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();
	}
	
	public boolean saveEmployee(Employee employee){
		try{
//			persist(employee); // masih error
			//-----------------------Sementara menggunakan ini------------------//
			Query query = getSession().createSQLQuery("insert into Employee Values('" +employee.getEmployeeCode()+"',current_date,'"+employee.getEmployeeAddress()+"','"+employee.getEmployeeName()+"','"+employee.getGender()+"',current_date,'"+employee.getDistrict().getDistrictCode()+"')");
			query.executeUpdate();
			//------------------------------------------------------------------//
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean deleteEmployee(String employeeCode){
		try{
			Query query = getSession().createSQLQuery("delete from Employee where Employee_Code = '" +employeeCode+"'");
			query.executeUpdate();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
