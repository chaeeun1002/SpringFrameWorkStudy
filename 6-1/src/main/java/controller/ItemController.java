package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.ItemService;
import model.Item;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/item/index.html", method=RequestMethod.GET)
	public ModelAndView index() {
		List<Item> itemList = this.itemService.findAll();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("itemList", itemList);
		ModelAndView mav = new ModelAndView("index");
		mav.addAllObjects(model);
		return mav;
	}
	
	@RequestMapping(value="/item/search.html", method=RequestMethod.POST)
	public ModelAndView search(String itemName) {
		if(itemName == null || itemName.equals("")) {
			return this.index();//상품 이름이 없으면 목록 출력
		}
		List<Item> itemList = this.itemService.findByItemName(itemName);
		if(itemList == null || itemList.isEmpty()) {
			return this.index();//해당 이름의 상품이 없으면 목록 출력
		}
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList",itemList);
		return mav;
	}
	
	@RequestMapping(value="/item/create.html", method=RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("add");
		mav.addObject(new Item());
		return mav;
	}
	
	@RequestMapping(value="/item/register.html", method=RequestMethod.POST)
	public ModelAndView register(@Valid Item item, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("add");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		this.itemService.create(item);
		return this.index();//상품 등록 후 목록 출력
	}
	
	@RequestMapping(value="/item/edit.html", method=RequestMethod.GET)
	public ModelAndView edit(Integer itemId) {
		ModelAndView mav = new ModelAndView("update");
		Item item = this.itemService.findByPrimaryKey(itemId);
		mav.addObject(item);
		return mav;
	}
	
	@RequestMapping(value="/item/update.html", method=RequestMethod.POST)
	public ModelAndView update(@Valid Item item, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("update");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		this.itemService.update(item);
		return this.index();//상품 정보 변경 후 목록 출력
	}
	
	@RequestMapping(value="/item/confirm.html", method=RequestMethod.GET)
	public ModelAndView confirm(Integer itemId) {
		ModelAndView mav = new ModelAndView("delete");
		Item item = this.itemService.findByPrimaryKey(itemId);
		mav.addObject(item);
		return mav;
	}
	
	@RequestMapping(value="/item/delete.html", method=RequestMethod.POST)
	public ModelAndView delete(Item item) {
		this.itemService.delete(item);
		return this.index();//상품 정보 삭제 후 목록 출력
	}
	
	@RequestMapping(value="/item/image.html", method=RequestMethod.GET)
	public ModelAndView image(Integer itemId) {
		String picture_url = this.itemService.getPicture(itemId);
		ModelAndView mav = new ModelAndView("delete");
		mav.addObject("picture_url",picture_url);
		return mav;
	}
	
}














