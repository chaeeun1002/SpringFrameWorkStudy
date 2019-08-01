package logic;

import java.util.List;

import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

public interface Shop {
	void entryUser(User user);
	User getUserByUserIdAndPassword(User user);
	List<Item> getItemList();
	Item getItemByItemId(Integer itemId);
	Cart getCart();
	Integer caculateTotal(List<ItemSet> itemList);
	void checkout(User user, Cart cart);
}
