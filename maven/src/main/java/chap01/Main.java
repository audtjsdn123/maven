package chap01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g = (Greeter) ctx.getBean("greeter");
		System.out.println(g.greet("홍길동"));
		

	}

}
