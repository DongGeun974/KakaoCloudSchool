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
	
	<% List<GuestbookDTO> dataList = (List<GuestbookDTO>)request.getAttribute("dataList"); %>
	
	<form name="form">
		<input type="hidden" name="cmd" id="cmd">
		<table>
		<%
			for(int i =0; i<dataList.size(); i++)
			{
				GuestbookDTO dto = dataList.get(i);
			
		%>
		<tr>
			<td><%=dto.getId() %></td>
			<td><a href="<%=request.getContextPath()%>/guest.do?cmd=view&id=<%=dto.getId()%>"><%=dto.getId() %></a></td>		
			<td><%=dto.getTitle() %></td>
			<td><%=dto.getWriter() %></td>
			<td><%=dto.getWdate() %></td>
		</tr>
		<%} %>
		</table>
	
	</form>
	
	<button id="btnWrite" type="button">글쓰기</button>
</body>
</html>

<script >
	window.onload = function(){
		document.getElementById("btnWrite").addEventListener("click", function(){
			var frm = document.form;
			frm.cmd.value = "write";
			frm.action="/myhome2/guest.do";
			frm.method="get";
			frm.submit();
		})
	}
</script>