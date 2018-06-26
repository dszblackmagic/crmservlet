package com.crm.model;

/*
 * Ӫ������
 */
/**
 * @author Deng
 *
 */
public class Market {
	private String numberId;
	private String opporTunity;
	private String customerName;
	private Integer probability;//�ɹ�����
	private String outLine;  //��Ҫ
	private String contacts;//��ϵ��
	private String contactPhone;
	private String description ;//��������
	private String founder ;//������
	private String time;//����ʱ��
	private String distribution;//������
	private String distime;//����ʱ��
	private String judge;//�ж��Ƿ����
	private String development;//�Ƿ񿪷�
	
	
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
