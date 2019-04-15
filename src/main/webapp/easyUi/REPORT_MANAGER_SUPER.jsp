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
<h2>报表管理(超级管理员)</h2>
<div style="margin:20px 0;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w7').window('open')">查询员工信息</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w8').window('open')">查询客户信息</a>
</div>

<div id="w7" class="easyui-window" title="查询员工信息" style="width:530px;height:500px;padding:10px;" data-options="modal:true,closed:true">
	<input class="easyui-searchbox" data-options="prompt:'查询条件',searcher:doSearchEmployee" style="width:300px;"></input>
	<div style="padding: 0">
	<form id="ff7" method="post" style="padding:10px">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
		<table id="employeeExcel7" class="easyui-datagrid"
			title="查询员工"
			style="width: 480px; height: 320px;"
			data-options="
			selectOnCheck:true,
			checkOnSelect:true,
			singleSelect:false,
			collapsible:true,
			url:'#',
			method:'post'">
			<thead>
				<tr>
					<th data-options="field:'id',width:50,align:'center'">员工id</th>
					<th data-options="field:'employeeName',width:60,align:'center'">姓名</th>
					<th data-options="field:'employeePositionName',width:100,align:'center'">职位</th>
					<th data-options="field:'employeeCellphone',width:100,align:'center'">手机号</th>
					<th data-options="field:'employeeTelephone',width:100,align:'center'">工作号</th>
					<th data-options="field:'employeeStatus',width:50,align:'center',
						formatter:function(value,row){
										var test;
										switch (value){
											case 0:
												test = '在职';
												break;
											case 1:
												test = '离职';
												break;
											default:
												test = '--';
										}
											return test;
									}">状态</th>	
				</tr>
			</thead>
		</table>
	</form>
	</div>
</div>

<div id="w8" class="easyui-window" title="查询客户信息" style="width:1130px;height:500px;padding:10px;" data-options="modal:true,closed:true">
	<input class="easyui-searchbox" data-options="prompt:'查询条件',searcher:doSearchCustomer" style="width:300px"></input>
	<div style="padding: 0">
	<form id="ff8" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
		<table id="customerExcel8" class="easyui-datagrid"
			title="查询客户信息"
			style="width: 1100px; height: 250px"
			data-options="
			selectOnCheck:true,
			checkOnSelect:true,
			singleSelect:false,
			collapsible:true,
			url:'#',
			method:'post'">
			<thead>
				<tr>
					<th data-options="field:'id',width:60,align:'center'">客户ID</th>
					<th data-options="field:'customerName',width:80,align:'center'">客户名</th>
					<th data-options="field:'educationalLevel',width:60,align:'center'">学历</th>
					<th data-options="field:'customerTelephone',width:130,align:'center'">手机号</th>
					<th data-options="field:'qq',width:130,align:'center'">qq</th>
					<th data-options="field:'customerEmail',width:160,align:'center'">邮箱</th>
					<th data-options="field:'custmerStatusCustomerId',width:80,align:'center',
					formatter:function(value,row){
 						var test0;
 						switch(value)
						{
						case 1:
						   test = '新增';
						  break;
						case 2:
						  test = '紧跟';
						  break;
					    case 3:
						  test = '已报名';
						  break;
					    case 4:
						  test = '死单';
						  break;
					    case 5:
						  test = '报名后退费';
						  break;
				   		case 6:
						  test = '上门';
						  break;
						default:
						  break;
						}
 						return test;}">客户状态</th>
					<th data-options="field:'createTime',width:150,align:'center'">创建时间</th>
					<th data-options="field:'customerRemark',width:200,align:'center'">备注</th>
				</tr>
			</thead>
		</table>
	</form>
	</div>
</div>
<script>
	function doSearchEmployee(value){
		$('#employeeExcel7').datagrid({
			selectOnCheck:true,
			checkOnSelect:true,
			singleSelect:false,
			collapsible:true,
			url:'${pageContext.request.contextPath}/workspace/reportManagerSuper/selectEmployeeByCondition?condition='+value,
			method:'get'
	    });
	}
	function doSearchCustomer(value){
		$('#customerExcel8').datagrid({
			selectOnCheck:true,
			checkOnSelect:true,
			singleSelect:false,
			collapsible:true,
			url:'${pageContext.request.contextPath}/workspace/reportManagerSuper/selectCustomerByCondition?condition='+value,
			method:'get'
	    });
	}
</script>
</body>
</html>