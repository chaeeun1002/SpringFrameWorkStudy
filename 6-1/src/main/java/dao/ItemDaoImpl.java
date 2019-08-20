package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private SqlSession session;
	
	
	public List<Item> findAll() {
		return session.selectList("mappers.mymapper.selectAll");
	}

	
	public Item findByPrimaryKey(Integer itemId) {
		return session.selectOne("mappers.mymapper.selectItem",itemId);
	}

	
	public List<Item> findByItemName(String itemName) {
		return session.selectOne("mappers.mymapper.selectName",itemName);
	}

	
	public void create(Item item) {
		session.insert("mappers.mymapper.insertItem",item);
	}

	
	public void update(Item item) {
		session.update("mappers.mymapper.updateItem",item);
	}

	
	public void delete(Item item) {
		session.delete("mappers.mymapper.deleteItem",item);
	}

	
	public String getPicture(Integer itemId) {
		return session.selectOne("mappers.mymapper.getPicture",itemId);
	}

}
