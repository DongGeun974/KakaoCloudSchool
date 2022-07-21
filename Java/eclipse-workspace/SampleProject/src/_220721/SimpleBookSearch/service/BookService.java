// Service
// 하나의 transaction

package _220721.SimpleBookSearch.service;

import java.sql.SQLException;
import java.util.ArrayList;

import _220721.SimpleBookSearch.dao.BookDAO;
import _220721.SimpleBookSearch.vo.BookVO;

public class BookService {
	
	private BookDAO dao;
	
	public BookService() {
		// 생성자
		dao = new BookDAO();
	}

	public ArrayList<BookVO> bookSearchByKeyword(String keyword) {
		// keyword를 이용해서 책을 찾음
		// for, if 로직 처리가 일반적
		// Database 처리
		ArrayList<BookVO> result = dao.select(keyword);
		return result;
	}
	
	public void bookDeleteByISBN(String bisbn) {
		// 책 고유번호를 받아서 해당 책을 삭제
	}
}
