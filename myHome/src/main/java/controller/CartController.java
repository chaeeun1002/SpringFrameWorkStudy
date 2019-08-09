package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDao;
import javassist.bytecode.Descriptor.Iterator;
import model.Cart;
import model.CartItem;
import model.User;

@Controller
public class CartController {

	@Autowired
	private Cart cart;
	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping(value="/cart/login.html", method=RequestMethod.POST)
	public ModelAndView login(@Valid User user, BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/cartLogin");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		ModelAndView mav = new ModelAndView("home/template");
		String password = loginDao.getPassword(user.getId());
		if(! user.getPassword().equals(password)) {
			mav.addObject("cartlogin","YES");
			return mav;
		}else {
			mav.addObject("cartlogin","SUCCESS");
			session.setAttribute("loginUser", user.getId());
			List<CartItem> cartList = cart.getCart(user.getId());
			if(cartList != null) {//장바구니 정보가 존재하는 경우
				Iterator it = cartList.iterator();
				int i = 0;
				while(it.hasNext()) {
					CartItem ci = (CartItem)it.next();
					this.cart.setCodeList(i, ci.getCode());
					this.cart.setNumList(i, ci.getNum());
					i++;
				}
				session.setAttribute("CART", this.cart);
			}
		}
		return null;
	}
	
	@RequestMapping(value="/cart/login.html", method=RequestMethod.GET)
	public ModelAndView open() {
		ModelAndView mav = new ModelAndView("home/cartLogin");
		mav.addObject("RESULT","nologin");
		mav.addObject(new User());
		return mav;
	}
	
	@RequestMapping(value="/cart/addCart.html", method=RequestMethod.GET)
	public ModelAndView addCart(String CODE, HttpSession session) {
		String id = (String)session.getAttribute("loginUser");
		if(id == null) {
			ModelAndView mav = new ModelAndView("redirect:/cart/login.html");
			mav.addObject("RESULT","nologin");
			return mav;
		}
		Cart cart = (Cart)session.getAttribute("CART");
		if(cart == null) cart = this.cart;//세션에 카트가 없으면 생성
		cart.addCart(CODE, 1, id);
		session.setAttribute("CART", cart);//카트를 세션에 저장
		ModelAndView mav = new ModelAndView("home/addCartResult");
		mav.addObject("ITEM_NUM",1);
		return mav;
	}
}
