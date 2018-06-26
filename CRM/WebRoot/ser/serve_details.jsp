<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'serve_details.jsp' starting page</title>
    
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
   <div class="panel admin-panel">
    <form id="serve-details-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 服务反馈</strong></div>
    <div class="form-group" style="float: left;">
		
		<strong><button class="button border-red" onclick="serve_return();" type="button">返回</button></strong>
		
		</div>
    
    <table class="table table-hover text-center">
		 	<tr>
		 	<input type="hidden" name="serveId" value="${list.serveId}">
		 	<td style="background-color: rgb(133,209,235);width: 200px">编号</td>
		 	<td style="text-align: left;">${list.serveId}</td>
		 	<td style="background-color: rgb(133,209,235);">服务类型</td>
		 	<td style="text-align: left;">${list.serveType}</td>
		 	</tr>      
     		<tr>
     		<td style="background-color: rgb(133,209,235);">概要</td>
     		<td colspan="3" style="text-align: left;">${list.serveOutline}</td>
     		
     		</tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">客户</td>
     		<td style="text-align: left;">${list.serveCustomer}</td>
     		<td style="background-color: rgb(133,209,235);">状态</td>
     		<td style="text-align: left;">已处理</td>
     		</tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">服务请求</td>
     		<td colspan="3" style="text-align: left;">${list.serveRequest}</td>
     		</tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">创建人</td>
     		<td style="text-align: left;">${list.serveFounder}</td>
     		<td style="background-color: rgb(133,209,235);">创建时间</td>
     		<td style="text-align: left;">${list.serveTime}</td>
     		</tr>
     		<tr style="height: 30px"></tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">分配人</td>
     		<td style="text-align: left;">${list.serveDistri}</td>
     		<td style="background-color: rgb(133,209,235);">分配时间</td>
     		<td style="text-align: left;">${list.serveDistritime}</td>
     		</tr>
     		
     		<tr style="height: 30px"></tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">服务处理</td>
     		<td colspan="3" style="text-align: left;">${list.serveHandle} </td>
     		</tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">处理人</td>
     		<td style="text-align: left;">${list.serveHandlepeo}</td>
     		<td style="background-color: rgb(133,209,235);">处理时间</td>
     		<td style="text-align: left;">${list.serveHandletime}</td>
     		</tr>
     		
     		<tr style="height: 30px"></tr>
     		<tr>
     		<td style="background-color: rgb(133,209,235);">处理结果</td>
     		<td style="text-align: left;">${list.serveResult} </td>
     		<td style="background-color: rgb(133,209,235);">满意度</td>
     	
     		<c:choose>
     		<c:when test="${list.serveSatisfied eq '3'}">
				<td style="text-align: left;" >	☆☆☆	</td>
				</c:when>
				<c:when test="${list.serveSatisfied eq '4'}">
				<td style="text-align: left;" >	☆☆☆☆	</td>
				</c:when>
				<c:when test="${list.serveSatisfied eq '5'}">
				<td style="text-align: left;" >	☆☆☆☆☆	</td>
				</c:when>
     		
     		</c:choose>
     		
     		</tr>
     		
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
    //返回列表
function serve_return(){
	window.location.href='{ctx}/serve/tofile';
}
  </script>
</html>
