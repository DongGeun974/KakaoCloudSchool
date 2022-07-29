package comment.model;

import java.util.ArrayList;

import comment.dao.CommentDAO;
import comment.vo.Comment;
import member.vo.Member;

public class CommentService {

	public ArrayList<Comment> getAllComment(String postNum) {
		
		CommentDAO dao;
		ArrayList<Comment> list = new ArrayList<Comment>();
		
		try {
			dao = new CommentDAO();
			list = dao.select(postNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public void createComment(Member m, String post_num, String comment) {
		
		CommentDAO dao;
		
		try {
			dao = new CommentDAO();
			dao.insert(m, post_num, comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void deleteAllComment(String postNum) {
		CommentDAO dao;
		try {
			dao = new CommentDAO();
			dao.delete(postNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteComment(String commentNum) {
		CommentDAO dao;
		try {
			dao = new CommentDAO();
			dao.deleteComment(commentNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
