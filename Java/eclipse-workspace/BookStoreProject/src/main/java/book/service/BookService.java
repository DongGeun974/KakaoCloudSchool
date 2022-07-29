package book.service;

import java.util.ArrayList;

import book.dao.BookDAO;
import book.vo.Book;

public class BookService {

	public ArrayList<Book> searchByKeyword(String keyword) {
		
		BookDAO dao;
		ArrayList<Book> list = null;
		try {
			dao = new BookDAO();
			list = dao.select(keyword);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

	public int deleteByIsbn(String isbn) {
		// TODO Auto-generated method stub
		BookDAO dao;
		int result = 0;
		try {
			dao = new BookDAO();
			result = dao.delete(isbn);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}

}
