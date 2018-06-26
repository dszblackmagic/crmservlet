<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'dictionary_add.jsp' starting page</title>
    
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
    <form id="dictionary-add-fm">
    <input type="hidden" id="currPage" name="currPage">
    <div class="panel-head"><strong class="icon-reorder"> 数字字典创建</strong></div>
    <div class="form-group" style="float: left;">
		<strong><button class="button border-blue" type="button" onclick="distionary_add();">保存</button></strong>
		<strong><button class="button border-red" type="button" onclick="dictionary_return(); return false">返回</button></strong>
		
		
		</div>
    
    <table class="table table-hover text-center">
		 	<tr>
		 	
		 	<td style="background-color: rgb(133,209,235);width: 200px">编号</td>
		 	<td style="text-align: left;"><input  type="text" id="dictionId" name="dictionId" style="cursor: pointer;width: 200px" readonly="readonly" ></td>
		 	<td style="background-color: rgb(133,209,235);">类别</td>
		 	<td style="text-align: left;">
		 	<input id="dictionType" name="dictionType" >
		 	 </td>
		 	</tr>      
     		
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">条目</td>
     		<td style="text-align: left;"><input type="text" name="dictionEntry"><label style="color: red;">* </label></td>
     		<td style="background-color: rgb(133,209,235);">值</td>
     		<td style="text-align: left;"><input type="text" name="dictionValue"><label style="color: red;">* </label></td>
     		</tr>
     		
     		<tr>
     		<td style="background-color: rgb(133,209,235);">是否可编辑</td>
     		<input name="dictionState" type="hidden" id="dictionState" value="N" >
     		<td colspan="3" style="text-align: left;"><input type="checkbox" value="Y" name="dictionState2"  onclick="dictionState.value=this.checked?'Y':'N'"> </td>
     		</tr>
     		
     		
    </table>
    </form>
  </div>
  </body>
  <script>
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
  
   //自动生成编号JS
  	function uuid() {
			var s = [];
			var hexDigits = "0123456789";
			for (var i = 0; i < 36; i++) {
				s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
			}
			s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
			s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
			
	
			var uuid = s.join("");
			document.getElementById('dictionId').value = uuid;
	
		}
		window.onload = uuid;
	
	//保存当前创建的数字字典
function distionary_add() {
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/dic/add",
		type : "POST",
		async : false,
		data : $('#dictionary-add-fm').serialize(),
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
	
	//返回数字列表
function dictionary_return(){
	window.location.href = '${ctx}/dic/todiclist';
}
  </script>
</html>
