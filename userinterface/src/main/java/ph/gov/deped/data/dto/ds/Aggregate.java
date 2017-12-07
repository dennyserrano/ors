package ph.gov.deped.data.dto.ds;

import java.util.List;

public class Aggregate {

	private boolean countIncluded;
	private String name;
	private List<Element> elements;
	public boolean isCountIncluded() {
		return countIncluded;
	}
	public void setCountIncluded(boolean countIncluded) {
		this.countIncluded = countIncluded;
	}
	public List<Element> getElements() {
		return elements;
	}
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
