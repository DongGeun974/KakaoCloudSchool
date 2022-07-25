package _220722.setp5;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// service없이 main에서 logic처리
		ConnectionMaker connectionMaker = new NUserDAO();
		
		UserDAO dao = new UserDAO(connectionMaker);
		
		User user = new User();
		user.setId("1");
		user.setName("hong");
		user.setPassword("test1234");
		
		dao.insert(user);
		
		System.out.println("새로운 사용자 등록");
		
		User user2 = dao.select("1");
		System.out.println(user2.getName() + ", " + user2.getPassword() );
	}

}
