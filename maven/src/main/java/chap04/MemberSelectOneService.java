package chap04;

public class MemberSelectOneService {
	private MemberDao memberDao;
	
	public MemberSelectOneService(MemberDao memberDao) {
		this.memberDao = memberDao;
		
		  
	}
	
	public Member selectOne(String email) {
		Member m = memberDao.selectByEmail(email);
		return m;
	}

}
