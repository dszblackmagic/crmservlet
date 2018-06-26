package com.crm.dao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.crm.dao.impl.CustomerDao;
import com.crm.dao.impl.DictionaryDao;
import com.crm.dao.impl.MarketDao;
import com.crm.model.Dictionary;
import com.crm.model.Serve;
import com.crm.model.User;
import com.crm.util.PageInfo;

public class DictionarySerivce {
	DictionaryDao dao=new DictionaryDao();
	/**
	 * ���������ֵ��б����
	 * @param qParams
	 * @param pageInfo
	 * @return
	 * @throws Exception 
	 */
	public List<Dictionary> todiclist(Map<String, Object> qParams, PageInfo pageInfo) throws Exception {
		// TODO Auto-generated method stub
		List<Dictionary> dictionaries =new ArrayList<Dictionary>();
		
		int total= dao.findTotalNum(qParams);//��������
		if(total!=0){
			pageInfo.setTotal(total);
			dictionaries= dao.todiclist(qParams, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return dictionaries;
	}
	
	/**
	 * ����µ������ֵ�
	 * @param dictionary
	 * @throws SQLException 
	 */
	public void add(Dictionary dictionary) throws SQLException {
		// TODO Auto-generated method stub
		dao.add(dictionary);
	}
	
	/**
	 * ɾ��ָ�������ֵ�
	 * @param dictionId
	 */
	public void del(String dictionId)throws SQLException {
		// TODO Auto-generated method stub
		dao.del(dictionId);
	}
	
	/**
	 * ����ָ���༭�����ֵ����
	 * @param dictionId
	 * @return
	 */

	public Dictionary findByid(String dictionId)throws SQLException {
		// TODO Auto-generated method stub
		Dictionary dictionary=new Dictionary();
		dictionary=dao.finByid(dictionId);
		return dictionary;
	}
	
	/**
	 * ���������ֵ�
	 * @param dictionary
	 */
	public void update(Dictionary dictionary) throws SQLException{
		// TODO Auto-generated method stub
		dao.update(dictionary);
	}
	
	/**
	 * �����û������б�
	 * @param qParams
	 * @param pageInfo
	 * @return
	 * @throws SQLException
	 */
	public List<User> touser(Map<String, Object> qParams, PageInfo pageInfo)throws SQLException  {
		// TODO Auto-generated method stub
		List<User> users =new ArrayList<User>();
		
		int total= dao.findTotalNumUser(qParams);//��������
		if(total!=0){
			pageInfo.setTotal(total);
			users= dao.touser(qParams, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return users;
	}
	
	/**
	 * ������û�
	 * @param user
	 */
	public void adduser(User user) throws SQLException {
		// TODO Auto-generated method stub
		dao.adduser(user);
	}
	
	/**
	 * �����û����ݸ���
	 * @param user
	 */
	public void edituser(User user)throws SQLException {
		// TODO Auto-generated method stub
		dao.edituser(user);
	}

}
