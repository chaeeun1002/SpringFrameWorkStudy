package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;

import dao.ProductDao;
import model.Product;

public class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Product getProduct(Integer id) throws DataAccessException {
		Product product = em.createQuery("from product where product_id = :product_id",Product.class).setParameter("product_id", id).getSingleResult();
		return product;
	}

	@Override
	public List<Product> getProductList(Integer id) throws DataAccessException {
		List<Product> list = em.createQuery("from product where product.shop.shop_id = :shop_id",Product.class).setParameter("shop_id", id).getResultList();
		return list;
	}

}
