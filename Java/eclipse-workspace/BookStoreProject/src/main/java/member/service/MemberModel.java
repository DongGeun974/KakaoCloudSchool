package member.service;

import javax.naming.NamingException;

import member.dao.MemberDAOCopy;
import member.vo.MemberCopy;

public class MemberModel {
	
	public MemberCopy login(MemberCopy m) {
		// database
		// using DAO
		try {
			MemberDAOCopy dao = new MemberDAOCopy();
			m = dao.select(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
}
