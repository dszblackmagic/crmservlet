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
	 * 到达数字字典列表界面
	 * @param qParams
	 * @param pageInfo
	 * @return
	 * @throws Exception 
	 */
	public List<Dictionary> todiclist(Map<String, Object> qParams, PageInfo pageInfo) throws Exception {
		// TODO Auto-generated method stub
		List<Dictionary> dictionaries =new ArrayList<Dictionary>();
		
		int total= dao.findTotalNum(qParams);//总数据数
		if(total!=0){
			pageInfo.setTotal(total);
			dictionaries= dao.todiclist(qParams, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return dictionaries;
	}
	
	/**
	 * 添加新的数字字典
	 * @param dictionary
	 * @throws SQLException 
	 */
	public void add(Dictionary dictionary) throws SQLException {
		// TODO Auto-generated method stub
		dao.add(dictionary);
	}
	
	/**
	 * 删除指定数字字典
	 * @param dictionId
	 */
	public void del(String dictionId)throws SQLException {
		// TODO Auto-generated method stub
		dao.del(dictionId);
	}
	
	/**
	 * 到达指定编辑数字字典界面
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
	 * 更新数字字典
	 * @param dictionary
	 */
	public void update(Dictionary dictionary) throws SQLException{
		// TODO Auto-generated method stub
		dao.update(dictionary);
	}
	
	/**
	 * 到达用户管理列表
	 * @param qParams
	 * @param pageInfo
	 * @return
	 * @throws SQLException
	 */
	public List<User> touser(Map<String, Object> qParams, PageInfo pageInfo)throws SQLException  {
		// TODO Auto-generated method stub
		List<User> users =new ArrayList<User>();
		
		int total= dao.findTotalNumUser(qParams);//总数据数
		if(total!=0){
			pageInfo.setTotal(total);
			users= dao.touser(qParams, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return users;
	}
	
	/**
	 * 添加新用户
	 * @param user
	 */
	public void adduser(User user) throws SQLException {
		// TODO Auto-generated method stub
		dao.adduser(user);
	}
	
	/**
	 * 保存用户数据更新
	 * @param user
	 */
	public void edituser(User user)throws SQLException {
		// TODO Auto-generated method stub
		dao.edituser(user);
	}

}
