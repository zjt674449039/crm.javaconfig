<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>定时跳转</title> 
</head>
<body>
	<p style="color:red">导入失败</p>
	<h3>3秒后跳转到meta_refresh.html页面，若没有跳转请点击<a href="/crm.javaconfig/">这里</a></h3>
	<% response.setHeader("refresh", "3;URL=/crm.javaconfig/"); %>
</body>
</html>