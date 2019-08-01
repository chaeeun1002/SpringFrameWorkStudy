package example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//환경설정 파일을 접근하는 객체가 필요 -> ApplicationContext
		ApplicationContext ctx = new ClassPathXmlApplicationContext("example2/beans.xml");
		MyMessage msg_kr = (MyMessage)ctx.getBean("message_kr");
//		MyMessageKr m_kr = new MyMessageKr();
//		m_kr.sayHello("가나다");
		msg_kr.sayHello("가나다");
		msg_kr.sayHello("홍길동");
		MyMessage msg_en = (MyMessage)ctx.getBean("message_en");
		msg_en.sayHello("가나다");
		msg_en.sayHello("홍길동");
	}

}
