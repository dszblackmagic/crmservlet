<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>My JSP 'plan_develop.jsp' starting page</title>
    
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
		<form class="form-x" id="plan_dev_fm">
		<div class="form-group" style="float: left;">
		<strong><button class="button border-blue" type="button" onclick="plan_exec();return false">执行计划</button>
		</strong> <strong><button class="button border-red" onclick="plan_cancel();" type="button">取消</button></strong>
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
		 	<td colspan="3" style="background-color: rgb(69,148,235);">计划项</td>
		 	</tr>
		 	<c:forEach var="plist" items="${planList}">
		 	
		 	<tr>
		 	<td>${plist.planTime}</td>
		 	
		 	<td colspan="3"><input type="text" style="width: 80%" value="${plist.executePlan}"  name="${plist.id }plancontext" id="${plist.id }plancontext"/>
		 	<button  type="button" onclick="update_plan('${plist.numberId}','${plist.id }')" >保存</button>
		 	<button  type="button" onclick="delete_plan('${plist.numberId}','${plist.id }');" >删除</button>
		 	</td>
		 	</tr>
		 	
		 	</c:forEach>
		 	<tr style="height: 50px"></tr>
		 	
		 <tr>
		 <td style="background-color: rgb(133,209,235);width: 10%">日期</td>
		 <td style="width: 15%"><input type="text" readonly="readonly" style="cursor:hand" onclick="new Calendar().show(planTime);" id="planTime" name="planTime"></td>
		 <td style="background-color: rgb(133,209,235);width: 10%">计划项</td>
		 <td ><input type="text" id="executePlan" name="executePlan" style="width: 80%">
		 <button  type="button" onclick="save_plan('${market.numberId}')" style="float: right;">保存</button>
		 </td>
		 </tr>
		 </table>		 	
		 </form>
	</div>  
  </body>
  <script type="text/javascript">
  
  //返回list显示
 function plan_cancel() {
	window.location.href = '${ctx}/plan/plist';
}
//执行计划并且返回list页面
function plan_exec(){
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/plan/exec",
		type : "POST",
		async : false,
		data : $('#plan_dev_fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('执行计划成功!', {
					icon : 1,
					time : 1000
				});
				//window.location.href = '${ctx}/plan/todevelop';
				window.setTimeout(function() {
					window.location.href = "${ctx}/plan/plist";
				}, 1010);
			} else {
				layer.msg('执行计划失败!', {
					icon : 5,
					time : 1000
				});
			}
		}
	});
	}

//提交并且刷新本页面
function save_plan(id) {
	var planTime=document.getElementById("planTime").value;
	var executePlan=document.getElementById('executePlan').value;
	if(planTime=="" || executePlan==""){
	alert("日期和计划项不能为空");
	}else{
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/plan/save",
		type : "POST",
		async : false,
		data : $('#plan_dev_fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('保存成功!', {
					icon : 1,
					time : 1000
				});
				//window.location.href = '${ctx}/plan/todevelop';
				window.setTimeout(function() {
					window.location.href = "${ctx}/plan/todevelop?numberId="+id;
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
	
	
//提交更新同时刷新本页面
	function update_plan(id,num) {
	var data=document.getElementById(num+"plancontext").value;
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/plan/update?key="+num+"&&data="+data,
		type : "POST",
		async : false,
		data : $('#plan_dev_fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('保存成功!', {
					icon : 1,
					time : 1000
				});
				//window.location.href = '${ctx}/plan/todevelop';
				window.setTimeout(function() {
					window.location.href = '${ctx}/plan/todevelop?numberId='+id;
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
	
	
	//删除某条计划同时刷新本页面
	function delete_plan(id,num) {
	var data=document.getElementById(num+"plancontext").value;
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/plan/delete?key="+num,
		type : "POST",
		async : false,
		data : $('#plan_dev_fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('删除成功!', {
					icon : 1,
					time : 1000
				});
				//window.location.href = '${ctx}/plan/todevelop';
				window.setTimeout(function() {
					window.location.href = '${ctx}/plan/todevelop?numberId='+id;
				}, 1010);
			} else {
				layer.msg('删除失败!', {
					icon : 2,
					time : 1000
				});
			}
		}
	});
	}
  </script>
</html>
