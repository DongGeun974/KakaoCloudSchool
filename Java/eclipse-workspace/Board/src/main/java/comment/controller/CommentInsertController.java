package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.model.CommentService;
import member.vo.Member;

/**
 * Servlet implementation class CommentInsertController
 */
@WebServlet("/commentInsert")
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertController() {
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
		request.setCharacterEncoding("UTF-8");
		
		// 1. 입력
		String comment = (String) request.getParameter("comment");
		String postNum = (String) request.getParameter("postNum");
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("m");
		int viewer = Integer.parseInt(request.getParameter("viewer"));

		
		// 2. 로직
		CommentService service = new CommentService();
		service.createComment(m, postNum, comment);
		
		// 3. 출력
		RequestDispatcher rd = request.getRequestDispatcher("post");
		request.setAttribute("m",m);
		request.setAttribute("viewer", viewer);
		request.setAttribute("postNum", postNum);
		
		rd.forward(request, response);
	}

}
