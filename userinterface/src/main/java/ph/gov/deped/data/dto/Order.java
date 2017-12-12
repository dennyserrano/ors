package ph.gov.deped.data.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model.support.ColumnElement;

public class Order {
	private final String order;
	private final List<ColumnElement> orderBy;
	
	
	
	public Order(String order,List<ColumnElement> columns) {
		super();
		this.order = order;
		this.orderBy=columns;
	}
	public String getOrder() {
		return order;
	}

	public List<ColumnElement> getOrderBy() {
		return orderBy;
	}

	
	
}
