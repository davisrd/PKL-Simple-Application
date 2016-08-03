package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@Column (name="Employee_Code")
	@Size (min = 13 , max = 13)
	private String employeeCode;
	
	@Column (name="Employee_Name")
	@Size (max = 30)
	private String employeeName;
	
	@Column (name="Gender")
	@Size (min = 1 , max = 1)
	private String gender;
	
	@Column (name="Birth_Date")
	private Date birthDate;
	
	@Column (name="Join_Date")
	private Date joinDate;
	
	@Column (name="Employee_Address")
	@Size (max = 255)
	private String employeeAddress;
}
