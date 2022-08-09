<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${count > 0 }">
	크다
</c:if>
<c:if test="${count < 0 }">
	작다
</c:if>

<br />
<c:forEach var="data" items="${list }">
	${data} <br />
</c:forEach>

<br />
<c:forEach var="i" begin="1" end="10" step="1">
	${i} <br />
</c:forEach>

<br />
<c:set var="name" value="java" />
${name}

<br />
<%--<c:redirect url="member/loginForm"/>--%>

<!-- 
redirect : 단순 이동
forward : 정보를 가지고 이동
 -->
 
 <fmt:formatDate  value="${day }"   type="date" />  <br />
 <fmt:formatDate  value="${day }"   type="time" />  <br />
 <fmt:formatDate  value="${day }"   type="both" />  <br />
 
 <jsp:include page="/member/loginForm" />
 <c:import var="form" url="/member/loginForm"></c:import>
 ${form}