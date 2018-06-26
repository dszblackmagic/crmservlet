<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'customer_contacts.jsp' starting page</title>
    
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
    <div class="panel-head"><strong class="icon-reorder"> 联系人界面</strong></div>
    <div class="form-group" style="float: left;">
		<strong><button class="button border-blue" type="button" onclick="contacts_add('${info.customerId}','${info.customerName}');">新建</button></strong>
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
     		<td style="background-color: rgb(69,148,235);">姓名</td>
     		<td style="background-color: rgb(69,148,235);">性别</td>
     		<td style="background-color: rgb(69,148,235);">职位</td>
     		<td style="background-color: rgb(69,148,235);">办公电话</td>
     		<td style="background-color: rgb(69,148,235);">手机</td>
     		<td style="background-color: rgb(69,148,235);">备注</td>
     		<td colspan="2" style="background-color: rgb(69,148,235);width: 100px">操作</td>
     		</tr>
      			
				<c:forEach var="list" items="${contacts }">
				<tr>
				<input type="hidden" name="contactsId"   value=""/>
				<td>
					${list.contactsName}
				</td>
				<td>
					${list.contactsSex}
				</td>
				<td>
					${list.contactsPosition}
				</td> 
				<td>
					${list.officePhone}
				</td> 
				<td>
					${list.contactsPhone}
				</td> 
				<td>
					${list.contactsRemarks}
				</td> 
			 <td style="width: 100px"><a class="button border-green" style="cursor:pointer;" onclick="contacts_edit('${list.id}','${info.customerId}','${info.customerName}')" >编辑</a></td>
			 <td style="width: 100px"><a class="button border-blue" style="cursor:pointer;" onclick="delete_contacts('${list.id}','${info.customerId}','${info.customerName}')" >删除</a></td>
      			<tr>
      </c:forEach>
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
    //返回客户编辑页面
function contacts_return(customerId){
	window.location.href="${ctx}/customer/toedit?customerId="+customerId;
}

    //到达新建联系人界面
function contacts_add(customerId,customerName){
	window.location.href="${ctx}/customer/toaddcon?customerId="+customerId+"&&customerName="+customerName;
}

    //到达编辑联系人界面
function contacts_edit(id,customerId,customerName){
	window.location.href="${ctx}/customer/toeditcon?customerId="+customerId+"&&customerName="+customerName+"&&id="+id;
}

	//删除单条联系人信息
function delete_contacts(id,customerId,customerName){
	layer.confirm('确认要删除吗？',function(){
		contacts_del(id,customerId,customerName);
	});
}

//联系人信息-删除
function contacts_del(ids,customerId,customerName){
	$.ajax({
		type: 'POST',
		data: {ids:ids},
		url: '${ctx}/customer/delcon',
		dataType: 'json',
		success: function(result){
			if(result.status == 'success'){
				layer.msg('已删除!', {icon:1, time:1000});
				window.setTimeout(function(){
					window.location.href = "${ctx}/customer/tocontacts?id="+customerId+"&&name="+customerName;
				}, 1010);
			} else {
				layer.msg('删除失败!', {icon:6, time:1000});
			}
		}
	});
}
  </script>
</html>
