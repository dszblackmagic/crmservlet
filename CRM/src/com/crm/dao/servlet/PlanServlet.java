package com.crm.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Executable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;

import com.alibaba.fastjson.JSON;
import com.crm.dao.service.MarketService;
import com.crm.dao.service.PlanSerivce;
import com.crm.model.Market;
import com.crm.model.Plan;
import com.crm.util.JSONResult;
import com.crm.util.PageInfo;
import com.crm.util.PageInfoUtils;

@WebServlet("/plan/*")
public class PlanServlet extends HttpServlet {
	
	private PlanSerivce planSerivce=new PlanSerivce();
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
		//获取所需要的执行状态
		if("/plist".equals(method)){//显示全部信息
			plist(request, response);
		}else if("/todevelop".equals(method)){
			todevelop(request,response);
		}else if("/save".equals(method)){
			save(request, response);
		}else if("/update".equals(method)){
			update(request, response);
		}else if("/delete".equals(method)){
			delete(request,response);
		}else if("/exec".equals(method)){
			exec(request,response);
		}else if("/toexec".equals(method)){//到达执行计划页面
			toexec(request,response);
		}else if("/execupdate".equals(method)){
			execupdate(request,response);
		}else if("/stop".equals(method)){
			stop(request,response);
		}else if("/success".equals(method)){
			success(request,response);
		}else if("/todisplay".equals(method)){
			todisplay(request,response);
		}
		
	}







/**
 * 
 * 到达执行计划页面
 */
protected void toexec(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		String id=request.getParameter("numberId");
		List<Plan> planList=null;
		Market market=new Market();
		//获取指定营销机会的信息
		try {
			
			market=marketService.findByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		try {
			planList=planSerivce.findByPrimarykey(id);
		} catch (Exception e) {
			e.printStackTrace();
			planList =null;
		}
		
		
		//将获取的结果绑定到request域上面
		request.setAttribute("market", market);
		request.setAttribute("planList", planList);
	
		request.getRequestDispatcher("/marplan/plan_execdevlop.jsp").forward(request, response);
	}



/**
 * 
 * 显示所有已指派的营销机会
 */
	protected void plist(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		
		//判断是否是客户经理使用本功能

		
		List<Market> mplanList=null;
		
		
		//判断是否已经分配的条件
		String judge="Y";
		
		Map<String, Object>qParams =new HashMap<String, Object>();
		qParams.put("judge", judge);
		//当前页码
		String currPage =request.getParameter("currPage");
		//当前页大小
		String sizeStr =request.getParameter("size");
		
		PageInfo pageInfo= PageInfoUtils.calculatePageInfo(currPage, sizeStr);
		

		 try {
			 mplanList =planSerivce.list(qParams, pageInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mplanList =null;
		}
		 
		 //将属性绑定到request
		 request.setAttribute("qParams", qParams);
		 request.setAttribute("pageInfo", pageInfo);
		 request.setAttribute("List", mplanList);
		
		request.getRequestDispatcher("/marplan/plan_list.jsp").forward(request, response);
	}
	
	/**
	 * 到达制定计划页面
	 */
	protected void todevelop(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		
		String id=request.getParameter("numberId");
		
		
		
		List<Plan> planList=null;
		Market market=new Market();
		
		JSONResult jsonResult=new JSONResult();
		//获取指定营销机会的信息
				try {
					
					market=marketService.findByPrimaryKey(id);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				
				try {
					planList=planSerivce.findByPrimarykey(id);
				} catch (Exception e) {
					e.printStackTrace();
					planList =null;
				}
				
				
		//将获取的结果绑定到request域上面
				request.setAttribute("market", market);
				request.setAttribute("planList", planList);
			
				request.getRequestDispatcher("/marplan/plan_develop.jsp").forward(request, response);
	}
	
	/**
	 * 
	 * 保存刚输入的计划项
	 */
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String id=request.getParameter("numberId");
		String planTime=request.getParameter("planTime");
		String executePlan=request.getParameter("executePlan");
		
		
		
		Plan plan=new Plan();
		//存储获取的plan值
		plan.setPlanTime(planTime);
		plan.setNumberId(id);
		plan.setExecutePlan(executePlan);
		
		
		JSONResult jsonResult=new JSONResult();
		
				
		//保存新的计划项
				
					try {
						planSerivce.savePlan(plan);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						jsonResult.setStatus("error");
					}
				
					response.setContentType("application/json;charset=UTF-8");
					JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
	}
	/**
	 * 
	 * 更新计划项内容
	 * @throws IOException 
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("numberId");
		String plancontext=request.getParameter("data");
		String key=request.getParameter("key");
		
		
		Plan plan=new Plan();
		//存储获取的plan值
				
				plan.setNumberId(id);
				plan.setExecutePlan(plancontext);
				JSONResult jsonResult=new JSONResult();
				
				//更新新的计划项
						
							try {
								planSerivce.updatePlan(plan,key);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								jsonResult.setStatus("error");
							}
						
				response.setContentType("application/json;charset=UTF-8");
				JSON.writeJSONString(response.getOutputStream(), jsonResult);	

	}
	/**
	 * 
	 *删除某条指定的计划
	 * @throws IOException 
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
			// TODO Auto-generated method stub
		String id=request.getParameter("numberId");
		String key=request.getParameter("key");
		JSONResult jsonResult=new JSONResult();
		
		//删除某条计划项
		
		try {
			planSerivce.delete(key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult.setStatus("error");
		}
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);
		
		
		}
	/**
	 * 
	 * 执行制定好的开发计划
	 */
	protected void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			String id=request.getParameter("numberId");
			
			JSONResult jsonResult=new JSONResult();
			//开始执行计划
			
			try {
				planSerivce.exec(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				jsonResult.setStatus("error");
			}
			
			response.setContentType("application/json;charset=UTF-8");
			JSON.writeJSONString(response.getOutputStream(), jsonResult);
			
		}
	
	/**
	 * 
	 * 更新执行效果
	 * @throws IOException 
	 */
	protected void execupdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id=request.getParameter("numberId");
		String planEffect=request.getParameter("data");
		String key=request.getParameter("key");
		
		
		JSONResult jsonResult=new JSONResult();
		
		//更新执行效果
				
					try {
						planSerivce.execupdate(planEffect,key);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						jsonResult.setStatus("error");
					}
				
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);	
			
		}


/**
 * 
 * 终止计划
 */
	protected void stop(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id=request.getParameter("numberId");
		
		JSONResult jsonResult=new JSONResult();
		
			try {
				planSerivce.stop(id);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				jsonResult.setStatus("error");
			}
		
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);	
		
	}
		
/**
 * 
 * 成功开发并且自动创建客户信息
 */

	protected void success(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
				// TODO Auto-generated method stub
		String id=request.getParameter("numberId");
		Market market=new Market();
		
		JSONResult jsonResult=new JSONResult();
			
		
		try {
			market=marketService.findByPrimaryKey(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			planSerivce.success(market);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setStatus("error");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		JSON.writeJSONString(response.getOutputStream(), jsonResult);	
	}
	
	/**
	 * 
	 * 到达查看详情的界面
	 * @throws IOException 
	 * @throws ServletException 
	 */

	protected void todisplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		String id=request.getParameter("numberId");
		List<Plan> planList=null;
		Market market=new Market();
		//获取指定营销机会的信息
		try {
			
			market=marketService.findByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		try {
			planList=planSerivce.findByPrimarykey(id);
		} catch (Exception e) {
			e.printStackTrace();
			planList =null;
		}
		
		
		//将获取的结果绑定到request域上面
		request.setAttribute("market", market);
		request.setAttribute("planList", planList);
	
		request.getRequestDispatcher("/marplan/plan_display.jsp").forward(request, response);
		}

}
