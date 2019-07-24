package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Product;

public interface ProductDao {
	Product getProduct(Integer id) throws DataAccessException;
	List<Product> getProductList(Integer id) throws DataAccessException;
}
