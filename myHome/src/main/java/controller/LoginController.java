package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.LoginCatalog;
import model.User;

@Controller
public class LoginController {
	
	@Autowired
	private LoginCatalog loginCatalog;
	
	//로그인 폼을 띄우기 위해 메소드 GET을 받을 경우도 있고, POST를 받을 경우도 있을 경우에는
	//메서드 지정을 생략해도 된다.
	@RequestMapping(value="/login/login.html")
	public ModelAndView toLogin() {
		ModelAndView mav = new ModelAndView("home/loginForm");
		mav.addObject(new User());//form:form에 사용될 객체 주입
		return mav;
	}
	
	@RequestMapping(value="/login/template.html", method=RequestMethod.POST)
	public ModelAndView login(@Valid User user, BindingResult bindingResult,HttpSession session) {
		ModelAndView mav = new ModelAndView("home/template");
		if(bindingResult.getErrorCount() > 0) {
			mav.addObject("HEADER","loginForm.jsp");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
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
