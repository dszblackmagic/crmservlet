package com.crm.model;

public class Contacts {
	private int id;
	private String customerId;
	private String contactsName;
	private String contactsSex;
	private String contactsPosition;
	private String officePhone;
	private String contactsPhone;
	private String contactsRemarks;
	
	
	
	
	public Contacts(int id, String customerId, String contactsName, String contactsSex, String contactsPosition,
			String officePhone, String contactsPhone, String contactsRemarks) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.contactsName = contactsName;
		this.contactsSex = contactsSex;
		this.contactsPosition = contactsPosition;
		this.officePhone = officePhone;
		this.contactsPhone = contactsPhone;
		this.contactsRemarks = contactsRemarks;
	}
	public Contacts() {
		super();
	}
	public Contacts(String customerId, String contactsName, String contactsSex, String contactsPosition,
			String officePhone, String contactsPhone, String contactsRemarks) {
		super();
		this.customerId = customerId;
		this.contactsName = contactsName;
		this.contactsSex = contactsSex;
		this.contactsPosition = contactsPosition;
		this.officePhone = officePhone;
		this.contactsPhone = contactsPhone;
		this.contactsRemarks = contactsRemarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getContactsName() {
		return contactsName;
	}
	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}
	public String getContactsSex() {
		return contactsSex;
	}
	public void setContactsSex(String contactsSex) {
		this.contactsSex = contactsSex;
	}
	public String getContactsPosition() {
		return contactsPosition;
	}
	public void setContactsPosition(String contactsPosition) {
		this.contactsPosition = contactsPosition;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getContactsPhone() {
		return contactsPhone;
	}
	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}
	public String getContactsRemarks() {
		return contactsRemarks;
	}
	public void setContactsRemarks(String contactsRemarks) {
		this.contactsRemarks = contactsRemarks;
	}
	
}
