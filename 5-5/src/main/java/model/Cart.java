package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<ItemSet> itemList = new ArrayList<ItemSet>();
	
	public void push(ItemSet pushedItemSet) {
		boolean itemExistInCart = false;//이미 담긴 물건인지 검사
		Item pushedItem = pushedItemSet.getItem();
		int pushedItemId = pushedItem.getItemId().intValue();//번호
		for(ItemSet cartItemSet: this.itemList) {
			Item cartItem = cartItemSet.getItem();//카트의 물건을 불러옴
			int cartItemId = cartItem.getItemId().intValue();//번호
			if(cartItemId == pushedItemId) {
				cartItemSet.addQuantity(pushedItemSet.getQuantity());
				//기존의 물건 갯수에 담을 물건의 갯수를 누적한다.
				itemExistInCart = true;//기존의 물건임을 의미
				break;//반복 종료
			}//카트에 담긴 물건번호와 카트에 담을 물건번호를 비교한다.
		}//이미 카트에 담긴 물건인지를 반복해서 검사
		if(!itemExistInCart) {
			this.itemList.add(pushedItemSet);//새로운 물건이므로 카트에 담는다.
		}
	}//물건을 담는 메서드
	
	public List<ItemSet> getItemList(){
		return this.itemList;
	}
	
	public boolean isEmpty() {
		if(this.itemList == null || this.itemList.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void clearAll() {//장바구니를 비우는 메서드
		this.itemList = new ArrayList<ItemSet>();
	}
}
