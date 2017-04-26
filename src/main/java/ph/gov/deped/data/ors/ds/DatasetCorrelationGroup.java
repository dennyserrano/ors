package ph.gov.deped.data.ors.ds;

import java.util.Set;

public class DatasetCorrelationGroup 
{
	private int id;
	private String name;
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
	
	
}
