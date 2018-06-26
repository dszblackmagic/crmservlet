<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'dictionary_edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  	<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  	<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  </head>
  
  <body>
    <div class="panel admin-panel">
    <form id="dictionary-update-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 数字字典编辑</strong></div>
    <div class="form-group" style="float: left;">
		<strong><button class="button border-blue" type="button" onclick="distionary_add();">保存</button></strong>
		<strong><button class="button border-red" type="button" onclick="dictionary_return(); return false">返回</button></strong>
		
		
		</div>
    
    <table class="table table-hover text-center">
		 	<tr>
		 	
		 	<td style="background-color: rgb(133,209,235);width: 200px">编号</td>
		 	<td style="text-align: left;"><input  type="text" id="dictionId" name="dictionId" value="${List.dictionId} " style="cursor: pointer;width: 200px" readonly="readonly" ></td>
		 	<td style="background-color: rgb(133,209,235);">类别</td>
		 	<td style="text-align: left;">
		 	<input id="dictionType" name="dictionType" value="${List.dictionType}" >
		 	 </td>
		 	</tr>      
     		
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">条目</td>
     		<td style="text-align: left;"><input type="text" name="dictionEntry" value="${List.dictionEntry}"><label style="color: red;">* </label></td>
     		<td style="background-color: rgb(133,209,235);">值</td>
     		<td style="text-align: left;"><input type="text" name="dictionValue" value="${List.dictionValue}"><label style="color: red;">* </label></td>
     		</tr>
     		
     		<tr>
     		
     		
     		<td style="background-color: rgb(133,209,235);">是否可编辑</td>
     		<input name="dictionState" type="hidden" id="dictionState" value="N" >
     		<td colspan="3" style="text-align: left;"><input checked="checked" type="checkbox" value="Y" name="dictionState2"  onclick="dictionState.value=this.checked?'Y':'N'"> </td>
     	

     		</tr>
     		
     		
    </table>
    </form>
  </div>
  </body>
  <script type="text/javascript">
  
   //ajax自动补全
  $(function() {
    var availableTags = [
      "服务类型",
      "企业级客户等级",
      "企业级客户类型",
      "服务等级",
      "服务事件",
    ];
    $( "#dictionType" ).autocomplete({
      source: availableTags
    });
  });
  
  //返回数字列表
function dictionary_return(){
	window.location.href = '${ctx}/dic/todiclist';
}

function distionary_add() {
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/dic/update",
		type : "POST",
		async : false,
		data : $('#dictionary-update-fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('保存成功!', {
					icon : 1,
					time : 1000
				});
				window.setTimeout(function() {
					window.location.href = '${ctx}/dic/todiclist';
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
  </script>
</html>
