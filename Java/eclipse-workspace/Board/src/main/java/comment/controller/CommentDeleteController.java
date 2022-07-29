package comment.controller;

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
 * Servlet implementation class CommentDeleteController
 */
@WebServlet("/deleteComment")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentNum = request.getParameter("commentNum");
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("m");
		String postNum = request.getParameter("postNum");
		
		CommentService comment_service = new CommentService();
		comment_service.deleteComment(commentNum);
		
		PostService post_service = new PostService();	
		Post post = post_service.getPost(postNum);
		comment_service = new CommentService();
		ArrayList<Comment> list = comment_service.getAllComment(postNum);
		
		// 3. 출력
		RequestDispatcher rd = request.getRequestDispatcher("post/post.jsp");
		request.setAttribute("m",m);
		request.setAttribute("post", post);
		request.setAttribute("comment", list);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
