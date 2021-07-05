package chap04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"chap04"})
public class AppCtx {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService regSvc() {
		MemberRegisterService regSvc = new MemberRegisterService();
		return regSvc;
	}
	
	@Bean
	public ChangePasswordService pwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		//pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberListService listSvc() {
		MemberListService listSvc = new MemberListService();
		return listSvc;
	}
	
	@Bean
	public MemberSelectOneService infoSvc() {
		return new MemberSelectOneService(memberDao());
	}
}
