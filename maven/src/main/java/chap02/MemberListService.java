package chap02;

public class MemberListService {
	private MemberDao memberDao;
	
	public MemberListService(MemberDao memberDao) {
		this.memberDao = memberDao;
		
		  
	}
	
	public void list() {
		memberDao.list();
	}

}
