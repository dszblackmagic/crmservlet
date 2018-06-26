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
				/*if (StringUtils.isNotEmpty((String) params.get("judge"))) {
					sb.append(" AND judge= ?"); //
					list.add(params.get("judge"));
				}*/

		return sb.toString();
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
		sql.append(" FROM customer");
		sql.append(" WHERE 1=1");
		//ƴ�Ӳ�ѯ����
		sql.append(joinQueryCondition(params, list));

		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

		return qr.query(sql.toString(), new ScalarHandler<Long>(), list.toArray()).intValue();
	}
	
	
	/**
	 * ��ѯ���м�¼
	 */
	public List<Customer> list(Map<String, Object> params, int start, int size) throws Exception {
		// ��ѯ����
		List<Object> list = new ArrayList<Object>();
		// sql
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT *");
		sql.append(" FROM customer");
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
		return qr.query(sql.toString(), new BeanListHandler<Customer>(Customer.class), list.toArray());
	}
	
	
	//ʵ���Ա�Ų��ҵ���һ����Ϣ
		public Customer findByPrimaryKey(String numberId) throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from customer");
			sql.append(" where customerId=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			
			return qr.query(sql.toString(), new BeanHandler<Customer>(Customer.class), numberId);
		}
	//ʵ�ֱ��������������Ϣ
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
		//���ؿͻ�����Ӧ����ϵ��
		public List<Contacts> contacatsList(String id)throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from contacts");
			sql.append(" where customerId=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			// query������������ѯ��sql������������ѯ������
			return qr.query(sql.toString(), new BeanListHandler<Contacts>(Contacts.class), id);
		}
		
		//�������ϵ��
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
		//ɾ���ͻ���ϵ��
		public void delcon(String id) throws SQLException {
			String sql = "DELETE FROM contacts WHERE id=?";

			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			qr.update(sql, id);
			
		}
		//�����ض���ϵ����Ϣ������
		public Contacts toeditcon(String id)throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from contacts");
			sql.append(" where id=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			// query������������ѯ��sql������������ѯ������
			
			return qr.query(sql.toString(), new BeanHandler<Contacts>(Contacts.class), id);
		}
		
		
		
		//����ָ����ϵ�˵���Ϣ
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
		
		//����ָ���ͻ��Ľ�����¼�б�
		public List<Associ> associList(String customerId) throws SQLException{
			// TODO Auto-generated method stub
			
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from associ");
			sql.append(" where customerId=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			// query������������ѯ��sql������������ѯ������
			return qr.query(sql.toString(), new BeanListHandler<Associ>(Associ.class), customerId);
			
			
		}
		
		
		//����µĽ�����¼
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
		
		//ɾ��ָ���Ľ�����ʷ��¼
		public void delassoci(String id) throws SQLException{
			// TODO Auto-generated method stub
			String sql = "DELETE FROM associ WHERE id=?";

			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			qr.update(sql, id);
		}
		
		//����ָ������ʷ������¼��Ϣ
		public Associ toeditass(String id) throws SQLException{
			// TODO Auto-generated method stub
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from associ");
			sql.append(" where id=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			// query������������ѯ��sql������������ѯ������
			
			return qr.query(sql.toString(), new BeanHandler<Associ>(Associ.class), id);
		}
		
		
		//����ָ����ʷ������¼
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
		
		//Ѱ����ҵ�ͻ��ȼ�
		public List<Dictionary> findBydic(String dicjudge) throws SQLException {
			// TODO Auto-generated method stub
			StringBuffer sql= new StringBuffer();
			sql.append("select *");
			sql.append(" from dictionary");
			sql.append(" where dictionType=?");
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
			// query������������ѯ��sql������������ѯ������
			return qr.query(sql.toString(), new BeanListHandler<Dictionary>(Dictionary.class), dicjudge);
		}
}
