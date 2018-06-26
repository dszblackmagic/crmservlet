package com.crm.util;
/**
 * ��ҳ��Ϣ
 */
public class PageInfo {
	/** Ĭ����ʼҳ��*/
	public static final int DEFAULT_PAGENUM = 1;
	/** Ĭ��ҳ��С */
	public static final int DEFAULT_SIZE = 5;
	
	/** ��¼������ */
	private int total;
	/** ��ǰҳ�� */
	private int currPage;
	/** ҳ��С */
	private int size;
	
	public PageInfo(int currPage, int size, int total) {
		this.currPage = currPage;
		this.size = size;
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrPage() {
		int totalPage = total / size;
		if(total % size != 0){
			totalPage++;
		}
		totalPage = totalPage < 1 ? 1 : totalPage;
		return currPage > totalPage ? totalPage : currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStart() {
		//��ʼλ��=����ǰҳ��-1��*ҳ��С
		int start = (getCurrPage() - 1) * size;
		
		return start > total ? total : start;
	}

	public int getEnd() {
		//��ʼλ��=��ǰҳ��*ҳ��С
		int end = getCurrPage() * size;
		
		return end > total ? total : end;
	}

}
