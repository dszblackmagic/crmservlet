package com.crm.util;

import org.apache.commons.lang.StringUtils;

public class PageInfoUtils {
	/**
	 * �����ṩ��ҳ����Ϣ�����pageinfo
	 * @param currPageStr ��ǰҳ��
	 * @param sizeStr ҳ��С
	 * @param total ��¼������
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
	 * �����ṩ��ҳ����Ϣ�����pageInfo����
	 * @param currPage ��ǰҳ��
	 * @param size ҳ��С
	 * @param total ��¼������
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
