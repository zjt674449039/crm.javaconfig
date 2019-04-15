<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<button type="button" id="authorityManager">权限管理</button>
</div>
<div id="div0"></div>
<div id="mainDiv"></div>
<script type="text/javascript">
	$("#authorityManager").click(function(){
		var button1 = "<button type='button' id='selectAllAccounts'>查看所有用户信息</button>";
		var button2 = "<button type='button' id='button2' onclick='alert(2)'>测试2</button>";
		var button3 = "<button type='button' id='button3' onclick='alert(3)'>测试3</button>";
		var buttons = button1 + button2 + button3;
		$("#mainDiv").html(buttons);
	});

	$("#selectAllAccounts").click(function(){
		$.ajax({
			url:"workspace/accountManagerSuper/selectAllAccounts", //处理页面的路径
			async:false,
			data:{"key":"value"}, //要提交的数据是一个JSON
			type:"GET", //提交方式
			dataType:"html", //返回数据的类型
			//TEXT字符串 JSON返回JSON XML返回XML
			success:function(data){ //回调函数 ,成功时返回的数据存在形参data里
				alert(5);
				$("#div0").html(data);
			}
		});
	})
</script>