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
<h2>客户资料</h2>
<div style="margin:20px 0;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w16').window('open')">添加客户信息</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w17').window('open')">修改客户信息</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w18').window('open')">分配客户</a>
</div>
<div id="w16" class="easyui-window" title="添加客户信息" style="width:530px;height:550px;padding:10px;" data-options="modal:true,closed:true">
	<div style="padding: 10px 60px 20px 60px">
		<form id="ff16" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
		<table cellpadding="12">
			<tr>
				<td>客户名:</td>
				<td>
				<input class="easyui-textbox" type="text" id="customerName16"/>
				</td>
			</tr>
			<tr>
				<td>学历:</td>
				<td>
				<input class="easyui-textbox" type="text" id="educationalLevel16"/>
				</td>
			</tr>
			<tr>
				<td>电话号:</td>
				<td>
				<input class="easyui-textbox" type="text" id="customerTelephone16"/>
				</td>
			</tr>
			<tr>
				<td>qq:</td>
				<td>
				<input class="easyui-textbox" type="text" id="qq16"/>
				</td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td>
				<input class="easyui-textbox" type="text" id="customerEmail16"/>
				</td>
			</tr>
			<tr>
				<td>状态:</td>
				<td>
					<input class="easyui-combobox" id="custmerStatusCustomerId16"
					data-options="
							url:'${pageContext.request.contextPath}/info/customerStatusOnNewBuilt',
							method:'get',
							valueField:'id',
							textField:'statusName',
							panelHeight:'100px'">
				</td>
			</tr>
			<tr>
				<td>备注:</td>
				<td>
				<input class="easyui-textbox" type="text" id="customerRemark16"/>
				</td>
			</tr>
		</table>
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				id="addCustomerInfo">添加客户信息</a> 
			<a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="clearForm('#ff9')">清除信息</a>
		</div>
	</div>
</div>

<div id="w17" class="easyui-window" title="修改客户信息" style="width:920px;height:500px;padding:10px;" data-options="modal:true,closed:true">
	<table id="alterCustomerInfoExcel17" class="easyui-datagrid" title="修改客户信息"
		style="width: 880px; height: 450px"
		data-options="
			iconCls: 'icon-edit',
			singleSelect: true,
			toolbar: '#tb0',
			url: '${pageContext.request.contextPath}/info/customerInfo',
			method: 'get',
			onClickRow: onClickRow0">
		<thead>
			<tr>
				<th data-options="field:'id',width:50,align:'center'">客户ID</th>
				<th data-options="field:'customerName',width:80,align:'center',editor:'textbox'">用户姓名</th>
				<th data-options="field:'educationalLevel',width:100,align:'center',editor:'textbox'">学历</th>
				<th data-options="field:'customerTelephone',width:110,align:'center'">手机号</th>
				<th data-options="field:'qq',width:100,align:'center',editor:'textbox',editor:'textbox'">qq</th>
				<th data-options="field:'customerEmail',width:100,align:'center',editor:'textbox',editor:'textbox'">邮箱</th>
				<th data-options="field:'custmerStatusCustomerId',width:100,
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
 						return test;},
					editor:{
						type:'combobox',
						options:{
							valueField:'id',
							textField:'statusName',
							method:'get',
							url:'${pageContext.request.contextPath}/info/statusCustomer',
							required:true}
					}">状态</th>
				<th data-options="field:'createTime',width:160,align:'center'">创建时间</th>
				<th data-options="field:'customerRemark',width:100,align:'center',editor:'textbox'">备注</th>
			</tr>
		</thead>
	</table>
	<div id="tb0" style="height: auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="accept0()">确认修改</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="reject0()">撤销更改</a>
	</div>
</div>

<div id="w18" class="easyui-window" title="分配客户" style="width:1020px;height:500px;padding:10px;" data-options="modal:true,closed:true">
	<table id="allocationForTmkExcel18" class="easyui-datagrid" title="tmk分配"
		style="width: 980px; height: 450px"
		data-options="
			iconCls: 'icon-edit',
			singleSelect: true,
			toolbar: '#tb',
			collapsible:true,
			collapsed:true,
			url: '${pageContext.request.contextPath}/info/customerForTmkInfo',
			method: 'get',
			onClickRow: onClickRow">
		<thead>
			<tr>
				<th data-options="field:'id',width:50,align:'center'">客户ID</th>
				<th data-options="field:'customerName',width:80,align:'center'">用户姓名</th>
				<th data-options="field:'educationalLevel',width:100,align:'center'">学历</th>
				<th data-options="field:'customerTelephone',width:110,align:'center'">手机号</th>
				<th data-options="field:'qq',width:100,align:'center'">qq</th>
				<th data-options="field:'customerEmail',width:100,align:'center'">邮箱</th>
				<th data-options="field:'custmerStatusCustomerId',width:60,
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
 						return test;}">状态</th>
				<th data-options="field:'createTime',width:130,align:'center'">创建时间</th>
				<th data-options="field:'customerRemark',width:100,align:'center'">备注</th>
				<th data-options="field:'employeeId',width:100,
					editor:{
						type:'combobox',
						options:{
							valueField:'id',
							textField:'employeeName',
							method:'get',
							url:'${pageContext.request.contextPath}/info/tmkEmployee',
							required:true}
					}">tmk员工姓名</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="height: auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="accept()">确认分配</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="reject()">撤销更改</a>
	</div>
	
	<table id="allocationForCounselorExcel19" class="easyui-datagrid" title="咨询分配"
		style="width: 980px; height: 450px"
		data-options="
			iconCls: 'icon-edit',
			singleSelect: true,
			toolbar: '#tb1',
			collapsible:true,
			collapsed:true,
			url: '${pageContext.request.contextPath}/info/customerForCounselorInfo',
			method: 'get',
			onClickRow: onClickRow1">
		<thead>
			<tr>
				<th data-options="field:'id',width:50,align:'center'">客户ID</th>
				<th data-options="field:'customerName',width:80,align:'center'">用户姓名</th>
				<th data-options="field:'educationalLevel',width:100,align:'center'">学历</th>
				<th data-options="field:'customerTelephone',width:110,align:'center'">手机号</th>
				<th data-options="field:'qq',width:100,align:'center'">qq</th>
				<th data-options="field:'customerEmail',width:100,align:'center'">邮箱</th>
				<th data-options="field:'custmerStatusCustomerId',width:60,
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
 						return test;}">状态</th>
				<th data-options="field:'createTime',width:130,align:'center'">创建时间</th>
				<th data-options="field:'customerRemark',width:100,align:'center'">备注</th>
				<th data-options="field:'employeeId',width:100,
					editor:{
						type:'combobox',
						options:{
							valueField:'id',
							textField:'employeeName',
							method:'get',
							url:'${pageContext.request.contextPath}/info/counselorEmployee',
							required:true}
					}">咨询师员工姓名</th>
			</tr>
		</thead>
	</table>
	<div id="tb1" style="height: auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="accept1()">确认分配</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="reject1()">撤销更改</a>
	</div>
</div>
<script>
$("#addCustomerInfo").click(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/customerMaterial/addCustomerInfo", //处理页面的路径
		async:false,
		data:{
			"_csrf":$("#_csrf").val(),
			"customerName":$("#customerName16").val(),
			"educationalLevel":$("#educationalLevel16").val(),
			"customerTelephone":$("#customerTelephone16").val(),
			"qq":$("#qq16").val(),
			"customerEmail":$("#customerEmail16").val(),
			"custmerStatusCustomerId":$("#custmerStatusCustomerId16").val(),
			"customerRemark":$("#customerRemark16").val()},
			type:"POST", //提交方式
		dataType:"json", //返回数据的类型
		//TEXT字符串 JSON返回JSON XML返回XML
		success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
			clearForm("#ff16");
			$('#w16').window('close');
			if(data==0){
				alert('添加成功');
			}else{
				alert('添加失败!');
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert('添加失败!');
		}
	});
})

function clearForm(formName){
	$(formName).form('clear');
}

var editIndex0 = undefined;
function endEditing0(){
	if (editIndex0 == undefined){return true}
	if ($('#alterCustomerInfoExcel17').datagrid('validateRow', editIndex0)){
		$('#alterCustomerInfoExcel17').datagrid('endEdit', editIndex0);
		editIndex0 = undefined;
		reject0();
		return true;
	} else {
		return false;
	}
}
function onClickRow0(index){
	if (editIndex0 != index){
		if (endEditing0()){
			$('#alterCustomerInfoExcel17').datagrid('selectRow', index)
					.datagrid('beginEdit', index);
			editIndex0 = index;
		} else {
			$('#alterCustomerInfoExcel17').datagrid('selectRow', editIndex0);
		}
	}
}
function accept0(){
		$('#alterCustomerInfoExcel17').datagrid('acceptChanges');	
		var customer = $('#alterCustomerInfoExcel17').datagrid('getSelected');
		
		$.ajax({
			url:"${pageContext.request.contextPath}/workspace/customerMaterial/alterCustomerInfo",
			async:true,
			data:{"customerJson":JSON.stringify(customer)},
			dataType:"json",
			type:"post",
			success:function(data){
				if(data==0){
					alert("修改成功");
				}else{
					alert("修改失败");
				}
				window.location.reload();
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert('修改失败:`qq`号或者`状态`格式错误!');
				window.location.reload();
			}
		});
}
function reject0(){
	$('#alterCustomerInfoExcel17').datagrid('rejectChanges');
	editIndex0 = undefined;
}


var editIndex = undefined;
function endEditing(){
	if (editIndex == undefined){return true}
	if ($('#allocationForTmkExcel18').datagrid('validateRow', editIndex)){
		$('#allocationForTmkExcel18').datagrid('endEdit', editIndex);
		editIndex = undefined;
		reject();
		return true;
	} else {
		return false;
	}
}
function onClickRow(index){
	if (editIndex != index){
		if (endEditing()){
			$('#allocationForTmkExcel18').datagrid('selectRow', index)
					.datagrid('beginEdit', index);
			editIndex = index;
		} else {
			$('#allocationForTmkExcel18').datagrid('selectRow', editIndex);
		}
	}
}
function accept(){
		$('#allocationForTmkExcel18').datagrid('acceptChanges');
		var selectRow = $('#allocationForTmkExcel18').datagrid('getSelected');
		var customerId = selectRow.id;
		var employeeId = selectRow.employeeId;
		$.ajax({
			url:"${pageContext.request.contextPath}/workspace/customerMaterial/allotmentCustomerToTmk",
			async:true,
			data:{"customerId":customerId,
				"employeeId":employeeId},
			dataType:"json",
			type:"post",
			success:function(data){
				if(data==0){
					alert("修改成功");
				}else{
					alert("修改失败");
				}
				$('#w18').window('close');
				window.parent.tabsClose();
				top.location.reload();
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert('操作失败!');
			}
		});
}
function reject(){
	$('#allocationForTmkExcel18').datagrid('rejectChanges');
	editIndex = undefined;
}


var editIndex1 = undefined;
function endEditing1(){
	if (editIndex1 == undefined){return true}
	if ($('#allocationForCounselorExcel19').datagrid('validateRow', editIndex1)){
		$('#allocationForCounselorExcel19').datagrid('endEdit', editIndex1);
		editIndex1 = undefined;
		reject1();
		return true;
	} else {
		return false;
	}
}
function onClickRow1(index){
	if (editIndex1 != index){
		if (endEditing1()){
			$('#allocationForCounselorExcel19').datagrid('selectRow', index)
					.datagrid('beginEdit', index);
			editIndex1 = index;
		} else {
			$('#allocationForCounselorExcel19').datagrid('selectRow', editIndex1);
		}
	}
}
function accept1(){
		$('#allocationForCounselorExcel19').datagrid('acceptChanges');
		var selectRow = $('#allocationForCounselorExcel19').datagrid('getSelected');
		var customerId = selectRow.id;
		var employeeId = selectRow.employeeId;
		$.ajax({
			url:"${pageContext.request.contextPath}/workspace/customerMaterial/allotmentCustomerToCounselor",
			async:true,
			data:{"customerId":customerId,
				"employeeId":employeeId},
			dataType:"json",
			type:"post",
			success:function(data){
				if(data==0){
					alert("修改成功");
				}else{
					alert("修改失败");
				}
				$('#w19').window('close');
				window.parent.tabsClose();
				top.location.reload();
			}
		});
}
function reject1(){
	$('#allocationForCounselorExcel19').datagrid('rejectChanges');
	editIndex1 = undefined;
}
</script>
</body>
</html>