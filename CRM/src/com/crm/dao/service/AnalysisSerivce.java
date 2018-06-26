package com.crm.dao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.crm.dao.impl.AnalysisDao;
import com.crm.dao.impl.CustomerDao;
import com.crm.dao.impl.ServeDao;
import com.crm.model.CountCus;
import com.crm.model.CountSer;
import com.crm.model.Serve;
import com.crm.util.PageInfo;

public class AnalysisSerivce {
	AnalysisDao aDao=new AnalysisDao();
	CustomerDao cDao=new CustomerDao();
	//查找所符合要求的数据
	public List<CountCus> tocustomer(Map<String, Object> qParams, PageInfo pageInfo)throws Exception  {
		// TODO Auto-generated method stub
		List<CountCus> cus =new ArrayList<CountCus>();
		
		int total= cDao.findTotalNum(qParams);//总数据数
		if(total!=0){
			pageInfo.setTotal(total);
			cus= aDao.tocustomer(qParams, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return cus;
	}
	//查找符合要求的服务统计数据
	public List<CountSer> toserve(Map<String, Object> qParams, PageInfo pageInfo)throws Exception  {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				List<CountSer> ser =new ArrayList<CountSer>();
				ServeDao sDao=new ServeDao();
				int total= sDao.findTotalNum(qParams);//总数据数
				if(total!=0){
					pageInfo.setTotal(total);
					ser= aDao.toserve(qParams, pageInfo.getStart(), pageInfo.getSize());
				}
				
				return ser;
	}

}
