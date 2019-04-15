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
	<h2>报表管理(助理)</h2>
	<form action="#" method="post">
		<input type="button" value="客户开发表导出" id="exportCustomerDevelopment0Excel" class="easyui-linkbutton">
	</form>
<script>
$("#exportCustomerDevelopment0Excel").click(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/workspace/reportManagerInternetCounselor?accountName="+username,
		dataType:"json",
		success:function(data){
			alert('导出成功');
			JSONToExcelConvertor(data.datas, "customerDevelopment0", data.title);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert('操作失败!');
		}	
	})
})

function JSONToExcelConvertor(JSONData, FileName, ShowLabel) {
	//先转化json
	var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData)
			: JSONData;
	var excel = '<table>';
	//设置表头
	var row = "<tr>";
	for (var i = 0, l = ShowLabel.length; i < l; i++) {
		row += "<td>" + ShowLabel[i].value + '</td>';
	}
	//换行
	excel += row + "</tr>";
	//设置数据
	for (var i = 0; i < arrData.length; i++) {
		var row = "<tr>";
		for ( var index in arrData[i]) {
			var value = arrData[i][index].value === "." ? ""
					: arrData[i][index].value;
			row += '<td>' + value + '</td>';
		}
		excel += row + "</tr>";
	}
	excel += "</table>";
	var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
	excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';
	excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel';
        excelFile += '; charset=UTF-8">';
	excelFile += "<head>";
	excelFile += "<!--[if gte mso 9]>";
	excelFile += "<xml>";
	excelFile += "<x:ExcelWorkbook>";
	excelFile += "<x:ExcelWorksheets>";
	excelFile += "<x:ExcelWorksheet>";
	excelFile += "<x:Name>";
	excelFile += "{worksheet}";
	excelFile += "</x:Name>";
	excelFile += "<x:WorksheetOptions>";
	excelFile += "<x:DisplayGridlines/>";
	excelFile += "</x:WorksheetOptions>";
	excelFile += "</x:ExcelWorksheet>";
	excelFile += "</x:ExcelWorksheets>";
	excelFile += "</x:ExcelWorkbook>";
	excelFile += "</xml>";
	excelFile += "<![endif]-->";
	excelFile += "</head>";
	excelFile += "<body>";
	excelFile += excel;
	excelFile += "</body>";
	excelFile += "</html>";
	var uri = 'data:application/vnd.ms-excel;charset=utf-8,'
			+ encodeURIComponent(excelFile);
	var link = document.createElement("a");
	link.href = uri;
	link.style = "visibility:hidden";
	link.download = FileName + ".xls";
	document.body.appendChild(link);
	link.click();
	document.body.removeChild(link);
}

</script>
</body>
</html>