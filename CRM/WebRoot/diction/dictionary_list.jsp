<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'dictionary_manage.jsp' starting page</title>
    
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
    <form id="diction-list-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder">数字字典</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li> 
       <input type="text" name="dictionType" value="" placeholder="类别" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <input type="text" name="dictionEntry" value="" placeholder="条目" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <input type="text" name="dictionValue" value="" placeholder="值" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
      
        <button type="button"  class="button border-green"  onclick="diction_list(0);return false;" ><span class="icon-check"></span> 查询</button>
        <button type="button"  class="button border-blue"  onclick="diction_toadd();return false;" ><span class="icon-check"></span> 新建</button>
        </li>
      </ul>
    </div>
    
    <table class="table table-hover text-center">
    
      <tr>
      	
        <th width="120">编号</th>
        <th>类别</th>       
        <th>条目</th>
        <th>值</th>
        <th>是否可编辑</th>
        
       
        <th colspan="2" width="21%">操作</th>       
      </tr>  
          
      <!--对营销机会信息进行循环输出 -->  
      			<c:forEach var="list" items="${List}">
				<tr>
				<input type="hidden" name="dictionId" value="${list.dictionId}">
				<td>
					${list.dictionId}
				</td>
				<td>
					${list.dictionType}
				</td>
				<td>
					${list.dictionEntry}
				</td>
				<td>
					${list.dictionValue}
				</td>
				
				<c:choose>
				
				<c:when test="${list.dictionState eq 'Y'}">
				<td>可编辑</td>
				<td colspan="1" >			
					<a class="button border-blue" style="cursor:pointer;" onclick="diction_toedit('${list.dictionId}')">编辑</a>	
				</td>
				<td>
					<a class="button border-blue" onclick="dictionary_del('${list.dictionId}')" href="#">删除</a>	
				</td>
				</c:when>
				<c:otherwise>
				<td>不可编辑</td>
				</c:otherwise>
				</c:choose>
				
			</tr>
			</c:forEach> 
			
      <tr>
        <td  colspan="11">
       				 <a class="button" style="cursor: pointer;" onclick="diction_list(${pageInfo.currPage}-1)">上一页</a>
     				 &nbsp;&nbsp; 第&nbsp;&nbsp;${pageInfo.currPage}&nbsp;&nbsp;页&nbsp;&nbsp; 	
					 <a  class="button" style="cursor: pointer;" onclick="diction_list(${pageInfo.currPage}+1)">下一页</a>
					&nbsp;&nbsp; 共&nbsp;&nbsp;${pageInfo.total}&nbsp;&nbsp;条记录 &nbsp;&nbsp;
			
        </td>
      </tr>
      		
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
   function diction_list(currPage){
	$('#currPage').val(currPage);
	$('#diction-list-fm').submit();
}
	

	//到达新建字典页面
function diction_toadd(){
	window.location.href="${ctx}/dic/toadd";
}

	//到达编辑字典页面
function diction_toedit(dictionId){
	window.location.href="${ctx}/dic/toedit?dictionId="+dictionId;
}
	//删除指定数字字典
function dictionary_del(dictionId){
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/dic/del?dictionId="+dictionId,
		type : "POST",
		async : false,
		data : $('#diction-list-fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('删除成功!', {
					icon : 1,
					time : 1000
				});
				window.setTimeout(function() {
					window.location.href = '${ctx}/dic/todiclist';
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
