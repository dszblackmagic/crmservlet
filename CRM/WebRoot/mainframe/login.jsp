<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户关系管理系统登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/login.css" type="text/css" rel="stylesheet">
	<script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
    
    
	<!-- 
	验证码功能
	-->
	<!-- <script language="javascript">
		function loadimage() {
		document.getElementById("randImage").src = "image.jsp?" + Math.random();
			}
		</script> -->
	
	
  </head>
  
  <body>
   
<div class="login">
    <div class="message">客户关系管理系统</div>
    <div id="darkbannerwrap"></div>
    
    <form method="post" action="Login">
		<input name="action" value="login" type="hidden">
		<input name="username" placeholder="用户名" required="" type="text">
		<hr class="hr15">
		<input name="password" placeholder="密码" required="" type="password">
		<hr class="hr15">
		<!-- <input type="text" placeholder="验证码" required="" name="inputRand" style="width: 180px;"/>
		<img onclick="loadimage()" name="randImage" style="vertical-align: middle;" id="randImage"src="login/image.jsp" width="140" height="50" border="0">
		<hr class="hr15">
		<select name="type" style=" width: auto;">
		<option  value="admin" >教师</option>
		<option  value="user">学生</option>
		</select> -->
		
		<hr class="hr15">
		<input value="登录" style="width:100%;" type="submit">
		<hr class="hr20">
		 <a onClick="alert('请联系管理员')">忘记密码</a> 
	</form>

	
</div>

<div class="copyright">©  by DDDeng</div>
  </body>
</html>
