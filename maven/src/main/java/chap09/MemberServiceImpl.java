package chap09;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;
	
	@Override
	public List<MemberVo> selectList() {
		return dao.selectList();
	}

	@Override
	public MemberVo login(MemberVo vo) {
		return dao.login(vo);
	}

	@Override
	public MemberVo mypage(int mno) {
		return dao.selectOne(mno);
	}

	@Override
	public int update(MemberVo vo) {
		return dao.update(vo);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor= {Throwable.class})
	public int insert(MemberVo vo, HttpServletRequest req) {
		dao.insert(vo);
		// vo객체에 mno가 set이 되어있는 상태
		String[] school = req.getParameterValues("school");
		String[] year = req.getParameterValues("year");
		for (int i=0; i<school.length; i++) {
			if(!"".equals(school[i]) && !"".equals(year[i])) {
			Map map = new HashMap();
			map.put("members_mno", vo.getMno());
			map.put("school", school[i]);
			map.put("year", year[i]);
			dao.insertSchool(map);
			}
		}
		return 0;
	}
}
