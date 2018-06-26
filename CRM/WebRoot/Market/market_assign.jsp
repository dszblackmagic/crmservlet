<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    
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
			<strong><span class="icon-pencil-square-o"></span>指派销售机会</strong>
		</div>
		<form class="form-x" id="market_assign_fm">
		<div class="form-group" style="float: left;">
		<strong><button class="button border-blue" type="button" onclick="market_assgin();return false">保存</button>
		</strong> <strong><button class="button border-red" onclick="market_cancel();" type="button">取消</button></strong>
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
		 	<tr style="height: 50px"></tr>
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">指派人</td>
		 	
		 	<td style="text-align: left;">
		 	
		 	<select name="distribution" id="distribution"   style="font-size:15px; padding: 0 2%; width: auto;height: 30px">
		 	<c:choose>
		 	<c:when test="${market.distribution eq null}">
		 	<option style="text-align:center;" value="">未指派</option>		 			 	
		 	<c:forEach var="list" items="${userList}">		 	
		 	<option style="text-align:center;" value="${list.userName}">${list.userName}</option>
		 	</c:forEach>
		 	</c:when>
		 	<c:otherwise>
		 	<option style="text-align:center;" value="${market.distribution}">${market.distribution}</option>
		 	<c:forEach var="list" items="${userList}">		 	
		 	<option style="text-align:center;" value="${list.userName}">${list.userName}</option>
		 	</c:forEach>
		 	</c:otherwise>
		 	</c:choose>
		 	</select>  </td>
		 	<td style="background-color: rgb(133,209,235);">指派时间</td>
		 	<td style="text-align: left;"><input type="text" class="input " style="width: 200px;height: 30px" readonly="readonly" id="distime" name="distime" /></td>
		 	</tr>
		 </table>		 	
		 </form>
	</div>  
	</body>
	<script type="text/javascript">
//显示时间
	function today() {
			var today = new Date();
			var h = today.getFullYear();
			var m = today.getMonth() + 1;
			var d = today.getDate();
			var hour = today.getHours();
			var min = today.getMinutes();
			var second = today.getSeconds();
			return h + "-" + m + "-" + d + " " + hour + ":" + min + ":" + second;
		}
	
		document.getElementById("distime").value = today();
//返回list显示
 function market_cancel() {
	window.location.href = '${ctx}/market/list';
}

//提交表单
function market_assgin(){
	
	
	//ajax提交form表单
	$.ajax({
		url: "${ctx}/market/assign",
		type: "POST",
		async: false,
		data: $('#market_assign_fm').serialize(),
		dataType: "json",
		success: function(result){
			if(result.status == 'success'){
				
				layer.msg('指派成功!', {icon:1, time:1000});
				window.setTimeout(function(){
					window.location.href='{ctx}/market/list';
				}, 1010);
			} else {
				layer.msg('指派失败!', {icon:5, time:1000});
			}
		}
	});
}
	</script>
</html>
