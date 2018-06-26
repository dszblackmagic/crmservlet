package com.crm.dao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.crm.dao.impl.MarketDao;
import com.crm.model.Market;
import com.crm.model.User;
import com.crm.util.PageInfo;


public class MarketService {
	private MarketDao marketDao=new MarketDao();
	
	/**
	 * 查询记录条数(全部记录)
	 */
	
	public List<Market> list(Map<String, Object> params,PageInfo pageInfo) throws Exception{
		List<Market> marketList =new ArrayList<Market>();
		
		int total= marketDao.findTotalNum(params);//总数据数
		if(total!=0){
			pageInfo.setTotal(total);
			marketList= marketDao.list(params, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return marketList;
	}
	/**
	 * 添加新信息
	 */
	
	public void create(Market market) throws Exception {
		MarketDao.create(market);
	}
	
	/**
	 * 
	 * 删除信息
	 * @throws Exception 
	 */
	public void deleteBatch(String ids) throws Exception {
		marketDao.delete(ids);
		
	}
	
	/**
	 * 
	 * 修改信息
	 * @throws SQLException 
	 */
	
	public Market findByPrimaryKey(String id) throws SQLException {
		
		return marketDao.findByPrimaryKey(id);
	}
	
	/**
	 * 
	 * 更新营销信息
	 * @throws SQLException 
	 */
	public void update(Market market) throws SQLException {
		marketDao.update(market);
		
	}
	
	/**
	 * 
	 * 返回所有客户经理
	 */
	public List<User> findAlladmin() throws Exception{
		
		return marketDao.findAlladmin();
	}
	public void assign(String distribution, String distime, String numberId) throws SQLException {
		
		marketDao.assign(distribution,distime,numberId);
		
	}
}
