package post.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.Member;
import post.model.PostService;
import post.vo.Post;

/**
 * Servlet implementation class EditPostController
 */
@WebServlet("/edit")
public class EditPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNum = (String) request.getParameter("postNum");
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("m");
		if (m != null) {
			PostService post_service = new PostService();
			Post post = post_service.getPost(postNum);
			
			RequestDispatcher rd = request.getRequestDispatcher("post/editPost.jsp");
			request.setAttribute("m",m);
			request.setAttribute("post", post);
			
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
