package com.rapa.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapa.common.CommonUtil;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String rX = CommonUtil.nullToValue(request.getParameter("x"));
		String rY = CommonUtil.nullToValue(request.getParameter("y"));
		String oper = CommonUtil.nullToValue(request.getParameter("oper"), "1");
		
		int nX = Integer.parseInt(rX);
		int nY = Integer.parseInt(rY);
		String result = "";
		
		if(oper.equals("1"))
		{
			result = String.format("%d + %d = %d", nX, nY, nX+nY);
		} else if(oper.equals("2"))
		{
			result = String.format("%d - %d = %d", nX, nY, nX-nY);
		} else if(oper.equals("3"))
		{
			result = String.format("%d * %d = %d", nX, nY, nX*nY);
		}else 
		{
			result = String.format("%d / %d = %d", nX, nY, nX/nY);
		}
		
		System.out.println(rX);
		System.out.println(rY);
		System.out.println(oper);
		
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<meta charset='utf-8'>");
		out.print("<body>");
		out.print("<h1>"+result+"</h1>");
		out.print("</body>");
		out.print("</html>");
		
//		int x = Integer.parseInt(request.getParameter("x"));
//		int y = Integer.parseInt(request.getParameter("y"));
//		int oper = Integer.parseInt(request.getParameter("oper"));
//		
//		PrintWriter out = response.getWriter();
//		
//		out.print("<html>");
//		out.print("<meta charset='utf-8'>");
//		out.print("<body>");
//		if(oper == 1)
//		{
//			out.print("<h1>"+(x+y)+"</h1>");
//		} else if(oper == 2)
//		{
//			out.print("<h1>"+(x-y)+"</h1>");
//		} else if(oper == 3)
//		{
//			out.print("<h1>"+(x*y)+"</h1>");
//		}else if(oper == 4)
//		{
//			out.print("<h1>"+(x/y)+"</h1>");
//		}
//		
//		out.print("</body>");
//		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
