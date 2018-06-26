<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title></title>
    
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
    <div class="panel-head"><strong class="icon-reorder"> 客户信息界面</strong></div>
    
    
    <table class="table table-hover text-center">
    
      <tr>
      	
        <th width="120">编号</th>
        <th>客户名称</th>       
        <th>联系电话</th>
        
        <th colspan="2" width="21%">操作</th>       
      </tr>      
      <!--对营销机会信息进行循环输出 -->  
      			<c:forEach var="list" items="${List}">
				<tr>
				<input type="hidden" name="numberId"   value="${list.customerId }"/>
				<td>
					${list.customerId }
				</td>
				<td>
					${list.customerName }
				</td>
				<td>
					${list.telephone }
				</td> 
				
				
			 
			 <td><a class="button border-blue" style="cursor:pointer;" onclick="customer_toedit('${list.customerId }')" >编辑</a></td>
			</c:forEach> 
			
			
			
      <tr>
        <td  colspan="5">
       				  <a class="button" style="cursor: pointer;" onclick="customer_list(${pageInfo.currPage}-1)">上一页</a>
     				 &nbsp;&nbsp; 第&nbsp;&nbsp;${pageInfo.currPage}&nbsp;&nbsp;页&nbsp;&nbsp; 	
					 <a  class="button" style="cursor: pointer;" onclick="customer_list(${pageInfo.currPage}+1)">下一页</a>
					&nbsp;&nbsp; 共&nbsp;&nbsp;${pageInfo.total}&nbsp;&nbsp;条记录 &nbsp;&nbsp; 
			
        </td>
      </tr>
      		
    </table>
    </form>
  </div>
  
  
  
  
  
  <script type="text/javascript">
  //翻页
  function customer_list(currPage){
	$('#currPage').val(currPage);
	$('#customer-list-fm').submit();
}
  
  //到达客户编辑页面
function customer_toedit(numberId){
	window.location.href="${ctx}/customer/toedit?customerId="+numberId;
}
  </script>
  </body>
</html>
