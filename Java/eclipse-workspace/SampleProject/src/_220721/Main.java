package _220721;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
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
			
			// 3. Statement
			// 일반 statement
			smt = con.createStatement();
			// prepared statement
			String sql = "select userID, name, addr from usertbl";
			psmt = con.prepareStatement(sql);
			
			// 4. Query
			rs1 = smt.executeQuery(sql);
			rs2 = psmt.executeQuery();
			
			// 5. 결과 처리
			while(rs2.next()) {
				String id = rs2.getString(1);
				String name = rs2.getString(2);
				String addr = rs2.getString("addr");
				System.out.println(id +", "+ name +", "+ addr);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			// 6. 사용한 자원 해제
				try {
					if(rs1!=null) rs1.close();
					if(rs2!=null) rs2.close();
					if(smt!=null) smt.close();
					if(psmt!=null) psmt.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					
				}
		}
		
		
		

	}

}
