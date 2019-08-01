package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Item;
import model.User;

@Controller
public class DetailController {
	@Autowired
	private Shop shopService;
	@RequestMapping
	public ModelAndView detailItem(Integer itemId, HttpSession session) {
		Item item = this.shopService.getItemByItemId(itemId);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("item",item);//검색결과를 맵에 저장
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("detail");//jsp의 이름을 설정
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) {
			mav.addObject("loginUser",loginUser);
		}
		mav.addAllObjects(model);//맵을 ModelAndView에 저장
		return mav;//ModelAndView를 서블릿으로 리턴
	}
}
