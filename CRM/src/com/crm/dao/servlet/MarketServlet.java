package com.crm.dao.servlet;

import java.util.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.crm.dao.service.MarketService;
import com.crm.model.Market;
import com.crm.model.User;
import com.crm.util.JSONResult;
import com.crm.util.PageInfo;
import com.crm.util.PageInfoUtils;

@WebServlet("/market/*")
public class MarketServlet extends HttpServlet {
	
	private MarketService marketService=new MarketService();
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
		}else if("/toAdd".equals(method)){
			toAdd(request,response);
		}else if("/add".equals(method)){
			add(request,response);
		}else if ("/delete".equals(method)) {
			delete(request,response);
		}else if("/edit".equals(method)){
			edit(request,response);
		}else if ("/update".equals(method)) {
			update(request, response);
		}else if("/toassign".equals(method)){
			toassign(request, response);
		}else if ("/assign".equals(method)) {
			assign(request,response);
		}
	}
	


	/**
	 * ������Ϣ
	 */
	protected void list(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		List<Market> marketlist=null;
		
		//��ǰҳ��
		String currPage =request.getParameter("currPage");
		//��ǰҳ��С
		String sizeStr =request.getParameter("size");
		
		//Ԥ����ѯ����
		String customerName=request.getParameter("customerName");
		
		String outLine=request.getParameter("outLine");
		
		String conTacts=request.getParameter("conTacts");
		
		String judge=request.getParameter("judge");
		
		//�����Ƿ����������ж�
		
		//��ѯ���map
		Map<String, Object>qParams =new HashMap<String, Object>();
		qParams.put("customerName", customerName);
		qParams.put("outLine", outLine);
		qParams.put("conTacts", conTacts);
		qParams.put("judge", judge);
		
		PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
		
		 try {
			marketlist = marketService.list(qParams, pageInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			marketlist =null;
		}
		
		 //�����԰󶨵�request
		 request.setAttribute("qParams", qParams);
		 request.setAttribute("pageInfo", pageInfo);
		 request.setAttribute("marketlist", marketlist);
		
		request.getRequestDispatcher("/Market/market_list.jsp").forward(request, response);
	}
	
	
	/**
	 * �������Ӫ������ҳ��
	 */
	protected void toAdd(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		request.getRequestDispatcher("/Market/market_add.jsp").forward(request, response);
	}
	/**
	 * ���Ӫ��������Ϣ
	 */
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��ȡҳ�����е��ı���Ϣ
		String numberId=request.getParameter("numberId");
		String opporTunity=request.getParameter("opporTunity");
		String customerName=request.getParameter("customerName");
		int probability=Integer.valueOf(request.getParameter("probability")) ;
		String outLine =request.getParameter("outLine");
		String contacts=request.getParameter("contacts");
		String contactPhone=request.getParameter("contactPhone");
		String description=request.getParameter("description");
		String founder=request.getParameter("founder");
		String time=request.getParameter("time");
		//�浽Market����
		Market market=new Market(numberId,opporTunity,customerName,probability,outLine,contacts,contactPhone,description,founder,time,null,null,"N");
		
		JSONResult jsonResult=new JSONResult();
		
		try {
			marketService.create(market);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult.setStatus("error");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
	}
	
	/**
	 *ɾ��Ӫ��������Ϣ
	 */

	protected void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String ids = request.getParameter("ids");
		JSONResult jsonResult = new JSONResult();
		try {
			marketService.deleteBatch(ids);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setStatus("error");
		}
		
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
	}
	
	/**
	 * �޸�Ӫ��������Ϣ
	 */

	protected void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		String id=request.getParameter("id");
		Market market=new Market();
		
		try {
			market=marketService.findByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		//���õ��������Request
		request.setAttribute("market", market);
		request.getRequestDispatcher("/Market/market_edit.jsp").forward(request, response);
		
	}
	/**
	 * ����Ӫ��������Ϣ
	 */
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//��ȡҳ�����е��ı���Ϣ
				String numberId=request.getParameter("numberId");
				String opporTunity=request.getParameter("opporTunity");
				String customerName=request.getParameter("customerName");
				int probability=Integer.valueOf(request.getParameter("probability")) ;
				String outLine =request.getParameter("outLine");
				String contacts=request.getParameter("contacts");
				String contactPhone=request.getParameter("contactPhone");
				String description=request.getParameter("description");
				String founder=request.getParameter("founder");
				String time=request.getParameter("time");
				//�浽Market����(�����£�ָ���ˣ�ָ��ʱ�䣬ָ��״̬����
				Market market=new Market(numberId,opporTunity,customerName,probability,outLine,contacts,contactPhone,description,founder,time);
				JSONResult jsonResult=new JSONResult();
				
				try {
					marketService.update(market);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					jsonResult.setStatus("error");
				}
				
				response.setContentType("application/json;charset=UTF-8");
				JSON.writeJSONString(response.getOutputStream(), jsonResult);
	}
	
	/**
	 * ����ָ�ɽ���
	 */
	
	protected void toassign(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		List<User> userList=null;
		String id=request.getParameter("numberId");
		Market market=new Market();
		//��ȡ�û���Ϣ
		try {
			userList=marketService.findAlladmin();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//��ȡָ��Ӫ���������Ϣ
		try {
			
			market=marketService.findByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		//����󶨵�request����
		request.setAttribute("userList", userList);
		request.setAttribute("market", market);
		
		request.getRequestDispatcher("/Market/market_assign.jsp").forward(request, response);
	}
	/**
	 * ָ��Ӫ������
	 * @throws SQLException 
	 */
	
	protected void assign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//��ȡ�ı���Ϣ
		String distribution=request.getParameter("distribution");
		String distime=request.getParameter("distime");
		String numberId=request.getParameter("numberId");
		
		JSONResult jsonResult=new JSONResult();
		//ִ�и���ָ��
		try {
			marketService.assign(distribution,distime,numberId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("error");
		}
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
	}
	
}
