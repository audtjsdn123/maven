package chap05;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeAspect {

	@Pointcut("execution(public * chap05..*(..))")
	private void publicTarget() {}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		System.out.println("메서드 실행전!!!");
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			System.out.println("메서드 실행끝!!!");
			long end = System.nanoTime();
			System.out.println("AOP : "+(end-start));
		}
	}
}
