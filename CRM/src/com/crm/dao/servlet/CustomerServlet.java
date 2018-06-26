package com.crm.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.crm.dao.service.CustomerSerivce;
import com.crm.dao.service.DictionarySerivce;
import com.crm.dao.service.MarketService;
import com.crm.model.Associ;
import com.crm.model.Contacts;
import com.crm.model.Customer;
import com.crm.model.Dictionary;
import com.crm.model.User;
import com.crm.util.JSONResult;
import com.crm.util.PageInfo;
import com.crm.util.PageInfoUtils;
@WebServlet("/customer/*")
public class CustomerServlet extends HttpServlet {
	
	
	CustomerSerivce customerSerivce=new CustomerSerivce();
	MarketService marketService=new MarketService();
	DictionarySerivce dictionarySerivce=new DictionarySerivce();
	
	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String servletPath =request.getRequestURI();
		String method =servletPath.substring(servletPath.lastIndexOf("/"));
		
		
		if("/list".equals(method)){//��ʾȫ����Ϣ
			list(request, response);
		}else if("/toedit".equals(method)){
			toedit(request,response);
		}else if("/save".equals(method)){
			save(request,response);
		}else if("/tocontacts".equals(method)){
			tocontacts(request,response);
		}else if("/toaddcon".equals(method)){
			toaddcon(request,response);
		}else if("/addcon".equals(method)){
			addcon(request,response);
		}else if("/delcon".equals(method)) {
			delcon(request,response);
		}else if("/toeditcon".equals(method)){
			toeditcon(request,response);
		}else if("/conupdate".equals(method)){
			conupdate(request,response);
		}else if("/toassoci".equals(method)){
			toassoci(request,response);
		}else if("/toaddass".equals(method)){
			toaddass(request,response);
		}else if("/addassoci".equals(method)){
			addassoci(request,response);
		}else if("/delassoci".equals(method)){
			delassoci(request,response);
		}else if("/toeditass".equals(method)){
			toeditass(request,response);
		}else if("/updateassoci".equals(method)){
			updateassoci(request,response);
		}
	}
	/**
	 * ������ʷ������Ϣ
	 * @param request
	 * @param response
	 */
	
	protected void updateassoci(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
		
		String id= request.getParameter("id") ;
		String associTime=request.getParameter("associTime");
		String associPlace=request.getParameter("associPlace");
		String associOutline=request.getParameter("associOutline");
		String associDetails=request.getParameter("associDetails");
		String associRemarks=request.getParameter("associRemarks");
		
		
		//�洢�õ�����Ϣ
		Associ associ=new Associ(id, associTime, associPlace, associOutline, associDetails, associRemarks);
		
		
		JSONResult jsonResult=new JSONResult();
		
		try {
			customerSerivce.updateassoci(associ);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("error");
		}
		
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
	}


	/**
	 * ������ʷ��¼�༭����
	 * @param request
	 * @param response
	 */
	protected void toeditass(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String customerId=request.getParameter("customerId");
		String customerName=request.getParameter("customerName");
		
		//���û���Ϣ���д洢
		Map<String, Object>info =new HashMap<String, Object>();
		info.put("customerId",customerId);
		info.put("customerName", customerName);
				
				
		
		Associ associ=null;
		
		try {
			associ=customerSerivce.toeditass(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		//�����԰󶨵�request
		 request.setAttribute("info", info);
		 request.setAttribute("List", associ);
		 
		 request.getRequestDispatcher("/custom/customer_editassoci.jsp").forward(request, response);
	}

	/**
	 * ɾ��ĳ��������¼��Ϣ
	 * @param request
	 * @param response
	 */
protected void delassoci(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
	String id=request.getParameter("ids");
	JSONResult jsonResult = new JSONResult();
	try {
		customerSerivce.delassoci(id);
	} catch (Exception e) {
		e.printStackTrace();
		jsonResult.setStatus("error");
	}
	
	JSON.writeJSONString(response.getOutputStream(), jsonResult);
	}



/**
 * ���������ʷ������¼����
 * @param request
 * @param response
 */

protected void toaddass(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException{
		// TODO Auto-generated method stub
		String customerId=request.getParameter("customerId");
		String customerName=request.getParameter("customerName");
		
		Map<String, Object>info =new HashMap<String, Object>();
		
		info.put("customerId",customerId);
		info.put("customerName", customerName);
		//����Ϣ
		request.setAttribute("info", info);
		
		request.getRequestDispatcher("/custom/customer_addassoci.jsp").forward(request, response);
	}




/**
 * ���ｻ����¼����
 * @param request
 * @param response
 */

protected void toassoci(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException {
		// TODO Auto-generated method stub
	String customerId=request.getParameter("customerId");
	String customerName=request.getParameter("customerName");
	List<Associ> associs=null;
	Map<String, Object>info =new HashMap<String, Object>();
	
	info.put("customerId",customerId);
	info.put("customerName", customerName);
	try {
		associs=customerSerivce.toassoci(customerId);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	//����Ϣ��request����
	request.setAttribute("info", info);
	request.setAttribute("List", associs);
	
	request.getRequestDispatcher("/custom/customer_associ.jsp").forward(request, response);
	
	
	}






/**
 * ������ϵ�˵���Ϣ
 * @param request
 * @param response
 */

protected void conupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
	int id= Integer.parseInt(request.getParameter("id")) ;
	String customerId=request.getParameter("customerId");
	String contactsName=request.getParameter("contactsName");
	String contactsSex=request.getParameter("contactsSex");
	String contactsPosition=request.getParameter("contactsPosition");
	String officePhone=request.getParameter("officePhone");
	String contactsPhone=request.getParameter("contactsPhone");
	String contactsRemarks=request.getParameter("contactsRemarks");
	
	//�洢�õ�����Ϣ
	Contacts contacts=new Contacts(id, customerId, contactsName, contactsSex, contactsPosition, officePhone, contactsPhone, contactsRemarks);
	
	
	JSONResult jsonResult=new JSONResult();
	
	try {
		customerSerivce.conupdate(contacts);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		jsonResult.setStatus("error");
	}
	
	
	response.setContentType("application/json;charset=UTF-8");
	JSON.writeJSONString(response.getOutputStream(), jsonResult);
	
	
	
	}


/**
 * ����µ���ϵ��
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */

protected void addcon(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String customerId=request.getParameter("customerId");
		String contactsName=request.getParameter("contactsName");
		String contactsSex=request.getParameter("contactsSex");
		String contactsPosition=request.getParameter("contactsPosition");
		String officePhone=request.getParameter("officePhone");
		String contactsPhone=request.getParameter("contactsPhone");
		String contactsRemarks=request.getParameter("contactsRemarks");
		
		Contacts contacts=new Contacts(customerId, contactsName, contactsSex, contactsPosition, officePhone, contactsPhone, contactsRemarks);
		
		JSONResult jsonResult=new JSONResult();
		
		try {
			customerSerivce.addcon(contacts);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("error");
		}
		
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
	}







/**
 * �б���ʾҳ��
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
	protected void list(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
		List<Customer> list=null;
		
		//��ǰҳ��
		String currPage =request.getParameter("currPage");
		//��ǰҳ��С
		String sizeStr =request.getParameter("size");
		
		Map<String, Object>qParams =new HashMap<String, Object>();
		PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
		
		try {
			list =customerSerivce.list(qParams, pageInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list =null;
		}
		
		 //�����԰󶨵�request
		 request.setAttribute("qParams", qParams);
		 request.setAttribute("pageInfo", pageInfo);
		 request.setAttribute("List", list);
		
		request.getRequestDispatcher("/custom/customer_list.jsp").forward(request, response);
		
	}
	
	/**
	 * �����޸ı༭ҳ��
	 * @param request
	 * @param response
	 */
	protected void toedit(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String customerId=request.getParameter("customerId");
		List<User> userList=null;
		Customer customerList=null;
		List<Dictionary> dicList=null;
		String dicjudge="��ҵ���ͻ��ȼ�";
		
		try {
			dicList=customerSerivce.findBydic(dicjudge);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			userList=marketService.findAlladmin();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			customerList=customerSerivce.findByPrimaryKey(customerId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			customerList=null;
		}
		//�����԰󶨵�request
		request.setAttribute("list", customerList);
		request.setAttribute("userList", userList);
		request.setAttribute("dicList", dicList);
		request.getRequestDispatcher("/custom/customer_edit.jsp").forward(request, response);
	}
	
	/**
	 * ����ͻ�����ϸ��Ϣ
	 * @param request
	 * @param response
	 */
	protected void save(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
		String customerId=request.getParameter("customerId");
		String customerName=request.getParameter("customerName");
		String customerArea=request.getParameter("customerArea");
		String customerManager=request.getParameter("customerManager");
		String customerLevel=request.getParameter("customerLevel");
		String customerSat=request.getParameter("customerSat");
		String customerCredit=request.getParameter("customerCredit");
		String address=request.getParameter("address");
		String postalCode=request.getParameter("postalCode");
		String telephone=request.getParameter("telephone");
		String customerFax=request.getParameter("customerFax");
		String website=request.getParameter("website");
		String registerNum=request.getParameter("registerNum");
		String legalPerson=request.getParameter("legalPerson");
		String registerCapital=request.getParameter("registerCapital");
		String turnover=request.getParameter("turnover");
		String openBank=request.getParameter("openBank");
		String bankNum=request.getParameter("bankNum");
		String localTax=request.getParameter("localTax");
		String countryTax=request.getParameter("countryTax");
		
		
		
		Customer customer=new Customer(customerId, customerName, customerArea, 
				customerManager, customerLevel, customerSat, customerCredit, 
				address, postalCode, telephone, customerFax, 
				website, registerNum, legalPerson, registerCapital, 
				turnover, openBank, bankNum, localTax, countryTax);
		
		JSONResult jsonResult=new JSONResult();
		
		try {
			customerSerivce.save(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult.setStatus("error");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
	}
	
	/**
	 * �����½���ϵ�˽���	
	 * @param request
	 * @param response
	 */
	protected void toaddcon(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException   {
			// TODO Auto-generated method stub
		String customerId=request.getParameter("customerId");
		String customerName=request.getParameter("customerName");
		//���û���Ϣ���д洢
		Map<String, Object>info =new HashMap<String, Object>();
		info.put("customerId",customerId);
		info.put("customerName", customerName);
		
		//�����԰󶨵�request
		 request.setAttribute("info", info);
		 request.getRequestDispatcher("/custom/customer_addcon.jsp").forward(request, response);
		}
	
	/**
	 * ������ϵ�˽���
	 * @param request
	 * @param response
	 */


	protected void tocontacts(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException  {
			// TODO Auto-generated method stub
			String customerId=request.getParameter("id");
			String customerName=request.getParameter("name");
			List<Contacts> contacts=null;
			Map<String, Object>info =new HashMap<String, Object>();
			
			info.put("customerId",customerId);
			info.put("customerName", customerName);
			
			try {
				contacts=customerSerivce.contactsList(customerId);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			
			
			//�����԰󶨵�request
			 request.setAttribute("info", info);
			 request.setAttribute("contacts", contacts);
			 
			 request.getRequestDispatcher("/custom/customer_contacts.jsp").forward(request, response);
		
		}


	/**
	 * ɾ���ͻ���ϵ��
	 * @param request
	 * @param response
	 */

	protected void delcon(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException{
			// TODO Auto-generated method stub
			String id=request.getParameter("ids");
			JSONResult jsonResult = new JSONResult();
			try {
				customerSerivce.delcon(id);
			} catch (Exception e) {
				e.printStackTrace();
				jsonResult.setStatus("error");
			}
			
			JSON.writeJSONString(response.getOutputStream(), jsonResult);
		}



	/**
	 * ����༭��ϵ����Ϣ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

protected void toeditcon(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String customerId=request.getParameter("customerId");
		String customerName=request.getParameter("customerName");
		
		//���û���Ϣ���д洢
		Map<String, Object>info =new HashMap<String, Object>();
		info.put("customerId",customerId);
		info.put("customerName", customerName);
				
				
		
		Contacts contacts=null;
		
		try {
			contacts=customerSerivce.toeditcon(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		//�����԰󶨵�request
		 request.setAttribute("info", info);
		 request.setAttribute("List", contacts);
		 
		 request.getRequestDispatcher("/custom/customer_conedit.jsp").forward(request, response);
		
	}


/**
 * ����µ���ʷ������¼	
 * @param request
 * @param response
 */
protected void addassoci(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		// TODO Auto-generated method stub
	String customerId=request.getParameter("customerId");
	String customerName=request.getParameter("customerName");
	String associTime=request.getParameter("associTime");
	String associPlace=request.getParameter("associPlace");
	String associOutline=request.getParameter("associOutline");
	String associDetails=request.getParameter("associDetails");
	String associRemarks=request.getParameter("associRemarks");
	
	Associ associ=new Associ(customerId, customerName, associTime, associPlace, associOutline, associDetails, associRemarks);
	JSONResult jsonResult=new JSONResult();
	
	try {
		customerSerivce.addassoci(associ);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		jsonResult.setStatus("error");
	}
	
	
	response.setContentType("application/json;charset=UTF-8");
	JSON.writeJSONString(response.getOutputStream(), jsonResult);
	
	}


}
