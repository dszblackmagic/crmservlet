<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	 <%
   	String userType=(String)request.getSession().getAttribute("userType");
   	String err="请使用客户经理或销售主管登陆此功能";
   	if(!(userType.equals("khjl")||userType.equals("xszg"))){
   	%>
   	<script type="text/javascript" language="javascript">
	alert("<%=err%>");                                            // 弹出错误信息
	window.location.href='../welcomadmin.jsp' ;                           		 // 跳转到欢迎
	</script>
   	<% 
   	}
    %>
    
    
    <title>My JSP 'Marketing.jsp' starting page</title>

  </head>
  
  <body>
  
  <div class="panel admin-panel">
    <form id="market-list-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 销售机会信息</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li> 
       <input type="text" name="customerName" value="" placeholder="客户名称" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <input type="text" name="outLine" value="" placeholder="概要" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <input type="text" name="conTacts" value="" placeholder="联系人" style="width:200px;margin: 0px 20px 0px 0" class="input w50">
       <select id="judge" name="judge" class="input w50" style="width:200px;margin: 0px 20px 0px 0" >
       <option value="" >全部</option>
       <option value="Y" ${qParams['judge'] eq 'Y' ? 'selected="selected"' : ''}>已指派</option>
       <option value="N" ${qParams['judge'] eq 'N' ? 'selected="selected"' : ''}>未指派</option>
       </select>
        <button type="button"  class="button border-green"  onclick="market_list(0);return false;" ><span class="icon-check"></span> 查询</button>
        <button type="button"  class="button border-blue"  id="#" onclick="market_add();"><span class="icon-check"></span> 新建</button>
         <!--  <button type="button"  class="button border-green"  id="checkAll" ><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"  ><span class="icon-trash-o"></span> 批量删除</button> -->
        </li>
      </ul>
    </div>
    
    <table class="table table-hover text-center">
    
      <tr>
      	<th >选择</th>
        <th width="120">编号</th>
        <th>客户名称</th>       
        <th>概要</th>
        <th>联系人</th>
        <th>联系电话</th>
        <th>创建时间</th>
        
        <th colspan="3" width="21%">操作</th>       
      </tr>      
      <!--对营销机会信息进行循环输出 -->  
      			<c:forEach var="market" items="${marketlist}">
				<tr>
				<td><input type="checkbox" name="selAll"   value="${market.numberId}"/></td>
				<td>
					${market.numberId}
				</td>
				<td>
					${market.customerName}
				</td>
				<td>
					${market.outLine}
				</td>
				<td>
					${market.contacts}
				</td>
				<td>
					${market.contactPhone}
				</td>
				<td>
					${market.time}
				</td>
				<c:choose>
				<c:when test="${market.development eq 'S'}">
				<td >			
					<a class="button border-red" style="cursor:pointer;" onclick="">已终止</a>	
				</td>
				</c:when>
				<c:when test="${market.development eq 'YY'}">
				<td >			
					<a class="button border-green" style="cursor:pointer;" onclick="">开发成功</a>	
				</td>
				</c:when>
				<c:when test="${market.judge eq 'Y'}">
				<td >			
					<a class="button border-green" style="cursor:pointer;" onclick="market_assign('${market.numberId}')">已分配</a>	
				</td>
				</c:when>
				<c:otherwise>
				<td >			
					<a class="button border-blue" style="cursor:pointer;" onclick="market_assign('${market.numberId}')">未分配</a>	
				</td>
				</c:otherwise>
				</c:choose>
				<td >			
					<a class="button border-green" href="#" onclick="market_edit('${market.numberId}')">修改</a>	
				</td>
				
				<td>
					<a class="button border-red" onclick="delete_mar('${market.numberId}')" href="#">删除</a>	
				</td>
			</tr>
			</c:forEach>
			
      <tr>
        <td  colspan="11">
       				 <a class="button" style="cursor: pointer;" onclick="market_list(${pageInfo.currPage}-1)">上一页</a>
     				 &nbsp;&nbsp; 第&nbsp;&nbsp;${pageInfo.currPage}&nbsp;&nbsp;页&nbsp;&nbsp; 	
					 <a  class="button" style="cursor: pointer;" onclick="market_list(${pageInfo.currPage}+1)">下一页</a>
					&nbsp;&nbsp; 共&nbsp;&nbsp;${pageInfo.total}&nbsp;&nbsp;条记录 &nbsp;&nbsp;
			
        </td>
      </tr>
      		
    </table>
    </form>
  </div>
	
<script language="javascript"> 
//全选功能
$("#checkAll").click(function(){ 
  $("input[name='selAll']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//翻页显示列表
function market_list(currPage){
	$('#currPage').val(currPage);
	$('#market-list-fm').submit();
}


//新建营销机会
function market_add(){
	window.location.href = '${ctx}/market/toAdd';
}

//删除单条营销机会信息
function delete_mar(id){
	layer.confirm('确认要删除吗？',function(){
		market_del(id);
	});
}

//营销机会信息-删除
function market_del(ids){
	$.ajax({
		type: 'POST',
		data: {ids:ids},
		url: '${ctx}/market/delete',
		dataType: 'json',
		success: function(result){
			if(result.status == 'success'){
				layer.msg('已删除!', {icon:1, time:1000});
				window.setTimeout(function(){
					window.location.href = '${ctx}/market/list';
				}, 1010);
			} else {
				layer.msg('删除失败!', {icon:6, time:1000});
			}
		}
	});
}

//营销机会信息-修改
function market_edit(id){
	window.location.href="${ctx}/market/edit?id="+id;
}

//营销机会信息-指派
function market_assign(numberId){
	window.location.href="${ctx}/market/toassign?numberId="+numberId;
}
</script> 
  </body>
</html>
