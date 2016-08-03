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
	
	public District() {
		super();
	}

	public District(String districtCode, String districtName) {
		super();
		this.districtCode = districtCode;
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	
	
}
