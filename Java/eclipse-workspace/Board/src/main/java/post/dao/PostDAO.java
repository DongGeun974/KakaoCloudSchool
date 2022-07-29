package post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import post.vo.Post;

public class PostDAO {

	private DataSource ds;
	
	public PostDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}
	
	public ArrayList<Post> select() throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "SELECT * FROM post";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Post> list = new ArrayList<Post>();
		while(rs.next()) {
			Post post = new Post();
			
			post.setNum(rs.getInt("num"));
			post.setTitle(rs.getString("title"));
	        post.setContent(rs.getString("content"));
	        post.setAuthor(rs.getString("author"));
	        post.setLikey(rs.getInt("likey"));
	        post.setViewer(rs.getInt("viewer"));
	        post.setDate(rs.getString("date"));

	        list.add(post);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}

	public ArrayList<Post> insert(Post post) throws Exception {
		// TODO Auto-generated method stub
		Connection con = ds.getConnection();
		
		String sql = "INSERT INTO post (`title`, `content`, `author`, `date`) VALUES (?, ?, ?, now())";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, post.getTitle());
		pstmt.setString(2, post.getContent());
		pstmt.setString(3, post.getAuthor());
		
		pstmt.executeUpdate();
		
		// select
		sql = "SELECT * FROM post";
		pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Post> list = new ArrayList<Post>();
		while(rs.next()) {
			Post _post = new Post();
			
			_post.setNum(rs.getInt("num"));
			_post.setTitle(rs.getString("title"));
	        _post.setContent(rs.getString("content"));
	        _post.setAuthor(rs.getString("author"));
	        _post.setLikey(rs.getInt("likey"));
	        _post.setViewer(rs.getInt("viewer"));
	        _post.setDate(rs.getString("date"));

	        list.add(_post);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}

	public Post select(String postNum) throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "SELECT * FROM post WHERE num=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, postNum);
		
		ResultSet rs = pstmt.executeQuery();
		Post post = new Post();
		
		if(rs.next()) {			
			post.setNum(rs.getInt("num"));
			post.setTitle(rs.getString("title"));
	        post.setContent(rs.getString("content"));
	        post.setAuthor(rs.getString("author"));
	        post.setLikey(rs.getInt("likey"));
	        post.setViewer(rs.getInt("viewer"));
	        post.setDate(rs.getString("date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return post ;
	}

	public void updateLike(String postNum, int like) throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "UPDATE post SET `likey` = ? WHERE num = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, like);
		pstmt.setString(2, postNum);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

	public void updateViewer(String postNum, int viewer) throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "UPDATE post SET `viewer` = ? WHERE num = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, viewer);
		pstmt.setString(2, postNum);
		
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

	public Post update(String postNum, String title, String content) throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "UPDATE `post` SET `title` = ?, `content` = ? WHERE (`num` = ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, postNum);
		
		pstmt.executeUpdate();
		
		sql = "SELECT * FROM post WHERE num=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, postNum);
		
		ResultSet rs = pstmt.executeQuery();
		Post post = new Post();
		
		if(rs.next()) {			
			post.setNum(rs.getInt("num"));
			post.setTitle(rs.getString("title"));
	        post.setContent(rs.getString("content"));
	        post.setAuthor(rs.getString("author"));
	        post.setLikey(rs.getInt("likey"));
	        post.setViewer(rs.getInt("viewer"));
	        post.setDate(rs.getString("date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return post;
	}

	public void delete(String postNum) throws Exception {
		Connection con = ds.getConnection();
		
		String sql = "DELETE FROM `post` WHERE (`num` = ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, postNum);
		
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

}
