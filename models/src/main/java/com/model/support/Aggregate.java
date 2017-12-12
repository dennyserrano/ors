package com.model.support;

import java.io.Serializable;
import java.util.List;

public class Aggregate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
