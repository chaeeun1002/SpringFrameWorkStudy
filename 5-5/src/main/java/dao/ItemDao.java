package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	List<Item> findAll();
	Item findByPrimaryKey(Integer itemId);
	List<Item> findByItemName(String name);//이름으로 상품 검색
	void create(Item item);//상품 등록
	void update(Item item);//상품 변경
	void delete(Integer id);//상품 삭제
}
