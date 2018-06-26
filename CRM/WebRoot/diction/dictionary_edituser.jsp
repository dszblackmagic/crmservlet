<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'dictionary_edituser.jsp' starting page</title>
    
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
    <form id="dictionary-edituser-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 数字字典编辑</strong></div>
    <div class="form-group" style="float: left;">
		<strong><button class="button border-blue" type="button" onclick="distionary_edituser();">保存</button></strong>
		<strong><button class="button border-red" type="button" onclick="user_return(); return false">返回</button></strong>
		
		
		</div>
    
    <table class="table table-hover text-center">
		 	<tr>
		 	
		 	<td style="background-color: rgb(133,209,235);width: 200px">用户名</td>
		 	<td style="text-align: left;"><input  type="text" id="userName" name="userName" value="${list.userName}" style="cursor: pointer;width: 200px" ></td>
		 	<td style="background-color: rgb(133,209,235);">用户密码</td>
		 	<td style="text-align: left;">
		 	<input id="userPassword" name="userPassword" value="${list.userPassword}" >
		 	 </td>
		 	</tr>      
     		
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">用户类型</td>
     		<td colspan="2" style="float: left;">
     		<select name="userType" style="width: 200px">
     		<option value="gly" ${list['userType'] eq 'gly' ? 'selected="selected"' : ''}>管理员</option>
     		<option value="khjl" ${list['userType'] eq 'khjl' ? 'selected="selected"' : ''}>客户经理</option>
     		<option value="gg" ${list['userType'] eq 'gg' ? 'selected="selected"' : ''}>高管</option>
     		<option value="xszg" ${list['userType'] eq 'xszg' ? 'selected="selected"' : ''}>销售主管</option>
     		</select></td>
     		</tr>
     		
     		
     		
     		
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
  		//返回用户管理列表
function user_return(){
	window.location.href = '${ctx}/dic/touser';
}

  function distionary_edituser() {
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/dic/edituser",
		type : "POST",
		async : false,
		data : $('#dictionary-edituser-fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('保存成功!', {
					icon : 1,
					time : 1000
				});
				window.setTimeout(function() {
					window.location.href = '${ctx}/dic/touser';
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
  </script>
</html>
