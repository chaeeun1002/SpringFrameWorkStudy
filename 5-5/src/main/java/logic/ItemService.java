package logic;

import java.util.List;

import model.Item;

public interface ItemService {
	List<Item> getItemList();
	Item getItemByItemId(Integer id);
	List<Item> getItemByItemName(String name);
	void entryItem(Item item);
	void updateItem(Item item);
	void deleteItem(Integer id);
}
