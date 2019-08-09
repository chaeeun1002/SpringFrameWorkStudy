package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import model.Condition;
import model.ItemInfo;
@Service
public class ProductCatalogImpl implements ProductCatalog {

	@Autowired
	private ProductDao productDao;
	
	public Integer getMaxCode() {
		return this.productDao.getMaxCode();
	}

	public void insertItemInfo(ItemInfo item) {
		this.productDao.putItemInfo(item);
	}

	public List<ItemInfo> getProductList(Condition c) {
		return this.productDao.readItem(c);
	}

	public Integer getProductCount() {
		return this.productDao.getProductCount();
	}

	public ItemInfo getProductDetail(Integer code) {
		return this.productDao.getProductDetail(code);
	}

	
}
