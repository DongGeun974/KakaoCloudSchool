// database 처리

package _220722.SimpleBookSearch.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

import _220722.SimpleBookSearch.vo.BookVO;

public class BookDAO {
	ConnectionMaker connectionMaker;
	
	public BookDAO(ConnectionMaker connectionMaker) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		this.connectionMaker = connectionMaker;
		
	}
	
	public ArrayList<BookVO> select(String keyword)  {
		Connection con = connectionMaker.makeConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BookVO> list = null;
		
		System.out.println(keyword);
		String sql = "select btitle, bauthor, bisbn from book where btitle like ?";
		System.out.println(sql);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BookVO>();
			
			while(rs.next()) {
				BookVO tmp = new BookVO();
				tmp.setBtitle(rs.getString("btitle"));
				tmp.setBauthor(rs.getString("bauthor"));
				tmp.setBisbn(rs.getString("bisbn"));
				list.add(tmp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int delete(String bisbn)  {
		int result = 0;
		Connection con = connectionMaker.makeConnection();
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from book where bisbn = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bisbn);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return result;
	}
	
}
