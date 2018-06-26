package com.crm.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.crm.model.Associ;
import com.crm.model.Market;
import com.crm.model.Serve;
import com.crm.util.JDBCUtils;

public class ServeDao {

	
	//�����µķ�����Ϣ
	public void add(Serve serve) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into serve(serveId,serveType,serveOutline,serveCustomer,serveState,serveRequest,serveFounder,serveTime)");
		sql.append(" values(?,?,?,?,?,?,?,?)");
		
		Object [] params={serve.getServeId(),serve.getServeType(),serve.getServeOutline(),serve.getServeCustomer(),
				"N",serve.getServeRequest(),serve.getServeFounder(),serve.getServeTime()};
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
	}
	
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
		sql.append(" FROM serve");
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
		if (StringUtils.isNotEmpty((String) params.get("serveCustomer"))) {
			sb.append(" AND serveCustomer LIKE ?"); //
			list.add("%" + params.get("serveCustomer").toString() + "%");
		}
		// ��Ҫ��ѯ����
				if (StringUtils.isNotEmpty((String) params.get("serveOutline"))) {
					sb.append(" AND serveOutline LIKE ?"); //
					list.add("%" + params.get("serveOutline").toString() + "%");
				}
		
				//��ϵ�˲�ѯ����
				if (StringUtils.isNotEmpty((String) params.get("serveType"))) {
					sb.append(" AND serveType LIKE ?"); //
					list.add("%" + params.get("serveType").toString() + "%");
				}
				//�Ƿ�����ѯ����
				if (StringUtils.isNotEmpty((String) params.get("serveState"))) {
					sb.append(" AND serveState= ?"); //
					list.add(params.get("serveState"));
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

	
	//չʾ�б�(������䣩
	public List<Serve> todis(Map<String, Object> qParams, int start, int size) throws SQLException {
		
		// ��ѯ����
				List<Object> list = new ArrayList<Object>();
				// sql
				StringBuffer sql = new StringBuffer();
				sql.append(
						"SELECT *");
				sql.append(" FROM serve");
				sql.append(" WHERE 1=1");
				// ƴ�Ӳ�ѯ����
				sql.append(joinQueryCondition(qParams, list));
				// ��ҳ��Ϣ
				if (start != -1 || size != -1) {
					sql.append(" LIMIT ?, ?");
					list.add(start);
					list.add(size);
				}

				QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
				// query������������ѯ��sql������������ѯ������
				return qr.query(sql.toString(), new BeanListHandler<Serve>(Serve.class), list.toArray());
		
	}
	//����ͻ���������
	public void servedis(String serveId, String serveDistri)throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat =new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String date= dateFormat.format(calendar.getTime());
		
		sql.append("UPDATE serve SET serveState=?,serveDistri=?,serveDistritime=?");
		sql.append(" WHERE serveId=?");
		

		Object[] params = {"A",serveDistri,date,serveId};
		

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		qr.update(sql.toString(), params);
	}
	
	
	//ɾ��ָ������
	public void servedel(String serveId) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "DELETE FROM serve WHERE serveId=?";

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql, serveId);
	}

	public Serve finByid(String serveId) throws SQLException{
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();
		sql.append("select *");
		sql.append(" from serve");
		sql.append(" where serveId=?");
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// query������������ѯ��sql������������ѯ������
		
		return qr.query(sql.toString(), new BeanHandler<Serve>(Serve.class), serveId);
	}
	
	//���洦��
	public void edithandle(Serve serve) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE serve SET serveHandle=?,serveHandlepeo=?,serveHandletime=?,serveState=?");
		sql.append(" WHERE serveId=?");
		

		Object[] params = {serve.getServeHandle(),serve.getServeHandlepeo(),serve.getServeHandletime(),"H",serve.getServeId()};
		

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		qr.update(sql.toString(), params);
		
	}
	//���淴������
	public void editfdb(String serveId, String serveResult, String serveSatisfied) throws SQLException{
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE serve SET serveResult=?,serveSatisfied=?,serveState=?");
		sql.append(" WHERE serveId=?");
		
		if(Integer.valueOf(serveSatisfied)>=3){
		Object[] params = {serveResult,serveSatisfied,"F",serveId};
		

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		qr.update(sql.toString(), params);
		}else{
			Object[] params = {serveResult,serveSatisfied,"N",serveId};
			

			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			
			qr.update(sql.toString(), params);
		}
	}

}
