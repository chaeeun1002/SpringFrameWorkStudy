package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CartItem;
@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private SqlSession session;
	
	public void insertCart(CartItem cartItem) {
		session.insert("mappers.mymapper.insertCart",cartItem);
	}

	public void deleteCart(CartItem cartItem) {
		session.delete("mappers.mymapper.deleteCart",cartItem);
	}

	public void updateCart(CartItem cartItem) {
		session.update("mappers.mymapper.updateCart",cartItem);
	}

	public Integer selectMaxCart() {
		Integer max_seqno = session.selectOne("mappers.mymapper.selectMaxCart");
		if(max_seqno == null){
			return 0;
		}else {
			return max_seqno;
		}
	}

	public List<CartItem> selectCart(String id) {
		return session.selectList("mappers.mymapper.selectCart",id);
	}

}
