package dao;

import model.Sale;

public interface SaleDao {
	void create(Sale sale);
	Integer findMaxSaleId();
}
