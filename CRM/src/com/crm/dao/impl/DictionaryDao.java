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
	 * 计算数字字典总条数
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
		//拼接查询条件
		sql.append(joinQueryCondition(qParams, list));

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
		if (StringUtils.isNotEmpty((String) params.get("dictionType"))) {
			sb.append(" AND dictionType LIKE ?"); //
			list.add("%" + params.get("dictionType").toString() + "%");
		}
		// 概要查询条件
				if (StringUtils.isNotEmpty((String) params.get("dictionEntry"))) {
					sb.append(" AND dictionEntry LIKE ?"); //
					list.add("%" + params.get("dictionEntry").toString() + "%");
				}
		
				//联系人查询条件
				if (StringUtils.isNotEmpty((String) params.get("dictionValue"))) {
					sb.append(" AND dictionValue LIKE ?"); //
					list.add("%" + params.get("dictionValue").toString() + "%");
				}
				
				
				
		// 首页是否显示
		/*if (StringUtils.isNotEmpty((String) params.get("homepageShow"))) {
			sb.append(" AND homepage_show=?");
			list.add(params.get("homepageShow"));
		}*/
		// 客户类型拆查询
		/*if (StringUtils.isNotEmpty((String) params.get("customerType"))){
			sb.append(" AND customer_type = ?");
			list.add(params.get("customerType"));
		}*/
		

		return sb.toString();
	}
	
	/**
	 * 返回数字字典列表信息
	 * @param qParams
	 * @param start
	 * @param size
	 * @return
	 * @throws SQLException 
	 */
	public List<Dictionary> todiclist(Map<String, Object> qParams, int start, int size) throws SQLException {
		// TODO Auto-generated method stub
		// 查询参数
		List<Object> list = new ArrayList<Object>();
		// sql
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT *");
		sql.append(" FROM dictionary");
		sql.append(" WHERE 1=1");
		// 拼接查询条件
		sql.append(joinQueryCondition(qParams, list));
		// 分页信息
		if (start != -1 || size != -1) {
			sql.append(" LIMIT ?, ?");
			list.add(start);
			list.add(size);
		}

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// query方法参数：查询的sql，处理结果。查询参数。
		return qr.query(sql.toString(), new BeanListHandler<Dictionary>(Dictionary.class), list.toArray());
	}
	
	//添加新的数字字典
	public void add(Dictionary dictionary) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into dictionary(dictionId,dictionType,dictionEntry,dictionValue,dictionState)");
		sql.append(" values(?,?,?,?,?)");
		
		Object [] params={dictionary.getDictionId(),dictionary.getDictionType(),dictionary.getDictionEntry(),dictionary.getDictionValue(),dictionary.getDictionState()};
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql.toString(), params);
	}
	
	//删除指定数字字典
	public void del(String dictionId) throws SQLException  {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM dictionary WHERE dictionId=?";

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql, dictionId);
	}
	//查找指定id信息
	public Dictionary finByid(String dictionId) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();
		sql.append("select *");
		sql.append(" from dictionary");
		sql.append(" where dictionId=?");
		
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// query方法参数：查询的sql，处理结果。查询参数。
		
		return qr.query(sql.toString(), new BeanHandler<Dictionary>(Dictionary.class), dictionId);
	}
	
	//更新数字字典信息
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
		//拼接查询条件
		sql.append(joinQueryCondition(qParams, list));

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

		return qr.query(sql.toString(), new ScalarHandler<Long>(), list.toArray()).intValue();
		
	}

	/**
	 * 返回用户管理列表信息
	 * @param qParams
	 * @param start
	 * @param size
	 * @return
	 * @throws SQLException
	 */

	public List<User> touser(Map<String, Object> qParams, int start, int size) throws SQLException{
		// TODO Auto-generated method stub
		// 查询参数
				List<Object> list = new ArrayList<Object>();
				// sql
				StringBuffer sql = new StringBuffer();
				sql.append(
						"SELECT *");
				sql.append(" FROM user");
				sql.append(" WHERE 1=1");
				// 拼接查询条件
				sql.append(joinQueryCondition(qParams, list));
				// 分页信息
				if (start != -1 || size != -1) {
					sql.append(" LIMIT ?, ?");
					list.add(start);
					list.add(size);
				}

				QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
				// query方法参数：查询的sql，处理结果。查询参数。
				return qr.query(sql.toString(), new BeanListHandler<User>(User.class), list.toArray());
	}
	
	/**
	 * 添加新用户
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
	
	//更新用户
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
