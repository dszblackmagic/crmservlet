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

import com.crm.model.Associ;
import com.crm.model.Contacts;
import com.crm.model.Customer;
import com.crm.model.Dictionary;
import com.crm.model.Market;
import com.crm.util.JDBCUtils;

public class CustomerDao {
	
	
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
				/*if (StringUtils.isNotEmpty((String) params.get("judge"))) {
					sb.append(" AND judge= ?"); //
					list.add(params.get("judge"));
				}*/

		return sb.toString();
	}
	
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
		sql.append(" FROM customer");
		sql.append(" WHERE 1=1");
		//拼接查询条件
		sql.append(joinQueryCondition(params, list));

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

		return qr.query(sql.toString(), new ScalarHandler<Long>(), list.toArray()).intValue();
	}
	
	
	/**
	 * 查询所有记录
	 */
	public List<Customer> list(Map<String, Object> params, int start, int size) throws Exception {
		// 查询参数
		List<Object> list = new ArrayList<Object>();
		// sql
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT *");
		sql.append(" FROM customer");
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
		return qr.query(sql.toString(), new BeanListHandler<Customer>(Customer.class), list.toArray());
	}
	
	
	//实现以编号查找单独一份信息
		public Customer findByPrimaryKey(String numberId) throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from customer");
			sql.append(" where customerId=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			
			return qr.query(sql.toString(), new BeanHandler<Customer>(Customer.class), numberId);
		}
	//实现保存更新下来的信息
		public void save(Customer customer)throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE customer SET customerName=?,customerArea=?,");
			sql.append(" customerManager=?,customerLevel=?,customerSat=?,customerCredit=?,address=?,");
			sql.append(" postalCode=?,telephone=?,customerFax=?,website=?,registerNum=?,");
			sql.append(" legalPerson=?,registerCapital=?,turnover=?,openBank=?,bankNum=?,localTax=?,countryTax=?");
			sql.append(" WHERE customerId=?");
			
			Object[] params = {customer.getCustomerName(),customer.getCustomerArea(),customer.getCustomerManager()
					,customer.getCustomerLevel(),customer.getCustomerSat(),customer.getCustomerCredit(),customer.getAddress()
					,customer.getPostalCode(),customer.getTelephone(),customer.getCustomerFax(),customer.getWebsite(),customer.getRegisterNum()
					,customer.getLegalPerson(),customer.getRegisterCapital(),customer.getTurnover(),customer.getOpenBank()
					,customer.getBankNum(),customer.getLocalTax(),customer.getCountryTax(),customer.getCustomerId()};
			

			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			
			qr.update(sql.toString(), params);
		}
		//返回客户所对应的联系人
		public List<Contacts> contacatsList(String id)throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from contacts");
			sql.append(" where customerId=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			// query方法参数：查询的sql，处理结果。查询参数。
			return qr.query(sql.toString(), new BeanListHandler<Contacts>(Contacts.class), id);
		}
		
		//添加新联系人
		public void addcon(Contacts contacts) throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql = new StringBuffer();
			
			sql.append("insert into contacts(customerId,contactsName,contactsSex,contactsPosition,officePhone,contactsPhone,contactsRemarks)");
			sql.append(" values(?,?,?,?,?,?,?)");
			
			Object [] params={contacts.getCustomerId(),contacts.getContactsName(),contacts.getContactsSex(),
					contacts.getContactsPosition(),contacts.getOfficePhone(),contacts.getContactsPhone(),contacts.getContactsRemarks()};
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			qr.update(sql.toString(), params);
		}
		//删除客户联系人
		public void delcon(String id) throws SQLException {
			String sql = "DELETE FROM contacts WHERE id=?";

			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			qr.update(sql, id);
			
		}
		//查找特定联系人信息并返回
		public Contacts toeditcon(String id)throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from contacts");
			sql.append(" where id=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			// query方法参数：查询的sql，处理结果。查询参数。
			
			return qr.query(sql.toString(), new BeanHandler<Contacts>(Contacts.class), id);
		}
		
		
		
		//更新指定联系人的信息
		public void conupdate(Contacts contacts)throws SQLException  {
			// TODO Auto-generated method stub
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE contacts SET customerId=?,contactsName=?,");
			sql.append(" contactsSex=?,contactsPosition=?,officePhone=?,contactsPhone=?,contactsRemarks=?");
			sql.append(" WHERE id=?");
			

			Object[] params = {contacts.getCustomerId(),contacts.getContactsName(),contacts.getContactsSex(),
					contacts.getContactsPosition(),contacts.getOfficePhone(),contacts.getContactsPhone(),contacts.getContactsRemarks(),
					contacts.getId()};
			

			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			
			qr.update(sql.toString(), params);
		}
		
		//返回指定客户的交往记录列表
		public List<Associ> associList(String customerId) throws SQLException{
			// TODO Auto-generated method stub
			
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from associ");
			sql.append(" where customerId=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			// query方法参数：查询的sql，处理结果。查询参数。
			return qr.query(sql.toString(), new BeanListHandler<Associ>(Associ.class), customerId);
			
			
		}
		
		
		//添加新的交往记录
		public void addassoci(Associ associ)throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql = new StringBuffer();
			
			sql.append("insert into associ(customerId,customerName,associTime,associPlace,associOutline,associDetails,associRemarks)");
			sql.append(" values(?,?,?,?,?,?,?)");
			
			Object [] params={associ.getCustomerId(),associ.getCustomerName(),associ.getAssociTime(),associ.getAssociPlace(),
					associ.getAssociOutline(),associ.getAssociDetails(),associ.getAssociRemarks()};
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			qr.update(sql.toString(), params);
		}
		
		//删除指定的交往历史记录
		public void delassoci(String id) throws SQLException{
			// TODO Auto-generated method stub
			String sql = "DELETE FROM associ WHERE id=?";

			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			qr.update(sql, id);
		}
		
		//返回指定的历史交往记录信息
		public Associ toeditass(String id) throws SQLException{
			// TODO Auto-generated method stub
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from associ");
			sql.append(" where id=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			// query方法参数：查询的sql，处理结果。查询参数。
			
			return qr.query(sql.toString(), new BeanHandler<Associ>(Associ.class), id);
		}
		
		
		//更新指定历史交往记录
		public void updateassoci(Associ associ)throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE associ SET associTime=?,associPlace=?,");
			sql.append(" associOutline=?,associDetails=?,associRemarks=?");
			sql.append(" WHERE id=?");
			

			Object[] params = {associ.getAssociTime(),associ.getAssociPlace(),associ.getAssociOutline(),
					associ.getAssociDetails(),associ.getAssociRemarks(),associ.getId()};
			

			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			
			qr.update(sql.toString(), params);
		}
		
		//寻找企业客户等级
		public List<Dictionary> findBydic(String dicjudge) throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from dictionary");
			sql.append(" where dictionType=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			// query方法参数：查询的sql，处理结果。查询参数。
			return qr.query(sql.toString(), new BeanListHandler<Dictionary>(Dictionary.class), dicjudge);
		}
}
