package com.rapa.control.guestbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapa.common.CommonUtil;

//데이터베이스가 없으므로 model에서 더미 데이터 생성
//controller를 통해 데이터를 view로 전송
//
//모든 요청은 controller가 받음
//controller가 고객의 요청을 분석해서 model로부터 데이터 가져옴
//request 객체에 저장하고 jsp로 전달
//jsp는 request 객체로부터 값을 읽어서 출력
//
//servlet을 controller로 사용
//요청 : list.jsp, write.jsp, view.jsp
//
//model
//	DTO(Data Transfer Object) - 데이터베이스의 테이블과 1:1 매핑, 필드명이 멤버변수, 조인된 여러 테이블에서는 1:1 매핑이 아님
//DAO(Data Access Object) - 데이터베이스에서 데이터를 읽어오거나 쓰는 일을 하는 클래스


/**
 * Servlet implementation class GuestbookController
 */
@WebServlet("/guest.do")
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GuestbookDAO dao = new GuestbookDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestbookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String cmd = CommonUtil.nullToValue(request.getParameter("cmd"),"list");
		
		if (cmd.equals("list"))
		{
			doList(request, response);
		}else if (cmd.equals("view"))
		{
			doView(request, response);
		}else if (cmd.equals("write"))
		{
			doWrite(request, response);
		}else if (cmd.equals("save"))
		{
			doSave(request, response);
		}
	}

	protected void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		GuestbookDAO dao = new GuestbookDAO();
		request.setAttribute("dataList", dao.getList());
		
		RequestDispatcher rd = request.getRequestDispatcher("/guestbook/guest_list.jsp");
		rd.forward(request, response);
	}
	
	protected void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		GuestbookDAO dao = new GuestbookDAO();
		String id = request.getParameter("id");
		
		request.setAttribute("data", dao.getView(Integer.parseInt(id)-1));
		
		RequestDispatcher rd = request.getRequestDispatcher("/guestbook/guest_view.jsp");
		rd.forward(request, response);
	}
	
	protected void doWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/guestbook/guest_write.jsp");
		rd.forward(request, response);
	}
	
	protected void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookDTO dto = new GuestbookDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		dto.setWriter(request.getParameter("writer"));
		dto.setWdate("2022-06-24");
		
		dao.insert(dto);
		
		response.sendRedirect(request.getContextPath()+"/guest.do?cmd=list");
	}

		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
