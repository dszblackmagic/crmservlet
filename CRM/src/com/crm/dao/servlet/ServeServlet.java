package com.crm.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Address;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.crm.dao.service.MarketService;
import com.crm.dao.service.ServeService;
import com.crm.model.Customer;
import com.crm.model.Dictionary;
import com.crm.model.Serve;
import com.crm.model.User;
import com.crm.util.JSONResult;
import com.crm.util.PageInfo;
import com.crm.util.PageInfoUtils;
@WebServlet("/serve/*")
public class ServeServlet extends HttpServlet {
	
	ServeService serveService=new ServeService();
	MarketService marketService=new MarketService();
	
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
		
		if("/tocreate".equals(method)){//显示全部信息
			tocreate(request, response);
		}else if("/add".equals(method)){
			add(request,response);
		}else if("/todis".equals(method)){
			todis(request,response);
		}else if("/servedis".equals(method)){
			servedis(request,response);
		}else if("/servedel".equals(method)){
			servedel(request,response);
		}else if("/tohandle".equals(method)){
			tohandle(request,response);
		}else if("/toedit".equals(method)){
			toedit(request,response);
		}else if("/edithandle".equals(method)){
			edithandle(request,response);
		}else if("/tofeedback".equals(method)){
			tofeedback(request,response);
		}else if("/toeditfdb".equals(method)){
			toeditfdb(request,response);
		}else if("/editfdb".equals(method)){
			editfdb(request,response);
		}else if("/tofile".equals(method)){
			tofile(request,response);
		}else if("/todetails".equals(method)){
			todetails(request,response);
		}
		
		
	}
	/**'
	 * 查看归档详情
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void todetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String serveId=request.getParameter("serveId");
		Serve serve=new Serve();
		
		try {
			serve=serveService.findByid(serveId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		//绑定request
		request.setAttribute("list", serve);
		
		
		request.getRequestDispatcher("/ser/serve_details.jsp").forward(request, response);
	}

	/**
	 * 到达服务归档列表界面
	 * @param request
	 * @param response
	 */
	protected void tofile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Serve> list=null;
		
		//当前页码
		String currPage =request.getParameter("currPage");
		//当前页大小
		String sizeStr =request.getParameter("size");
		
		//预留查询条件
		String serveCustomer=request.getParameter("serveCustomer");
				
		String serveOutline=request.getParameter("serveOutline");
				
		String serveType=request.getParameter("serveType");
				
		String serveState=request.getParameter("serveState");
		
		Map<String, Object>qParams =new HashMap<String, Object>();
		qParams.put("serveCustomer", serveCustomer);
		qParams.put("serveOutline", serveOutline);
		qParams.put("serveType", serveType);
		qParams.put("serveState", serveState);
		
		
		PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
		
		
		
		try {
			list =serveService.todis(qParams, pageInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list =null;
		}
		
		 //将属性绑定到request
		 request.setAttribute("qParams", qParams);
		 request.setAttribute("pageInfo", pageInfo);
		 request.setAttribute("List", list);
		 
		 
		
		request.getRequestDispatcher("/ser/serve_file.jsp").forward(request, response);
	}
	/**
	 * 编辑反馈页面
	 * @param request
	 * @param response
	 */
	protected void editfdb(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String serveId=request.getParameter("serveId");
		String serveResult=request.getParameter("serveResult");
		String serveSatisfied=request.getParameter("serveSatisfied");
		
		
		
		
		JSONResult jsonResult=new JSONResult();
		
		try {
			serveService.editfdb(serveId,serveResult,serveSatisfied);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("erro");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
	}
/**
 * 到达服务反馈编辑界面
 * @param request
 * @param response
 */
	protected void toeditfdb(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String serveId=request.getParameter("serveId");
		Serve serve=new Serve();
		
		try {
			serve=serveService.findByid(serveId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		//绑定request
		request.setAttribute("list", serve);
		
		
		request.getRequestDispatcher("/ser/serve_editfdb.jsp").forward(request, response);
	}

	/**
	 * 到达服务反馈列表
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void tofeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Serve> list=null;
		
		//当前页码
		String currPage =request.getParameter("currPage");
		//当前页大小
		String sizeStr =request.getParameter("size");
		
		//预留查询条件
		String serveCustomer=request.getParameter("serveCustomer");
				
		String serveOutline=request.getParameter("serveOutline");
				
		String serveType=request.getParameter("serveType");
				
		String serveState=request.getParameter("serveState");
		
		Map<String, Object>qParams =new HashMap<String, Object>();
		qParams.put("serveCustomer", serveCustomer);
		qParams.put("serveOutline", serveOutline);
		qParams.put("serveType", serveType);
		qParams.put("serveState", serveState);
		
		
		PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
		
		
		
		try {
			list =serveService.todis(qParams, pageInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list =null;
		}
		
		 //将属性绑定到request
		 request.setAttribute("qParams", qParams);
		 request.setAttribute("pageInfo", pageInfo);
		 request.setAttribute("List", list);
		 
		 
		
		request.getRequestDispatcher("/ser/serve_feedback.jsp").forward(request, response);
	}

	/**
	 * 进行处理
	 * @param request
	 * @param response
	 */
	protected void edithandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String serveId=request.getParameter("serveId");
		String serveHandle=request.getParameter("serveHandle");
		String serveHandlepeo=request.getParameter("serveHandlepeo");
		String serveHandletime=request.getParameter("serveHandletime");
		
		Serve serve=new Serve(serveId, serveHandle, serveHandlepeo, serveHandletime);
		
		JSONResult jsonResult=new JSONResult();
		
		try {
			serveService.edithandle(serve);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("erro");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
	}

	/**
	 * 到达处理
	 * @param request
	 * @param response
	 */
	protected void toedit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String serveId=request.getParameter("serveId");
		Serve serve=new Serve();
		
		try {
			serve=serveService.findByid(serveId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		//绑定request
		request.setAttribute("list", serve);
		
		
		request.getRequestDispatcher("/ser/serve_edithandle.jsp").forward(request, response);
	}
/**
 * 到达处理服务界面
 * @param request
 * @param response
 */

	protected void tohandle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Serve> list=null;
		
		//当前页码
		String currPage =request.getParameter("currPage");
		//当前页大小
		String sizeStr =request.getParameter("size");
		
		//预留查询条件
		String serveCustomer=request.getParameter("serveCustomer");
				
		String serveOutline=request.getParameter("serveOutline");
				
		String serveType=request.getParameter("serveType");
				
		String serveState="A";
		
		Map<String, Object>qParams =new HashMap<String, Object>();
		qParams.put("serveCustomer", serveCustomer);
		qParams.put("serveOutline", serveOutline);
		qParams.put("serveType", serveType);
		qParams.put("serveState", serveState);
		
		
		PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
		
		
		
		try {
			list =serveService.todis(qParams, pageInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list =null;
		}
		
		 //将属性绑定到request
		 request.setAttribute("qParams", qParams);
		 request.setAttribute("pageInfo", pageInfo);
		 request.setAttribute("List", list);
		 
		 
		
		request.getRequestDispatcher("/ser/serve_handle.jsp").forward(request, response);
	}


	/**
	 *删除指定的服务
	 * @param request
	 * @param response
	 */
protected void servedel(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
	String serveId=request.getParameter("serveId");
	JSONResult jsonResult=new JSONResult();
	
	try {
		serveService.servedel(serveId);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	response.setContentType("application/json;charset=UTF-8");
	JSON.writeJSONString(response.getOutputStream(), jsonResult);
	}

/**
 * 分配客户经理给指定服务	
 * @param request
 * @param response
 */
protected void servedis(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		String serveId=request.getParameter("serveId");
		String serveDistri=request.getParameter("serveDistri");
		
		JSONResult jsonResult=new JSONResult();
		try {
			
			serveService.servedis(serveId,serveDistri);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
	}


/**
 * 到达服务分配界面	
 * @param request
 * @param response
 * @throws IOException 
 * @throws ServletException 
 */
private void todis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	List<Serve> list=null;
	List<User> userList=null;
	//当前页码
	String currPage =request.getParameter("currPage");
	//当前页大小
	String sizeStr =request.getParameter("size");
	
	//预留查询条件
	String serveCustomer=request.getParameter("serveCustomer");
			
	String serveOutline=request.getParameter("serveOutline");
			
	String serveType=request.getParameter("serveType");
			
	String serveState=request.getParameter("serveState");
	
	Map<String, Object>qParams =new HashMap<String, Object>();
	qParams.put("serveCustomer", serveCustomer);
	qParams.put("serveOutline", serveOutline);
	qParams.put("serveType", serveType);
	qParams.put("serveState", serveState);
	
	
	PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
	try {
		userList=marketService.findAlladmin();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	try {
		list =serveService.todis(qParams, pageInfo);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		list =null;
	}
	
	 //将属性绑定到request
	 request.setAttribute("qParams", qParams);
	 request.setAttribute("pageInfo", pageInfo);
	 request.setAttribute("List", list);
	 request.setAttribute("userList", userList);
	 
	
	request.getRequestDispatcher("/ser/serve_dis.jsp").forward(request, response);
	}



/**
 * 保存新建的服务信息	
 * @param request
 * @param response
 */
	
protected void add(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String serveId=request.getParameter("serveId");
		String serveType=request.getParameter("serveType");
		String serveOutline=request.getParameter("serveOutline");
		String serveCustomer=request.getParameter("serveCustomer");
		String serveState=request.getParameter("serveState");
		String serveRequest=request.getParameter("serveRequest");
		String serveFounder=request.getParameter("serveFounder");
		String serveTime=request.getParameter("serveTime");
		
		Serve serve=new Serve(serveId, serveType, serveOutline, serveCustomer, serveState, serveRequest, serveFounder, serveTime);
	
		JSONResult jsonResult=new JSONResult();
		
		try {
			serveService.add(serve);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("erro");
		}

		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
	}




/**
 * 到达创建服务界面
 * @param request
 * @param response
 */
	protected void tocreate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Dictionary> dicList=null;
		String dicjudge="服务类型";
		
		try {
			dicList=serveService.findBydic(dicjudge);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//绑定属性到request域
		request.setAttribute("dicList", dicList);
		
		 request.getRequestDispatcher("/ser/serve_create.jsp").forward(request, response);
	}

}
