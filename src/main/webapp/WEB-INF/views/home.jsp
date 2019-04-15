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
<p>这是首页</p>
<!-- <form action="login">
	用户名:<input type="text" name="username"/>
	密码<input type="password" name="password"/>
	<input type="submit" value="登陆"/>
</form> -->
<a href="workspace">登陆</a>
<a href="test">测试</a><br/>
<a href="addPosition">添加职位(绑定权限)</a>
<a href="alterAuthority">修改权限</a>
<a href="deleteAuthority">删除权限</a><br/>
<a href="addAdmin">添加管理员账号</a>
<a href="deleteAdmin">删除管理员账号</a>
<a href="selectAllAccounts">查看所有账号</a><br/>
<a href="selectEmployeeByCondition">按条件查询员工信息</a>
<a href="selectCustomerByCondition">按条件查询客户信息</a><br/>
<a href="addTypicalAccount">添加普通用户</a>
<a href="deleteTypicalAccount">删除普通用户</a>
<a href="resetAccountPassword">重置用户密码</a><br/>

<a href="selectAllSalesEmployees">助理查看员工信息</a>

<a href="easyUi/excelTestJsp.jsp">助理查看员工信息</a>
</body>
</html>