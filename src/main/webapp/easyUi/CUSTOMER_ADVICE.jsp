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
<h2>客户咨询</h2>
<div style="margin:20px 0;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w12').window('open')">客户咨询</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w13').window('open')">客户跟踪</a>
</div>
<div id="w12" class="easyui-window" title="客户咨询" style="width:920px;height:500px;padding:10px;" data-options="modal:true,closed:true">
	<table id="customerAdviceExcel12" class="easyui-datagrid" title="客户咨询"
		style="width: 880px; height: 450px"
		data-options="
			iconCls: 'icon-edit',
			singleSelect: true,
			toolbar: '#tb',
			url: '${pageContext.request.contextPath}/workspace/customerAdvice/selectVisitingCustomers',
			method: 'get',
			onClickRow: onClickRow">
		<thead>
			<tr>
				<th data-options="field:'id',width:50,align:'center'">用户ID</th>
				<th data-options="field:'customerName',width:80,align:'center'">用户姓名</th>
				<th data-options="field:'educationalLevel',width:60,align:'center'">学历</th>
				<th data-options="field:'customerTelephone',width:110,align:'center'">手机号</th>
				<th data-options="field:'qq',width:120,align:'center'">qq</th>
				<th data-options="field:'customerEmail',width:140,align:'center'">邮箱</th>
				<th data-options="field:'custmerStatusCustomerId',width:100,align:'center',
					formatter:function(value,row){
 							return '上门';}">状态</th>
				<th data-options="field:'createTime',width:120,align:'center'">创建时间</th>
				<th data-options="field:'customerRemark',width:100,align:'center',editor:'textbox'">备注</th>
			</tr>
		</thead>
	</table>

	<div id="tb" style="height: auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="accept()">修改备注</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="reject()">撤销更改</a>
		<a id="addCustomerDevelopment" class="easyui-linkbutton" data-options="iconCls:'icon-add'">选择跟踪</a>
	</div>
</div>

<div id="w13" class="easyui-window" title="客户跟踪" style="width:920px;height:500px;padding:10px;" data-options="modal:true,closed:true">
	<table id="customerFollowingExcel13" class="easyui-datagrid" title="客户跟踪"
		style="width: 880px; height: 450px"
		data-options="
			iconCls: 'icon-edit',
			singleSelect: true,
			toolbar: '#tb0',
			url: '${pageContext.request.contextPath}/workspace/customerAdvice/selectCustomerFollowingInfo?accountName='+username,
			method: 'get',
			onClickRow: onClickRow0">
		<thead>
			<tr>
				<th data-options="field:'customerId',width:50,align:'center'">客户ID</th>
				<th data-options="field:'customerName',width:80,align:'center'">用户姓名</th>
				<th data-options="field:'customerTelephone',width:110,align:'center'">手机号</th>
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
				<th data-options="field:'allocationTime',width:160,align:'center'">分配时间</th>
				<th data-options="field:'nextContactTime',width:160,align:'center',
					editor:{
						type:'datetimebox'
					}">下次联系时间</th>
				<th data-options="field:'customerRemark',width:100,align:'center',editor:'textbox'">备注</th>
			</tr>
		</thead>
	</table>
	<div id="tb0" style="height: auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="accept0()">修改备注</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="reject0()">撤销更改</a>
	</div>
</div>
<script>
$("#addCustomerDevelopment").click(function(){
	var username = "${username}";
	var row = $('#customerAdviceExcel12').datagrid('getSelected');
	var customerId = row.id;
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/customerAdvice/addCustomerDevelopment", //处理页面的路径
		async:false,
		data:{
			"customerId":customerId,
			"accountName":username},//要提交的数据是一个JSON
		type:"POST", //提交方式
		dataType:"json", //返回数据的类型
		//TEXT字符串 JSON返回JSON XML返回XML
		success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
			if(data==0){
				alert('添加成功');
			}else{
				alert('添加失败')
			}
			$('#w12').window('close');
			window.parent.tabsClose();
			top.location.reload();
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert('操作失败!');
		}
	});
})

var editIndex = undefined;
function endEditing(){
	if (editIndex == undefined){return true}
	if ($('#customerAdviceExcel12').datagrid('validateRow', editIndex)){
		$('#customerAdviceExcel12').datagrid('endEdit', editIndex);
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
			$('#customerAdviceExcel12').datagrid('selectRow', index)
					.datagrid('beginEdit', index);
			editIndex = index;
		} else {
			$('#customerAdviceExcel12').datagrid('selectRow', editIndex);
		}
	}
}
function accept(){
		$('#customerAdviceExcel12').datagrid('acceptChanges');
		var selectRow = $('#customerAdviceExcel12').datagrid('getSelected');
		var customerId = selectRow.id;
		var remark = selectRow.customerRemark;
		$.ajax({
			url:"${pageContext.request.contextPath}/workspace/customerAdvice/alterCustomer",
			async:true,
			data:{"customerId":customerId,
				"remark":remark},
			dataType:"json",
			type:"post",
			success:function(data){
				if(data==0){
					alert("修改成功");
				}else{
					alert("修改失败");
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert('操作失败!');
			}
		});
}
function reject(){
	$('#customerAdviceExcel12').datagrid('rejectChanges');
	editIndex = undefined;
}



var editIndex0 = undefined;
function endEditing0(){
	if (editIndex0 == undefined){return true}
	if ($('#customerFollowingExcel13').datagrid('validateRow', editIndex0)){
		$('#customerFollowingExcel13').datagrid('endEdit', editIndex0);
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
			$('#customerFollowingExcel13').datagrid('selectRow', index)
					.datagrid('beginEdit', index);
			editIndex0 = index;
		} else {
			$('#customerFollowingExcel13').datagrid('selectRow', editIndex0);
		}
	}
}
function accept0(){
		$('#customerFollowingExcel13').datagrid('acceptChanges');
		var selectRow = $('#customerFollowingExcel13').datagrid('getSelected');
		var customerId = selectRow.customerId;
		var custmerStatusCustomerId = selectRow.custmerStatusCustomerId;
		var customerRemark = selectRow.customerRemark;
		
		var cdId = selectRow.cdId;
		var nextContactTime = selectRow.nextContactTime;
		
		$.ajax({
			url:"${pageContext.request.contextPath}/workspace/customerAdvice/alterCustomerFollowInfo",
			async:true,
			data:{"customerId":customerId,
				"custmerStatusCustomerId":custmerStatusCustomerId,
				"customerRemark":customerRemark,
				"cdId":cdId,
				"nextContactTime":nextContactTime},
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
				alert('操作失败!');
			}
		});
}
function reject0(){
	$('#customerFollowingExcel13').datagrid('rejectChanges');
	editIndex0 = undefined;
}
</script>

</body>
</html>