package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

@Controller
public class CartController {
	@Autowired
	private Shop shopService;
	
	@RequestMapping(value="/cart/cartAdd.html")
	public ModelAndView add(Integer itemId, Integer quantity, HttpSession session) {//-> 매개변수로 파라미터를 받음.
		Item selectedItem = this.shopService.getItemByItemId(itemId);
		//세션에서 Cart를 불러온다. 세션에 Cart가 없으면 생성
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) {
			cart = this.shopService.getCart();
		}
		cart.push(new ItemSet(selectedItem, quantity));
		session.setAttribute("CART_KEY", cart);//세션에 Cart저장
		session.setAttribute("ITEM_KEY", selectedItem);
		session.setAttribute("NUMBER", quantity);
		ModelAndView mav = new ModelAndView("redirect:/cart/result.html");//컨트롤러 매핑
		//mav에 데이터를 저장(->session에 데이터를 저장)
		//mav에 뷰이름을 저장(->생성자에 뷰이름을 저장)
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) {
			mav.addObject("loginUser",loginUser);
		}
		return mav;
	}
	
	@RequestMapping(value="/cart/result.html")
	public ModelAndView reload(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY"); 
		Item selectedItem = (Item)session.getAttribute("ITEM_KEY");
		Integer quantity = (Integer)session.getAttribute("NUMBER");
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("message",selectedItem.getItemName()+"을(를) "+quantity+"개 카트에 담았습니다.");
		mav.addObject("cart",cart);
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) {
			mav.addObject("loginUser",loginUser);
		}
		return mav;
	}
	
	@RequestMapping(value="/cart/cartClear.html")
	public ModelAndView clear(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) {
			cart = this.shopService.getCart();
		}
		cart.clearAll();
		session.setAttribute("CART_KEY", cart);
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("message","카트를 비웠습니다.");
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) {
			mav.addObject("loginUser",loginUser);
		}
		return mav;
	}
	
	@RequestMapping(value="/cart/cartConfirm.html")
	public ModelAndView confirm(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) {
			cart = this.shopService.getCart();
		}
		session.setAttribute("CART_KEY", cart);
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("cart",cart);
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) {
			mav.addObject("loginUser",loginUser);
		}
		return mav;
	}
}
