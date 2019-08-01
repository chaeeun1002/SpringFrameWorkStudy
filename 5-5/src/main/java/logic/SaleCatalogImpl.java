package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.SaleDao;
import dao.SaleDetailDao;
import model.Sale;
import model.SaleDetail;
@Repository
public class SaleCatalogImpl implements SaleCatalog {
	@Autowired
	private SaleDao saleDao;
	@Autowired
	private SaleDetailDao saleDetailDao;
	public void entrySale(Sale sale) {
		this.saleDao.create(sale);
		List<SaleDetail> saleDetailList = sale.getSaleDetailList();
		for(SaleDetail saleDetail:saleDetailList) {
			this.saleDetailDao.create(saleDetail);
		}
	}

	public Integer getNewSaleId() {
		int newSaleId = this.saleDao.findMaxSaleId()+1;
		return newSaleId;
	}

}
