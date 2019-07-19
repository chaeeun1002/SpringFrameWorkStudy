package sample4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

//일반 클래스로 어드바이스를 만들 때에는 이 클래스가 어드바이스임을 선언. -> @Aspect
@Aspect
public class MyAdvice {
	
//	자동으로 호출되는 콜백메서드임을 선언
//	@Around : 포인트 컷 전,후로 동작 , @Before : 포인트 컷 후에 동작 , @After : 포인트 컷 전에 동작
	
	/*
	 * *포인트 컷을 찾는 매핑사용법 
	 * execution (1 2 3) 
	 * 1 : public, private, protected 등 (생략가능) 
	 * 2 : 메서드의 리턴타입 
	 * 3 : 패키지이름, 클래스이름, 메서드이름(매개변수) 
	 * 예1 ) execution(* name()) -> 의미 : 이름이 name이고 매개변수가 없는 메서드 
	 * 예2 ) execution(* name(..)) -> 의미 : 이름이 name이고 매개변수가 있거나 없는 메서드(점 두개(..)는 0개 이상을 의미한다. 
	 * 예3 ) execution(public void name*()) -> 의미 : public이고 void이고 name으로 시작하는 이름의 메서드 매개변수는 없다. 
	 * 예4 ) execution(public * sample.*.*(..)) -> 의미 : public이고 모든 return타입이며 sample패키지에 속한 모든 메서드 
	 * 예5 ) execution(* sample.*.(..)) -> 의미 : 모든 return 타입이며 sample및 그 하위 패키지에 속한 모든 메서드
	 */
	
	@Around("execution (* sayHello())")
	public Object doIt(ProceedingJoinPoint pjp) throws Throwable{
		//어드바이스의 콜백메서드의 리턴타입은 반드시 Object이어야 한다.
		StopWatch sw = new StopWatch();
		String methodName = pjp.getSignature().getName();
		System.out.println("어라운드 어드바이스 실행");
		sw.start(methodName);//시간 측정
		Object obj = pjp.proceed();
		sw.stop();//시간 측정 중지
		System.out.println("어라운드 어드바이스 재실행");
		System.out.println("포인트 컷 실행시간 :"+sw.getTotalTimeMillis()/1000+"초");
		return obj;
	}
	
}
