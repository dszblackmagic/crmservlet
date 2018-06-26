<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../_meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>customer_edit</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="panel admin-panel margin-top">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>客户信息</strong>
		</div>
		<form class="form-x" id="customer_edit_fm">
		<div class="form-group" style="float: left;">
		<strong><button class="button border-red" type="button" onclick="customer_tocontacts('${list.customerId}','${list.customerName}')">联系人</button>
		</strong> 
		<strong><button class="button border-blue" type="button" onclick="customer_toassoci('${list.customerId}','${list.customerName}')">交往记录</button></strong>
		<strong><button class="button border-red" onclick="customer_return();" type="button">返回</button></strong>
		<button class="button border-green" type="button" onclick="customer_save();" >保存</button>
		</div>
		 <table class="table table-hover text-center">
		 	<tr>
		 	<input type="hidden" name="customerId"  value="${list.customerId}"/>
		 	<td style="background-color: rgb(133,209,235);">客户编号</td>
		 	<td style="text-align: left;">${list.customerId}</td>
		 	<td style="background-color: rgb(133,209,235);">名称</td>
		 	<td style="text-align: left;"><input id="customerName" name="customerName" type="text" required="required" value="${list.customerName}"><label style="color: red;">* </label></td>
		 	</tr>
		 	
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">地区</td>
		 	<td style="text-align: left;">
		 	<select name="customerArea">
		 	<option value="北京">北京</option>
		 	</select>
		 	</td>
		 	<td style="background-color: rgb(133,209,235);">客户经理</td>
		 	<td style="text-align: left;">
		 	<select id="customerManager" name="customerManager">
		 	<c:choose>
		 	<c:when test="${list.customerManager eq null}">
		 	<option style="text-align:center;" value="">未指定</option>		 			 	
		 	<c:forEach var="list" items="${userList}">		 	
		 	<option style="text-align:center;" value="${list.userName}">${list.userName}</option>
		 	</c:forEach>
		 	</c:when>
		 	<c:otherwise>
		 	<option style="text-align:center;" value="${list.customerManager}">${list.customerManager}</option>
		 	<c:forEach var="list" items="${userList}">		 	
		 	<option style="text-align:center;" value="${list.userName}" >${list.userName}</option>
		 	</c:forEach>
		 	</c:otherwise>
		 	</c:choose>
		 	</select>
		 	<label style="color: red;">*</label>
		 	</td>
		 	
		 	</tr>
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">客户等级</td>
		 	<td style="text-align: left;">
		 	<select id="customerLevel" name="customerLevel">
		 	<c:forEach var="dic" items="${dicList}">
		 	<option value="${dic.dictionEntry}"  ${list['customerLevel'] eq dic['dictionEntry'] ? 'selected="selected"' : ''}>${dic.dictionEntry}</option>
		 	</c:forEach>
		 	</select><label style="color: red;">*</label></td>
		 	<td style="background-color: rgb(133,209,235);"></td>
		 	<td style="text-align: left;"></td>
		 	</tr>
		 	
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">客户满意度</td>
		 	<td style="text-align: left;">
		 	<select name="customerSat">
		 	<option value="5" ${list['customerSat'] eq '5' ? 'selected="selected"' : ''}>☆☆☆☆☆</option>
		 	<option value="4" ${list['customerSat'] eq '4' ? 'selected="selected"' : ''}>☆☆☆☆</option>
		 	<option value="3" ${list['customerSat'] eq '3' ? 'selected="selected"' : ''}>☆☆☆</option>
		 	<option value="2" ${list['customerSat'] eq '2' ? 'selected="selected"' : ''}>☆☆</option>
		 	<option value="1" ${list['customerSat'] eq '1' ? 'selected="selected"' : ''}>☆</option>
		 	</select>
		 	</td>
		 	<td style="background-color: rgb(133,209,235);">客户信用度</td>
		 	<td style="text-align: left;">
		 	<select name="customerCredit">
		 	<option value="5" ${list['customerCredit'] eq '5' ? 'selected="selected"' : ''}>☆☆☆☆☆</option>
		 	<option value="4" ${list['customerCredit'] eq '4' ? 'selected="selected"' : ''}>☆☆☆☆</option>
		 	<option value="3" ${list['customerCredit'] eq '3' ? 'selected="selected"' : ''}>☆☆☆</option>
		 	<option value="2" ${list['customerCredit'] eq '2' ? 'selected="selected"' : ''}>☆☆</option>
		 	<option value="1" ${list['customerCredit'] eq '1' ? 'selected="selected"' : ''}>☆</option>
		 	</select>
			</td>
		 	</tr>
		 	
		 	<tr style="height: 30px"></tr>
		 	
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">地址</td>
		 	<td style=" text-align: left; " ><input type="text" id="address" name="address" value="${list.address}" required="required"> <label style="color: red;">* </label></td>
		 	<td style="background-color: rgb(133,209,235);">邮政编码</td>
		 	<td style=" text-align: left; " ><input type="text" id="postalCode" name="postalCode" value="${list.postalCode}" required="required"> <label style="color: red;">* </label></td>
		 	</tr>
		 	
		 	
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">电话</td>
		 	<td style="text-align: left;"><input type="text" id="telephone" name="telephone" value="${list.telephone}" required="required"> <label style="color: red;">* </label></td>
		 	<td style="background-color: rgb(133,209,235);">传真</td>
		 	<td style="text-align: left;"><input type="text" id="customerFax" name="customerFax" value="${list.customerFax}" required="required"> <label style="color: red;">* </label></td>
		 	</tr>
		 	
		 	<tr>
		 	<td style="background-color: rgb(133,209,235);">网址</td>
		 	<td style="text-align: left;"><input type="text" id="website" name="website" value="${list.website}" required="required"><label style="color: red;" >* </label></td>
		 	<td style="background-color: rgb(133,209,235);"></td>
		 	<td style="text-align: left;"></td>
		 	</tr>
		 	
		 	
		 	<tr style="height: 50px"></tr>
		 	
		 	
		 	<tr>
		 	<td style="background-color: rgb(69,148,235);">营业执照注册号</td>
		 	<td style="text-align: left;"><input type="text" name="registerNum" value="${list.registerNum}" ></td>
		 	<td style="background-color: rgb(69,148,235);">法人</td>
		 	<td style="text-align: left;"><input type="text" id="legalPerson" name="legalPerson" value="${list.legalPerson}" required="required"><label style="color: red;">* </label></td>
		 	</tr>
		 	
		 	
		 	
		 	<tr>
		 	<td style="background-color: rgb(69,148,235);">注册资金(万元)</td>
		 	<td style="text-align: left;"><input type="text" name="registerCapital" value="${list.registerCapital}" ></td>
		 	<td style="background-color: rgb(69,148,235);">年营业额</td>
		 	<td style="text-align: left;"><input type="text" name="turnover" value="${list.turnover}" ></td>
		 	</tr>
		 	
		 	<tr>
		 	<td style="background-color: rgb(69,148,235);">开户银行</td>
		 	<td style="text-align: left;"><input type="text" id="openBank" name="openBank" value="${list.openBank}"><label style="color: red;" required="required">* </label></td>
		 	<td style="background-color: rgb(69,148,235);">银行账号</td>
		 	<td style="text-align: left;"><input type="text" id="bankNum" name="bankNum" value="${list.bankNum}"><label style="color: red;" required="required">* </label></td>
		 	</tr>
		 	
		 	<tr>
		 	<td style="background-color: rgb(69,148,235);">地税登记号</td>
		 	<td style="text-align: left;"><input type="text" name="localTax" value="${list.localTax}" ></td>
		 	<td style="background-color: rgb(69,148,235);">国税登记号</td>
		 	<td style="text-align: left;"><input type="text" name="countryTax" value="${list.countryTax}" ></td>
		 	</tr>
		
		 </table>		 	
		 </form>
	</div>  
  </body>
  <script type="text/javascript">
 //返回list显示
 function customer_return() {
	window.location.href = '${ctx}/customer/list';
}

//到达联系人界面
function customer_tocontacts(id,name){
	window.location.href="${ctx}/customer/tocontacts?id="+id+"&&name="+name;
}

//到达交往记录界面
function customer_toassoci(id,name){
	window.location.href="${ctx}/customer/toassoci?customerId="+id+"&&customerName="+name;
}
//保存信息
function customer_save(){
	var customerName=document.getElementById("customerName").value;
	var customerManager=document.getElementById("customerManager").value;
	var customerLevel=document.getElementById("customerLevel").value;
	var address=document.getElementById("address").value;
	var postalCode=document.getElementById("postalCode").value;
	var telephone=document.getElementById("telephone").value;
	var customerFax=document.getElementById("customerFax").value;
	var website=document.getElementById("website").value;
	var legalPerson=document.getElementById("legalPerson").value;
	var openBank=document.getElementById("openBank").value;
	var bankNum=document.getElementById("bankNum").value;
	
	if(customerName=="" ||customerManager=="" ||customerLevel==""||address==""
	||postalCode==""||telephone==""||customerFax==""||website==""||legalPerson==""
	||openBank==""||bankNum==""
	){
	 alert("必选项不能为空");
	}else{

	//ajax提交form表单
	$.ajax({
		url: "${ctx}/customer/save",
		type: "POST",
		async: false,
		data: $('#customer_edit_fm').serialize(),
		dataType: "json",
		success: function(result){
		if(result.status == 'success'){
				
				layer.msg('保存成功!', {icon:1, time:1000});
				window.setTimeout(function(){
					window.location.href='{ctx}/customer/list';
				}, 1010);
			} else {
				layer.msg('保存失败!', {icon:5, time:1000});
			}
		}
	});
	}
}

  </script>
</html>
