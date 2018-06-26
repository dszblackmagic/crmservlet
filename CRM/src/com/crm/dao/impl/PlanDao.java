package com.crm.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.crm.model.Market;
import com.crm.model.Plan;
import com.crm.util.JDBCUtils;

public class PlanDao {

	/**
	 * 计算总记录条数
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int findTotalNum(Map<String, Object> params) throws Exception {
		//查询条件
		List<Object> list = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*)");
		sql.append(" FROM market");
		sql.append(" WHERE 1=1");
		//拼接查询条件
		sql.append(joinQueryCondition(params, list));

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

		return qr.query(sql.toString(), new ScalarHandler<Long>(), list.toArray()).intValue();
	}
	
	/**
	 * 根据传入条件拼接查询
	 * @param params
	 * @param list
	 * @return
	 */
	
	public String joinQueryCondition(Map<String, Object> params, List<Object> list) {
		if (params == null || params.isEmpty()) {
			return "";
		}
		StringBuffer sb = new StringBuffer(" ");
		// 客户名查询条件
		/*if (StringUtils.isNotEmpty((String) params.get("customerName"))) {
			sb.append(" AND customerName LIKE ?"); //
			list.add("%" + params.get("customerName").toString() + "%");
		}
		// 概要查询条件
				if (StringUtils.isNotEmpty((String) params.get("outLine"))) {
					sb.append(" AND outLine LIKE ?"); //
					list.add("%" + params.get("outLine").toString() + "%");
				}
		
				//联系人查询条件
				if (StringUtils.isNotEmpty((String) params.get("conTacts"))) {
					sb.append(" AND conTacts LIKE ?"); //
					list.add("%" + params.get("conTacts").toString() + "%");
				}*/
				//是否分配查询条件
				if (StringUtils.isNotEmpty((String) params.get("judge"))) {
					sb.append(" AND judge= ?"); //
					list.add(params.get("judge"));
				}

		return sb.toString();
	}
	
	/**
	 * 查询所有记录
	 */
	public List<Market> list(Map<String, Object> params, int start, int size) throws Exception {
		// 查询参数
		List<Object> list = new ArrayList<Object>();
		// sql
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT numberId,opporTunity,customerName,probability,outLine,contacts,contactPhone,description,founder,time,distribution,distime,judge,development");
		sql.append(" FROM market");
		sql.append(" WHERE 1=1");
		// 拼接查询条件
		sql.append(joinQueryCondition(params, list));
		// 分页信息
		if (start != -1 || size != -1) {
			sql.append(" LIMIT ?, ?");
			list.add(start);
			list.add(size);
		}

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// query方法参数：查询的sql，处理结果。查询参数。
		return qr.query(sql.toString(), new BeanListHandler<Market>(Market.class), list.toArray());
	}
	
	/**
	 * 保存新的计划
	 * @throws SQLException 
	 */
	public void save(Plan plan) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("insert into plan(numberId,planTime,executePlan)");
		sql.append(" values(?,?,?)");
		Object [] params={plan.getNumberId(),plan.getPlanTime(),plan.getExecutePlan()};
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
	}
/**
 * 
 *返回所有的计划内容（根据id）
 */
	public List<Plan> planList(String id)throws SQLException {
		
				
				// sql
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT *");
				sql.append(" FROM plan");
				sql.append(" WHERE numberId=?");
		
				
				QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
				// query方法参数：查询的sql，处理结果。查询参数。
				return qr.query(sql.toString(), new BeanListHandler<Plan>(Plan.class), id);
	}
/**
 * 
 * 更新指定的计划内容
 */
	public void update(Plan plan,String key) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("update plan set executePlan=?");
		sql.append(" where id=?");
		Object [] params={plan.getExecutePlan(),key};
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
	}
/**
 * 
 * 删除指定的计划内容
 */
	public void delete(String key)throws SQLException  {
		String sql = "DELETE FROM plan WHERE id=?";

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql, key);
		
	}
	/**
	 * 
	 *根据客户编号执行指定计划
	 */
	public void exec(String id)throws SQLException {
	// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("update market set development=?");
		sql.append(" where numberId=?");
		
		Object [] params={"IN",id};
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
	}
	/**
	 * 
	 * 更新指定计划的执行效果
	 * @throws SQLException 
	 */
	public void execupdate(String planEffect, String key) throws SQLException {
		// TODO Auto-generated method stub
		
		StringBuffer sql = new StringBuffer();
		sql.append("update plan set planEffect=?");
		sql.append(" where id=?");
		
		Object [] params={planEffect,key};
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
		
	}
	
	/**
	 * 终止计划
	 * @throws SQLException 
	 */
	
	public void stop(String id) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("update market set development=?");
		sql.append(" where numberId=?");
		
		Object [] params={"S",id};
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
		
	}
	/**
	 * 开发成功并且自动创建客户记录
	 */
	public void success(Market market)throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("update market set development=?");
		sql.append(" where numberId=?");
		Object [] params={"YY",market.getNumberId()};
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
		
		
		//自动创建客户记录
		StringBuffer sql2 = new StringBuffer();
		sql2.append("insert into customer(customerId,customerName,telephone)");
		sql2.append(" values(?,?,?)");
		Object [] params2={market.getNumberId(),market.getCustomerName(),market.getContactPhone()};
		
		QueryRunner qr2 = new QueryRunner(JDBCUtils.getDataSource());
		qr2.update(sql2.toString(), params2);
	}
	
	
}
