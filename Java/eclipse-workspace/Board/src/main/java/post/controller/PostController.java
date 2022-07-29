package post.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.model.CommentService;
import comment.vo.Comment;
import member.vo.Member;
import post.model.PostService;
import post.vo.Post;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("m");
		String postNum = request.getParameter("postNum");
		int viewer = Integer.parseInt(request.getParameter("viewer"));
		
		if (m != null) {
			// 2. 로직
			// viewer
			PostService post_service = new PostService();
			post_service.setViewer(postNum, viewer);
			
			// post
			Post post = post_service.getPost(postNum);
			
			// comment
			CommentService comment_service = new CommentService();
			ArrayList<Comment> list = comment_service.getAllComment(postNum);
			
			// 3. 출력
			RequestDispatcher rd = request.getRequestDispatcher("post/post.jsp");
			request.setAttribute("m",m);
			request.setAttribute("post", post);
			request.setAttribute("comment", list);
			
			rd.forward(request, response);
		}else {
			response.sendRedirect("/board");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
