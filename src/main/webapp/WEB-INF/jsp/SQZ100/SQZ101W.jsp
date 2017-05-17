<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<title>首頁</title>
<script type="text/javascript">
var data = null;

$(document).ready(function(){
	data = 
	$("#b1").click(function(){
		$.post("/TEST0112/TEST0112F2/ajax.do",{},function(data, textStatus){
			data = JSON.stringify(data);
			//data = eval("("+data+")");
			data = JSON.parse(data);
			$("#userName1").val(data.userName);
			$("#password1").val(data.password);
		});
	});
	
	$("#b2").click(function(){
		$.post("/TEST0112/TEST0112F2/ajax2.do",{},function(data, textStatus){
			data = JSON.stringify(data);
			//data = eval("("+data+")");
			data = JSON.parse(data);
			$("#userName2").val(data.userName);
			$("#password2").val(data.password);
		});
	});
	
	$("#b3").click(function(){
		$.post("/TEST0112/TEST0112F2/ajax3.do",{},function(data, textStatus){
			data = JSON.stringify(data);
			data = JSON.parse(data);
			alert(data[1].userName);
			alert(data[1].password);
		});
	});
});	
</script>
</head>
<body id="body">

			<p>101W</p>
			<p><a href="/TEST0112/TEST0112F2/ajax.do">ajax object測試</a></p>
			<p>
				<input id="b1" type="button" value="object測試" /><br /> 姓名：<input
					type="text" id="userName1" /><br />
			</p>
			<p><a href="/TEST0112/TEST0112F2/ajax2.do">ajax map測試</a></p>
			<p>
				<input id="b2" type="button" value="map測試" /><br /> 姓名：<input
					type="text" id="userName2" /><br /> 密碼：<input type="text" id="password2" />
			</p>
			<div>
				<input id="b3" type="button" value="list測試" /><br />
				<div id="content3"></div>
			</div>
			
</body>
</html>
