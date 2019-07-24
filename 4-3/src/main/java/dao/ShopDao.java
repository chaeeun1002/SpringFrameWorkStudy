package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Shop;

public interface ShopDao {
	List<Shop> getShopList() throws DataAccessException;
	Shop getShop(Integer shopId) throws DataAccessException;
}
