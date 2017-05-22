package ph.gov.deped.data.ors.ds;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable("DatasetCorrelationGroupDtl")
@javax.persistence.Cacheable
public class DatasetCorrelationGroupDtl 
{
	@Id
	private int id;
	@Transient
	private DatasetCorrelationGroup datasetCorrelationGroup;
	@Transient
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
