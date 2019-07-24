package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;

import dao.ShopDao;
import model.Shop;

public class ShopDaoImpl implements ShopDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Shop> getShopList() throws DataAccessException {
		List<Shop> list = em.createQuery("from shop",Shop.class).getResultList();
		return list;
	}

	@Override
	public Shop getShop(Integer shopId) throws DataAccessException {
		Shop shop = em.createQuery("from shop where shop_id = :shop_id",Shop.class).setParameter("shop_id", shopId).getSingleResult();
		return shop;
	}

}
