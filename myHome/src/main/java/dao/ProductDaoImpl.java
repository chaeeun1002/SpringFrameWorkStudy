package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Condition;
import model.ItemInfo;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SqlSession session;
	
	public Integer getMaxCode() {
		Integer max_code = session.selectOne("mappers.mymapper.getMaxCode");
		if(max_code == null) max_code = 0;
		return max_code;
	}

	public void putItemInfo(ItemInfo item) {
		session.insert("mappers.mymapper.putItemInfo",item);
	}

	public List<ItemInfo> readItem(Condition c) {
		return session.selectList("mappers.mymapper.getItemInfoList",c);
	}

	public Integer getProductCount() {
		return session.selectOne("mappers.mymapper.getItemInfoCount");
	}

	public ItemInfo getProductDetail(Integer code) {
		return session.selectOne("mappers.mymapper.getItemInfoDetail",code);
	}

	
}
