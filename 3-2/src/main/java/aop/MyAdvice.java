package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAdvice {
	
	public void logBefore(JoinPoint pjp) throws Throwable{
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().getName();
		//조인 포인트의 메서드 이름과 클래스 이름을 획득
		System.out.println("AOP가 적용됨..."+className+","+methodName+"이 호출됨");
	}
}
