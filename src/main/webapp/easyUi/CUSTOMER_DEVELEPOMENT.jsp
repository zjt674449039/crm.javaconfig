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
<h2>客户开发(查修)</h2>
<div style="margin:20px 0;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w21').window('open')">添加客户信息</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w22').window('open')">查看\修改客户开发信息</a>
</div>

<div id="w21" class="easyui-window" title="添加客户信息" style="width:530px;height:550px;padding:10px;" data-options="modal:true,closed:true">
	<div style="padding: 10px 60px 20px 60px">
		<form id="ff21" method="post">
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
				class="easyui-linkbutton" onclick="clearForm('#ff21')">清除信息</a>
		</div>
	</div>
</div>

<div id="w22" class="easyui-window" title="查看\修改客户开发信息" style="width:920px;height:500px;padding:10px;" data-options="modal:true,closed:true">
	<table id="customerDevelopmentBeforeExcel21" class="easyui-datagrid" title="客户跟踪"
		style="width: 880px; height: 450px"
		data-options="
			iconCls: 'icon-edit',
			singleSelect: true,
			toolbar: '#tb',
			url: '${pageContext.request.contextPath}/workspace/customerDevelepomentSelect/selectCustomerFollowingInfo?accountName='+username,
			method: 'get',
			onClickRow: onClickRow">
		<thead>
			<tr>
				<th data-options="field:'customerId',width:50,align:'center'">客户ID</th>
				<th data-options="field:'customerName',width:80,align:'center',editor:'textbox'">用户姓名</th>
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
	<div id="tb" style="height: auto">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="accept()">修改备注</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="reject()">撤销更改</a>
	</div>
</div>
<script>
$("#addCustomerInfo").click(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/customerDevelepomentSelect/addCustomerInfoByAccountName", //处理页面的路径
		async:false,
		data:{
			"_csrf":$("#_csrf").val(),
			"customerName":$("#customerName16").val(),
			"educationalLevel":$("#educationalLevel16").val(),
			"customerTelephone":$("#customerTelephone16").val(),
			"qq":$("#qq16").val(),
			"customerEmail":$("#customerEmail16").val(),
			"custmerStatusCustomerId":$("#custmerStatusCustomerId16").val(),
			"customerRemark":$("#customerRemark16").val(),
			"accountName":username},
			type:"POST", //提交方式
		dataType:"json", //返回数据的类型
		//TEXT字符串 JSON返回JSON XML返回XML
		success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
			clearForm("#ff21");
			$('#w21').window('close');
			if(data==0){
				alert('添加成功');
			}else{
				alert('添加失败!');
			}
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert('添加失败:数据格式不正确!');
		}
	});
})

function clearForm(formName){
	$(formName).form('clear');
}

var editIndex = undefined;
function endEditing(){
	if (editIndex == undefined){return true}
	if ($('#customerDevelopmentBeforeExcel21').datagrid('validateRow', editIndex)){
		$('#customerDevelopmentBeforeExcel21').datagrid('endEdit', editIndex);
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
			$('#customerDevelopmentBeforeExcel21').datagrid('selectRow', index)
					.datagrid('beginEdit', index);
			editIndex = index;
		} else {
			$('#customerDevelopmentBeforeExcel21').datagrid('selectRow', editIndex);
		}
	}
}
function accept(){
		$('#customerDevelopmentBeforeExcel21').datagrid('acceptChanges');
		var selectRow = $('#customerDevelopmentBeforeExcel21').datagrid('getSelected');
		var customerId = selectRow.customerId;
		var customerName = selectRow.customerName;
		var custmerStatusCustomerId = selectRow.custmerStatusCustomerId;
		var nextContactTime = selectRow.nextContactTime;
		var remark = selectRow.customerRemark;
		var cdId = selectRow.cdId;
		$.ajax({
			url:"${pageContext.request.contextPath}/workspace/customerDevelepomentSelect/alterCustomerFollowInfo",
			async:true,
			data:{"customerId":customerId,
				"customerName":customerName,
				"custmerStatusCustomerId":custmerStatusCustomerId,
				"nextContactTime":nextContactTime,
				"remark":remark,
				"cdId":cdId},
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
	$('#customerDevelopmentBeforeExcel21').datagrid('rejectChanges');
	editIndex = undefined;
}

</script>

</body>
</html>