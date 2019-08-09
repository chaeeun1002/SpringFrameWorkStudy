package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.ProductCatalog;
import model.Condition;
import model.ItemInfo;

@Controller
public class ItemController {

	@Autowired
	private ProductCatalog productCatalog;
	
	@RequestMapping(value="/item/itemTemplate.html", method=RequestMethod.GET)
	public ModelAndView itemTemplate() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject(new ItemInfo());//form:form에 사용될 객체 주입
		mav.addObject("BODY","itemInput.jsp");
		return mav;
	}
	
	@RequestMapping(value="/item/write.html", method=RequestMethod.POST)
	public ModelAndView write(ItemInfo item) {
		int max_code = this.productCatalog.getMaxCode()+1;
		item.setCode(max_code);
		this.productCatalog.insertItemInfo(item);
		ModelAndView mav = new ModelAndView("home/template");
		return new ModelAndView("redirect:/item/read.html");
	}
	
	@RequestMapping(value="/item/read.html", method=RequestMethod.GET)
	public ModelAndView read(Integer pageNo) {
		ModelAndView mav = new ModelAndView("home/template");
		Integer cnt = productCatalog.getProductCount();
		if(cnt == null) cnt = 0;
		int startRow = 0; int endRow = 0; int pageCnt = 0;
		int currentPage = 0;
		if(pageNo == null) currentPage = 1;
		else currentPage = pageNo;
		if(cnt > 0) {
			pageCnt = cnt / 5;
			if(cnt % 5 > 0) pageCnt++;
			startRow = (currentPage - 1) * 5 + 1;
			endRow = currentPage * 5;
			if(endRow > cnt) endRow = cnt;
		}
		Condition c = new Condition();
		c.setStartRow(startRow);
		c.setEndRow(endRow);
		List<ItemInfo> itemList = productCatalog.getProductList(c);
		mav.addObject("ITEM_LIST", itemList);
		mav.addObject("COUNT",pageCnt);
		mav.addObject("BODY","itemListView.jsp");
		return mav;
	}
	
	@RequestMapping(value="/item/readDetail.html", method=RequestMethod.GET)
	public ModelAndView readDetail(Integer CODE) {
		ModelAndView mav = new ModelAndView("home/template");
		ItemInfo item = this.productCatalog.getProductDetail(CODE);
		mav.addObject("ITEM",item);
		mav.addObject("BODY","itemView.jsp");
		return mav;
	}
}
