package sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;
//안녕하세요~ 가 출력되기까지의 소요시간을 출력
public class MyAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//어드바이스가 동작되면 자동으로 invoke 메서드가 호출된다.
		StopWatch sw = new StopWatch();//시간측정을 위한 객체 생성
		String methodName = invocation.getMethod().getName();
		sw.start(methodName);//시간측정 시작
		System.out.println("어드바이스 실행됨, 호출메서드 이름 :"+methodName);
		//(조인포인트)
		Object obj = invocation.proceed();//원래 프로그램의 흐름이 진행됨(sayHello 메서드가 호출됨)
		sw.stop();//시간측정 중지
		System.out.println("어드바이스 다시 실행됨, 메서드 실행 시간 : "+sw.getTotalTimeMillis()/1000);
		return obj;
	}

}
