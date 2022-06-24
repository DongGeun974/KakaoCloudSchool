package com.rapa.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapa.common.CommonUtil;

/**
 * Servlet implementation class GuestBook
 */
@WebServlet("/guest")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = CommonUtil.nullToValue(request.getParameter("cmd"), "list");
		if (cmd.equals("info")){
			doInfo(request, response);
		}else if (cmd.equals("list"))
		{
			getList(request, response);
		}
		
	}
	
	protected void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<String> list = new ArrayList<String>(); // Generic 기법
		// List - 추상클래스
		// ArrayList - 구현클래스
		
		list.add("작약");
		list.add("할매꽃");
		list.add("모란");
		list.add("국화");
		list.add("백일홍");
		
		request.setAttribute("flowerList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
		rd.forward(request, response);
	}
	
	protected void doInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// 각 페이지에서 요청을 받으면 그 페이지가 바뀌면 받았던 요청은 전달되지 않음
		// RequestDispatcher를 이용하면 요청이 다른 페이지로 이전
		// 원하는 jsp 페이지를 매개변수로 전달하면 그 페이지로 이동
		
		// 부가적인 정보를 저장해서 jsp로 전달 할 수 있음
		// request 객체에 부가적인 정보를 저장하려면 setAttribute 함수 사용
		// 키와 값 형태로 정보 저장 가능
		request.setAttribute("userName","홍길동");
		request.setAttribute("age",23);
		request.setAttribute("phone","010-7777-7777");
		// parameter는 form 태그를 통해서 가능
		
		RequestDispatcher rd = request.getRequestDispatcher("/guest.jsp");
		rd.forward(request, response);	// jsp 호출	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
