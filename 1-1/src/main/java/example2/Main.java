package example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//환경설정 파일을 접근하는 객체가 필요 -> ApplicationContext
		ApplicationContext ctx = new ClassPathXmlApplicationContext("example2/beans.xml");
		MyMessage msg = (MyMessage)ctx.getBean("message_kr");
		msg.sayHello("가나다");
		msg = (MyMessage)ctx.getBean("message_en");
		msg.sayHello("가나다");
	}

}
