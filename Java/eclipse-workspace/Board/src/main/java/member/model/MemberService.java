package member.model;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberService {

	public Member login(Member m) {
		
		MemberDAO dao;
		try {
			dao = new MemberDAO();
			m = dao.selete(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	public int signin(Member m) {
		
		MemberDAO dao;
		int result = 0;
		try {
			dao = new MemberDAO();
			result = dao.insert(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return result;
	}
	
}
