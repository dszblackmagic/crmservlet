package com.crm.model;

public class Customer {
	private String customerId;
	private String customerName;
	private String customerArea;
	private String customerManager;
	private String customerLevel;
	private String customerSat;
	private String customerCredit;
	private String address;
	private String postalCode;
	private String telephone;
	private String customerFax;
	private String website;
	private String registerNum;
	private String legalPerson;
	private String registerCapital;
	private String turnover;
	private String openBank;
	private String bankNum;
	private String LocalTax;
	private String state;
	private String countryTax;
	
	
	
	public Customer() {
		super();
	}
	public Customer(String customerId, String customerName, String customerArea, String customerManager,
			String customerLevel, String customerSat, String customerCredit, String address, String postalCode,
			String telephone, String customerFax, String website, String registerNum, String legalPerson,
			String registerCapital, String turnover, String openBank, String bankNum, String localTax,
			String countryTax) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerArea = customerArea;
		this.customerManager = customerManager;
		this.customerLevel = customerLevel;
		this.customerSat = customerSat;
		this.customerCredit = customerCredit;
		this.address = address;
		this.postalCode = postalCode;
		this.telephone = telephone;
		this.customerFax = customerFax;
		this.website = website;
		this.registerNum = registerNum;
		this.legalPerson = legalPerson;
		this.registerCapital = registerCapital;
		this.turnover = turnover;
		this.openBank = openBank;
		this.bankNum = bankNum;
		LocalTax = localTax;
		this.countryTax = countryTax;
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
	public String getCustomerArea() {
		return customerArea;
	}
	public void setCustomerArea(String customerArea) {
		this.customerArea = customerArea;
	}
	public String getCustomerManager() {
		return customerManager;
	}
	public void setCustomerManager(String customerManager) {
		this.customerManager = customerManager;
	}
	public String getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}
	public String getCustomerSat() {
		return customerSat;
	}
	public void setCustomerSat(String customerSat) {
		this.customerSat = customerSat;
	}
	public String getCustomerCredit() {
		return customerCredit;
	}
	public void setCustomerCredit(String customerCredit) {
		this.customerCredit = customerCredit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCustomerFax() {
		return customerFax;
	}
	public void setCustomerFax(String customerFax) {
		this.customerFax = customerFax;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getRegisterNum() {
		return registerNum;
	}
	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getRegisterCapital() {
		return registerCapital;
	}
	public void setRegisterCapital(String registerCapital) {
		this.registerCapital = registerCapital;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getOpenBank() {
		return openBank;
	}
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}
	public String getBankNum() {
		return bankNum;
	}
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
	public String getLocalTax() {
		return LocalTax;
	}
	public void setLocalTax(String localTax) {
		LocalTax = localTax;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountryTax() {
		return countryTax;
	}
	public void setCountryTax(String countryTax) {
		this.countryTax = countryTax;
	}
	
	
	
}
