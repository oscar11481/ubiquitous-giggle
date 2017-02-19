<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顯示目前學生數</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>學生姓名</th>
				<th>年紀</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${studentList}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.age}</td>
					<td><a href="${pageContext.request.contextPath}/TEST0112F1/startProcess.do?id=${student.id}">啟動流程</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>