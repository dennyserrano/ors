package com.repo.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.model.data.RefLegislative;


@Repository
@RepositoryDefinition(domainClass = RefLegislative.class, idClass = Short.class)
public interface RefLegislativeRepository {
	
	@Query("select rl from RefLegislative rl "
			 + "join fetch rl.refProvince rp "
			 + "join fetch rl.districtLabel "
			 + "where rp.refRegionId=?1 and "
			 + "rl.refProvince.id=?2")
	public List<RefLegislative> listBy(short regionId,short provinceId);
	
}
