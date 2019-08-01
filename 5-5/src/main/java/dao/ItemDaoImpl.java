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
}
