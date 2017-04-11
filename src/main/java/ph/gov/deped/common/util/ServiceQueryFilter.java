package ph.gov.deped.common.util;

import java.util.List;

import ph.gov.deped.data.dto.KeyValue;

public class ServiceQueryFilter 
{
	private String tablePrefix;
	private String columnName;
	private String operator;
	private List<KeyValue> keys;
	private ServiceQueryFilter nextFilter;
	
	
	
	
	public ServiceQueryFilter(String tablePrefix, String columnName,
			String operator, List<KeyValue> keys, ServiceQueryFilter nextFilter) {
		super();
		this.tablePrefix = tablePrefix;
		this.columnName = columnName;
		this.operator = operator;
		this.keys = keys;
		this.nextFilter = nextFilter;
	}


	public String getTablePrefix() {
		return tablePrefix;
	}


	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}


	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public List<KeyValue> getKeys() {
		return keys;
	}
	public void setKeys(List<KeyValue> keys) {
		this.keys = keys;
	}


	public ServiceQueryFilter getNextFilter() {
		return nextFilter;
	}


	public void setNextFilter(ServiceQueryFilter nextFilter) {
		this.nextFilter = nextFilter;
	}
	
	
}
