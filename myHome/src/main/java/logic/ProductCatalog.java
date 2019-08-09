package logic;

import java.util.List;

import model.Condition;
import model.ItemInfo;

public interface ProductCatalog {
	Integer getMaxCode();
	void insertItemInfo(ItemInfo item);
	
	List<ItemInfo> getProductList(Condition c);
	Integer getProductCount();
	ItemInfo getProductDetail(Integer code);
}
