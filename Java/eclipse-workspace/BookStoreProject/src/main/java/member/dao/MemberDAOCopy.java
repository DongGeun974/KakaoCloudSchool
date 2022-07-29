package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.vo.MemberCopy;

public class MemberDAOCopy {

	private DataSource ds;
	
	public MemberDAOCopy() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}
	
	public MemberCopy select(MemberCopy m) throws SQLException {
		Connection con = ds.getConnection();
		
		String sql = "SELECT * FROM members WHERE id=? AND pw=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPw());
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			m.setName(rs.getString("name"));
			return m;
		}
		return null;
		
	}
}
