package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Sale {
	private Integer saleId;
	private String userId;
	private String updateTime;
	private List<SaleDetail> saleDetailList = new ArrayList<SaleDetail>();
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addSaleDetail(SaleDetail detail) {
		this.saleDetailList.add(detail);
	}
	
	public void setSaleDetailList(List<SaleDetail> saleDetailList) {
		this.saleDetailList = saleDetailList;
	}
	
	public List<SaleDetail> getSaleDetailList(){
		return saleDetailList;
	}
	
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = String.valueOf(updateTime);
	}
}
