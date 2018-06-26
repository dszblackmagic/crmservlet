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

import com.crm.dao.service.AnalysisSerivce;
import com.crm.model.CountCus;
import com.crm.model.CountSer;
import com.crm.util.PageInfo;
import com.crm.util.PageInfoUtils;
@WebServlet("/analysis/*")
public class AnalysisServlet extends HttpServlet {
	AnalysisSerivce analysisSerivce=new AnalysisSerivce();
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
		
		if("/tocustomer".equals(method)){//显示全部信息
			tocustomer(request, response);
		}else if("/toserve".equals(method)){
			toserve(request,response);
		}
		
	}
	/**
	 * 到达服务分析界面
	 * @param request
	 * @param response
	 */
	protected void toserve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
			List<CountSer> count=null;
		
		//当前页码
				String currPage =request.getParameter("currPage");
				//当前页大小
				String sizeStr =request.getParameter("size");
				
				//预留查询条件
				
				

				Map<String, Object>qParams =new HashMap<String, Object>();
				
				PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
				
				try {
					count =analysisSerivce.toserve(qParams, pageInfo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					count =null;
				}
				
				 //将属性绑定到request
				 request.setAttribute("list", count);
				 
				 request.getRequestDispatcher("/analy/analysis_serve.jsp").forward(request, response);
	}

	/**
	 * 到达客户分析界面
	 * @param request
	 * @param response
	 */
	protected void tocustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		List<CountCus> count=null;
		
		//当前页码
		String currPage =request.getParameter("currPage");
		//当前页大小
		String sizeStr =request.getParameter("size");
		
		//预留查询条件
		
		

		Map<String, Object>qParams =new HashMap<String, Object>();
		
		PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
		
		try {
			count =analysisSerivce.tocustomer(qParams, pageInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			count =null;
		}
		
		 //将属性绑定到request
		 request.setAttribute("list", count);
		 
		 request.getRequestDispatcher("/analy/analysis_customer.jsp").forward(request, response);
		
	}

}
