package dao;

import java.util.List;

import model.Condition;
import model.ItemInfo;

public interface ProductDao {
	Integer getMaxCode();
	void putItemInfo(ItemInfo item);
	
	List<ItemInfo> readItem(Condition c);
	Integer getProductCount();
	ItemInfo getProductDetail(Integer code);
 }
