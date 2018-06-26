package com.crm.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.crm.model.CountCus;
import com.crm.model.CountSer;
import com.crm.model.Dictionary;
import com.crm.util.JDBCUtils;

public class AnalysisDao {
	
	/**
	 * 统计客户构成
	 * @param qParams
	 * @param start
	 * @param size
	 * @return
	 * @throws SQLException 
	 */
	public List<CountCus> tocustomer(Map<String, Object> qParams, int start, int size) throws SQLException {
		// TODO Auto-generated method stub
		
		
		StringBuffer sql= new StringBuffer();
		sql.append("select customerId,customerLevel,COUNT(customerLevel) number");
		sql.append(" from customer");
		sql.append(" GROUP BY customerLevel");
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// query方法参数：查询的sql，处理结果。查询参数。
		return qr.query(sql.toString(), new BeanListHandler<CountCus>(CountCus.class));
	}

	public List<CountSer> toserve(Map<String, Object> qParams, int start, int size)throws SQLException  {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();
		sql.append("select serveId,serveType,COUNT(serveType) number");
		sql.append(" from serve");
		sql.append(" GROUP BY serveType");
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// query方法参数：查询的sql，处理结果。查询参数。
		return qr.query(sql.toString(), new BeanListHandler<CountSer>(CountSer.class));
	}

}
