package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	@Autowired
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "District_Code")
	private District district;

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	
	public Employee(String employeeCode, String employeeName, String gender, Date birthDate, Date joinDate,
			String employeeAddress, District district) {
		super();
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.joinDate = joinDate;
		this.employeeAddress = employeeAddress;
		this.district = district;
	}

	public Employee() {
		super();
	}
	
	
}
