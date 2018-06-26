package com.crm.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.apache.commons.lang.StringUtils;

import com.crm.model.Market;
import com.crm.model.User;
import com.crm.util.JDBCUtils;






/*
	 * Ӫ��������Ϣ���ݿ����
	 */
public class MarketDao {
	
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
		if (StringUtils.isNotEmpty((String) params.get("customerName"))) {
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
				}
				//�Ƿ�����ѯ����
				if (StringUtils.isNotEmpty((String) params.get("judge"))) {
					sb.append(" AND judge= ?"); //
					list.add(params.get("judge"));
				}
		
				
		// ��ҳ�Ƿ���ʾ
		/*if (StringUtils.isNotEmpty((String) params.get("homepageShow"))) {
			sb.append(" AND homepage_show=?");
			list.add(params.get("homepageShow"));
		}*/
		// �ͻ����Ͳ��ѯ
		/*if (StringUtils.isNotEmpty((String) params.get("customerType"))){
			sb.append(" AND customer_type = ?");
			list.add(params.get("customerType"));
		}*/
		

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
				"SELECT *");
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

	
	//ʵ������µ�Ӫ��������Ϣ
	public static void create(Market market) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("insert into market(numberId,opporTunity,customerName,probability,outLine,contacts,contactPhone,description,founder,time,distribution,distime,judge,development)");
		sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		Object [] params={market.getNumberId(),market.getOpporTunity(),market.getCustomerName(),market.getProbability(),market.getOutLine(),market.getContacts(),market.getContactPhone()
				,market.getDescription(),market.getFounder(),market.getTime(),market.getDistribution(),market.getDistime(),market.getJudge(),"N"};
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
	};
	
	
	//ʵ��ɾ��������Ϣ����ɾ�����������Ϣ)
	public void delete(String numberId) throws Exception {
		String sql = "DELETE FROM market WHERE numberId=?";

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql, numberId);
		
		String sql2 = "DELETE FROM contacts WHERE customerId=?";

		QueryRunner qr2 = new QueryRunner(JDBCUtils.getDataSource());
		qr2.update(sql2, numberId);
		
		String sql3 = "DELETE FROM associ WHERE customerId=?";

		QueryRunner qr3 = new QueryRunner(JDBCUtils.getDataSource());
		qr3.update(sql3, numberId);
		
		String sql4 = "DELETE FROM customer WHERE customerId=?";

		QueryRunner qr4 = new QueryRunner(JDBCUtils.getDataSource());
		qr4.update(sql4, numberId);
	}
	//ʵ���Ա�Ų��ҵ���һ����Ϣ
	public Market findByPrimaryKey(String numberId) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();
		sql.append("select numberId,opporTunity,customerName,probability,outLine,contacts,contactPhone,description,founder,time,distribution,distime,judge");
		sql.append(" from market");
		sql.append(" where numberId=?");
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		return qr.query(sql.toString(), new BeanHandler<Market>(Market.class), numberId);
	}
	//ʵ�ָ���Ӫ����Ϣ�����ݱ�ţ�
	public void update(Market market) throws SQLException {
		// TODO Auto-generated method stub
		
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE market SET opporTunity=?,customerName=?,");
			sql.append(" probability=?,outLine=?,contacts=?,contactPhone=?,description=?");
			
			sql.append(" WHERE numberId=?");
			
			Object[] params = { market.getOpporTunity(),market.getCustomerName(),market.getProbability(),market.getOutLine(),
					market.getContacts(),market.getContactPhone(),market.getDescription(),market.getNumberId()};
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			
			qr.update(sql.toString(), params);
		
	}

	/**
	 * 
	 *�������еĿͻ�����
	 */
	public List<User> findAlladmin() throws SQLException {
		// TODO Auto-generated method stub
		String judge="khjl";
		StringBuffer sql = new StringBuffer();
		sql.append("select userName,userPassword,userType");
		sql.append(" FROM user");
		sql.append(" where userType=?");
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		return qr.query(sql.toString(), new BeanListHandler<User>(User.class),judge);
	}
	/**
	 * 
	 * ����ָ����Ϣ
	 * @throws SQLException 
	 */
	public void assign(String distribution, String distime, String numberId) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE market SET distribution=?,distime=?,judge=?");
		sql.append(" where numberId=?");
		//�༭����
		Object[] params = { distribution,distime,"Y",numberId};
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
		
	}
}
