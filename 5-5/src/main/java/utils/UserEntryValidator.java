package utils;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class UserEntryValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		//유효성 검사의 대상이 되는 클래스가 명시되어야 함.
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if(!StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required.user");
		}
		if(!StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required.user");
		}
		if(!StringUtils.hasLength(user.getUserName())) {
			errors.rejectValue("userName", "error.required.user");
		}
		if(!StringUtils.hasLength(user.getPostCode())) {
			errors.rejectValue("postCode", "error.required.user");
		}
		if(!StringUtils.hasLength(user.getAddress())) {
			errors.rejectValue("address", "error.required.user");
		}
		if(!StringUtils.hasLength(user.getEmail())) {
			errors.rejectValue("email", "error.required.user");
		}
		if(!StringUtils.hasLength(user.getBirthday())) {
			errors.rejectValue("birthday", "error.required.user");
		}
		if(user.getBirthday().length() != 8) {
			errors.rejectValue("birthday", "typeMismatch.user");
		}
		if(errors.hasErrors()) {//폼에 에러가 있는 경우
			errors.reject("error.input.user");
		}
		//instanceof : 조상클래스를 찾는 연산자(return type : boolean)
	}

}
