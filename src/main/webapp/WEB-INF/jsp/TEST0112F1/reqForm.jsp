<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>reqForm</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/TEST0112F1/addReqForm.do" method="post">
	name<input type = "text" id = "name" name = "name"/><br>
	age<input type = "text" id = "age" name = "age"/><br>
	<input type ="submit" value="提交"/>
</form>

</body>
</html>