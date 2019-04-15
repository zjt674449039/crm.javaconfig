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
<body class="easyui-layout">
<div data-options="region:'north'" style="height:50px">
	欢迎:<security:authentication property="principal.username"/>
	<security:authentication property="principal.username" var="username"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="_csrf">
	<a href="/crm.javaconfig/logout">注销</a>
</div>
<div data-options="region:'south',split:true" style="height:50px;">
	<h3 style="algin:center">页脚</h3>
</div>
<div data-options="region:'west',split:true" title="功能区" style="width:300px;">
	<div class="easyui-accordion" data-options="fit:false,border:false" style="padding:10px 20px">
		<div title="我的crm" style="text-align:center" id="myAuthorities">
		</div>
	</div>
	<div class="easyui-calendar" style="width:250px;height:250px;margin:20px"></div>
</div>

<div id="tt" class="easyui-tabs" data-options="region:'center'" style="width:700px;height:250px"></div>
	
<script type="text/javascript">
function addPanel(authorityName,url){
	if ($('#tt').tabs('exists', authorityName)) {
		$('#tt').tabs('select', authorityName)
	} else {
		$('#tt').tabs('add',{
			title: authorityName,
			href : url,
			closable: true
		});
	}
}

var username="${username}";
$.ajax({
	url:"${pageContext.request.contextPath}/login/selectUserInfo", //处理页面的路径
	async:false,
	data:{"_csrf":$("#_csrf").val(),"username":username},
	type:"POST", //提交方式
	dataType:"json", //返回数据的类型
	//TEXT字符串 JSON返回JSON XML返回XML
	success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
		var authorities = data;
		var s = "";
		for(var i=0;i<authorities.length;i++){
			s += "<a href='javascript:void(0)' class='easyui-linkbutton' plain='false' onclick=\"addPanel(\'"+ authorities[i].naRemark+"','"+ authorities[i].naName+ ".jsp')\" style='width: 236px; height: 50px' >"+authorities[i].naRemark+"</a>";
		}
		$("#myAuthorities").append(s);
	},
	error:function(XMLHttpRequest, textStatus, errorThrown){
		alert('操作失败!');
	}
});


function tabsClose(){
	var tab=$('#tt').tabs('getSelected');//获取当前选中tabs
	var index = $('#tt').tabs('getTabIndex',tab);//获取当前选中tabs的index
	$('#tt').tabs('close',index);//关闭对应index的tabs
}
</script>
</body>
</html>