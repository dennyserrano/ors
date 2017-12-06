package com.repo.data;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.model.data.RefOffice;


@Repository
@RepositoryDefinition(domainClass = RefOffice.class, idClass = Short.class)
public interface RefOfficeRepository {
	public List<RefOffice> findByOfficeTypeAndParentOfficeAndRefRegionId(short officeType, int parentOffice,int regionId);
}
