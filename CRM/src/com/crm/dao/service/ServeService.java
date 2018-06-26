package com.crm.dao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.crm.dao.impl.CustomerDao;
import com.crm.dao.impl.ServeDao;
import com.crm.model.Dictionary;
import com.crm.model.Market;
import com.crm.model.Serve;
import com.crm.util.PageInfo;

public class ServeService {
	
	ServeDao sDao=new ServeDao();
	
	/**
	 * �����µķ�����Ϣ
	 * @param serve
	 */
	
	public void add(Serve serve)throws SQLException {
		// TODO Auto-generated method stub
		sDao.add(serve);
	}
	
	/**
	 * �������������
	 * @param qParams
	 * @param pageInfo
	 * @return
	 * @throws Exception 
	 */
	public List<Serve> todis(Map<String, Object> qParams, PageInfo pageInfo)throws Exception  {
		// TODO Auto-generated method stub
		List<Serve> serves =new ArrayList<Serve>();
		
		int total= sDao.findTotalNum(qParams);//��������
		if(total!=0){
			pageInfo.setTotal(total);
			serves= sDao.todis(qParams, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return serves;
		
	}
	/**
	 * ����ͻ�����ָ������
	 * @param serveId
	 * @param serveDistri
	 */
	public void servedis(String serveId, String serveDistri)throws Exception  {
		// TODO Auto-generated method stub
		sDao.servedis(serveId,serveDistri);
	}
	/**
	 * ɾ��ָ������
	 * @param serveId
	 */

	public void servedel(String serveId)throws Exception  {
		// TODO Auto-generated method stub
		sDao.servedel(serveId);
	}
	
	/**
	 * ����ָ��������Ϣ
	 * @param serveId
	 * @return
	 */
	public Serve findByid(String serveId)throws Exception {
		// TODO Auto-generated method stub
		Serve serve=new Serve();
		serve=sDao.finByid(serveId);
		return serve;
	}
	
	/**
	 * ���������
	 * @param serve
	 * @throws Exception
	 */
	public void edithandle(Serve serve) throws Exception {
		// TODO Auto-generated method stub
		sDao.edithandle(serve);
	}
	
	/**
	 * ���淴��������
	 * @param serveId
	 * @param serveResult
	 * @param serveSatisfied
	 */
	public void editfdb(String serveId, String serveResult, String serveSatisfied)  throws Exception{
		// TODO Auto-generated method stub
		sDao.editfdb(serveId,serveResult,serveSatisfied);
	}
	
	
		/**
		 * ���ҷ�������
		 * @param dicjudge
		 * @return
		 * @throws Exception
		 */
	public List<Dictionary> findBydic(String dicjudge)throws Exception {
		// TODO Auto-generated method stub
		CustomerDao customerDao=new CustomerDao();
		List<Dictionary> dictionaries=new ArrayList<Dictionary>();
		dictionaries=customerDao.findBydic(dicjudge);
		return dictionaries;
	}

}
