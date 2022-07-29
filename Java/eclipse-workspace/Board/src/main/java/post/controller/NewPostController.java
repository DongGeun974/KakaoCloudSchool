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
 * Servlet implementation class NewPostController
 */
@WebServlet("/newPost")
public class NewPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPostController() {
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
		// 1. 입력
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("m");
		
		// 2. 로직
		int result = 0;
		PostService service = new PostService();
		Post post = new Post();
		post.setTitle(title);
		post.setContent(content);
		post.setAuthor(m.getName());
		
		ArrayList<Post> list = new ArrayList<Post>();
		list = service.createPost(post);
		
		// 3. 출력
		
		request.setAttribute("list", list);
		request.setAttribute("m", m);
		
		RequestDispatcher rd = request.getRequestDispatcher("post/list.jsp");
		rd.forward(request, response);
		
	}

}
