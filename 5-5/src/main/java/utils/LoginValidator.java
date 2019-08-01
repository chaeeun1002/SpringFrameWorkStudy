package utils;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}//검증 대상이 되는 객체를 리턴한다.

	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if( !StringUtils.hasLength(user.getUserId())){
			errors.rejectValue("userId", "error.required");
			//항목 검사(errors.rejectValue)
		}//검증 대상의 각 항목에 대한 오류정보를 설정
		if( !StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required");
		}
		if(errors.hasErrors()) {
			errors.reject("error.input.user");
			//폼 검사(errors.reject)
		}//검증 대상 자체에 대한 오류 정보 설정
	}

}
