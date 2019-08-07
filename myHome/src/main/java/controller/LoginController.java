package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.LoginCatalog;
import model.User;

@Controller
public class LoginController {
	
	@Autowired
	private LoginCatalog loginCatalog;
	
	@RequestMapping(value="/login/login.html", method=RequestMethod.GET)
	public ModelAndView toLogin() {
		ModelAndView mav = new ModelAndView("home/loginForm");
		mav.addObject(new User());//form:form에 사용될 객체 주입
		return mav;
	}
	
	@RequestMapping(value="/login/template.html", method=RequestMethod.POST)
	public ModelAndView login(@Valid User user, HttpSession session) {
		ModelAndView mav = new ModelAndView("home/template");
		if(user.getId().equals("")) return mav;
		if(user.getPassword().equals("")) return mav;
		String password = this.loginCatalog.getPwd(user.getId());
		if(!user.getPassword().equals(password)) {
			//id는 일치하지만 암호가 일치하지 않을 경우
			mav.addObject("BODY","loginResult.jsp");
		}else {
			//id와 암호가 모두 일치하는 경우
			session.setAttribute("loginUser", user.getId());
			mav.addObject("BODY","loginResult.jsp");
		}
		return mav;
	}
}
