<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="_meta.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   

  </head>
  
  <body>
    <%
    	String userName=null;
    	userName=(String)session.getAttribute("userName");
    	if(userName==null){
    	out.print("<script>alert('您还没有登录，请登录...'); window.document.location.href='../mainframe/login.jsp' </script>");
    	}
     %>
  </body>
</html>
