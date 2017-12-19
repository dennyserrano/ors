package com.generate.model;

public class File {

	private String name;
	private String path;
	
	public File(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getFullPath()
	{
		return path+name;
	}
	
}
