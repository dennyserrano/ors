package com.model.db;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable("DatasetCorrelationGroup")
@javax.persistence.Cacheable
public class DatasetCorrelationGroup 
{
	@Id
	private int id;
	
	@Column(length=50)
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="datasetCorrelationGroup")
	@OrderBy
	private Set<DatasetCorrelationGroupDtl> groupDetails;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<DatasetCorrelationGroupDtl> getGroupDetails() {
		return groupDetails;
	}
	public void setGroupDetails(Set<DatasetCorrelationGroupDtl> groupDetails) {
		this.groupDetails = groupDetails;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((groupDetails == null) ? 0 : groupDetails.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatasetCorrelationGroup other = (DatasetCorrelationGroup) obj;
		if (groupDetails == null) {
			if (other.groupDetails != null)
				return false;
		} else if (!groupDetails.equals(other.groupDetails))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
	
}
