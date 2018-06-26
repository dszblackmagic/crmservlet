<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@include file="../_meta.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'Market_add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script type="text/javascript" src="js/Calendar3.js"></script>
<script type="text/javascript"
	src="js/jquery.validation/1.14.0/jquery.validate.js"></script>
</head>

<body>
	<div class="panel admin-panel margin-top">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>新建销售机会</strong>

		</div>
		<div class="body-content">
			<form class="form-x" id="market-add-fm">
				<input type="hidden" name="id" value="" />
				<div class="form-group" style="float: left;width: 50%">
					<div class="label">
						<label>编号：</label>
					</div>
					<div class="field">
						<input type="text" value="" readonly="readonly"
							style="width: 200px" class="input w50" name="numberId"
							id="numberId" />
					</div>

				</div>


				<div class="form-group" style="float: right;width: 50%;">
					<div class="label" style="width: 15%;">
						<label>机会来源：</label>
					</div>
					<div class="field">
						<input type="text" id="url1" name="opporTunity" class="input tips"
							style="width:35%; float:left;" data-toggle="hover"
							data-place="right" />

					</div>
				</div>


				<div class="form-group" style="float: right;width: 50%;">
					<div class="label" style="width: 15%;">
						<label>成功概率：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" id="probability" name="probability"
						placeholder="请输入小于100整数"
							style="width: 200px" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"  
							 /><label style="color: red;">*</label>
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group" style="float: right;width: 50%">
					<div style="float: left; ">客户名称：</div>
					<div class="field">
						<input type="text" class="input w50" id="customerName" name="customerName"
							style="width: 200px" /><label style="color: red;">*</label>
					</div>
				</div>

				<div class="form-group">
					<div style="float: left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;概要：</div>
					<div class="field">
						<input type="text" class="input" id="outLine" name="outLine" style="width: 70%">
						<label style="color: red;">*</label>
					</div>
				</div>

				<div class="form-group" style="float: left;width: 50%">
					<div style="float: left;">&nbsp;&nbsp;&nbsp;联系人：</div>
					<div class="field">
						<input type="text" class="input w50" name="contacts"
							style="width: 200px" />
					</div>
				</div>
				<div class="form-group" style="float: right;width: 50%">
					<div class="label" style="width: 15%">
						<label>联系电话：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="contactPhone"
							style="width: 200px" />
					</div>
				</div>

				<div class="form-group">
					<div style="float: left;">
						<label>机会描述：</label>
					</div>
					<div class="field">
						<textarea class="input" id="description" name="description" style="height:150px;"></textarea>
						<label style="color: red;">*</label>
					</div>
				</div>


				<div class="form-group" style="float: left;width: 50%">
					<div style="float: left;">&nbsp;&nbsp;&nbsp;创建人：</div>
					<div class="field">
						<input type="text" readonly="readonly" class="input w50"
							name="founder" style="width: 200px"
							value=<%=(String) session.getAttribute("userName")%>>
					</div>
				</div>
				<div class="form-group" style="float: right;width: 50%">
					<div class="label" style="width: 15%">
						<label>创建时间：</label>
					</div>
					<div class="field">
						<input type="text" readonly="readonly" value="" id="time"
							name="time"  class="input w50" style="width: 200px"/>
					</div>

					<div class="form-group" style="float: right;width: 50%">
						<strong><button class="button border-blue" type="button" onclick="market_save();return false">保存</button>
						</strong> <strong><button class="button border-red" onclick="market_cancel();" type="button">取消</button></strong>
					</div>

				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		function uuid() {
			var s = [];
			var hexDigits = "0123456789";
			for (var i = 0; i < 36; i++) {
				s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
			}
			s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
			s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
			
	
			var uuid = s.join("");
			document.getElementById('numberId').value = uuid;
	
		}
		window.onload = uuid;
	
		function today() {
			var today = new Date();
			var h = today.getFullYear();
			var m = today.getMonth() + 1;
			var d = today.getDate();
			var hour = today.getHours();
			var min = today.getMinutes();
			var second = today.getSeconds();
			return h + "-" + m + "-" + d + " " + hour + ":" + min + ":" + second;
		}
	
		document.getElementById("time").value = today();
		
		//提交表单
function market_save() {
	var description=document.getElementById("description").value;
	var customerName=document.getElementById("customerName").value;
	var probability=document.getElementById("probability").value;
	var outLine=document.getElementById("outLine").value;
	if(description=="" || customerName=="" ||probability=="" ||outLine==""){
		alert("必填项不能为空")
	}else{
	
	//ajax提交form表单
	$.ajax({
		url : "${ctx}/market/add",
		type : "POST",
		async : false,
		data : $('#market-add-fm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 'success') {
			
				//$(obj).parents("tr").remove();
				layer.msg('保存成功!', {
					icon : 1,
					time : 1000
				});
				window.setTimeout(function() {
					window.location.href = '${ctx}/market/list';
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
}
//取消，跳转到列表页面
function market_cancel() {
	window.location.href = '${ctx}/market/list';
}
	</script>
</body>
</html>
