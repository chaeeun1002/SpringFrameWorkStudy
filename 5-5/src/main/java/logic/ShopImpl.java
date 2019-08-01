package logic;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cart;
import model.Item;
import model.ItemSet;
import model.Sale;
import model.SaleDetail;
import model.User;
@Service
public class ShopImpl implements Shop {
	@Autowired
	private UserCatalog userCatalog;
	@Autowired
	private ItemCatalog itemCatalog;
	@Autowired
	private SaleCatalog saleCatalog;
	public void entryUser(User user) {
		this.userCatalog.entryUser(user);
	}
	public User getUserByUserIdAndPassword(User user) {
		return this.userCatalog.getUserByUserIdAndPassword(user);
	}
	public List<Item> getItemList() {
		return this.itemCatalog.getItemList();
	}
	public Item getItemByItemId(Integer itemId) {
		return this.itemCatalog.getItemByItemId(itemId);
	}
	public Cart getCart() {
		return new Cart();
	}
	public Integer caculateTotal(List<ItemSet> itemList) {
		int totalAmount = 0;
		for(ItemSet itemSet: itemList) {//향상된 for문(기존 for문보다 반복하는 속도가 빨라짐)
			int price = itemSet.getItem().getPrice().intValue();
			int quantity = itemSet.getQuantity().intValue();
			totalAmount = totalAmount + (price * quantity);
		}
		return new Integer(totalAmount);
	}
	public void checkout(User user, Cart cart) {
		Sale sale = createSale(user,cart);
		entrySale(sale);
	}
	
	private void entrySale(Sale sale) {
		this.saleCatalog.entrySale(sale);
	}
	
	private Integer getNewSaleId() {
		Integer id = this.saleCatalog.getNewSaleId();
		return id;
	}
	
	private Timestamp getCurrentTime() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
	
	private SaleDetail createSaleDetail(Sale sale, int saleDetailId, ItemSet itemSet, Timestamp currentTime) {
		return new SaleDetail(sale, new Integer(saleDetailId), itemSet, currentTime);
	}
	
	private Sale createSale(User user, Cart cart) {
		Sale sale = new Sale();
		sale.setSaleId(getNewSaleId());
		sale.setUser(user);
		sale.setUserId(user.getUserId());
		Timestamp currentTime = getCurrentTime();
		sale.setUpdateTime(currentTime);
		List<ItemSet> itemList = cart.getItemList();
		for(int i = 0; i<itemList.size(); i++) {
			ItemSet itemSet = (ItemSet)itemList.get(i);
			int saleDetailId = i+1;
			SaleDetail saleDetail = createSaleDetail(sale,saleDetailId,itemSet,currentTime);
			sale.addSaleDetail(saleDetail);
		}
		return sale;
	}

}
