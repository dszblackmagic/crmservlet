package com.crm.dao.service;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import com.crm.model.User;
import com.crm.util.JDBCUtils;

public class LoginSerivce {
	
	
	public User check(String userName,String userPassword)throws Exception{
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT *");
		sql.append(" FROM user");
		sql.append(" WHERE userName=? and userPassword=?");
		
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		User user2=(User)qr.query(sql.toString(),new BeanHandler<User>(User.class),userName,userPassword);
		
		
		return user2;
		
		
		
		
		
		
		
	}
}
