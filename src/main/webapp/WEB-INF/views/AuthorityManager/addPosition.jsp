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
<sf:form action="workspace/authorityManager/addPosition" method="POST" commandName="addPosition">
	positionName:<input type="text" name="positionName"/><br/>
	positionDepartmentId:<input type="text" name="positionDepartmentId"/><br/>
	1:<input type="checkbox" name="authorityNameAuthorityIds" value="1"><br/>
	2:<input type="checkbox" name="authorityNameAuthorityIds" value="2"><br/>
	3:<input type="checkbox" name="authorityNameAuthorityIds" value="3"><br/>
	4:<input type="checkbox" name="authorityNameAuthorityIds" value="4"><br/>
	5:<input type="checkbox" name="authorityNameAuthorityIds" value="5"><br/>
	6:<input type="checkbox" name="authorityNameAuthorityIds" value="6"><br/>
	7:<input type="checkbox" name="authorityNameAuthorityIds" value="7"><br/>
	8:<input type="checkbox" name="authorityNameAuthorityIds" value="8"><br/>
	9:<input type="checkbox" name="authorityNameAuthorityIds" value="9"><br/>
	10:<input type="checkbox" name="authorityNameAuthorityIds" value="10"><br/>
	11:<input type="checkbox" name="authorityNameAuthorityIds" value="11"><br/>
	12:<input type="checkbox" name="authorityNameAuthorityIds" value="12"><br/>
	13:<input type="checkbox" name="authorityNameAuthorityIds" value="13"><br/>
	14:<input type="checkbox" name="authorityNameAuthorityIds" value="14"><br/>
	15:<input type="checkbox" name="authorityNameAuthorityIds" value="15"><br/>
	<input type="submit" value="增加职位">
</sf:form>
${result}
</body>
</html>