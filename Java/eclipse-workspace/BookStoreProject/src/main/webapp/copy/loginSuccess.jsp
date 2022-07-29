<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.vo.MemberCopy"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% MemberCopy m = (MemberCopy) request.getAttribute("m"); %>
	하이 <%= m.getName() %> 
</body>
</html>