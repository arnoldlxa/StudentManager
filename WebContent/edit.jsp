<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%-- 引入JQ和Bootstrap --%>
<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet">

<title>学生管理页面 - 编辑页面</title>
</head>
<body>



	<div class="editDIV">

		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">编辑学生</h3>
			</div>
			<div class="panel-body">

				<form method="post" action="UpdateServlet" role="form">
					<table class="editTable">
						<tr>
							<td>学号：</td>
							<td><input type="text" name="studentID" id="studentID"
								value="${student.studentID}" placeholder="请在这里输入学号"></td>
						</tr>
						<tr>
							<td>姓名：</td>
							<td><input type="text" name="name" id="name"
								value="${student.name}" placeholder="请在这里输入名字"></td>
						</tr>
						<tr>
							<td>年龄：</td>
							<td><input type="text" name="age" id="age"
								value="${student.age}" placeholder="请在这里输入年龄"></td>
						</tr>
						<tr>
							<td>性别：</td>
							<td>
							 	<input type="radio" name="sex" value="男" <c:if test="${student.sex == '男'}">checked</c:if>>男
							<input type="radio" name="sex" value="女" <c:if test="${student.sex == '女'}">checked</c:if>>女 
							
							</td>

						</tr>
						<tr>
							<td>出生日期：</td>
							<td><input type="date" name="birthday" id="birthday"
								value="${student.birthday}" placeholder="请在这里输入出生日期"></td>
						</tr>
						<tr>
							<td>简介</td>
							<td><textarea name="info" rows="3" cols="20"></textarea></td>
						</tr>
						<tr class="submitTR">
							<td colspan="2" align="center"><input type="hidden"
								name="id" value="${student.id}">
								<button type="submit" class="btn btn-success">提 交</button></td>

						</tr>

					</table>
				</form>
			</div>
		</div>

	</div>
</body>
</html>