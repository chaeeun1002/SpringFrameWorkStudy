package example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("example3/beans.xml");
		MrHong mrHong = (MrHong)ctx.getBean("mrHong");
		mrHong.has();
		MrHong mrHong2 = (MrHong)ctx.getBean("mrHong2");
		mrHong2.has();
		MrPark mrPark = (MrPark)ctx.getBean("mrPark");
		mrPark.has();
		MrPark mrPark2 = (MrPark)ctx.getBean("mrPark2");
		mrPark2.has();
	}

}
