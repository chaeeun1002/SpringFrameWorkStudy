package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Item;
import model.User;

@Controller
public class IndexController{
	@Autowired
	private Shop shopService;
	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		List<Item> itemList = this.shopService.getItemList();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("itemList", itemList);
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("index");
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) {
			mav.addObject("loginUser",loginUser);
		}
		mav.addAllObjects(model);
		return mav;
	}

}
