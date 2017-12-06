package com.repo.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.model.data.RefProvince;




@Repository
@RepositoryDefinition(domainClass = RefProvince.class, idClass = Short.class)
public interface RefProvinceRepository {

	public List<RefProvince> findByRefRegionId(short regionId);
}
