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
import com.crm.dao.service.DictionarySerivce;
import com.crm.model.Dictionary;
import com.crm.model.Serve;
import com.crm.model.User;
import com.crm.util.JSONResult;
import com.crm.util.PageInfo;
import com.crm.util.PageInfoUtils;
@WebServlet("/dic/*")
public class DictionaryServlet extends HttpServlet {
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
		
		if("/todiclist".equals(method)){//��ʾȫ����Ϣ
			todiclist(request, response);
		}else if("/toadd".equals(method)){
			toadd(request,response);
		}else if("/add".equals(method)){
			add(request,response);
		}else if("/del".equals(method)){
			del(request,response);
		}else if("/toedit".equals(method)){
			toedit(request,response);
		}else if("/update".equals(method)){
			update(request,response);
		}else if("/touser".equals(method)){
			touser(request,response);
		}else if("/adduser".equals(method)){
			adduser(request,response);
		}else if("/toadduser".equals(method)){
			toadduser(request,response);
		}else if("/edituser".equals(method)){
			edituser(request,response);
		}
	}
	/**
	 * �����û�����
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	protected void edituser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String userType=request.getParameter("userType");
		
		
		
		
		User user=new User(userName, userPassword, userType);
		
		JSONResult jsonResult=new JSONResult();
		try {
			
			dictionarySerivce.edituser(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("erro");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
	}

	/**
	 * ��������û�����
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void toadduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/diction/dictionary_adduser.jsp").forward(request, response);
	}
	/**
	 * ����˻�����
	 * @param request
	 * @param response
	 */
	protected void adduser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String userType=request.getParameter("userType");
		
		
		
		
		User user=new User(userName, userPassword, userType);
		
		JSONResult jsonResult=new JSONResult();
		try {
			
			dictionarySerivce.adduser(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("erro");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
	}

	/**
	 * �����û��������
	 * @param request
	 * @param response
	 */
	protected void touser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		List<User> list=null;
		
		//��ǰҳ��
		String currPage =request.getParameter("currPage");
		//��ǰҳ��С
		String sizeStr =request.getParameter("size");
		
		//Ԥ����ѯ����
		
				
		
		
		Map<String, Object>qParams =new HashMap<String, Object>();
		
		
		
		
		PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
		
		
		
		try {
			list =dictionarySerivce.touser(qParams, pageInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list =null;
		}
		
		 //�����԰󶨵�request
		 request.setAttribute("qParams", qParams);
		 request.setAttribute("pageInfo", pageInfo);
		 request.setAttribute("List", list);
		 
		 
		
		request.getRequestDispatcher("/diction/dictionary_user.jsp").forward(request, response);
	}

	/**
	 * ���������ֵ���Ϣ
	 * @param request
	 * @param response
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dictionId=request.getParameter("dictionId");
		String dictionType=request.getParameter("dictionType");
		String dictionEntry=request.getParameter("dictionEntry");
		String dictionValue=request.getParameter("dictionValue");
		String dictionState=request.getParameter("dictionState");
		
		
		
		Dictionary dictionary=new Dictionary(dictionId, dictionType, dictionEntry, dictionValue, dictionState);
		
		JSONResult jsonResult=new JSONResult();
		try {
			
			dictionarySerivce.update(dictionary);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("erro");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
	}

	/**
	 * ����༭�����ֵ����
	 * @param request
	 * @param response
	 */
	protected void toedit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dictionId=request.getParameter("dictionId");

		Dictionary dictionary=new Dictionary();
		try {
			dictionary=dictionarySerivce.findByid(dictionId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//�����ݵ�request
		
		 request.setAttribute("List", dictionary);
		 
		 
			
		request.getRequestDispatcher("/diction/dictionary_edit.jsp").forward(request, response);
	}
	/**
	 * ɾ��ָ�������ֵ�
	 * @param request
	 * @param response
	 */
	protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		String dictionId=request.getParameter("dictionId");
		
		JSONResult jsonResult=new JSONResult();
		try {
			
			dictionarySerivce.del(dictionId);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("erro");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
	}
	/**
	 * �����½������ֵ�
	 * @param request
	 * @param response
	 */
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dictionId=request.getParameter("dictionId");
		String dictionType=request.getParameter("dictionType");
		String dictionEntry=request.getParameter("dictionEntry");
		String dictionValue=request.getParameter("dictionValue");
		String dictionState=request.getParameter("dictionState");
		
		
		
		Dictionary dictionary=new Dictionary(dictionId, dictionType, dictionEntry, dictionValue, dictionState);
		JSONResult jsonResult=new JSONResult();
		
		try {
			dictionarySerivce.add(dictionary);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("erro");
		}

		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
		
		
	}
	/**
	 * ����ҳ���½��ֵ�
	 * @param request
	 * @param response
	 */
	protected void toadd(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/diction/dictionary_add.jsp").forward(request, response);
	}

	/**
	 * ���������ֵ��б�
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void todiclist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Dictionary> list=null;
		
		//��ǰҳ��
		String currPage =request.getParameter("currPage");
		//��ǰҳ��С
		String sizeStr =request.getParameter("size");
		
		//Ԥ����ѯ����
		String dictionType=request.getParameter("dictionType");
				
		String dictionEntry=request.getParameter("dictionEntry");
				
		String dictionValue=request.getParameter("dictionValue");
				
		
		
		Map<String, Object>qParams =new HashMap<String, Object>();
		qParams.put("dictionType", dictionType);
		qParams.put("dictionEntry", dictionEntry);
		qParams.put("dictionValue", dictionValue);
		
		
		
		PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
		
		
		
		try {
			list =dictionarySerivce.todiclist(qParams, pageInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list =null;
		}
		
		 //�����԰󶨵�request
		 request.setAttribute("qParams", qParams);
		 request.setAttribute("pageInfo", pageInfo);
		 request.setAttribute("List", list);
		 
		 
		
		request.getRequestDispatcher("/diction/dictionary_list.jsp").forward(request, response);
	}

}
