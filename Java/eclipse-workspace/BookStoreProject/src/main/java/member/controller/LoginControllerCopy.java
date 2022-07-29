package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberModel;
import member.vo.MemberCopy;

/**
 * Servlet implementation class LoginControllerCopy
 */
@WebServlet("/loginCopy")
public class LoginControllerCopy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllerCopy() {
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
		
		// 2. 로직
		MemberCopy m = new MemberCopy();
		MemberModel memberModel = new MemberModel();
		
		m.setId(id);
		m.setPw(pw);
		
		m = memberModel.login(m);
		
		// 3. 출력
		if (m != null) {
			RequestDispatcher rd = request.getRequestDispatcher("copy/loginSuccess.jsp");
			request.setAttribute("m", m);
			rd.forward(request, response);
		}else {
			response.sendRedirect("/book/copy/loginFail.html");
		}
	}

}
