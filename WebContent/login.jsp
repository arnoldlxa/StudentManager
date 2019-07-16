<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<h3> 学生管理系统后台登录界面</h3>
		
		<form action="LoginServlet" method="post">  
		用户名:<input type="text" name="username"> <br>
		密码: <input type="password" name="password" > <br>
		记住密码<input type="checkbox" name="auto_login"> <br>
		<input type="submit" value="提交">
		</form>
</body>
</html>