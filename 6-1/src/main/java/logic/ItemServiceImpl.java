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
	
	
	public List<Item> findAll() {
		return this.itemDao.findAll();
	}

	
	public Item findByPrimaryKey(Integer itemId) {
		return this.itemDao.findByPrimaryKey(itemId);
	}

	
	public List<Item> findByItemName(String itemName) {
		return this.itemDao.findByItemName(itemName);
	}

	
	public void create(Item item) {
		this.itemDao.create(item);
	}

	
	public void update(Item item) {
		this.itemDao.update(item);
	}

	
	public void delete(Item item) {
		this.itemDao.delete(item);
	}

	
	public String getPicture(Integer itemId) {
		return this.itemDao.getPicture(itemId);
	}

}
