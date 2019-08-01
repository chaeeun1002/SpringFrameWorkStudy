package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;
import utils.UserEntryValidator;

@Controller
public class UserEntryFormController {
	@Autowired
	private Shop shopservice;
	@Autowired
	private UserEntryValidator userEntryValidator;
	@Autowired
	private MessageSource messageSource;
	@ModelAttribute
	public User setup() {
		User user = new User();
		MessageSourceAccessor msa = new MessageSourceAccessor(this.messageSource);//properties파일에 접근하는 객체
		user.setUserId(msa.getMessage("user.userId.default"));
		user.setUserName(msa.getMessage("user.userName.default"));
		return user;//jsp로 전달됨.(form:form)
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String toUserEntry() {//view의 이름이 리턴됨.(default 페이지)
		return "userentryform/userEntry";
	}//userEntry라는 이름의 jsp
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult br) {//jsp에서 보내주는 데이터를 매개변수로 받아줌
		//유효성검사
		this.userEntryValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());//mav에 br이 가지고 있는 에러메시지를 보내줌.
			return mav;//다시 동일한 등록폼(userEntry.jsp)=>default페이지가 열린다.
		}
		try {
			this.shopservice.entryUser(user);
			mav.setViewName("userEntrySuccess");
			mav.addObject("user",user);//userEntrySuccess페이지에 user라는 데이터를 보내줌.
			return mav;//화면을 userEntrySuccess로 바꾼다.
		}catch(DataIntegrityViolationException e) {
			//만약 동일한 데이터가 DB에 존재하는 경우, 예외가 발생
			br.reject("error.duplicate.user");
			mav.getModel().putAll(br.getModel());
			return mav;//다시 동일한 등록폼(userEntry.jsp)가 열린다.
		}
	}
}
