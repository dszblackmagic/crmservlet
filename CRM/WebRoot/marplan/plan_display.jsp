<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <div class="panel admin-panel margin-top">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>查看详情</strong>
		</div>
		<form class="form-x" id="plan_exec_fm">
		<div class="form-group" style="float: left;">
		
		 <strong><button class="button border-red" onclick="plan_return();" type="button">返回</button></strong>
		
		</div>
		 <table class="table table-hover text-center">
		 	<tr>
		 	<input type="hidden" name="numberId"  value="${market.numberId}"/>
		 	<td style="background-color: rgb(133,209,235);">编号</td>
		 	<td style="text-align: left;">${market.numberId}</td>
		 	<td style="background-color: rgb(133,209,235);">机会来源</td>
		 	<td style="text-align: left;">${market.opporTunity}</td>
		 	</tr>
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">客户名称</td>
		 	<td style="text-align: left;">${market.customerName}</td>
		 	<td style="background-color: rgb(133,209,235);">成功机率(%)</td>
		 	<td style="text-align: left;">${market.probability}</td>
		 	</tr>
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">概要</td>
		 	
		 	<td colspan="3" style="text-align: left;">${market.outLine}</td>
		 	
		 	</tr>
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">联系人</td>
		 	<td style="text-align: left;">${market.contacts}</td>
		 	<td style="background-color: rgb(133,209,235);">联系人电话</td>
		 	<td style="text-align: left;">${market.contactPhone}</td>
		 	</tr>
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">机会描述</td>
		 	
		 	<td colspan="3" style="text-align: left;">${market.description}</td>
		 	
		 	</tr>
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">创建人</td>
		 	<td style="text-align: left;">${market.founder}</td>
		 	<td style="background-color: rgb(133,209,235);">创建时间</td>
		 	<td style="text-align: left;">${market.time}</td>
		 	</tr>
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">指派人</td>
		 	
		 	<td style="text-align: left;">${market.distribution}</td>
		 	<td style="background-color: rgb(133,209,235);">指派时间</td>
		 	<td style="text-align: left;">${market.distime}</td>
		 	</tr>
		 	<tr style="height: 50px"></tr>
		 	
		 	
		 	<tr>
		 	<td style="background-color: rgb(69,148,235);">日期</td>
		 	<td colspan="1" style="background-color: rgb(69,148,235);">计划</td>
		 	<td colspan="2" style="background-color: rgb(69,148,235);">执行效果</td>
		 	</tr>
		 	<c:forEach var="plist" items="${planList}">
		 	
		 	<tr>
		 	<td>${plist.planTime}</td>
		 	
		 	<td colspan="1">${plist.executePlan}</td>
		 	<td colspan="2">${plist.planEffect}</td>
		 	</tr>
		 	
		 	</c:forEach>
		
		 	
		
		 </table>		 	
		 </form>
	</div>  
  </body>
  <script type="text/javascript">
   //返回list显示
 function plan_return() {
	window.location.href = '${ctx}/plan/plist';
}
</script>
</html>
