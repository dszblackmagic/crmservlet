package com.crm.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.crm.model.Dictionary;
import com.crm.model.Serve;
import com.crm.model.User;
import com.crm.util.JDBCUtils;

public class DictionaryDao {
	
	/**
	 * ���������ֵ�������
	 * @param qParams
	 * @return
	 */
	public int findTotalNum(Map<String, Object> qParams) throws Exception  {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*)");
		sql.append(" FROM dictionary");
		sql.append(" WHERE 1=1");
		//ƴ�Ӳ�ѯ����
		sql.append(joinQueryCondition(qParams, list));

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
		if (StringUtils.isNotEmpty((String) params.get("dictionType"))) {
			sb.append(" AND dictionType LIKE ?"); //
			list.add("%" + params.get("dictionType").toString() + "%");
		}
		// ��Ҫ��ѯ����
				if (StringUtils.isNotEmpty((String) params.get("dictionEntry"))) {
					sb.append(" AND dictionEntry LIKE ?"); //
					list.add("%" + params.get("dictionEntry").toString() + "%");
				}
		
				//��ϵ�˲�ѯ����
				if (StringUtils.isNotEmpty((String) params.get("dictionValue"))) {
					sb.append(" AND dictionValue LIKE ?"); //
					list.add("%" + params.get("dictionValue").toString() + "%");
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
	 * ���������ֵ��б���Ϣ
	 * @param qParams
	 * @param start
	 * @param size
	 * @return
	 * @throws SQLException 
	 */
	public List<Dictionary> todiclist(Map<String, Object> qParams, int start, int size) throws SQLException {
		// TODO Auto-generated method stub
		// ��ѯ����
		List<Object> list = new ArrayList<Object>();
		// sql
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT *");
		sql.append(" FROM dictionary");
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
		return qr.query(sql.toString(), new BeanListHandler<Dictionary>(Dictionary.class), list.toArray());
	}
	
	//����µ������ֵ�
	public void add(Dictionary dictionary) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into dictionary(dictionId,dictionType,dictionEntry,dictionValue,dictionState)");
		sql.append(" values(?,?,?,?,?)");
		
		Object [] params={dictionary.getDictionId(),dictionary.getDictionType(),dictionary.getDictionEntry(),dictionary.getDictionValue(),dictionary.getDictionState()};
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
	}
	
	//ɾ��ָ�������ֵ�
	public void del(String dictionId) throws SQLException  {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM dictionary WHERE dictionId=?";

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql, dictionId);
	}
	//����ָ��id��Ϣ
	public Dictionary finByid(String dictionId) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();
		sql.append("select *");
		sql.append(" from dictionary");
		sql.append(" where dictionId=?");
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// query������������ѯ��sql������������ѯ������
		
		return qr.query(sql.toString(), new BeanHandler<Dictionary>(Dictionary.class), dictionId);
	}
	
	//���������ֵ���Ϣ
	public void update(Dictionary dictionary) throws SQLException{
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE dictionary SET dictionType=?,dictionEntry=?,dictionValue=?,dictionState=?");
		sql.append(" WHERE dictionId=?");
		

		Object[] params = {dictionary.getDictionType(),dictionary.getDictionEntry(),dictionary.getDictionValue(),dictionary.getDictionState(),dictionary.getDictionId()};
		

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		qr.update(sql.toString(), params);
	}

	public int findTotalNumUser(Map<String, Object> qParams) throws SQLException {
		List<Object> list = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*)");
		sql.append(" FROM user");
		sql.append(" WHERE 1=1");
		//ƴ�Ӳ�ѯ����
		sql.append(joinQueryCondition(qParams, list));

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

		return qr.query(sql.toString(), new ScalarHandler<Long>(), list.toArray()).intValue();
		
	}

	/**
	 * �����û������б���Ϣ
	 * @param qParams
	 * @param start
	 * @param size
	 * @return
	 * @throws SQLException
	 */

	public List<User> touser(Map<String, Object> qParams, int start, int size) throws SQLException{
		// TODO Auto-generated method stub
		// ��ѯ����
				List<Object> list = new ArrayList<Object>();
				// sql
				StringBuffer sql = new StringBuffer();
				sql.append(
						"SELECT *");
				sql.append(" FROM user");
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
				return qr.query(sql.toString(), new BeanListHandler<User>(User.class), list.toArray());
	}
	
	/**
	 * ������û�
	 * @param user
	 * @throws SQLException
	 */
	public void adduser(User user) throws SQLException{
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into user(userName,userPassword,userType)");
		sql.append(" values(?,?,?)");
		
		Object [] params={user.getUserName(),user.getUserPassword(),user.getUserType()};
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
	}
	
	//�����û�
	public void edituser(User user) throws SQLException {
		// TODO Auto-generated method stub
StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE user SET userPassword=?,userType=?");
		sql.append(" WHERE userName=?");
		

		Object[] params = {user.getUserPassword(),user.getUserType(),user.getUserName()};
		

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		qr.update(sql.toString(), params);
	}

}
