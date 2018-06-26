package com.crm.dao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jboss.weld.bean.proxy.Marker;

import com.crm.dao.impl.PlanDao;
import com.crm.model.Market;
import com.crm.model.Plan;
import com.crm.util.PageInfo;

public class PlanSerivce {
	PlanDao planDao=new PlanDao();

	/**
	 * ��ѯ��¼����(��ָ�ɳɹ�)
	 */
	
	public List<Market> list(Map<String, Object> params,PageInfo pageInfo) throws Exception{
		List<Market> marketList =new ArrayList<Market>();
		
		int total= planDao.findTotalNum(params);//��������
		if(total!=0){
			pageInfo.setTotal(total);
			marketList= planDao.list(params, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return marketList;
	}
	/**
	 * 
	 * �����µ�ִ�мƻ�
	 * @throws SQLException 
	 */
	public void savePlan(Plan plan) throws SQLException {
		
		planDao.save(plan);
	}
	public List<Plan> findByPrimarykey(String id) throws SQLException {
		List<Plan> planList=new ArrayList<Plan>();
		
		planList=planDao.planList(id);
		
		return planList;
	}
	/**
	 * 
	 * ����ִ�мƻ�	
	 */
	public void updatePlan(Plan plan,String key) throws SQLException{
		
		planDao.update(plan,key);
	}
	
	
	/**
	 * 
	 * ɾ��ĳ��ָ���ļƻ�
	 */
	public void delete(String key)throws SQLException {
		// TODO Auto-generated method stub
		planDao.delete(key);
	}
	
	/**
	 * ���ݿͻ����ִ�����Ӧ�ļƻ�
	 */
	public void exec(String id) throws SQLException{
		planDao.exec(id);
		
	}
	
	/**
	 * 
	 *���Ķ�Ӧ�ƻ���ִ��Ч��
	 */
	
	public void execupdate(String planEffect, String key) throws SQLException {
		planDao.execupdate(planEffect,key);
		
	}
	

	/**
	 * 
	 *��ֹ�ƻ�
	 */
	public void stop(String id)throws SQLException {
		// TODO Auto-generated method stub
		planDao.stop(id);
	}
	
	
	/**
	 * �ɹ������������Զ�����һ���ͻ���Ϣ��
	 * @throws SQLException 
	 */
	public void success(Market market) throws SQLException {
		// TODO Auto-generated method stub
		
		planDao.success(market);
	}
	
	

}
