<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.12.4/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/SQZ120W.js"></script>
<title>SQZ120W</title>
</head>
<body>
	<!-- button測試 -->
	<input type="button" id="test" name="test" value="test" class="form-control">
	<form id="queryEmplForm" style="margin-top: 6px;" method="post"
							action="${pageContext.request.contextPath}/TEST0112F1/ajaxListEmployeeByQuery.do">
		<input  type="text" name="emplCd" value="${pageBean}">
		<input  type="text" name="emplNm" value="${empls}">
		<a href="#" id="queryEmplButton" style="width: 80px;">Query</a>
	</form>
</body>
</html>