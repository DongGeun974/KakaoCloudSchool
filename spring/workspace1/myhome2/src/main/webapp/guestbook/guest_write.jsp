<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.rapa.control.guestbook.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>방명록</h1>
	<form name="form">
		제목 : <input type="text" name="title" id="title">
		작성자 : <input type="text" name="writer" id="writer">
		내용 : <textarea rows="5" cols="80" name="contents" id="contents"></textarea>
		
		<button type="button" id="btnSend">Send</button>
	</form>
</body>
</html>

<script>
window.onload=function(){
	document.getElementById("btnSend").addEventListener("click", function(){
		var frm = document.form;
		frm.action = "/myhome2/guest.do?cmd=save";
		frm.method="post";
		frm.submit();
	})
}
</script>