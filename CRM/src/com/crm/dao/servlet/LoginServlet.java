package com.crm.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.dao.service.LoginSerivce;
import com.crm.model.User;
@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {
	LoginSerivce loginSerivce=new LoginSerivce();
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
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		User user =null;
		
		
		
		try {
			user=loginSerivce.check(name,password);

		} catch (Exception e) {

		}
		
		if(user!=null){
		 //将属性绑定到session
			
		 request.getSession().setAttribute("userName", user.getUserName());
		 request.getSession().setAttribute("userPassword", user.getUserPassword());
		 request.getSession().setAttribute("userType", user.getUserType());
		
		 
		 request.getRequestDispatcher("mainframe/mainframe.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("mainframe/login.jsp").forward(request, response);
		}
		
	}
	
	
}
