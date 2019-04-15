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
	<h2>账号管理(超级管理员)</h2>
	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w4').window('open')">增加管理员账号</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w5').window('open')">删除管理员账号</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w6').window('open')">查看所有用户</a>
	</div>
	<div id="w4" class="easyui-window" title="增加管理员账号" style="width:530px;height:500px;padding:10px;" data-options="modal:true,closed:true">
		<div style="padding: 10px 60px 20px 60px">
			<form id="ff4" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
			<table cellpadding="12">
				<tr>
					<td>用户名:</td>
					<td>
					<input class="easyui-textbox" type="text" name="username4" id="username4"/>
					</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td>
					<input class="easyui-textbox" type="password" name="password4" id="password4"/>
					</td>
				</tr>
				<tr>
					<td>昵称:</td>
					<td>
					<input class="easyui-textbox" type="text" name="nickName4" id="nickName4"/>
					</td>
				</tr>
				<tr>
					<td>员工名:</td>
					<td>
					<input class="easyui-textbox" type="text" name="employeeName4" id="employeeName4"/>
					</td>
				</tr>
				<tr>
					<td>员工手机号:</td>
					<td>
					<input class="easyui-textbox" type="text" name="employeeCellphone4" id="employeeCellphone4"/>
					</td>
				</tr>
				<tr>
					<td>员工座机号(工作):</td>
					<td>
					<input class="easyui-textbox" type="text" name="employeeTelephone4" id="employeeTelephone4"/>
					</td>
				</tr>
			</table>
			</form>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					id="addAdmin">添加管理员</a> 
				<a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="clearForm('#ff4')">清除信息</a>
			</div>
		</div>
	</div>
	
	<div id="w5" class="easyui-window" title="删除管理员账号" style="width:830px;height:500px;padding:10px;" data-options="modal:true,closed:true">
		<div style="padding: 0">
			<form id="ff5" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
				<table id="adminExcel5" class="easyui-datagrid"
					title="管理员账号信息"
					style="width: 800px; height: 250px"
					data-options="
					selectOnCheck:true,
					checkOnSelect:true,
					singleSelect:false,
					collapsible:true,
					url:'${pageContext.request.contextPath}/info/accountAndEmployeeInfo?type=管理员',
					method:'post'">
					<thead>
						<tr>
							<th data-options="field:'ck',checkbox:true"></th>
							<th data-options="field:'accountId',width:60,align:'center'">账号ID</th>
							<th data-options="field:'username',width:100,align:'center'">用户名</th>
							<th data-options="field:'password',width:100,align:'center'">密码</th>
							<th data-options="field:'nickName',width:60,align:'center'">昵称</th>
							<th data-options="field:'employeeId',width:50,align:'center'">员工id</th>
							<th data-options="field:'employeeName',width:60,align:'center'">姓名</th>
							<th data-options="field:'employeePositionName',width:80,align:'center'">职位</th>
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
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					id="deleteAdmin">删除管理员</a> 
				<a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="clearForm('#ff5')">清除信息</a>
			</div>
		</div>
	</div>
	
	<div id="w6" class="easyui-window" title="查看所有账号" style="width:830px;height:500px;padding:10px;" data-options="modal:true,closed:true">
		<div style="padding: 0">
			<form id="ff6" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
				<table id="adminExcel5" class="easyui-datagrid"
					title="查看所有账号"
					style="width: 800px; height: 250px"
					data-options="
					selectOnCheck:true,
					checkOnSelect:true,
					singleSelect:true,
					collapsible:true,
					url:'${pageContext.request.contextPath}/info/allAccountAndEmployeeInfo',
					method:'post'">
					<thead>
						<tr>
							<th data-options="field:'accountId',width:60,align:'center'">账号ID</th>
							<th data-options="field:'username',width:100,align:'center'">用户名</th>
							<th data-options="field:'password',width:100,align:'center'">密码</th>
							<th data-options="field:'nickName',width:60,align:'center'">昵称</th>
							<th data-options="field:'employeeId',width:50,align:'center'">员工id</th>
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

<script>
$("#addAdmin").click(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/accountManagerSuper/addAdmin", //处理页面的路径
		async:false,
		data:{
			"_csrf":$("#_csrf").val(),
			"username":$("#username4").val(),
			"password":$("#password4").val(),
			"nickName":$("#nickName4").val(),
			"employeeName":$("#employeeName4").val(),
			"employeeCellphone":$("#employeeCellphone4").val(),
			"employeeTelephone":$("#employeeTelephone4").val()},//要提交的数据是一个JSON
			type:"POST", //提交方式
		dataType:"json", //返回数据的类型
		//TEXT字符串 JSON返回JSON XML返回XML
		success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
			clearForm("#ff4");
			$('#w4').window('close');
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

$("#deleteAdmin").click(function(){
	var accountIds0 = new Array();
	var employeeIds0 = new Array();
	var rows = $('#adminExcel5').datagrid('getSelections');
	for(var i=0; i<rows.length; i++){
		accountIds0[i] = rows[i].accountId;
		employeeIds0[i] = rows[i].employeeId;
	}
	var accountIds = JSON.stringify(accountIds0);
	var employeeIds = JSON.stringify(employeeIds0);
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/accountManagerSuper/deleteAccount", //处理页面的路径
		async:false,
		data:{
			"_csrf":$("#_csrf").val(),
			"accountIds":accountIds,
			"employeeIds":employeeIds},//要提交的数据是一个JSON
			type:"POST", //提交方式
		dataType:"json", //返回数据的类型
		//contentType:"application/json",
		//TEXT字符串 JSON返回JSON XML返回XML
		success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
			clearForm("#ff5");
			$('#w5').window('close');
			if(data==0){
				alert('操作成功');
			}else{
				alert('操作失败');
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

</script>
	
</body>
</html>