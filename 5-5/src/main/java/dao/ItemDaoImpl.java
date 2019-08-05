package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;
//자동주입(객체) : Repository
@Repository
public class ItemDaoImpl implements ItemDao {
	//자동주입(속성) : Autowired
	@Autowired
	private SqlSession session;
	public List<Item> findAll() {
		List<Item> list = session.selectList("mappers.mymapper.selectItemList");
		return list;
	}
	public Item findByPrimaryKey(Integer itemId) {
		Item item = session.selectOne("mappers.mymapper.selectItemByID",itemId);
		return item;
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
