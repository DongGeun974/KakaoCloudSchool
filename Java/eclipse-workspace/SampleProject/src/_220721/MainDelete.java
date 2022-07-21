package _220721;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDelete {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement psmt = null;
		
		try {
			// 1. JDBC driver loading
			// full package name
			// MySQL 8.0부터는 아래의 class를 이용
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("-----------------드라이버 로딩 성공-----------------");
			
			// 2. Database connection
			String jdbcURL = "jdbc:" + "mysql://" +"localhost:"+"3306/"+"sqldb?"
							+"characterEncoding=UTF-8&"+"serverTimezone=UTC&"+"allowPublicKeyRetrieval=true&"+"useSSL=false";
			System.out.println(jdbcURL);
			con = DriverManager.getConnection(jdbcURL, "root", "zxcasd3004");
			System.out.println("-----------------데이터베이스 연결 성공-----------------");
			
			con.setAutoCommit(false);			// transaction start
			
			// 3. Statement
			// prepared statement
			// IN parameter 사용
			String sql = "delete from buytbl where userId=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "BBK");
			
			// 4. Query
			// auto-commit
			int result = psmt.executeUpdate();
			
			// 5. 결과 처리
			System.out.println("총 " + result + "행이 삭제되었습니다.");
					
			con.rollback();						// transaction terminate
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			// 6. 사용한 자원 해제
				try {
					if(psmt!=null) psmt.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					
				}
		}
		
		
		

	}

}
