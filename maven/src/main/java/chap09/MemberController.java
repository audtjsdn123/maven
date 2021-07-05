package chap09;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired // 서비스 주입 (여기서 필요한 객체를 주입)
	MemberService service;
//	@Autowired
//	MemberDao dao;
//	@Autowired
//	SqlSessionTemplate sqlSessionTemplate;
	
	@RequestMapping("/member/index.do")
	public String index(Model model) {
		List<MemberVo> list = service.selectList();
		model.addAttribute("list", list);
		return "member/index";
	}
	
	@RequestMapping("/member/form.do")
	public String form(MemberVo vo, @CookieValue(value = "cookieEmail", required = false) Cookie cookie) {
		if (cookie != null) {
			vo.setEmail(cookie.getValue());
			vo.setCheckEmail("check");
		}
		return "member/form";
	}
	
	@RequestMapping("/member/login.do")
	public String login(MemberVo vo, HttpSession sess/*, HttpServletRequest req*/, HttpServletResponse res) throws Exception{ // 파라미터를 받아야됨 (email, pwd)
		MemberVo m =service.login(vo);
		if (m != null) { // 로그인 성공하면.
			// 세션에 저장
			// 세션객체를 가져오는 방법
			
			// 1. HttpServletRequest를 통해서
			// HttpSession session = req.getSession(); 
			//getSession(true) : 세션이 존재하지 않으면 새로 생성
			//getSession(false) : 세션이 존재하지 않으면 null을 리턴
			
			// 2. 매개변수로 HttpSession (스프링)
			// 세션에 저장
			sess.setAttribute("memberInfo", m); // m을 memberInfo로 
			// 쿠키에 저장
			Cookie cookie = new Cookie("cookieEmail", vo.getEmail());
			cookie.setPath("/");
			if ("check".equals(vo.getCheckEmail())) { // 쿠기 객체는 항상 저장
				cookie.setMaxAge(60*60*24*365); // 60초 60분 24시간 365일
			} else {
				cookie.setMaxAge(0); // 시간을 0으로
			}
			res.addCookie(cookie);
			return "redirect:index.do";
		} else {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('이메일과 비밀번호가 옳바르지 않습니다');");
			out.println("location.href='form.do';");
			out.println("</script>");
			return null; //그냥 null로 리턴해도 된다.
		}
	}
	
	@RequestMapping("/member/logout.do")
	public String logout(Model model, HttpSession sess, HttpServletResponse res) throws Exception{
		sess.invalidate();
		model.addAttribute("msg", "로그아웃되었습니다");
		model.addAttribute("url", "index.do");
		return "include/alert";
	}
	
	@RequestMapping("/member/mypage.do")
	public String mypage(Model model, HttpSession sess) throws Exception{
		// 세션에서 MemberVo객체를 가져오기
		MemberVo vo = (MemberVo)sess.getAttribute("memberInfo");
		if (vo != null) {
			MemberVo m = service.mypage(vo.getMno());
			model.addAttribute("vo", m);
			return "member/mypage";
		} else {
			model.addAttribute("msg", "로그인 후 사용가능합니다.");
			model.addAttribute("url", "index.do");
			return "include/alert";
		}
	}
	
	@RequestMapping("/member/update.do")
	public String update(Model model, MemberVo vo, HttpSession sess) {
		int r = service.update(vo);
		if (r == 0) {
			model.addAttribute("msg", "수정실패");
			model.addAttribute("url", "mypage.do");
			return "include/alert";
		} else {
			model.addAttribute("msg", "정상적으로 수정되었습니다.");
			model.addAttribute("url", "index.do");
			return "include/alert";
		}
	}
	
	@RequestMapping("/member/write.do")
	public String wirte(MemberVo vo)throws Exception {
		return "member/write";
	}
	@RequestMapping("/member/insert.do")
	public String wirte(MemberVo vo, HttpServletRequest req)throws Exception {
		service.insert(vo, req);
		return "redirect:index.do";
	}
}