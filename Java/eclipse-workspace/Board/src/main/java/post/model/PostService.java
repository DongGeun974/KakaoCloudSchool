package post.model;

import java.util.ArrayList;

import post.dao.PostDAO;
import post.vo.Post;

public class PostService {

	public ArrayList<Post> getAllPost() {
		// TODO Auto-generated method stub
		
		PostDAO dao;
		ArrayList<Post> list = new ArrayList<Post>();
		try {
			dao = new PostDAO();
			list = dao.select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Post> createPost(Post post) {
		// TODO Auto-generated method stub
		
		PostDAO dao;
		int result = 0;
		ArrayList<Post> list = new ArrayList<Post>();
		
		try {
			dao = new PostDAO();
			list = dao.insert(post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public Post getPost(String postNum) {
		// TODO Auto-generated method stub
		PostDAO dao;
		Post post = new Post();
		
		try {
			dao = new PostDAO();
			post = dao.select(postNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}

	public void setLike(String postNum, int like) {
		PostDAO dao;
		try {
			dao = new PostDAO();
			dao.updateLike(postNum, like);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setViewer(String postNum, int viewer) {
		PostDAO dao;
		try {
			dao = new PostDAO();
			dao.updateViewer(postNum, viewer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Post editPost(String postNum, String title, String content) {
		PostDAO dao;
		Post post = new Post();
		
		try {
			dao = new PostDAO();
			post = dao.update(postNum, title, content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}

	public void deletePost(String postNum) {
		// TODO Auto-generated method stub
		PostDAO dao;
		try {
			dao = new PostDAO();
			dao.delete(postNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
