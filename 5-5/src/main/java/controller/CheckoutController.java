package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import logic.Shop;
import model.Cart;
import model.ItemSet;
import model.User;

@Controller
public class CheckoutController {
	@Autowired
	private Shop shopService;
	
	@RequestMapping
	public ModelAndView checkout(HttpSession session) {
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null) {
			throw new LoginRequiredException("로그인 되어있지 않습니다.");
		}
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null || cart.isEmpty()) {
			throw new CartEmptyException("카트가 비었습니다.");
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser",loginUser);
		List<ItemSet> itemList = cart.getItemList();
		mav.addObject("itemList",itemList);
		
		Integer totalAmount = this.shopService.caculateTotal(itemList);
		mav.addObject("totalAmount",totalAmount);
		return mav;
	}
}
