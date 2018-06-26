package com.crm.util;
/**
 * JSON结果
 */
public class JSONResult {
	/** 请求是否成功处理 */
	private String status;
	/** 提示信息 */
	private String msg;
	/** 数据 */
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
