package example4;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	private Outputter outputter;
	//setter메서드로 들어가는 값과 생성자로 들어가는 값은 환경설정 파일에서의 주입방식이 달라짐.
	public MessageBeanImpl(String name) {
		this.name = name;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	@Override
	public void sayHello() {
		String msg = greeting + name + "~";
		try {
			outputter.output(msg);//파일에 출력
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
