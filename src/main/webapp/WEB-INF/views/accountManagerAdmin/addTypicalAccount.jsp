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
<sf:form action="workspace/accountManagerAdmin/addTypicalAccount" method="POST" commandName="account">
	账户名:<input type="text" name="username"/>
	密码:<input type="text" name="password"/>
	昵称:<input type="text" name="nickName"/><br/>
	员工姓名:<input type="text" name="employeeName"/>
	员工职位:<input type="text" name="employeePositionName"/>
	员工手机号:<input type="text" name="employeeCellphone"/>
	员工工作电话(选填):<input type="text" name="employeeTelephone"/><br/>
	<input type="submit" value="增加普通员工账号">
</sf:form>
${result}
</body>
</html>