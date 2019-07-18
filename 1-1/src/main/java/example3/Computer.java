package example3;

public class Computer implements Item {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void showname() {
		System.out.println(name+"입니다.");
	}

}
