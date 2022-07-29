package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 2. 처리
		Member m = new Member();
		m.setId(id);
		m.setPw(pw);
		
		MemberService service = new MemberService();
		m = service.login(m);
		
		// 3. 출력
		if (m.getName() != null) {
			
			
//			request.setAttribute("m", m);
//			RequestDispatcher rd = request.getRequestDispatcher("post/main.jsp");
			
			// session
			HttpSession session = request.getSession();
			session.setAttribute("m", m);
			
//			rd.forward(request, response);
			response.sendRedirect("list");
		}else {
			response.sendRedirect("member/loginError.html");
		}
	}

}
