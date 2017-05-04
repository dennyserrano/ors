package ph.gov.deped.data.ors.ds;

public class DatasetCorrelationGroupDtl 
{
	private int id;
	private DatasetCorrelationGroup datasetCorrelationGroup;
	private DatasetCorrelation datasetCorrelation;
	private int chainType; //1 - Linear, 2 - Distributed
	
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
	public int getChainType() {
		return chainType;
	}
	public void setChainType(int chainType) {
		this.chainType = chainType;
	}
	
	
}
