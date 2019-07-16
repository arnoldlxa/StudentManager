<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>添加学生页面</h3>


<form method="post" action="AddServlet">
  <table class="table table-striped table-bordered table-hover table-condensed">
  
<tbody>
  <tr>
	<th>学号</th>
	<th><input type="text" name="studentID"></th>
  </tr>
  <tr>
  	<th>姓名</th>
  	<th> <input type="text" name="name"> </th>
  </tr>
  <tr> 
  	<td>年龄</td>
  	<td> <input type="text" name="age"> </td>
  </tr>
  <tr>
	<td>性别</td>
	<td>
		<input type="radio" name="sex" value="男">男
		<input type="radio" name="sex" value="女">女
	</td>
  </tr>
  <tr>
	<td>出生日期</td>
	<td><input type="text" name="birthday"></td>
  </tr>
  <tr>
	<td>简介</td>
	<td><textarea name="info" rows="3" cols="20"></textarea></td>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="添加"> </td>
  </tr>
 </tbody>
  </table>
   </form>
</body>
</html>