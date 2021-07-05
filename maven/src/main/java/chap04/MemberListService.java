package chap04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListService {
	@Autowired
	private MemberDao memberDao;
	
//	public MemberListService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//		
//		  
//	}
	
	public void list() {
		memberDao.list();
	}

}
