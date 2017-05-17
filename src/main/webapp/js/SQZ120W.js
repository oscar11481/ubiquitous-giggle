efiaUpdatePage = efiaUpdatePageSQZ120W;

$(function () {
	$('#test').on('click', function () {
		alert("123");
		});
	
	$("#queryEmplButton").click(function(e) {
		e.preventDefault();
		//var url = "http://localhost:8080/TEST0112/TEST0112F1/ajaxListEmployeeByQuery.do";
		var url = "/TEST0112/TEST0112F1/ajaxListEmployeeByQuery.do";
		var form = $("#queryEmplForm");
		form.attr('action', url);
		efiaUpdatePage(form);
		//efiaSetCmdMessage("查詢完成");
		//efiaShowCmdLine();
	});
	
});

function efiaUpdatePageSQZ120W(form) {
	//init();
	var url = form.attr("action");
	alert(url);
	var params = form.serialize();	
	alert(params);	
	$.post(url,params,function(data, textStatus) {
		data = JSON.stringify(data);
		data = JSON.parse(data);
		alert("data" + data + "textStatus" + textStatus);
	});
}