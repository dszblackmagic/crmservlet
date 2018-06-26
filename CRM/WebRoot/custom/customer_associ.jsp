<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>交往记录</title>
    
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
    <form id="customer-list-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 交往历史列表</strong></div>
    <div class="form-group" style="float: left;">
		<strong><button class="button border-blue" type="button" onclick="associ_add('${info.customerId}','${info.customerName}');">新建</button></strong>
		<strong><button class="button border-red" onclick="contacts_return('${info.customerId}');" type="button">返回</button></strong>
		
		</div>
    
    <table class="table table-hover text-center">
		 	<tr>
		 	<input type="hidden" name="customerId"  value="${info.customerId}"/>
		 	<td style="background-color: rgb(133,209,235);width: 200px">客户编号</td>
		 	<td colspan="3" style="text-align: left;">${info.customerId} </td>
		 	<td style="background-color: rgb(133,209,235);">客户名称</td>
		 	<td colspan="3" style="text-align: left;">${info.customerName}</td>
		 	</tr>      
     		
     		<tr style="height: 50px"></tr>
     		
     		<tr>
     		<td style="background-color: rgb(69,148,235);">时间</td>
     		<td style="background-color: rgb(69,148,235);">地点</td>
     		<td style="background-color: rgb(69,148,235);">概要</td>
     		<td style="background-color: rgb(69,148,235);">详细信息</td>
     		<td style="background-color: rgb(69,148,235);">备注</td>
     		<td colspan="2" style="background-color: rgb(69,148,235);width: 100px">操作</td>
     		</tr>
      			
				<c:forEach var="list" items="${List }">
				<tr>
				<input type="hidden" name="id"   value="${list.id}"/>
				<td>
					${list.associTime}
				</td>
				<td>
					${list.associPlace}
				</td>
				<td>
					${list.associOutline}
				</td> 
				<td>
					${list.associDetails}
				</td> 
				<td>
					${list.associRemarks}
				</td> 
			 <td style="width: 100px"><a class="button border-green" style="cursor:pointer;" onclick="associ_edit('${list.id}','${info.customerId}','${info.customerName}')" >编辑</a></td>
			 <td style="width: 100px"><a class="button border-blue" style="cursor:pointer;" onclick="delete_associ('${list.id}','${info.customerId}','${info.customerName}')" >删除</a></td>
      			<tr>
      </c:forEach>
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
  //返回客户编辑界面
  function contacts_return(customerId){
	window.location.href="${ctx}/customer/toedit?customerId="+customerId;
}
    //到达新建交往记录界面
function associ_add(customerId,customerName){
	window.location.href="${ctx}/customer/toaddass?customerId="+customerId+"&&customerName="+customerName;
}

//到达交往记录编辑界面
function associ_edit(id,customerId,customerName){
	window.location.href="${ctx}/customer/toeditass?customerId="+customerId+"&&customerName="+customerName+"&&id="+id;
}

	//删除单条交往记录
function delete_associ(id,customerId,customerName){
	layer.confirm('确认要删除吗？',function(){
		associ_del(id,customerId,customerName);
	});
}

//交往历史记录-删除
function associ_del(ids,customerId,customerName){
	$.ajax({
		type: 'POST',
		data: {ids:ids},
		url: '${ctx}/customer/delassoci',
		dataType: 'json',
		success: function(result){
			if(result.status == 'success'){
				layer.msg('已删除!', {icon:1, time:1000});
				window.setTimeout(function(){
					window.location.href = "${ctx}/customer/toassoci?customerId="+customerId+"&&customerName="+customerName;
				}, 1010);
			} else {
				layer.msg('删除失败!', {icon:6, time:1000});
			}
		}
	});
}
  </script>
</html>
