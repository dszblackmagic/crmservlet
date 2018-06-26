package com.crm.model;

/*
 * 营销机会
 */
/**
 * @author Deng
 *
 */
public class Market {
	private String numberId;
	private String opporTunity;
	private String customerName;
	private Integer probability;//成功概率
	private String outLine;  //概要
	private String contacts;//联系人
	private String contactPhone;
	private String description ;//机会描述
	private String founder ;//创建人
	private String time;//创建时间
	private String distribution;//分配人
	private String distime;//分配时间
	private String judge;//判断是否分配
	private String development;//是否开发
	
	
	public Market(String numberId, String opporTunity, String customerName, Integer probability, String outLine,
			String contacts, String contactPhone, String description, String founder, String time, String distribution,
			String distime, String judge) {
		super();
		this.numberId = numberId;
		this.opporTunity = opporTunity;
		this.customerName = customerName;
		this.probability = probability;
		this.outLine = outLine;
		this.contacts = contacts;
		this.contactPhone = contactPhone;
		this.description = description;
		this.founder = founder;
		this.time = time;
		this.distribution = distribution;
		this.distime = distime;
		this.judge = judge;
	}
	public Market() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Market(String numberId, String opporTunity, String customerName, Integer probability, String outLine,
			String contacts, String contactPhone, String description, String founder, String time) {
		super();
		this.numberId = numberId;
		this.opporTunity = opporTunity;
		this.customerName = customerName;
		this.probability = probability;
		this.outLine = outLine;
		this.contacts = contacts;
		this.contactPhone = contactPhone;
		this.description = description;
		this.founder = founder;
		this.time = time;
	}
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public String getDistime() {
		return distime;
	}
	public void setDistime(String distime) {
		this.distime = distime;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public String getOpporTunity() {
		return opporTunity;
	}
	public void setOpporTunity(String opporTunity) {
		this.opporTunity = opporTunity;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getProbability() {
		return probability;
	}
	public void setProbability(Integer probability) {
		this.probability = probability;
	}
	public String getOutLine() {
		return outLine;
	}
	public void setOutLine(String outLine) {
		this.outLine = outLine;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDevelopment() {
		return development;
	}
	public void setDevelopment(String development) {
		this.development = development;
	}
	public Market(String numberId, String opporTunity, String customerName, Integer probability, String outLine,
			String contacts, String contactPhone, String description, String founder, String time, String distribution,
			String distime, String judge, String development) {
		super();
		this.numberId = numberId;
		this.opporTunity = opporTunity;
		this.customerName = customerName;
		this.probability = probability;
		this.outLine = outLine;
		this.contacts = contacts;
		this.contactPhone = contactPhone;
		this.description = description;
		this.founder = founder;
		this.time = time;
		this.distribution = distribution;
		this.distime = distime;
		this.judge = judge;
		this.development = development;
	}
	
	
	
	
}
