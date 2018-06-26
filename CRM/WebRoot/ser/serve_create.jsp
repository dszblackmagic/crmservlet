<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
    <form id="serve-add-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 服务创建</strong></div>
    <div class="form-group" style="float: left;">
		<strong><button class="button border-blue" type="button" onclick="serve_add(); return false">保存</button></strong>
		
		
		</div>
    
    <table class="table table-hover text-center">
		 	<tr>
		 	
		 	<td style="background-color: rgb(133,209,235);width: 200px">编号</td>
		 	<td style="text-align: left;"><input type="text" id="serveId" name="serveId" style="cursor: pointer;" readonly="readonly" ></td>
		 	<td style="background-color: rgb(133,209,235);">服务类型</td>
		 	<td style="text-align: left;">
		 	<select style="width: 200px" name="serveType">
		 	<c:forEach var="dic" items="${dicList}">
		 	<option value="${dic.dictionValue}">${dic.dictionEntry}</option>
		 	</c:forEach>
		 	</select>
		 	 </td>
		 	</tr>      
     		<tr>
     		<td style="background-color: rgb(133,209,235);">概要</td>
     		<td colspan="3" style="text-align: left;"><input style="width: 60%" type="text" id="serveOutline" name="serveOutline"><label style="color: red;">* </label></td>
     		
     		</tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">客户</td>
     		<td style="text-align: left;"><input type="text" id="serveCustomer" name="serveCustomer"><label style="color: red;">* </label></td>
     		<td style="background-color: rgb(133,209,235);">状态</td>
     		<td style="text-align: left;">新创建</td>
     		</tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">服务请求</td>
     		<td colspan="3" style="text-align: left;"><textarea style="width: 50%;height: 150px" type="text" id="serveRequest" name="serveRequest"></textarea><label style="color: red;">* </label></td>
     		</tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">创建人</td>
     		<td style="text-align: left;"><input type="text" id="serveFounder" name="serveFounder" value=<%=(String)session.getAttribute("userName") %>><label style="color: red;">* </label></td>
     		<td style="background-color: rgb(133,209,235);">创建时间</td>
     		<td style="text-align: left;"><input type="text" id="serveTime" name="serveTime"></td>
     		</tr>
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
  //自动生成编号和日期JS
  	function uuid() {
			var s = [];
			var hexDigits = "0123456789";
			for (var i = 0; i < 36; i++) {
				s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
			}
			s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
			s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
			
	
			var uuid = s.join("");
			document.getElementById('serveId').value = uuid;
	
		}
		window.onload = uuid;
	
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
	
		document.getElementById("serveTime").value = today();
		
		
	//保存当前创建的服务
function serve_add() {
	
	var serveOutline=document.getElementById("serveOutline").value;
	var serveRequest=document.getElementById("serveRequest").value;
	var serveCustomer=document.getElementById("serveCustomer").value;
	var serveFounder=document.getElementById("serveFounder").value;
	
	if(serveOutline==""||serveRequest==""||serveCustomer==""||serveFounder==""){
	alert("必选项不能为空")
	}else{
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/serve/add",
		type : "POST",
		async : false,
		data : $('#serve-add-fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('保存成功!', {
					icon : 1,
					time : 1000
				});
				window.setTimeout(function() {
					window.location.href = '${ctx}/serve/tocreate';
				}, 1010);
			} else {
				layer.msg('保存失败!', {
					icon : 5,
					time : 1000
				});
			}
		}
	});
	}
	}
  </script>
</html>
