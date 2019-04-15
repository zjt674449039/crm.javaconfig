<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.1.0.min.js" type="text/javascript"></script>
</head>
<body>
	<h1>workspace页面</h1>
	<security:authorize access="isAuthenticated()">
		欢迎:<security:authentication property="principal.username" /><br>
		你的权限:<security:authentication property="principal.authorities" /><br>
	</security:authorize>
	<security:authorize access="hasRole('AUTHORITY_MANAGER')">
		<%@ include file="accountManagerSuper/accountManagerSuper.jsp"%>
		<br/>
	</security:authorize>
	<security:authorize access="hasRole('ACCOUNT_MANAGER_SUPER')">
		ff<br/>
	</security:authorize>
	<security:authorize access="hasRole('REPORT_MANAGER_SUPER')">
		REPORT_MANAGER_SUPER<br/>
	</security:authorize>
	<a href="/orm.javaconfig/logout">注销</a>
	
	
	
	
</body>
</html>