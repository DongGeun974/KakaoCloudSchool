package member.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.vo.Member;

public class MemberDAO {
	
	private DataSource ds;
	
	public MemberDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}
	
	public Member selete(Member m) throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "SELECT name FROM member WHERE id=? AND pw=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPw());
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			System.out.println(rs.getString("name"));
			m.setName(rs.getString("name"));
		}
		
		pstmt.close();
		con.close();
		
		return m;
	}

	public int insert(Member m) throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "INSERT INTO member VALUES (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPw());
		pstmt.setString(3, m.getName());
		System.out.println(pstmt);
		
		int rs = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rs;
	}
	
}
