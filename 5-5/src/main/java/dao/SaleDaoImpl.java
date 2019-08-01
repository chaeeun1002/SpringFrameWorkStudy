package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Sale;
@Repository
public class SaleDaoImpl implements SaleDao {
	@Autowired
	private SqlSession session;
	
	public void create(Sale sale) {
		this.session.insert("mappers.mymapper.putSale",sale);
	}

	public Integer findMaxSaleId() {
		Integer max = this.session.selectOne("mappers.mymapper.getMaxSaleId");
		if(max == null) {
			return 0;
		}
		return max;
	}

}
