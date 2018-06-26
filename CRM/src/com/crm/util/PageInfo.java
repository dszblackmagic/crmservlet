package com.crm.util;
/**
 * 分页信息
 */
public class PageInfo {
	/** 默认起始页码*/
	public static final int DEFAULT_PAGENUM = 1;
	/** 默认页大小 */
	public static final int DEFAULT_SIZE = 5;
	
	/** 记录总条数 */
	private int total;
	/** 当前页码 */
	private int currPage;
	/** 页大小 */
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
		//起始位置=（当前页码-1）*页大小
		int start = (getCurrPage() - 1) * size;
		
		return start > total ? total : start;
	}

	public int getEnd() {
		//起始位置=当前页码*页大小
		int end = getCurrPage() * size;
		
		return end > total ? total : end;
	}

}
