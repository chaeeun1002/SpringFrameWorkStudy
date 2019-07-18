package example3;

public class Apple implements Item{
	private String name;
	
	public void setName(String name) {//은닉된 name에 이름을 넣어주기 위해 setter메서드만 생성
		this.name = name;
	}

	@Override
	public void showname() {
		System.out.println(name+"입니다.");
	}
	
}
