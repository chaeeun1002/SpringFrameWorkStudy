package sample4;

public class MessageBeanImpl implements MessageBean {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void sayHello() {
		try {
			Thread.sleep(1000);//1초 대기
		}catch(Exception e) {
			
		}
		System.out.println("안녕하세요? "+name);
	}

}
