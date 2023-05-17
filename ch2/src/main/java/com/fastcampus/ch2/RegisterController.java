package com.fastcampus.ch2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator()); //UserValidator를 WebDataBinder의 로컬 Validator로 등록
		binder.addValidators(new UserValidator()); //UserValidator를 WebDataBinder의 로컬 Validator로 등록
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList=" +validatorList);
	}
	
	@RequestMapping("/register/add") //신규회원 가입 화면
	public String register() {
		return "registerForm"; //WEB-INF/views/registerForm.jsp
	}

//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/add") // 스프링4.3부터 가능
	public String save(@Valid User user, BindingResult result, Model m) throws Exception{
		System.out.println("user=" +user);
		
//		//수동 검증 - Validator를 직접 생성하고 validate()를 직접 호출
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); // BindingResult는 Error의 자손
		
		//User객체를 검증한 결과 에러가 있으면, RegisterForm을 이용해서 에러를 보여줘야 함.
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		
		
//		// 1. 유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "redirect:/register/add";
////			return "redirect:/register/add?msg="+msg; // URL재작성(rewriting)//위 두줄이랑 기능같음
//		}
		
		// 2.DB에 신규회원 정보를 저장
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
}
}
