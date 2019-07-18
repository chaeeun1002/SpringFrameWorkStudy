package example3;

public class MrPark implements Human {
	private String name;
	private Item item;
	public void setName(String name) {
		this.name = name;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public void has() {
		System.out.println(name+"입니다. 다음 상품을 가지고 있습니다.");
		item.showname();
	}

}
