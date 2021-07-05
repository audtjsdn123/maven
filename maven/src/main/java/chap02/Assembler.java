package chap02;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	private MemberListService listSvc;
	private MemberSelectOneService seloSvc;
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		
		listSvc = new MemberListService(memberDao);
		seloSvc = new MemberSelectOneService(memberDao);
		
		
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
	
	public MemberListService getListSvc() {
		return listSvc;
	}
	
	public MemberSelectOneService getSeoloSvc() {
		return seloSvc;
	}
}
