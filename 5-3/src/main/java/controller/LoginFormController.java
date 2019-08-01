package controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;

@Controller
public class LoginFormController {
	private Shop shop;
	private Validator loginValidator;
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}
	
	@ModelAttribute
	public User setup() {
		return new User();
	}//콜백메서드(User를 생성)
	
	@RequestMapping(method=RequestMethod.GET)
	public String setupForm() {
		return "login";
	} 
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult br) {
		this.loginValidator.validate(user, br);//유효성 검사
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {//유효성 검사결과 에러가 있는 경우
			mav.getModel().putAll(br.getModel());
			//로그인 화면에서 입력했던 데이터를 지우지 않고 다시 출력한다.
			return mav;
		}
		try {
			User loginUser = this.shop.getUser(user);
			if(loginUser != null) {//로그인 성공한 경우
				mav.setViewName("loginSuccess");
				mav.addObject("loginUser",loginUser);
				return mav;
			}else {//로그인 실패한 경우
				br.reject("error.login.user");//화면에 출력될 메세지 설정
				mav.getModel().putAll(br.getModel());
				return mav;
			}
		}catch(EmptyResultDataAccessException e) {
			br.reject("error.login.user");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
	}
}
