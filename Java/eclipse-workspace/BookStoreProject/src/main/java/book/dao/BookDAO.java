package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import book.vo.Book;

public class BookDAO {

	private DataSource ds;
	
	public BookDAO() throws Exception{
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");			
	}
	
	
	public ArrayList<Book> select(String keyword)throws Exception {
	
		Connection con = ds.getConnection();
		
		String sql = "SELECT bisbn, btitle, bauthor, bprice, bimgurl FROM book WHERE btitle like ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyword +"%");
		
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Book> list = new ArrayList<Book>();
		
		while (rs.next()) {
			//vo 생성해서 arraylist에 추가
			Book book = new Book();
			book.setBtitle(rs.getString("btitle"));
			book.setBauthor(rs.getString("bauthor"));
			book.setBimgurl(rs.getString("bimgurl"));
			book.setBprice(rs.getInt("bprice"));
			book.setBisbn(rs.getString("bisbn"));
			
			list.add(book);
		}
		
		
		return list;
	}


	public int delete(String isbn) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = ds.getConnection();
		
		String sql = "DELETE FROM book WHERE bisbn=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, isbn);
		
		
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
}
