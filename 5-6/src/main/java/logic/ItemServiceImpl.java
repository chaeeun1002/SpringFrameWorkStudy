package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import model.Item;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;
	
	public List<Item> getItemList() {
		return this.itemDao.findAll();
	}

	
	public Item getItemByItemId(Integer id) {
		return this.itemDao.findByPrimaryKey(id);
	}

	
	public List<Item> getItemByItemName(String name) {
		return this.itemDao.findByItemName(name);
	}

	
	public void entryItem(Item item) {
		this.itemDao.create(item);

	}

	
	public void updateItem(Item item) {
		this.itemDao.update(item);

	}

	
	public void deleteItem(Integer id) {
		this.itemDao.delete(id);

	}

}
