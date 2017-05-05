package ph.gov.deped.data.ors.ds;

import java.util.List;
import java.util.Set;

public class DatasetCorrelationGroup 
{
	private int id;
	private String name;
	private List<DatasetCorrelationGroupDtl> groupDetails;
	
	
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
	public List<DatasetCorrelationGroupDtl> getGroupDetails() {
		return groupDetails;
	}
	public void setGroupDetails(List<DatasetCorrelationGroupDtl> groupDetails) {
		this.groupDetails = groupDetails;
	}
	
	
	
	
	
}
