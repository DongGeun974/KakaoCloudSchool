package com.rapa.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
// http://127.0.0.1:9090/myhome2/hello
@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // GET method, call doGet
    // request - 클라이언트(브라우저)의 요청을 받아오는 객체, WAS가 만들어 줌
    // response - 서버에서 클라이언트(브라우저)에게 응답을 보낸 때 사용하는 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("doget console창");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<meta charset='utf-8'>");
		out.print("<body>");
		out.print("<h1>hello</h1>");
		out.print("<h1>안녕하세요</h1>");
		out.print("</body>");
		out.print("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// POST method, call doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost console창");
		doGet(request, response); //doGet을 호출해서 특별한 상황이 아니면 GET or POST 둘 다 처리
	}

}
