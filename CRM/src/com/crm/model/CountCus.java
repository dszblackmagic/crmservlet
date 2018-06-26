package com.crm.model;

public class CountCus {
	private String customerId;
	private String customerLevel;
	private int number;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public CountCus(String customerId, String customerLevel, int number) {
		super();
		this.customerId = customerId;
		this.customerLevel = customerLevel;
		this.number = number;
	}
	public CountCus() {
		super();
	}
	
	
}
