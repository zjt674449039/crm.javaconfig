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
<sf:form action="workspace/authorityManager/deleteAuthority" method="POST">
	岗位编号1~9:<input type="text" name="positionId"/><br/>
	<p>权限编号</p>
	1:<input type="checkbox" name="authorityIds" value="1"><br/>
	2:<input type="checkbox" name="authorityIds" value="2"><br/>
	3:<input type="checkbox" name="authorityIds" value="3"><br/>
	4:<input type="checkbox" name="authorityIds" value="4"><br/>
	5:<input type="checkbox" name="authorityIds" value="5"><br/>
	6:<input type="checkbox" name="authorityIds" value="6"><br/>
	7:<input type="checkbox" name="authorityIds" value="7"><br/>
	8:<input type="checkbox" name="authorityIds" value="8"><br/>
	9:<input type="checkbox" name="authorityIds" value="9"><br/>
	10:<input type="checkbox" name="authorityIds" value="10"><br/>
	11:<input type="checkbox" name="authorityIds" value="11"><br/>
	12:<input type="checkbox" name="authorityIds" value="12"><br/>
	13:<input type="checkbox" name="authorityIds" value="13"><br/>
	14:<input type="checkbox" name="authorityIds" value="14"><br/>
	15:<input type="checkbox" name="authorityIds" value="15"><br/>
	<input type="submit" value="删除权限">
</sf:form>
${result}
</body>
</html>