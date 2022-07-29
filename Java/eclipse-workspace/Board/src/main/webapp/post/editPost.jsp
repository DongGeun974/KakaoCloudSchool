<%@page import="member.vo.Member"%>
<%@page import="post.vo.Post"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Member m = (Member) request.getAttribute("m"); %>
	<% Post post = (Post) request.getAttribute("post"); %>
	
	<form action="doneEdit" method="post">
		<div>안녕하세요 <%= m.getName() %></div>
		<div>제목 <input type="text" name="title" value="<%=post.getTitle() %>"></div>
		<div>작성자  <%=post.getAuthor() %></div>
		<div>작성일 <%= post.getDate() %></div>
		<div>조회수  <%=post.getViewer() %></div>
		<div>좋아요  <%=post.getLikey() %></div>
		<div>내용  </div>
		<textarea rows="10" cols="60" name="content"><%=post.getContent() %></textarea><br>
		<input type="hidden" name="postNum" value="<%=post.getNum() %>">
		<input type="submit" value="수정하기">
	</form>
	
</body>
</html>