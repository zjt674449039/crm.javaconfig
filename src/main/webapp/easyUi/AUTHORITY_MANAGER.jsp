<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Basic Layout - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" 
	href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/themes/icon.css">
<script type="text/javascript" 
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/jquery.min.js"></script>
<script type="text/javascript" 
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<h2>权限管理</h2>
	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w1').window('open')">增加职位</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w2').window('open')">修改职位权限</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w3').window('open')">删除权限</a>
	</div>
	<div id="w1" class="easyui-window" title="增加职位" style="width:530px;height:500px;padding:10px;" data-options="modal:true,closed:true">
		<div style="padding: 10px 60px 20px 60px">
			<form id="ff1" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
			<table cellpadding="25">
				<tr>
					<td>职位名:</td>
					<td>
					<input class="easyui-textbox" type="text" name="positionName1" id="positionName1"/>
					</td>
				</tr>
				<tr>
					<td>所属部门:</td>
					<td>
						<input class="easyui-combobox" name="positionDepartmentId1" id="positionDepartmentId1"
						data-options="
								url:'${pageContext.request.contextPath}/info/departmentInfo',
								method:'get',
								valueField:'id',
								textField:'department',
								panelHeight:'auto'">
					</td>
				</tr>
				<tr>
					<td>权限:</td>
					<td>
						<input class="easyui-combobox" name="authorityNameAuthorityIds1" id="authorityNameAuthorityIds1" 
							style="height:100px;width:200px" 
							data-options="
							url:'${pageContext.request.contextPath}/info/nameAuthorityInfo',
							method:'get',
							valueField:'id',
							textField:'naRemark',
							multiple:true,
							multiline:true,
							panelHeight:'300px'">
					</td>
				</tr>
			</table>
			</form>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					id="addPosition">添加职位</a> 
				<a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="clearForm('#ff1')">清除信息</a>
			</div>
		</div>
	</div>
	
	<div id="w2" class="easyui-window" title="修改职位权限" 
		style="width:700px;height:500px;padding:10px;"
		data-options="modal:true,closed:true">
		<%-- <table id="excelData" class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
			data-options="
			singleSelect:true,
			collapsible:true,
			url:'${pageContext.request.contextPath}/easyUi/exportExcelData',
			method:'post'">
		<thead>
			<tr>
				<th data-options="field:'id',width:80">ID</th>
				<th data-options="field:'username',width:100">用户名</th>
				<th data-options="field:'password',width:80,align:'right'">密码</th>
				<th data-options="field:'nick_name',width:80,align:'right'">昵称</th>
				<th data-options="field:'account_employee_id',width:250">员工id</th>
			</tr>
		</thead>
		</table> --%>
<!-- 	<input type="button" onclick="tableToExcel('testTable', 'W3C Example Table')" value="导出"> -->
	
		<div style="padding: 10px 60px 20px 60px">
			<form id="ff2" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
			<table cellpadding="25">
				<tr>
					<td>职位:</td>
					<td>
						<input class="easyui-combobox" name="positionId2" id="positionId2"
						data-options="
								url:'${pageContext.request.contextPath}/info/positionInfo',
								method:'get',
								valueField:'id',
								textField:'positionName',
								panelHeight:'300px'">
					</td>
				</tr>
				<tr>
					<td>权限:</td>
					<td>
						<input class="easyui-combobox" name="authorityIds2" id="authorityIds2" 
							style="height:100px;width:200px" 
							data-options="
							url:'${pageContext.request.contextPath}/info/nameAuthorityInfo',
							method:'get',
							valueField:'id',
							textField:'naRemark',
							multiple:true,
							multiline:true,
							panelHeight:'300px'">
					</td>
				</tr>
			</table>
			</form>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					id="alterAuthority">修改权限</a> 
				<a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="clearForm('#ff2')">清除信息</a>
			</div>
		</div>
	</div>
	<div id="w3" class="easyui-window" title="删除权限" 
		style="width:500px;height:400px;padding:10px;"
		data-options="modal:true,closed:true">
		<form id="ff3" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
			<table cellpadding="25">
				<tr>
					<td>职位:</td>
					<td>
						<input class="easyui-combobox" name="positionIdForDelete3" id="positionIdForDelete3"
						data-options="
								url:'${pageContext.request.contextPath}/info/positionInfo',
								method:'get',
								valueField:'id',
								textField:'positionName',
								panelHeight:'300px'">
					</td>
				</tr>
				<tr>
					<td>权限:</td>
					<td id="searchAuthorities">
						<input class="easyui-combobox" name="authorityIdsForDelete3" id="authorityIdsForDelete3" 
							style="height:100px;width:200px" 
							data-options="
							disabled:true">
					</td>
				</tr>
			</table>
			</form>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					id="getAuthorities" onclick="getAuthorities()" >获取现有权限</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton"
					id="deleteAuthority">删除权限</a> 
				<a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="resetForm()">清除信息</a>
			</div>
	</div>
	
<script>
$("#addPosition").click(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/authorityManager/addPosition", //处理页面的路径
		async:false,
		data:{
			"_csrf":$("#_csrf").val(),
			"positionName":$("#positionName1").val(),
			"positionDepartmentId":$("#positionDepartmentId1").val(),
			"authorityNameAuthorityIds":$("#authorityNameAuthorityIds1").val()}, //要提交的数据是一个JSON
		type:"POST", //提交方式
		dataType:"json", //返回数据的类型
		//TEXT字符串 JSON返回JSON XML返回XML
		success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
			clearForm("#ff1");
			$('#w1').window('close');
			if(data==0){
				alert('添加成功');
			}else{
				alert('添加失败')
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert('操作失败!');
		}
	});
})

$("#alterAuthority").click(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/authorityManager/alterAuthority", //处理页面的路径
		async:false,
		data:{
			"_csrf":$("#_csrf").val(),
			"positionId":$("#positionId2").val(),
			"authorityIds":$("#authorityIds2").val()}, //要提交的数据是一个JSON
		type:"POST", //提交方式
		dataType:"json", //返回数据的类型
		//TEXT字符串 JSON返回JSON XML返回XML
		success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
			clearForm("#ff2");
			$('#w2').window('close');
			if(data==0){
				alert('修改成功');
			}else{
				alert('修改失败');
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert('操作失败!');
		}
	});
})

$("#deleteAuthority").click(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/authorityManager/deleteAuthority", //处理页面的路径
		async:false,
		data:{
			"_csrf":$("#_csrf").val(),
			"positionId":$("#positionIdForDelete3").val(),
			"authorityIds":$("#authorityIdsForDelete3").val()}, //要提交的数据是一个JSON
		type:"POST", //提交方式
		dataType:"json", //返回数据的类型
		//TEXT字符串 JSON返回JSON XML返回XML
		success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
			resetForm();
			$('#w3').window('close');
			if(data==0){
				alert('修改成功');
			}else{
				alert('修改失败');
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert('操作失败!');
		}
	});
})

function clearForm(formName){
	$(formName).form('clear');
}

function getAuthorities(){
	var val = $("#positionIdForDelete3").val();
	$("#positionIdForDelete3").combobox('disable');
	$('#authorityIdsForDelete3').combobox('enable');
	$('#authorityIdsForDelete3').combobox({
		disabled:false,
		url:'${pageContext.request.contextPath}/info/nameAuthorityByPositionIdInfo?positionId='+val,
		method:'get',
		valueField:'id',
		textField:'naRemark',
		multiple:true,
		multiline:true,
		panelHeight:'300px'
    });
}
function resetForm(){
	$("#ff3").form('clear');
	$('#authorityIdsForDelete3').combobox('disable');
	$("#positionIdForDelete3").combobox('enable');
}

/* var tableToExcel = (function() {
	var uri = 'data:application/vnd.ms-excel;base64,', 
	template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
	base64 = function(s) {
		return window.btoa(unescape(encodeURIComponent(s)))
	},
	format = function(s, c) {
		return s.replace(/{(\w+)}/g, function(m, p) {
			return c[p];
		})
	}
	return function(table, name) {
		if (!table.nodeType)
			table = document.getElementById(table)
		var ctx = {
			worksheet : name || 'Worksheet',
			table : table.innerHTML
		}
		window.location.href = uri + base64(format(template, ctx))
		}
	})() */
</script>
</body>
</html>