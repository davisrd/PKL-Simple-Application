package com.model;

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
@Table(name="District")
public class District {
	
	@Id
	@Column(name="District_Code")
	@Size(min=5 , max=5)
	private String districtCode;
	
	@Column(name="District_Name")
	@Size(max=20)
	private String districtName;
	
	@Autowired
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "Employee_Code")
	private Employee employee;
	
}
