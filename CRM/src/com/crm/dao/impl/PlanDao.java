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
	 * �����ܼ�¼����
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int findTotalNum(Map<String, Object> params) throws Exception {
		//��ѯ����
		List<Object> list = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*)");
		sql.append(" FROM market");
		sql.append(" WHERE 1=1");
		//ƴ�Ӳ�ѯ����
		sql.append(joinQueryCondition(params, list));

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

		return qr.query(sql.toString(), new ScalarHandler<Long>(), list.toArray()).intValue();
	}
	
	/**
	 * ���ݴ�������ƴ�Ӳ�ѯ
	 * @param params
	 * @param list
	 * @return
	 */
	
	public String joinQueryCondition(Map<String, Object> params, List<Object> list) {
		if (params == null || params.isEmpty()) {
			return "";
		}
		StringBuffer sb = new StringBuffer(" ");
		// �ͻ�����ѯ����
		/*if (StringUtils.isNotEmpty((String) params.get("customerName"))) {
			sb.append(" AND customerName LIKE ?"); //
			list.add("%" + params.get("customerName").toString() + "%");
		}
		// ��Ҫ��ѯ����
				if (StringUtils.isNotEmpty((String) params.get("outLine"))) {
					sb.append(" AND outLine LIKE ?"); //
					list.add("%" + params.get("outLine").toString() + "%");
				}
		
				//��ϵ�˲�ѯ����
				if (StringUtils.isNotEmpty((String) params.get("conTacts"))) {
					sb.append(" AND conTacts LIKE ?"); //
					list.add("%" + params.get("conTacts").toString() + "%");
				}*/
				//�Ƿ�����ѯ����
				if (StringUtils.isNotEmpty((String) params.get("judge"))) {
					sb.append(" AND judge= ?"); //
					list.add(params.get("judge"));
				}

		return sb.toString();
	}
	
	/**
	 * ��ѯ���м�¼
	 */
	public List<Market> list(Map<String, Object> params, int start, int size) throws Exception {
		// ��ѯ����
		List<Object> list = new ArrayList<Object>();
		// sql
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT numberId,opporTunity,customerName,probability,outLine,contacts,contactPhone,description,founder,time,distribution,distime,judge,development");
		sql.append(" FROM market");
		sql.append(" WHERE 1=1");
		// ƴ�Ӳ�ѯ����
		sql.append(joinQueryCondition(params, list));
		// ��ҳ��Ϣ
		if (start != -1 || size != -1) {
			sql.append(" LIMIT ?, ?");
			list.add(start);
			list.add(size);
		}

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// query������������ѯ��sql������������ѯ������
		return qr.query(sql.toString(), new BeanListHandler<Market>(Market.class), list.toArray());
	}
	
	/**
	 * �����µļƻ�
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
 *�������еļƻ����ݣ�����id��
 */
	public List<Plan> planList(String id)throws SQLException {
		
				
				// sql
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT *");
				sql.append(" FROM plan");
				sql.append(" WHERE numberId=?");
		
				
				QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
				// query������������ѯ��sql������������ѯ������
				return qr.query(sql.toString(), new BeanListHandler<Plan>(Plan.class), id);
	}
/**
 * 
 * ����ָ���ļƻ�����
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
 * ɾ��ָ���ļƻ�����
 */
	public void delete(String key)throws SQLException  {
		String sql = "DELETE FROM plan WHERE id=?";

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql, key);
		
	}
	/**
	 * 
	 *���ݿͻ����ִ��ָ���ƻ�
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
	 * ����ָ���ƻ���ִ��Ч��
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
	 * ��ֹ�ƻ�
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
	 * �����ɹ������Զ������ͻ���¼
	 */
	public void success(Market market)throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("update market set development=?");
		sql.append(" where numberId=?");
		Object [] params={"YY",market.getNumberId()};
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
		
		
		//�Զ������ͻ���¼
		StringBuffer sql2 = new StringBuffer();
		sql2.append("insert into customer(customerId,customerName,telephone)");
		sql2.append(" values(?,?,?)");
		Object [] params2={market.getNumberId(),market.getCustomerName(),market.getContactPhone()};
		
		QueryRunner qr2 = new QueryRunner(JDBCUtils.getDataSource());
		qr2.update(sql2.toString(), params2);
	}
	
	
}
