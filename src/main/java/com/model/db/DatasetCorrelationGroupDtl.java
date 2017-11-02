package com.model.db;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable("DatasetCorrelationGroupDtl")
@javax.persistence.Cacheable
public class DatasetCorrelationGroupDtl 
{
	@Id
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DatasetCorrelationGroup datasetCorrelationGroup;
	
	@OneToOne(fetch=FetchType.LAZY)
//	@Transient
	private DatasetCorrelation datasetCorrelation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DatasetCorrelationGroup getDatasetCorrelationGroup() {
		return datasetCorrelationGroup;
	}
	public void setDatasetCorrelationGroup(
			DatasetCorrelationGroup datasetCorrelationGroup) {
		this.datasetCorrelationGroup = datasetCorrelationGroup;
	}
	public DatasetCorrelation getDatasetCorrelation() {
		return datasetCorrelation;
	}
	public void setDatasetCorrelation(DatasetCorrelation datasetCorrelation) {
		this.datasetCorrelation = datasetCorrelation;
	}
	
	
}
