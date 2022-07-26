package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class LoginController
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
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		
		// 2. 로직
		// service 객체 필요
		// service class 필요
		// 클라이언트에게 입력 받은 데이터를 전달하기 위해 VO 필요
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		MemberService memberService = new MemberService();
		member = memberService.login(member);
		
		// 3. 출력
		// 로그인이 성공하면 vo 객체 안에 로그인한 사람의 이름이 들어감
		if (member != null) {
			// login success
			// jsp 사용
			// member vo 객체를 jsp에게 전달
			// controller servlet이 request를 전달해서 다른 servlet(jsp)를 호출
			RequestDispatcher rd = request.getRequestDispatcher("/member/loginSuccess.jsp");
			request.setAttribute("member", member);
			rd.forward(request, response);
			
		}else {
			response.sendRedirect("/book/member/loginFail.html");
		}
		
	}

}
