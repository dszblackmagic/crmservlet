<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'analysis_customer.jsp' starting page</title>
    
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
    <form id="analysis-cus-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder">客户构成分析</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li> 
       <select name="" style="height: 40px;width: 100px">
        <option>待定</option>
       </select>
       
      
        <button type="button"  class="button border-green"  onclick="analysis_cus(0);return false;" ><span class="icon-check"></span> 查询</button>
        
        </li>
      </ul>
    </div>
    
    <table class="table table-hover text-center">
    
      <tr>
      	
        
             
        <th>等级</th>
        <th>客户数量</th>
             
      </tr>  
          
      <!--对营销机会信息进行循环输出 -->  
      			<c:forEach var="list" items="${list}">
				<tr>
				
				<td>
					${list.customerLevel}
				</td>
				<td>
					${list.number}
				</td>
				
			</c:forEach> 
			
      <tr>
        <td  colspan="11">
       				
			
        </td>
      </tr>
      		
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
   function analysis_cus(currPage){
	$('#currPage').val(currPage);
	$('#analysis-cus-fm').submit();
}
	
  </script>
</html>
