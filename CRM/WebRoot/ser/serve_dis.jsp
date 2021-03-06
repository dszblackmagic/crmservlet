<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'serve_dis.jsp' starting page</title>
    
	

  </head>
  
  <body>
    <div class="panel admin-panel">
    <form id="serve-dis-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 服务分配</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li> 
       <input type="text" name="serveCustomer" value="" placeholder="客户" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <input type="text" name="serveOutline" value="" placeholder="概要" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <input type="text" name="serveType" value="" placeholder="服务类型" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <select id="judge" name="serveState" class="input w50" style="width:200px;margin: 0px 20px 0px 0" >
       <option value="" >全部</option>
        <option value="A" ${qParams['serveState'] eq 'A' ? 'selected="selected"' : ''}>已指派</option>
       <option value="N" ${qParams['serveState'] eq 'N' ? 'selected="selected"' : ''}>新创建</option>
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
        <th colspan="2">分配给</th>
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
				<c:when test="${list.serveState eq 'N'}">
				<td >			
					<a class="button border-red" style="cursor:pointer;" onclick="">未分配</a>	
				</td>
				<td>
				<select id="${ list.serveId}serveDistri" name="serveDistri">
				<c:forEach var="ulist" items="${userList}">
				<option value="${ulist.userName}">${ulist.userName}</option>
				</c:forEach>
				</select>
				</td>
				<td >			
					<a class="button border-green" href="#" onclick="serve_dis('${list.serveId}')">分配</a>	
				</td>
				<td>
					<a class="button border-red" onclick="serve_del('${list.serveId}')" href="#">删除</a>	
				</td>
				</c:when>
				
				<c:when test="${list.serveState eq 'A'}">
				<td colspan="3" >			
					<a class="button border-green" style="cursor:pointer;" onclick="">已分配</a>	
				</td>
				<td>
					<a class="button border-red" onclick="serve_del('${list.serveId}')" href="#">删除</a>	
				</td>
				</c:when>
				
				<c:when test="${list.serveState eq 'H'}">
				<td colspan="3" >			
					<a class="button border-green" style="cursor:pointer;" onclick="">已处理</a>	
				</td>
				</c:when>
				
				<c:when test="${list.serveState eq 'F'}">
				<td colspan="3" >			
					<a class="button border-blue" style="cursor:pointer;" onclick="">已归档</a>	
				</td>
				</c:when>
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
  </body>
  <script type="text/javascript">
  //翻页功能
  function serve_list(currPage){
	$('#currPage').val(currPage);
	$('#serve-dis-fm').submit();
}
	
 //分配客户经理

function serve_dis(serveId){
	var serveDistri=document.getElementById(serveId+"serveDistri").value;
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/serve/servedis?serveId="+serveId+"&&serveDistri="+serveDistri,
		type : "POST",
		async : false,
		data : $('#serve-dis-fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('分配成功!', {
					icon : 1,
					time : 1000
				});
				window.setTimeout(function() {
					window.location.href = '${ctx}/serve/todis';
				}, 1010);
			} else {
				layer.msg('分配失败!', {
					icon : 5,
					time : 1000
				});
			}
		}
	});
	}
	
	//删除指定服务
function serve_del(serveId){
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/serve/servedel?serveId="+serveId,
		type : "POST",
		async : false,
		data : $('#serve-dis-fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('删除成功!', {
					icon : 1,
					time : 1000
				});
				window.setTimeout(function() {
					window.location.href = '${ctx}/serve/todis';
				}, 1010);
			} else {
				layer.msg('删除失败!', {
					icon : 5,
					time : 1000
				});
			}
		}
	});
	}
  </script>
</html>
