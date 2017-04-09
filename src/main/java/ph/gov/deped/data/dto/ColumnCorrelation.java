package ph.gov.deped.data.dto;

public class ColumnCorrelation 
{
	private String leftTablePrefix;
	private String rightTablePrefix;
	
	public ColumnCorrelation(String leftTablePrefix, String rightTablePrefix) {
		this.leftTablePrefix = leftTablePrefix;
		this.rightTablePrefix = rightTablePrefix;
	}

	public String getLeftTablePrefix() {
		return leftTablePrefix;
	}

	public String getRightTablePrefix() {
		return rightTablePrefix;
	}
	
	
}
