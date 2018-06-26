<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'customer_conedit.jsp' starting page</title>
    
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
    <form id="contacts-update-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 编辑联系人</strong></div>
    <div class="form-group" style="float: left;">
		<strong><button class="button border-blue" type="button" onclick="contacts_update('${info.customerId}','${info.customerName}');return false">保存</button></strong>
		<strong><button class="button border-red" onclick="return_tocontacts('${info.customerId}','${info.customerName}');" type="button">返回</button></strong>
		
		</div>
    
    <table class="table table-hover text-center">
		 	<tr>
		 	<input type="hidden" name="customerId"  value="${info.customerId}"/>
		 	<input type="hidden" name="id"  value="${List.id}"/>
		 	<td style="background-color: rgb(133,209,235);width: 200px">姓名</td>
		 	<td style="text-align: left;"><input type="text" id="contactsName" name="contactsName" value="${List.contactsName}"><label style="color: red;">* </label></td>
		 	<td style="background-color: rgb(133,209,235);">性别</td>
		 	<td style="text-align: left;">
		 	<c:choose>
		 	<c:when test="${List.contactsSex eq '男'}">
		 	<input type="radio" name="contactsSex" value="男" checked="checked">男
		 	<input type="radio" name="contactsSex" value="女">女
		 	<label style="color: red;">* </label>
		 	</c:when>
		 	<c:otherwise>
		 	<input type="radio" name="contactsSex" value="男" >男
		 	<input type="radio" name="contactsSex" value="女" checked="checked">女
		 	<label style="color: red;">* </label>
		 	</c:otherwise>
		 	</c:choose>
		 	 </td>
		 	</tr>   
		 	
		 	   
     		<tr>
     		<td style="background-color: rgb(133,209,235);">职位</td>
     		<td style="text-align: left;"><input type="text" id="contactsPosition" name="contactsPosition" value="${List.contactsPosition}"><label style="color: red;">* </label></td>
     		<td style="background-color: rgb(133,209,235);">办公电话</td>
     		<td style="text-align: left;"><input type="text" id="officePhone" name="officePhone" value="${List.officePhone} "><label style="color: red;">* </label></td>
     		</tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">手机</td>
     		<td style="text-align: left;"><input type="text" name="contactsPhone" value="${List.contactsPhone} "></td>
     		<td style="background-color: rgb(133,209,235);">备注</td>
     		<td style="text-align: left;"><input type="text" name="contactsRemarks"  value="${List.contactsRemarks}"></td>
     		</tr>
     		
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
  //返回联系人界面
function return_tocontacts(id,name){
	window.location.href="${ctx}/customer/tocontacts?id="+id+"&&name="+name;
}
 //更新联系人信息
 function contacts_update(id,name){
 
 
 var contactsName=document.getElementById("contactsName").value;
	var contactsPosition=document.getElementById("contactsPosition").value;
	var officePhone=document.getElementById("officePhone").value;

	if(contactsName=="" || contactsPosition==""||officePhone==""){
	alert("必选项不能为空");
	}else{
	//ajax提交form表单
	$.ajax({
		url: "${ctx}/customer/conupdate",
		type: "POST",
		async: false,
		data: $('#contacts-update-fm').serialize(),
		dataType: "json",
		success: function(result){
		if(result.status == 'success'){
				
				layer.msg('保存成功!', {icon:1, time:1000});
				window.setTimeout(function(){
					window.location.href="{ctx}/customer/tocontacts?id="+id+"&&name="+name;
				}, 1010);
			} else {
				layer.msg('保存失败!', {icon:5, time:1000});
			}
		}
	});
	}

}
  </script>
</html>
