package com.crm.util;
/**
 * JSON���
 */
public class JSONResult {
	/** �����Ƿ�ɹ����� */
	private String status;
	/** ��ʾ��Ϣ */
	private String msg;
	/** ���� */
	private Object data;

	public JSONResult(){
		this.status = "success";
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
