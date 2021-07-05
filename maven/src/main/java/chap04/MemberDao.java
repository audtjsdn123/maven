package chap04;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	private static long nextId = 0;
	private Map<String, Member>map = new HashMap<String, Member>();
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	public void list() {
		for (String key : map.keySet()) {
            Member value = map.get(key);
            System.out.println("[Name]:" + value.getName() + ", [email]:" + value.getEmail() + "\n");
        }
	}
	
	
}
