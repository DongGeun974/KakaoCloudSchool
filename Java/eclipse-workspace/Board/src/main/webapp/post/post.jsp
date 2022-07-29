<%@page import="comment.vo.Comment"%>
<%@page import="member.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="post.vo.Post"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="post/post.js"></script>
</head>
<body>
	<% Member m = (Member) request.getAttribute("m"); %>
	<% Post post = (Post) request.getAttribute("post"); %>
	<% ArrayList<Comment> list = (ArrayList<Comment>) request.getAttribute("comment"); %>
	
	<div>안녕하세요 <%= m.getName() %></div>
	<div>제목  <%=post.getTitle() %></div>
	<div>작성자  <%=post.getAuthor() %></div>
	<button onclick="goToLike('<%= m.getName() %>', '<%= post.getAuthor()%>','<%=post.getNum() %>', '<%=post.getLikey()+1 %>' , '<%=post.getViewer() %>')">좋아요 </button>
	<button onclick="goToEditPost('<%= m.getName() %>', '<%= post.getAuthor()%>','<%=post.getNum() %>')">수정 </button>
	<div>작성일 <%= post.getDate() %>></div>
	<div>조회수  <%=post.getViewer() %></div>
	<div>좋아요  <%=post.getLikey() %></div>
	<div>내용  </div>
	<div>
		<%=post.getContent() %>
	</div>
	
	
	<br>
	<br>
	
	<div>댓글</div>
	<div>
       <table>
         <thead>
           <tr>
             <th scope="col">작성자</th>
             <th scope="col">댓글 내용</th>
             <th scope="col">댓글 삭제</th>
           </tr>
         </thead>
         <tbody>
         
         <% for(Comment comment : list){ %>
           <tr>
             <td><%=comment.getAuthor() %></td>
             <td><%=comment.getComment() %></td>
             <td><button onclick="goToDeleteComment(<%=comment.getId() %>, '<%=post.getNum() %>', '<%=comment.getAuthor() %>', '<%= m.getName() %>')">삭제</button></td>
           </tr>
          <%} %>
          
        </tbody>
      </table>
    </div>
    
    <br>
    
    <form action="commentInsert" method="post">
    	댓글 작성 : <input type="text" name="comment" required><br>
    	<input type="hidden" name="postNum" value="<%=post.getNum() %>">
    	<input type="hidden" name="viewer" value="<%=post.getViewer() %>" >
    	
    	<input type="submit" value="댓글 작성" >
    </form>
	
</body>
</html>