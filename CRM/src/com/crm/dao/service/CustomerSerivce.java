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
	 * 查询记录条数
	 */
	
	public List<Customer> list(Map<String, Object> params,PageInfo pageInfo) throws Exception{
		List<Customer> list =new ArrayList<Customer>();
		
		
		int total= customerDao.findTotalNum(params);//总数据数
		if(total!=0){
			pageInfo.setTotal(total);
			list= customerDao.list(params, pageInfo.getStart(), pageInfo.getSize());
		}
		
		return list;
	}
	
	
	/**
	 * 
	 * 根据ID检索
	 * @throws SQLException 
	 */
	
	public Customer findByPrimaryKey(String id) throws SQLException {
		
		return customerDao.findByPrimaryKey(id);
	}

	/**
	 * 保存信息
	 * @param customer
	 * @throws SQLException
	 */
	public void save(Customer customer) throws SQLException{
		// TODO Auto-generated method stub
		customerDao.save(customer);
	}

	/**
	 * 返回联系人列表(对应客户)
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
	 * 添加新的联系人
	 * @param contacts
	 * @throws SQLException
	 */
	public void addcon(Contacts contacts)throws SQLException  {
		// TODO Auto-generated method stub
		customerDao.addcon(contacts);
	}

	/**
	 * 删除客户联系人
	 * @param id
	 */
	public void delcon(String id) throws SQLException{
		// TODO Auto-generated method stub
		customerDao.delcon(id);
	}

	
	/**
	 * 查找特定用户信息
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
	 * 更新指定的联系人信息
	 * @param contacts
	 */
	public void conupdate(Contacts contacts) throws SQLException{
		// TODO Auto-generated method stub
		customerDao.conupdate(contacts);
	}

	/**
	 * 到达交往记录界面
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
	 * 添加新的交往记录
	 * @param associ
	 * @throws SQLException
	 */

	public void addassoci(Associ associ) throws SQLException {
		// TODO Auto-generated method stub
		customerDao.addassoci(associ);
	}

	/**
	 * 删除指定历史交往记录
	 * @param id
	 * @throws SQLException
	 */
	public void delassoci(String id) throws SQLException{
		// TODO Auto-generated method stub
		customerDao.delassoci(id);
	}

	/**
	 * 到达编辑指定历史交往记录
	 * @param id
	 * @return
	 */
	public Associ toeditass(String id) throws SQLException{
		Associ List=new Associ();
		List=customerDao.toeditass(id);
		
		return List;
	}

	/**
	 * 更新指定历史交往记录
	 * @param associ
	 */
	public void updateassoci(Associ associ) throws SQLException{
		// TODO Auto-generated method stub
		customerDao.updateassoci(associ);
	}

	/**
	 * 寻找企业客户等级
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
