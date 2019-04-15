<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
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
<security:authentication property="principal.username" var="username"/>
<h2>账号管理(销售助理)</h2>
<div style="margin:20px 0;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w19').window('open')">销售员信息</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w20').window('open')">咨询师信息</a>
</div>
<div id="w19" class="easyui-window" title="电销员工信息" style="width:580px;height:500px;padding:10px;" data-options="modal:true,closed:true">
	<table id="tmkEmployeeExcel19" class="easyui-datagrid" title="电销员工信息"
		style="width: 550px; height: 450px"
		data-options="
			iconCls: 'icon-edit',
			singleSelect: true,
			url: '${pageContext.request.contextPath}/info/tmkEmployee',
			method: 'get'">
		<thead>
			<tr>
				<th data-options="field:'id',width:50,align:'center'">员工ID</th>
				<th data-options="field:'employeeName',width:80,align:'center'">姓名</th>
				<th data-options="field:'employeePositionName',width:100,align:'center'">职位</th>
				<th data-options="field:'employeeCellphone',width:110,align:'center'">手机</th>
				<th data-options="field:'employeeTelephone',width:120,align:'center'">办公电话号</th>
				<th data-options="field:'employeeStatus',width:70,align:'center',
					formatter:function(value,row){
 						var test;
 						switch(value)
						{
						case 0:
						   test = '在职';
						  break;
						case 1:
						  test = '离职';
						  break;
						default:
						  test = '--';
						  break;
						}
 						return test;}">在职状态</th>
			</tr>
		</thead>
	</table>
</div>

<div id="w20" class="easyui-window" title="咨询师信息" style="width:580px;height:500px;padding:10px;" data-options="modal:true,closed:true">
	<table id="counselorEmployeeExcel19" class="easyui-datagrid" title="咨询师信息"
		style="width: 550px; height: 450px"
		data-options="
			iconCls: 'icon-edit',
			singleSelect: true,
			url: '${pageContext.request.contextPath}/info/counselorEmployee',
			method: 'get'">
		<thead>
			<tr>
				<th data-options="field:'id',width:50,align:'center'">员工ID</th>
				<th data-options="field:'employeeName',width:80,align:'center'">姓名</th>
				<th data-options="field:'employeePositionName',width:100,align:'center'">职位</th>
				<th data-options="field:'employeeCellphone',width:110,align:'center'">手机</th>
				<th data-options="field:'employeeTelephone',width:120,align:'center'">办公电话号</th>
				<th data-options="field:'employeeStatus',width:70,align:'center',
					formatter:function(value,row){
 						var test;
 						switch(value)
						{
						case 0:
						   test = '在职';
						  break;
						case 1:
						  test = '离职';
						  break;
						default:
						  test = '--';
						  break;
						}
 						return test;}">在职状态</th>
			</tr>
		</thead>
	</table>
</div>

</body>
</html>