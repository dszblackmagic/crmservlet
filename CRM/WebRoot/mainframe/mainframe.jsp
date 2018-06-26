<%@page import="com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleIfStatement.ElseIf"%>
<%@ page language="java" import="java.util.*,com.crm.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../_meta.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户关系管理系统</title>     
</head>
<body style="background-color:#f2f9fd;">


<%

	String type=(String)session.getAttribute("userType");
	if(type.equals("gg"))
	type="高管";
	else if(type.equals("xszg"))
	type="销售主管";
	else if(type.equals("khjl"))
	type="客户经理";
	else if(type.equals("gly"))
	type="管理员"; 
 %>
	
	



<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />客户关系管理系统</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="${ctx}/index" target=""  > <span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>客户关系管理系统</strong></div>
  <h2><span class="icon-user"></span>营销管理</h2>
  <ul style="display:block">
    <li><a href="welcomadmin.jsp" target="right"><span class="icon-caret-right"></span>欢迎主页</a></li>
    <li><a href="${ctx}/market/list" target="right"><span class="icon-caret-right"></span>销售机会管理</a></li>
    <li><a href="${ctx}/plan/plist" target="right"><span class="icon-caret-right"></span>客户开发计划</a></li>  
    
  </ul>   
  <h2><span class="icon-user"></span>客户管理</h2>
  <ul>
    <li><a href="${ctx}/customer/list" target="right"><span class="icon-caret-right"></span>客户信息管理</a></li>
    <li><a href="javascript:void(null)" target="right"><span class="icon-caret-right"></span>客户流失管理</a></li>
    <!--<li><a href="cate.html" target="right"><span class="icon-caret-right"></span>分类管理</a></li>        
  --></ul>  
  
  <h2><span class="icon-user"></span>服务管理</h2>
  <ul>
     <li><a href="${ctx}/serve/tocreate" target="right"><span class="icon-caret-right"></span>服务创建</a></li> 
     <li><a href="${ctx}/serve/todis" target="right"><span class="icon-caret-right"></span>服务分配</a></li> 
     <li><a href="${ctx}/serve/tohandle" target="right"><span class="icon-caret-right"></span>服务处理</a></li>  
     <li><a href="${ctx}/serve/tofeedback" target="right"><span class="icon-caret-right"></span>服务反馈</a></li>
     <li><a href="${ctx}/serve/tofile" target="right"><span class="icon-caret-right"></span>服务归档</a></li>
  </ul>  
  
   <h2><span class="icon-user"></span>统计报表</h2>
  <ul>
      <li><a href="javascript:void(null)" target="right"><span class="icon-caret-right"></span>客户贡献分析</a></li>
      <li><a href="${ctx}/analysis/tocustomer" target="right"><span class="icon-caret-right"></span>客户构成分析</a></li>
      <li><a href="${ctx}/analysis/toserve" target="right"><span class="icon-caret-right"></span>客户服务分析</a></li>
      <li><a href="javascript:void(null)" target="right"><span class="icon-caret-right"></span>客户流失分析</a></li>
  </ul>  
   <h2><span class="icon-user"></span>基础数据</h2>
  <ul>
       <li><a href="${ctx}/dic/todiclist" target="right"><span class="icon-caret-right"></span>数据字典管理</a></li> 
       <li><a href="${ctx}/dic/touser" target="right"><span class="icon-caret-right"></span>用户账户管理</a></li>
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
	      $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
  
  
});


</script>
<ul class="bread">
  <li><a href="../welcomadmin.jsp" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前用户：<%=(String)session.getAttribute("userName") %></b><span style="color:black;"></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户类型：<%=type %><a href="##" style="color: red"></li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="welcomadmin.jsp" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>
