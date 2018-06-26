<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'customer_editassoci.jsp' starting page</title>
    
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
    <form id="associ-update-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 编辑交往记录界面</strong></div>
    <div class="form-group" style="float: left;">
		<strong><button class="button border-blue" type="button" onclick="associ_update('${info.customerId}','${info.customerName}');return false">保存</button></strong>
		<strong><button class="button border-red" onclick="return_toassoci('${info.customerId}','${info.customerName}');" type="button">返回</button></strong>
		
		</div>
    
    <table class="table table-hover text-center">
		 	<tr>
		 	<input type="hidden" name="id"  value="${List.id}"/>
		 	
		 	<td style="background-color: rgb(133,209,235);width: 200px">时间</td>
		 	<td style="text-align: left;"><input type="text" id="associTime" name="associTime" value="${List.associTime}" style="cursor: pointer;" readonly="readonly" onclick="new Calendar().show(associTime);"><label style="color: red;">* </label></td>
		 	<td style="background-color: rgb(133,209,235);">地点</td>
		 	<td style="text-align: left;"><input type="text" id="associPlace" name="associPlace" value="${List.associPlace}">
		 	<label style="color: red;">* </label>
		 	 </td>
		 	</tr>      
     		<tr>
     		<td style="background-color: rgb(133,209,235);">概要</td>
     		<td style="text-align: left;"><input type="text" id="associOutline" name="associOutline" value="${List.associOutline}"></td>
     		<td style="background-color: rgb(133,209,235);">备注</td>
     		<td style="text-align: left;"><input type="text" name="associRemarks" value="${List.associRemarks}"><label style="color: red;">* </label></td>
     		</tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">详细信息</td>
     		<td colspan="3" style="text-align: left;"><textarea style="width: 50%;height: 150px" type="text" name="associDetails" >${List.associDetails}</textarea></td>
     		</tr>
     		
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
  //返回交往记录界面
function return_toassoci(id,name){
	window.location.href="${ctx}/customer/toassoci?customerId="+id+"&&customerName="+name;
}

//更新历史交往记录
 function associ_update(id,name){
 var associTime=document.getElementById("associTime").value;
	var associPlace=document.getElementById("associPlace").value;
	var associOutline=document.getElementById("associOutline").value;
	
	if(associTime==""||associPlace==""||associOutline==""){
	alert("必选项不能为空")
	}else{
	//ajax提交form表单
	$.ajax({
		url: "${ctx}/customer/updateassoci",
		type: "POST",
		async: false,
		data: $('#associ-update-fm').serialize(),
		dataType: "json",
		success: function(result){
		if(result.status == 'success'){
				
				layer.msg('保存成功!', {icon:1, time:1000});
				window.setTimeout(function(){
					window.location.href="${ctx}/customer/toassoci?customerId="+id+"&&customerName="+name;
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
