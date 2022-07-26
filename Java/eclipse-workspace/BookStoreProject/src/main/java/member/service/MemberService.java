package member.service;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberService {

	// login business method
	public Member login(Member member) {
		
		// 로그인이 되는지 확인
		// database 처리를 위해 DAO 필요
		// DAO class 필요
		try {
			MemberDAO dao = new MemberDAO();
			member = dao.select(member);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return member;
	}
}
