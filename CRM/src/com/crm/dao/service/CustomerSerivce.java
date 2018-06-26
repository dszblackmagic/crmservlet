package com.crm.dao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.crm.dao.impl.CustomerDao;
import com.crm.model.Associ;
import com.crm.model.Contacts;
import com.crm.model.Customer;
import com.crm.model.Dictionary;
import com.crm.model.Market;
import com.crm.util.PageInfo;

public class CustomerSerivce {
	CustomerDao customerDao=new CustomerDao();
	
	/**
	 * ��ѯ��¼����
	 */
	
	public List<Customer> list(Map<String, Object> params,PageInfo pageInfo) throws Exception{
		List<Customer> list =new ArrayList<Customer>();
		
		
		int total= customerDao.findTotalNum(params);//��������
		if(total!=0){
			pageInfo.setTotal(total);
			list= customerDao.list(params, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return list;
	}
	
	
	/**
	 * 
	 * ����ID����
	 * @throws SQLException 
	 */
	
	public Customer findByPrimaryKey(String id) throws SQLException {
		
		return customerDao.findByPrimaryKey(id);
	}

	/**
	 * ������Ϣ
	 * @param customer
	 * @throws SQLException
	 */
	public void save(Customer customer) throws SQLException{
		// TODO Auto-generated method stub
		customerDao.save(customer);
	}

	/**
	 * ������ϵ���б�(��Ӧ�ͻ�)
	 * @return
	 * @throws SQLException 
	 */
	public List<Contacts> contactsList(String id) throws SQLException {
		// TODO Auto-generated method stub
		List<Contacts> cList=new ArrayList<Contacts>();
		cList=customerDao.contacatsList(id);
				
		
		return cList;
	}

	/**
	 * ����µ���ϵ��
	 * @param contacts
	 * @throws SQLException
	 */
	public void addcon(Contacts contacts)throws SQLException  {
		// TODO Auto-generated method stub
		customerDao.addcon(contacts);
	}

	/**
	 * ɾ���ͻ���ϵ��
	 * @param id
	 */
	public void delcon(String id) throws SQLException{
		// TODO Auto-generated method stub
		customerDao.delcon(id);
	}

	
	/**
	 * �����ض��û���Ϣ
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Contacts toeditcon(String id) throws SQLException{
		// TODO Auto-generated method stub
		Contacts List=new Contacts();
		List=customerDao.toeditcon(id);
		
		return List;
	}

	/**
	 * ����ָ������ϵ����Ϣ
	 * @param contacts
	 */
	public void conupdate(Contacts contacts) throws SQLException{
		// TODO Auto-generated method stub
		customerDao.conupdate(contacts);
	}

	/**
	 * ���ｻ����¼����
	 * @param customerId
	 * @return
	 */
	public List<Associ> toassoci(String customerId) throws SQLException{
		// TODO Auto-generated method stub
		List<Associ> aList=new ArrayList<Associ>();
		aList=customerDao.associList(customerId);
		
		return aList;
	}
	
	/**
	 * ����µĽ�����¼
	 * @param associ
	 * @throws SQLException
	 */

	public void addassoci(Associ associ) throws SQLException {
		// TODO Auto-generated method stub
		customerDao.addassoci(associ);
	}

	/**
	 * ɾ��ָ����ʷ������¼
	 * @param id
	 * @throws SQLException
	 */
	public void delassoci(String id) throws SQLException{
		// TODO Auto-generated method stub
		customerDao.delassoci(id);
	}

	/**
	 * ����༭ָ����ʷ������¼
	 * @param id
	 * @return
	 */
	public Associ toeditass(String id) throws SQLException{
		Associ List=new Associ();
		List=customerDao.toeditass(id);
		
		return List;
	}

	/**
	 * ����ָ����ʷ������¼
	 * @param associ
	 */
	public void updateassoci(Associ associ) throws SQLException{
		// TODO Auto-generated method stub
		customerDao.updateassoci(associ);
	}

	/**
	 * Ѱ����ҵ�ͻ��ȼ�
	 * @param dicjudge
	 * @return
	 */
	public List<Dictionary> findBydic(String dicjudge)throws SQLException {
		// TODO Auto-generated method stub
		List<Dictionary> dicList=new ArrayList<Dictionary>();
		dicList=customerDao.findBydic(dicjudge);
		return dicList;
	}
	
}
