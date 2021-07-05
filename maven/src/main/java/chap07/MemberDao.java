package chap07;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplete;  //@Bean으로 등록한 SqlSessionTemplate을 @Autowired
	
	public List<MemberVo> selectList() {
		return sqlSessionTemplete.selectList("member.selectList"); //("xml이 있는 위치","파라미터")  **namespace.id
	}
}
