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
	 * ��ѯ��¼����(ȫ����¼)
	 */
	
	public List<Market> list(Map<String, Object> params,PageInfo pageInfo) throws Exception{
		List<Market> marketList =new ArrayList<Market>();
		
		int total= marketDao.findTotalNum(params);//��������
		if(total!=0){
			pageInfo.setTotal(total);
			marketList= marketDao.list(params, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return marketList;
	}
	/**
	 * �������Ϣ
	 */
	
	public void create(Market market) throws Exception {
		MarketDao.create(market);
	}
	
	/**
	 * 
	 * ɾ����Ϣ
	 * @throws Exception 
	 */
	public void deleteBatch(String ids) throws Exception {
		marketDao.delete(ids);
		
	}
	
	/**
	 * 
	 * �޸���Ϣ
	 * @throws SQLException 
	 */
	
	public Market findByPrimaryKey(String id) throws SQLException {
		
		return marketDao.findByPrimaryKey(id);
	}
	
	/**
	 * 
	 * ����Ӫ����Ϣ
	 * @throws SQLException 
	 */
	public void update(Market market) throws SQLException {
		marketDao.update(market);
		
	}
	
	/**
	 * 
	 * �������пͻ�����
	 */
	public List<User> findAlladmin() throws Exception{
		
		return marketDao.findAlladmin();
	}
	public void assign(String distribution, String distime, String numberId) throws SQLException {
		
		marketDao.assign(distribution,distime,numberId);
		
	}
}
