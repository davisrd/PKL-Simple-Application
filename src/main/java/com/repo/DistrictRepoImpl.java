package com.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.model.District;

@Repository("DistrictRepo")
public class DistrictRepoImpl extends AbstractDao<Integer, District> implements DistrictRepo{
	
	public List<District> getAllDistrict(){
		Criteria criteria = createEntityCriteria();
		int id = criteria.list().size();
		System.out.println(id);
		return (List<District>) criteria.list();
	}
	
	public District getDistrict(String districtCode){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("District_Code", districtCode));
		return (District) criteria.uniqueResult();
	}
}
