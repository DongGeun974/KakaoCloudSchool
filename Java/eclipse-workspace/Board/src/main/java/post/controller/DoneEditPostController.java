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
 * Servlet implementation class DoneEditPostController
 */
@WebServlet("/doneEdit")
public class DoneEditPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoneEditPostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("m");
		String postNum = request.getParameter("postNum");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		PostService post_service = new PostService();
		
		Post post = post_service.editPost(postNum, title, content);
		
		// comment
		CommentService comment_service = new CommentService();
		ArrayList<Comment> list = comment_service.getAllComment(postNum);
		
		// 3. 출력
		RequestDispatcher rd = request.getRequestDispatcher("post/post.jsp");
		request.setAttribute("m",m);
		request.setAttribute("post", post);
		request.setAttribute("comment", list);
		
		rd.forward(request, response);
	}

}
