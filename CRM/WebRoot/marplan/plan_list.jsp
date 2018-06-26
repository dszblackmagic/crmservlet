<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
   
   <%
   	String userType=(String)request.getSession().getAttribute("userType");
   	String err="请使用客户经理登陆此功能";
   	if(!userType.equals("khjl")){
   	%>
   	<script type="text/javascript" language="javascript">
	alert("<%=err%>");                                            // 弹出错误信息
	window.location.href='../welcomadmin.jsp' ;                           		 // 跳转到欢迎
	</script>
   	<% 
   	}
    %>
    
    <title>My JSP 'plan_list.jsp' starting page</title>
    
	

  </head>
  
  <body>
   <div class="panel admin-panel">
    <form id="plan-list-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 客户开发计划</strong></div>
    
    
    <table class="table table-hover text-center">
    
      <tr>
      	
        <th width="120">编号</th>
        <th>客户名称</th>       
        <th>概要</th>
        <th>联系人</th>
        <th>联系电话</th>
        <th>创建时间</th>
        
        <th colspan="3" width="21%">操作</th>       
      </tr>      
      <!--对营销机会信息进行循环输出 -->  
      			<c:forEach var="list" items="${List}">
				<tr>
				<input type="hidden" name="numberId"   value="${list.numberId }"/>
				<td>
					${list.numberId }
				</td>
				<td>
					${list.customerName }
				</td>
				<td>
					${list.outLine }
				</td>
				<td>
					${list.contacts }
				</td>
				<td>
					${list.contactPhone }
				</td>
				<td>
					${list.distime }
				</td>
				<c:choose>
					<c:when test="${list.development eq 'N'}">
				<td >			
					<a class="button border-green" style="cursor:pointer;" onclick="plan_todevelop('${list.numberId }')">待计划</a>	
				</td>
				<td>
					<a class="button border-red" style="cursor:pointer;" onclick="stop_plan()">终止计划</a>	
				</td>
				</c:when>
				<c:when test="${list.development eq 'S'}">
				<td >	
				<a class="button border-red" style="cursor:pointer;" onclick="plan_todisplay('${list.numberId }')" >计划已终止</a>			
					
				</td>
				
				</c:when>
				<c:when test="${list.development eq 'YY'}">
				<td >			
					<a class="button border-green" style="cursor:pointer;" onclick="plan_todisplay('${list.numberId }')">开发成功</a>	
				</td>
				
				</c:when>
				<c:otherwise>
				<td >			
					<a class="button border-blue" style="cursor:pointer;" onclick="plan_toexec('${list.numberId }')">执行中</a>	
				</td>
				<td>
					<a class="button border-red" style="cursor:pointer;" onclick="stop_plan()" >终止计划</a>	
				</td>
				</c:otherwise>
				</c:choose>
				
				
				
			</tr>
			</c:forEach>
			
      <tr>
        <td  colspan="11">
       				  <a class="button" style="cursor: pointer;" onclick="plan_list(${pageInfo.currPage}-1)">上一页</a>
     				 &nbsp;&nbsp; 第&nbsp;&nbsp;${pageInfo.currPage}&nbsp;&nbsp;页&nbsp;&nbsp; 	
					 <a  class="button" style="cursor: pointer;" onclick="plan_list(${pageInfo.currPage}+1)">下一页</a>
					&nbsp;&nbsp; 共&nbsp;&nbsp;${pageInfo.total}&nbsp;&nbsp;条记录 &nbsp;&nbsp; 
			
        </td>
      </tr>
      		
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
  
  //翻页
  function plan_list(currPage){
	$('#currPage').val(currPage);
	$('#plan-list-fm').submit();
}

//到达指定计划页面
function plan_todevelop(numberId){
	window.location.href="${ctx}/plan/todevelop?numberId="+numberId;
}

//到达执行计划页面
function plan_toexec(numberId){
	window.location.href="${ctx}/plan/toexec?numberId="+numberId;
}

//到达查看详情页面
function plan_todisplay(numberId){
	window.location.href="${ctx}/plan/todisplay?numberId="+numberId;
}

//终止开发
	function stop_plan() {
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/plan/stop ",
		type : "POST",
		async : false,
		data : $('#plan-list-fm').serialize(),
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
  </script>
</html>
