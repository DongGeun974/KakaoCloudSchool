// Service
// 하나의 transaction

package _220722.SimpleBookSearch.service;

import java.sql.SQLException;
import java.util.ArrayList;

import _220722.SimpleBookSearch.dao.BookDAO;
import _220722.SimpleBookSearch.dao.ConnectionMaker;
import _220722.SimpleBookSearch.vo.BookVO;

public class BookService {
	
	private BookDAO dao;
	
	public BookService(ConnectionMaker connectionMaker) {
		// 생성자
		dao = new BookDAO(connectionMaker);
	}

	public ArrayList<BookVO> bookSearchByKeyword(String keyword) {
		// keyword를 이용해서 책을 찾음
		// for, if 로직 처리가 일반적
		// Database 처리
		ArrayList<BookVO> result = dao.select(keyword);
		return result;
	}
	
	public int bookDeleteByISBN(String bisbn) {
		int result = dao.delete(bisbn);
		return result;
	}
}
