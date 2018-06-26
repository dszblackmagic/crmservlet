package com.crm.model;

public class CountSer {
	private String serveId;
	private String serveType;
	private int number;
	public String getServeId() {
		return serveId;
	}
	public void setServeId(String serveId) {
		this.serveId = serveId;
	}
	public String getServeType() {
		return serveType;
	}
	public void setServeType(String serveType) {
		this.serveType = serveType;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public CountSer(String serveId, String serveType, int number) {
		super();
		this.serveId = serveId;
		this.serveType = serveType;
		this.number = number;
	}
	public CountSer() {
		super();
	}
	
	
}
