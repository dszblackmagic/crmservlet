<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'plan_exec.jsp' starting page</title>
    
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
			<strong><span class="icon-pencil-square-o"></span>执行中的销售计划</strong>
		</div>
		<form class="form-x" id="plan_exec_fm">
		<div class="form-group" style="float: left;">
		<strong><button class="button border-red" type="button" onclick="stop_plan();return false">终止计划</button>
		</strong> <strong><button class="button border-red" onclick="plan_return();" type="button">返回</button></strong>
		<strong><button class="button border-blue" type="button" onclick="plan_todevelop('${market.numberId}');return false">制定计划</button>
		<strong><button class="button border-green" type="button" onclick="success_plan();return false">开发成功</button>
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
		 	<td colspan="2"><input type="text" style="width: 80%" value="${plist.planEffect}"  name="${plist.id }plancontext" id="${plist.id }plancontext"/>
		 	<button  type="button" onclick="execupdate_plan('${plist.numberId}','${plist.id }')" >保存</button>
		 	</td>
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

//到达指定计划页面
function plan_todevelop(numberId){
	window.location.href="${ctx}/plan/todevelop?numberId="+numberId;
}

//提交更新同时刷新本页面
	function execupdate_plan(id,num) {
	var data=document.getElementById(num+"plancontext").value;
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/plan/execupdate?key="+num+"&&data="+data,
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
					window.location.href = '${ctx}/plan/toexec?numberId='+id;
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
	
	
//终止开发
	function stop_plan() {
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/plan/stop ",
		type : "POST",
		async : false,
		data : $('#plan_exec_fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('终止成功!', {
					icon : 1,
					time : 1000
				});
				//window.location.href = '${ctx}/plan/todevelop';
				window.setTimeout(function() {
					window.location.href = '${ctx}/plan/plist'
				}, 1010);
			} else {
				layer.msg('终止失败!', {
					icon : 5,
					time : 1000
				});
			}
		}
	});
	}

//成功开发
	
	function success_plan() {
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/plan/success ",
		type : "POST",
		async : false,
		data : $('#plan_exec_fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('成功开发!', {
					icon : 1,
					time : 1000
				});
				//window.location.href = '${ctx}/plan/todevelop';
				window.setTimeout(function() {
					window.location.href = '${ctx}/plan/plist'
				}, 1010);
			} else {
				layer.msg('系统出现错误!', {
					icon : 5,
					time : 1000
				});
			}
		}
	});
	}
	
  </script>
</html>
