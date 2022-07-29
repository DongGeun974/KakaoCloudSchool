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

import member.vo.Member;
import post.model.PostService;
import post.vo.Post;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
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
		if (m != null) {
			// 2. 로직
			PostService service = new PostService();
			ArrayList<Post> list = new ArrayList<Post>();
			list = service.getAllPost();
			
			// 3. 출력
			RequestDispatcher rd = request.getRequestDispatcher("post/list.jsp");
			request.setAttribute("m",m);
			request.setAttribute("list", list);
			
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
