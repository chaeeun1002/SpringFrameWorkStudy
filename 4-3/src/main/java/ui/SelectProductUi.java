package ui;

import java.util.List;

import dao.ProductDao;
import model.Product;

public class SelectProductUi extends AbstarctUiTemplate {
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	protected void showMenu() {
		System.out.println("==========ORM 프로젝트==========");
		System.out.println("1. 돌아가기");
		System.out.println();
		System.out.println("번호를 입력하고 Enter를 누르세요.");
	}

	@Override
	protected int getMaxMenuNumber() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	protected int getMinMenuNumber() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	protected void execute(int number) {
		switch(number) {
		case 1 : return;
		}
	}
	
	protected Integer getShopId() {
		System.out.println("목록을 표시하려는 상점번호를 입력하고 Enter를 누르세요.");
		String shopId = this.getInputedString();
		return Integer.valueOf(shopId);
	}
	
	protected void showProductList(List<Product> list) {
		System.out.println("=============================");
		System.out.println();
		if(! list.isEmpty()) {
			Product product = list.get(0);
			System.out.printf("상점명:%s\n",product.getShop().getShop_name());
		}
		System.out.println();
	}
}
