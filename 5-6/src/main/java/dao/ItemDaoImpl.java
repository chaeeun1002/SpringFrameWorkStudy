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
		return session.selectList("mappers.mymapper.getItemList");
	}

	
	public Item findByPrimaryKey(Integer id) {
		return session.selectOne("mappers.mymapper.getItem",id);
	}

	
	public List<Item> findByItemName(String name) {
		return session.selectList("mappers.mymapper.findItem",name);
	}

	
	public void create(Item item) {
		session.insert("mappers.mymapper.putItem",item);
	}

	
	public void update(Item item) {
		session.update("mappers.mymapper.updateItem",item);
	}

	
	public void delete(Integer id) {
		session.delete("mappers.mymapper.deleteItem",id);
	}

}
