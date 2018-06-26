package com.crm.model;

public class Dictionary {
	private String dictionId;
	private String dictionType;
	private String dictionEntry;
	private String dictionValue;
	private String dictionState;
	public Dictionary(String dictionId, String dictionType, String dictionEntry, String dictionValue,
			String dictionState) {
		super();
		this.dictionId = dictionId;
		this.dictionType = dictionType;
		this.dictionEntry = dictionEntry;
		this.dictionValue = dictionValue;
		this.dictionState = dictionState;
	}
	public Dictionary() {
		super();
	}
	public String getDictionId() {
		return dictionId;
	}
	public void setDictionId(String dictionId) {
		this.dictionId = dictionId;
	}
	public String getDictionType() {
		return dictionType;
	}
	public void setDictionType(String dictionType) {
		this.dictionType = dictionType;
	}
	public String getDictionEntry() {
		return dictionEntry;
	}
	public void setDictionEntry(String dictionEntry) {
		this.dictionEntry = dictionEntry;
	}
	public String getDictionValue() {
		return dictionValue;
	}
	public void setDictionValue(String dictionValue) {
		this.dictionValue = dictionValue;
	}
	public String getDictionState() {
		return dictionState;
	}
	public void setDictionState(String dictionState) {
		this.dictionState = dictionState;
	}
	
	
}
