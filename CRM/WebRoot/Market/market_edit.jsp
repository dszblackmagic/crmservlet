<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
   
    
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
   <div class="panel admin-panel margin-top">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>新建销售机会</strong>

		</div>
		<div class="body-content">
			<form class="form-x" id="market-edit-fm">
				<input type="hidden" name="id" value="" />
				<div class="form-group" style="float: left;width: 50%">
					<div class="label">
						<label>编号：</label>
					</div>
					<div class="field">
						<input type="text" value="${market.numberId}" readonly="readonly" 
							style="width: 200px" class="input w50" name="numberId" 
							id="numberId" />
					</div>

				</div>


				<div class="form-group" style="float: right;width: 50%;">
					<div class="label" style="width: 15%;">
						<label>机会来源：</label>
					</div>
					<div class="field">
						<input type="text"  name="opporTunity" class="input tips"
							style="width:35%; float:left;" data-toggle="hover"
							data-place="right" value="${market.opporTunity}"/>

					</div>
				</div>


				<div class="form-group" style="float: right;width: 50%;">
					<div class="label" style="width: 15%;">
						<label>成功概率：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="probability"
						placeholder="请输入小于100整数" value="${market.probability}"
							style="width: 200px" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
							 />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group" style="float: right;width: 50%">
					<div style="float: left; ">客户名称：</div>
					<div class="field">
						<input type="text" class="input w50" name="customerName"
							style="width: 200px" value="${market.customerName}"/>
					</div>
				</div>

				<div class="form-group">
					<div style="float: left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;概要：</div>
					<div class="field">
						<input type="text" class="input" name="outLine" style="width: 70%" value="${market.outLine}">
					</div>
				</div>

				<div class="form-group" style="float: left;width: 50%">
					<div style="float: left;">&nbsp;&nbsp;&nbsp;联系人：</div>
					<div class="field">
						<input type="text" class="input w50" name="contacts"
							value="${market.contacts} " style="width: 200px" />
					</div>
				</div>
				<div class="form-group" style="float: right;width: 50%">
					<div class="label" style="width: 15%">
						<label>联系电话：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="contactPhone"
							style="width: 200px" value="${ market.contactPhone}" />
					</div>
				</div>

				<div class="form-group">
					<div style="float: left;">
						<label>机会描述：</label>
					</div>
					<div class="field">
						<textarea class="input" name="description" style="height:150px;">${market.description}</textarea>
					</div>
				</div>


				<div class="form-group" style="float: left;width: 50%">
					<div style="float: left;">&nbsp;&nbsp;&nbsp;创建人：</div>
					<div class="field">
						<input type="text" readonly="readonly" class="input w50"
							name="founder" style="width: 200px"
							value="${market.founder}"/>
					</div>
				</div>
				<div class="form-group" style="float: right;width: 50%">
					<div class="label" style="width: 15%">
						<label>创建时间：</label>
					</div>
					<div class="field">
						<input type="text" readonly="readonly" value="${market.time}" id="time"
							name="time"  class="input w50" style="width: 200px"/>
					</div>

					<div class="form-group" style="float: right;width: 50%">
						<strong><button class="button border-blue" type="button" onclick="market_edit();return false">保存</button>
						</strong> <strong><button class="button border-red" onclick="market_cancel();" type="button">取消</button></strong>
					</div>

				</div>
			</form>
		</div>
	</div>
  </body>
  <script type="text/javascript">
  function market_cancel() {
	window.location.href = '${ctx}/market/list';
}

//提交表单
function market_edit(){
	
	
	//ajax提交form表单
	$.ajax({
		url: "${ctx}/market/update",
		type: "POST",
		async: false,
		data: $('#market-edit-fm').serialize(),
		dataType: "json",
		success: function(result){
			if(result.status == 'success'){
				
				layer.msg('修改成功!', {icon:1, time:1000});
				window.setTimeout(function(){
					window.location.href='{ctx}/market/list';
				}, 1010);
			} else {
				layer.msg('修改失败!', {icon:5, time:1000});
			}
		}
	});
}
  </script>
</html>
