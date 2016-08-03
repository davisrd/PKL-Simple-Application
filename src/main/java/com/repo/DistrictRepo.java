package com.repo;

import java.util.List;

import com.model.District;

public interface DistrictRepo {
	
	public List<District> getAllDistrict();
	
	public District getDistrict(String districtCode);
}
