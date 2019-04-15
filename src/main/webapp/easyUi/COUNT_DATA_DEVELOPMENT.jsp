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
<h2>统计数据(开发)</h2>
<div style="margin:20px 0;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w23').window('open')">统计数据(开发)</a>
</div>
<div id="w23" class="easyui-window" title="统计数据(开发)" style="width:670px;height:300px;padding:5px;" data-options="modal:true,closed:true">
	<table id="countDataCounselor" class="easyui-datagrid" title="统计数据(开发)"
		style="width: 640px; height: 250px"
		data-options="
			iconCls: 'icon-edit',
			singleSelect: true,
			toolbar: '#cdc',
			url: '${pageContext.request.contextPath}/workspace/countDataDevelopment?accountName='+username,
			method: 'post'">
		<thead>
			<tr>
				<th data-options="field:'employeeId',width:80,align:'center'">员工Id</th>
				<th data-options="field:'employeeName',width:80,align:'center'">员工姓名</th>
				<th data-options="field:'newCount',width:80,align:'center'">新增客户数</th>
				<th data-options="field:'followingCount',width:80,align:'center'">紧跟客户数</th>
				<th data-options="field:'signedCount',width:100,align:'center'">已报名客户数</th>
				<th data-options="field:'deadCount',width:80,align:'center'">死单客户数</th>
				<th data-options="field:'paybackCount',width:80,align:'center'">报名后退费</th>
				<th data-options="field:'totalCount',width:60,align:'center'">总分配</th>
			</tr>
		</thead>
	</table>

	<div id="cdc" style="height: auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
					id="reflashCountDataCounselor">刷新信息</a>
	</div>
</div>
<script type="text/javascript">
$("#reflashCountDataCounselor").click(function(){
	$("#countDataCounselor").datagrid({
		iconCls: 'icon-edit',
		singleSelect: true,
		toolbar: '#cdc',
		url: '${pageContext.request.contextPath}/workspace/countDataDevelopment?accountName='+username,
		method: 'post'
	});
	
})
</script>
</body>
</html>