package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	List<Item> findAll();
	Item findByPrimaryKey(Integer itemId);
	List<Item> findByItemName(String itemName);
	void create(Item item);
	void update(Item item);
	void delete(Item item);
	String getPicture(Integer itemId);
}
