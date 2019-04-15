<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<sf:form action="workspace/accountManagerSuper/deleteAdmin" method="POST">
	<c:forEach var="account" items="${accounts}">
	<input type="checkbox" value="${account.id}" name="accountIds">
	username:<label>${account.username}</label>
	password:<label>${account.password}</label>
	nickName:<label>${account.nickName}</label>
	accountEmployeeId:
		<label>${account.accountEmployeeId}</label><br/>
	</c:forEach>
	<input type="submit" value="删除管理员账号">
</sf:form>
</body>
</html>