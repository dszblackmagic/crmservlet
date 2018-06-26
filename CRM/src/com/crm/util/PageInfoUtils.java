package com.crm.util;

import org.apache.commons.lang.StringUtils;

public class PageInfoUtils {
	/**
	 * 根据提供的页码信息计算出pageinfo
	 * @param currPageStr 当前页码
	 * @param sizeStr 页大小
	 * @param total 记录总条数
	 */
	public static PageInfo calculatePageInfo(String currPageStr, String sizeStr){
		int currPage = PageInfo.DEFAULT_PAGENUM;
		int size = PageInfo.DEFAULT_SIZE;
		
		if(StringUtils.isNotEmpty(currPageStr) ){
			currPage = Integer.parseInt(currPageStr);
		}
		
		if(StringUtils.isNotEmpty(sizeStr)){
			size = Integer.parseInt(sizeStr);
		}
		
		return calculatePageInfo(currPage, size, 0);
		
	}
	/**
	 * 根据提供的页码信息计算出pageInfo对象
	 * @param currPage 当前页码
	 * @param size 页大小
	 * @param total 记录总条数
	 */
	public static PageInfo calculatePageInfo(int currPage, int size, int total){
		if(currPage < 1){
			currPage = PageInfo.DEFAULT_PAGENUM;
		}
		if(size < 1){
			size = PageInfo.DEFAULT_SIZE;
		}
		if(total < 1){
			total = 0;
		}
		
		return new PageInfo(currPage, size, total);
	}
}
