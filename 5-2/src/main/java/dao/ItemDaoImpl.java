package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Item;

public class ItemDaoImpl implements ItemDao {
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public List<Item> findAll() {
		List<Item> list = session.selectList("mappers.mymapper.selectItemList");
		return list;
	}
	public Item findByPrimaryKey(Integer itemId) {
		Item item = session.selectOne("mappers.mymapper.selectItemByID",itemId);
		return item;
	}
}
