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


<title>学生列表页面</title>



</head>


<c:if test="${not empty  user}">

	<center>
		<h3>这是后台管理系统 欢迎您, ${user.username }!</h3>
	</center>

	<script>
        $(function () {
            $("ul.pagination li.disabled a").click(function () {
                return false;
            });
        });
    </script>
	<h3>
		<!-- <a href="StudentListServlet">显示所有学生列表</a> -->
	</h3>
	<br>

	<script type="text/javascript">

	function doDelete(id) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?\n\n请确认！");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			//window.location.href="DeleteServlet?sid="+sid;
			location.href="DeleteServlet?id="+id;
		}
	}
</script>

	<div class="listDIV">
		<table
			class="table table-striped table-bordered table-hover table-condensed">

			<caption>学生列表 - 共人</caption>

		
			<thead>

				<tr class="success">
					<th>学号</th>
					<th>姓名</th>
					<th>年龄</th>
					<th>性别</th>
					<th>出生日期</th>
					<th>简介</th>


					<th>编辑</th>
					<th>删除</th>

				</tr>
				
				
			</thead>

			<tbody>
				<c:forEach items="${list}" var="s" varStatus="status">
					<tr>
						<td>${s.studentID}</td>
						<td>${s.name}</td>
						<td>${s.age}</td>
						<td>${s.sex}</td>
						<td>${s.birthday}</td>
						<td>${s.info}</td>

						<td><a href="EditServlet?id=${s.id}"> <span
								class="glyphicon glyphicon-edit"></span>
						</a></td>
						<td><a href="#" onclick="javascript:return doDelete(${s.id})"><span
								class="glyphicon glyphicon-trash"></span> </a></td>

					</tr>
				</c:forEach>

<!-- 			<tr>
				<td colspan="8">
				按姓名查询:<input type="text" name="findbyname" /> 
				</td>
			</tr> -->
			</tbody>
		</table>
	</div>


	<div class="addDIV">

		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">增加学生</h3>
			</div>
			<div class="panel-body">

				<form method="post" action="AddServlet" role="form">
					<table class="addTable">
						<tr>
							<td>学号：</td>
							<td><input type="text" name="studentID" id="studentID"
								placeholder="请在这里输入学号"></td>
						</tr>
						<tr>
							<td>姓名：</td>
							<td><input type="text" name="name" id="name"
								placeholder="请在这里输入名字"></td>
						</tr>
						<tr>
							<td>年龄：</td>
							<td><input type="text" name="age" id="age"
								placeholder="请在这里输入年龄"></td>
						</tr>
						<tr>
							<td>性别：</td>
							<td><input type="radio" class="radio radio-inline"
								name="sex" value="男"> 男 <input type="radio"
								class="radio radio-inline" name="sex" value="女"> 女</td>
						</tr>
						<tr>
							<td>出生日期：</td>
							<td><input type="date" name="birthday" id="birthday"
								placeholder="请在这里输入出生日期"></td>
						</tr>
						<tr>
							<td>简介</td>
							<td><textarea name="info" rows="3" cols="20"></textarea></td>
						</tr>
						<tr class="submitTR">
							<td colspan="2" align="center">
								<button type="submit" class="btn btn-success">提 交</button>
							</td>

						</tr>

					</table>
				</form>
			</div>
		</div>

	</div>




</c:if>

<c:if test="${ empty  user}">
		您好，请登录!<br>
	<a href="login.jsp"> 点击跳转到登录界面</a>
</c:if>

<body>

</body>
</html>