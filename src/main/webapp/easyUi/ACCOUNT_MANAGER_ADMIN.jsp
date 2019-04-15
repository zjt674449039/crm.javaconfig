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
	<h2>账号管理(管理员)</h2>
	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w9').window('open')">增加普通账号</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w10').window('open')">删除普通账号</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w11').window('open')">重置用户密码</a>
	</div>
	<div id="w9" class="easyui-window" title="增加普通账号" style="width:530px;height:550px;padding:10px;" data-options="modal:true,closed:true">
		<div style="padding: 10px 60px 20px 60px">
			<form id="ff9" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
			<table cellpadding="12">
				<tr>
					<td>用户名:</td>
					<td>
					<input class="easyui-textbox" type="text" id="username9"/>
					</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td>
					<input class="easyui-textbox" type="password" id="password9"/>
					</td>
				</tr>
				<tr>
					<td>昵称:</td>
					<td>
					<input class="easyui-textbox" type="text" id="nickName9"/>
					</td>
				</tr>
				<tr>
					<td>员工名:</td>
					<td>
					<input class="easyui-textbox" type="text" id="employeeName9"/>
					</td>
				</tr>
				<tr>
					<td>职位:</td>
					<td>
						<input class="easyui-combobox" id="positionName9" name="positionName9"
						data-options="
								url:'${pageContext.request.contextPath}/info/positionInfoUnAdmin',
								method:'get',
								valueField:'positionName',
								textField:'positionName',
								panelHeight:'300px'">
					</td>
				</tr>
				<tr>
					<td>员工手机号:</td>
					<td>
					<input class="easyui-textbox" type="text" id="employeeCellphone9"/>
					</td>
				</tr>
				<tr>
					<td>员工座机号(工作):</td>
					<td>
					<input class="easyui-textbox" type="text" id="employeeTelephone9"/>
					</td>
				</tr>
			</table>
			</form>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					id="addTypicalAccount">增加普通账号</a> 
				<a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="clearForm('#ff9')">清除信息</a>
			</div>
		</div>
	</div>
	
	<div id="w10" class="easyui-window" title="删除普通账号" style="width:860px;height:500px;padding:10px;" data-options="modal:true,closed:true">
		<div style="padding: 0">
			<form id="ff10" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
				<table id="deleteTypicalAccountExcel10" class="easyui-datagrid"
					title="普通账号信息"
					style="width: 830px; height: 250px"
					data-options="
					selectOnCheck:true,
					checkOnSelect:true,
					singleSelect:false,
					collapsible:true,
					url:'${pageContext.request.contextPath}/info/accountAndEmployeeInfoUnAdmin',
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
							<th data-options="field:'employeePositionName',width:120,align:'center'">职位</th>
							<th data-options="field:'employeeCellphone',width:100,align:'center'">手机号</th>
							<th data-options="field:'employeeTelephone',width:100,align:'center'">工作号</th>
							<th data-options="field:'employeeStatus',width:50,align:'center'">状态</th>	
						</tr>
					</thead>
				</table>
			</form>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					id="deleteTypicalAccount">删除普通账户</a> 
				<a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="clearForm('#ff10')">清除信息</a>
			</div>
		</div>
	</div>

	<div id="w11" class="easyui-window" title="重置用户密码" style="width:860px;height:500px;padding:10px;" data-options="modal:true,closed:true">
		<div style="padding: 0">
			<form id="ff11" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
				<table id="resetPasswordExcel11" class="easyui-datagrid"
					title="重置用户密码"
					style="width: 830px; height: 250px"
					data-options="
					selectOnCheck:true,
					checkOnSelect:true,
					singleSelect:true,
					collapsible:true,
					url:'${pageContext.request.contextPath}/info/accountAndEmployeeInfoUnAdmin',
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
							<th data-options="field:'employeePositionName',width:120,align:'center'">职位</th>
							<th data-options="field:'employeeCellphone',width:100,align:'center'">手机号</th>
							<th data-options="field:'employeeTelephone',width:100,align:'center'">工作号</th>
							<th data-options="field:'employeeStatus',width:50,align:'center'">状态</th>	
						</tr>
					</thead>
				</table>
			</form>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					id="resetPassword">重置用户密码</a> 
				<a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="clearForm('#ff11')">清除信息</a>
			</div>
		</div>
	</div>	
<script>
$("#addTypicalAccount").click(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/accountManagerAdmin/addTypicalAccount", //处理页面的路径
		async:false,
		data:{
			"_csrf":$("#_csrf").val(),
			"username":$("#username9").val(),
			"password":$("#password9").val(),
			"nickName":$("#nickName9").val(),
			"employeeName":$("#employeeName9").val(),
			"employeePositionName":$("#positionName9").val(),
			"employeeCellphone":$("#employeeCellphone9").val(),
			"employeeTelephone":$("#employeeTelephone9").val()},//要提交的数据是一个JSON
			type:"POST", //提交方式
		dataType:"json", //返回数据的类型
		//TEXT字符串 JSON返回JSON XML返回XML
		success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
			clearForm("#ff9");
			$('#w9').window('close');
			if(data==0){
				alert('添加成功');
			}else{
				alert('添加失败:用户名重复!');
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert('添加失败:用户名重复!');
		}
	});
})

$("#deleteTypicalAccount").click(function(){
	var accountIds0 = new Array();
	var employeeIds0 = new Array();
	var rows = $('#deleteTypicalAccountExcel10').datagrid('getSelections');
	for(var i=0; i<rows.length; i++){
		accountIds0[i] = rows[i].accountId;
		employeeIds0[i] = rows[i].employeeId;
	}
	var accountIds = JSON.stringify(accountIds0);
	var employeeIds = JSON.stringify(employeeIds0);
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/accountManagerAdmin/deleteTypicalAccount", //处理页面的路径
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
			clearForm("#ff10");
			$('#w10').window('close');
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

$("#resetPassword").click(function(){
	var row = $('#resetPasswordExcel11').datagrid('getSelected');
	var accountId = row.accountId;
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/accountManagerAdmin/resetAccountPassword", //处理页面的路径
		async:false,
		data:{
			"_csrf":$("#_csrf").val(),
			"accountId":accountId},
			type:"POST", //提交方式
		dataType:"json", //返回数据的类型
		success:function(data){
			clearForm("#ff11");
			$('#w11').window('close');
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