package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import comment.vo.Comment;
import member.vo.Member;
import post.vo.Post;

public class CommentDAO {
	
	private DataSource ds;
	
	public CommentDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}
	

	public ArrayList<Comment> select(String postNum) throws Exception {
		
		Connection con = ds.getConnection();
		
		String sql = "SELECT * FROM comment WHERE post_num=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, postNum);
		
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Comment> list = new ArrayList<Comment>();
		
		while(rs.next()) {
			Comment comment = new Comment();
			
			comment.setAuthor(rs.getString("author"));
			comment.setComment(rs.getString("comment"));
			comment.setId(rs.getInt("id"));
			comment.setPost_num(rs.getInt("post_num"));
			
	        list.add(comment);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}


	public void insert(Member m, String post_num, String comment) throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "INSERT INTO comment (`post_num`, `author`, `comment`) VALUES (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, post_num);
		pstmt.setString(2, m.getName());
		pstmt.setString(3, comment);
		
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
	}


	public void delete(String postNum) throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "DELETE FROM `comment` WHERE (`post_num` = ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, postNum);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}


	public void deleteComment(String commentNum) throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "DELETE FROM `comment` WHERE (`id` = ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, commentNum);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

}
