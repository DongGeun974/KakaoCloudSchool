package _220725;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
		

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력
		// 입력받을 때 사용되는 stream의 encoding은 ISO-8859-1, 한글깨짐
		// 한글 데이터를 전달받으려면 처리 필요
		// get 방식 : tomcat의 입력 스트림의 인코딩을 변경, URIEncoding
		// post 방식 : request.setCharacterEncoding("EUC-KR");
		String email = request.getParameter("userEmail");
		String pw = request.getParameter("userPassword");
		
		// 2. 로직처리
		// 입력된 email과 password가 database table에 존재하는지 확인
		// JDBC code
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean loginStatus = false;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false","root", "zxcasd3004");
			String sql = "SELECT * FROM tmpuser WHERE email=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginStatus = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// 3. 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = new PrintWriter(response.getOutputStream());
		if (loginStatus) {
			out.println("환영합니다");
		}else {
			out.println("로그인 실패");
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
