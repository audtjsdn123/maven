package chap06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
	
	@Bean //helloController라는 이름의 bean 생성
	public HelloController helloController() {
		return new HelloController();
	}
}
