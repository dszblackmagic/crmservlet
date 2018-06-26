<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'dictionary_user.jsp' starting page</title>
    
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
    <form id="diction-user-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder">账户信息管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li> 
        <button type="button"  class="button border-blue"  onclick="user_toadd();return false;" ><span class="icon-check"></span> 添加</button>
        </li>
      </ul>
    </div>
    
    <table class="table table-hover text-center">
    
      <tr>
      	
        <th width="120">用户名</th>
        <th>用户密码</th>       
        <th>用户类型</th>
       	
        
       
        <th colspan="2" width="21%">操作</th>       
      </tr>  
          
      <!--对营销机会信息进行循环输出 -->  
      			<c:forEach var="list" items="${List}">
				<tr>
				<input type="hidden" name="userName" value="${list.userName}">
				<td>
					${list.userName}
				</td>
				<td>
					${list.userPassword}
				</td>
				
				
				<c:choose>
				<c:when test="${list.userType eq 'gly'}">
				<td>管理员</td>
				</c:when>
				<c:when test="${list.userType eq 'khjl'}">
				<td>客户经理</td>
				</c:when>
				<c:when test="${list.userType eq 'gg'}">
				<td>高管</td>
				</c:when>
				<c:when test="${list.userType eq 'xszg'}">
				<td>销售主管</td>
				</c:when>
				</c:choose>
				
				<td >			
					<a class="button border-blue" style="cursor:pointer;" onclick="diction_toedit()">编辑</a>	
				</td>
				<td>
					<a class="button border-blue" onclick="dictionary_del()" href="#">删除</a>	
				</td>
				
				
			</tr>
			
				
			</c:forEach> 
			
      	<tr>
        <td  colspan="11">
       				 <a class="button" style="cursor: pointer;" onclick="diction_user(${pageInfo.currPage}-1)">上一页</a>
     				 &nbsp;&nbsp; 第&nbsp;&nbsp;${pageInfo.currPage}&nbsp;&nbsp;页&nbsp;&nbsp; 	
					 <a  class="button" style="cursor: pointer;" onclick="diction_user(${pageInfo.currPage}+1)">下一页</a>
					&nbsp;&nbsp; 共&nbsp;&nbsp;${pageInfo.total}&nbsp;&nbsp;条记录 &nbsp;&nbsp;
			
        </td>
      </tr>
      		
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
  function diction_user(currPage){
	$('#currPage').val(currPage);
	$('#diction-user-fm').submit();
}

	//到达新建字典页面
function user_toadd(){
	window.location.href="${ctx}/dic/toadduser";
}
  </script>
</html>
