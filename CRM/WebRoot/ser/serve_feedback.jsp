<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'serve_feedback.jsp' starting page</title>
    
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
    <form id="serve-fdb-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 服务反馈</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li> 
       <input type="text" name="serveCustomer" value="" placeholder="客户" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <input type="text" name="serveOutline" value="" placeholder="概要" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <input type="text" name="serveType" value="" placeholder="服务类型" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <select id="judge" name="serveState" class="input w50" style="width:200px;margin: 0px 20px 0px 0" >
       <option value="" >全部</option>
        <option value="H" ${qParams['serveState'] eq 'H' ? 'selected="selected"' : ''}>已处理</option>
      
       </select>
        <button type="button"  class="button border-green"  onclick="serve_list(0);return false;" ><span class="icon-check"></span> 查询</button>
        </li>
      </ul>
    </div>
    
    <table class="table table-hover text-center">
    
      <tr>
      	
        <th width="120">编号</th>
        <th>客户</th>       
        <th>概要</th>
        <th>服务类型</th>
        <th>创建人</th>
        <th>创建时间</th>
        <th>分配状态</th>
       
        <th width="21%">操作</th>       
      </tr>  
          
      <!--对营销机会信息进行循环输出 -->  
      			<c:forEach var="list" items="${List}">
				<tr>
				
				<td>
					${list.serveId}
				</td>
				<td>
					${list.serveCustomer}
				</td>
				<td>
					${list.serveOutline}
				</td>
				<td>
					${list.serveType}
				</td>
				<td>
					${list.serveFounder}
				</td>
				<td>
					${list.serveTime}
				</td>
				<c:choose>
				<c:when test="${list.serveState eq 'H'}">
				<td colspan="1" >			
					<a class="button border-green" style="cursor:pointer;" onclick="">已处理</a>	
				</td>
				<td>
					<a class="button border-blue" onclick="serve_editfdb('${list.serveId}')" href="#">反馈</a>	
				</td>
				</c:when>
				<c:when test="${list.serveState eq 'F'}">
				<td colspan="2" >			
					<a class="button border-blue" style="cursor:pointer;" onclick="">已归档</a>	
				</td>
				
				</c:when>
				<c:otherwise>
				<td colspan="2" >			
					<a class="button border-red" style="cursor:pointer;" onclick="">未处理</a>	
				</td>
				</c:otherwise>
				</c:choose>
				
			</tr>
			</c:forEach> 
			
      <tr>
        <td  colspan="11">
       				 <a class="button" style="cursor: pointer;" onclick="serve_list(${pageInfo.currPage}-1)">上一页</a>
     				 &nbsp;&nbsp; 第&nbsp;&nbsp;${pageInfo.currPage}&nbsp;&nbsp;页&nbsp;&nbsp; 	
					 <a  class="button" style="cursor: pointer;" onclick="serve_list(${pageInfo.currPage}+1)">下一页</a>
					&nbsp;&nbsp; 共&nbsp;&nbsp;${pageInfo.total}&nbsp;&nbsp;条记录 &nbsp;&nbsp;
			
        </td>
      </tr>
      		
    </table>
    </form>
  </div>
  <script type="text/javascript">
    //翻页功能
  function serve_list(currPage){
	$('#currPage').val(currPage);
	$('#serve-fdb-fm').submit();
}

//到达反馈服务编辑界面
function serve_editfdb(serveId){
	window.location.href="${ctx}/serve/toeditfdb?serveId="+serveId;
}


  </script>
  </body>
</html>
