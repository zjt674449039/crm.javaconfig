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
<h2>部门管理</h2>
<div style="margin:20px 0;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w15').window('open')">员工信息表</a>
</div>

<div id="w15" class="easyui-window" title="员工信息表" style="width:670px;height:300px;padding:5px;" data-options="modal:true,closed:true">
	<table id="countDataCounselor" class="easyui-datagrid" title="员工信息表"
		style="width: 640px; height: 250px"
		data-options="
			iconCls: 'icon-edit',
			singleSelect: true,
			toolbar: '#cdc',
			url: '${pageContext.request.contextPath}/workspace/departmentManager?accountName='+username,
			method: 'post'">
		<thead>
			<tr>
				<th data-options="field:'id',width:80,align:'center'">员工Id</th>
				<th data-options="field:'employeeName',width:80,align:'center'">员工姓名</th>
				<th data-options="field:'employeePositionName',width:120,align:'center'">职位</th>
				<th data-options="field:'employeeCellphone',width:100,align:'center'">手机</th>
				<th data-options="field:'employeeTelephone',width:100,align:'center'">办公电话</th>
				<th data-options="field:'employeeStatus',width:180,align:'center',
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

	<div id="cdc" style="height: auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
					id="reflashCountDataCounselor">刷新信息</a>
	</div>
</div>
	
<script>
$("#reflashCountDataCounselor").click(function(){
	$("#countDataCounselor").datagrid({
		iconCls: 'icon-edit',
		singleSelect: true,
		toolbar: '#cdc',
		url: '${pageContext.request.contextPath}/workspace/departmentManager?accountName='+username,
		method: 'post'
	});
	
})
</script>
</body>
</html>