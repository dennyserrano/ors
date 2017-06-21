package ph.gov.deped.data.dto;

import java.util.HashSet;
import java.util.Set;

public class Order {
	private final String order;
	private final Set<ColumnElement> orderBy;
	
	
	
	public Order(String order,Set<ColumnElement> columns) {
		super();
		this.order = order;
		this.orderBy=columns;
	}
	public String getOrder() {
		return order;
	}

	public Set<ColumnElement> getOrderBy() {
		return orderBy;
	}

	
	
}
