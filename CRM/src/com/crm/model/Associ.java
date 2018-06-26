package com.crm.model;

public class Associ {
	private String id;
	private String customerId;
	private String customerName;
	private String associTime;
	private String associPlace;
	private String associOutline;
	private String associDetails;
	private String associRemarks;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAssociTime() {
		return associTime;
	}
	public void setAssociTime(String associTime) {
		this.associTime = associTime;
	}
	public String getAssociPlace() {
		return associPlace;
	}
	public void setAssociPlace(String associPlace) {
		this.associPlace = associPlace;
	}
	public String getAssociOutline() {
		return associOutline;
	}
	public void setAssociOutline(String associOutline) {
		this.associOutline = associOutline;
	}
	public String getAssociDetails() {
		return associDetails;
	}
	public void setAssociDetails(String associDetails) {
		this.associDetails = associDetails;
	}
	public String getAssociRemarks() {
		return associRemarks;
	}
	public void setAssociRemarks(String associRemarks) {
		this.associRemarks = associRemarks;
	}
	public Associ(String customerId, String customerName, String associTime, String associPlace, String associOutline,
			String associDetails, String associRemarks) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.associTime = associTime;
		this.associPlace = associPlace;
		this.associOutline = associOutline;
		this.associDetails = associDetails;
		this.associRemarks = associRemarks;
	}
	public Associ() {
		super();
	}
	public Associ(String id, String associTime, String associPlace, String associOutline, String associDetails,
			String associRemarks) {
		super();
		this.id = id;
		this.associTime = associTime;
		this.associPlace = associPlace;
		this.associOutline = associOutline;
		this.associDetails = associDetails;
		this.associRemarks = associRemarks;
	}
	
	
	
}
