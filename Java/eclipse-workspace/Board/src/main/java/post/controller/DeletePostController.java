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
import member.vo.Member;
import post.model.PostService;
import post.vo.Post;

/**
 * Servlet implementation class DeletePostController
 */
@WebServlet("/deletePost")
public class DeletePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNum = request.getParameter("postNum");
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("m");
		
		PostService post_service = new PostService();
		post_service.deletePost(postNum);
		ArrayList<Post> list = new ArrayList<Post>();
		list = post_service.getAllPost();
		
		// 모든 comment 삭제
		CommentService comment_service = new CommentService();
		comment_service.deleteAllComment(postNum);
		
		// 3. 출력
		RequestDispatcher rd = request.getRequestDispatcher("post/list.jsp");
		request.setAttribute("m",m);
		request.setAttribute("list", list);
		
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
