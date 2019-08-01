package model;

public class ItemSet {
	private Item item;//상품
	private Integer quantity;//갯수
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ItemSet(Item item, Integer quantity) {
		this.item = item;
		this.quantity = quantity;
	}//생성자(생성자를 이용해서 주입한다.)
	
	public void addQuantity(Integer addQuantity) {
		int number = addQuantity.intValue();//추가할 갯수
		int existQuantity = this.getQuantity().intValue();//기존갯수
		this.setQuantity(new Integer(number+existQuantity));
		//기존갯수 + 추가갯수 = 갯수
	}
}
