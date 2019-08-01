package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("USER_KEY");
		ModelAndView mav = new ModelAndView("logout/logout");
		return mav;
	}
	
}
