package chap08;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired //어노테이션으로 등록한 빈을 @Autowired로 주입
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<MemberVo> selectList(){
		return sqlSessionTemplate.selectList("member.selectList"); // member.xml의 selectList
	}
	
	public MemberVo login(MemberVo vo) {
		return sqlSessionTemplate.selectOne("member.login", vo);
	}
	public MemberVo selectOne(int mno) {
		return sqlSessionTemplate.selectOne("member.selectOne", mno);
	}
	public int update(MemberVo vo) {
		return sqlSessionTemplate.update("member.update", vo);
	}

}
