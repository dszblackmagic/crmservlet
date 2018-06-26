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
	 * 查询记录条数(已指派成功)
	 */
	
	public List<Market> list(Map<String, Object> params,PageInfo pageInfo) throws Exception{
		List<Market> marketList =new ArrayList<Market>();
		
		int total= planDao.findTotalNum(params);//总数据数
		if(total!=0){
			pageInfo.setTotal(total);
			marketList= planDao.list(params, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return marketList;
	}
	/**
	 * 
	 * 保存新的执行计划
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
	 * 更新执行计划	
	 */
	public void updatePlan(Plan plan,String key) throws SQLException{
		
		planDao.update(plan,key);
	}
	
	
	/**
	 * 
	 * 删除某条指定的计划
	 */
	public void delete(String key)throws SQLException {
		// TODO Auto-generated method stub
		planDao.delete(key);
	}
	
	/**
	 * 根据客户编号执行相对应的计划
	 */
	public void exec(String id) throws SQLException{
		planDao.exec(id);
		
	}
	
	/**
	 * 
	 *更改对应计划的执行效果
	 */
	
	public void execupdate(String planEffect, String key) throws SQLException {
		planDao.execupdate(planEffect,key);
		
	}
	

	/**
	 * 
	 *终止计划
	 */
	public void stop(String id)throws SQLException {
		// TODO Auto-generated method stub
		planDao.stop(id);
	}
	
	
	/**
	 * 成功开发（并且自动创建一个客户信息）
	 * @throws SQLException 
	 */
	public void success(Market market) throws SQLException {
		// TODO Auto-generated method stub
		
		planDao.success(market);
	}
	
	

}
