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
//		binder.setValidator(new UserValidator()); //UserValidator�� WebDataBinder�� ���� Validator�� ���
		binder.addValidators(new UserValidator()); //UserValidator�� WebDataBinder�� ���� Validator�� ���
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList=" +validatorList);
	}
	
	@RequestMapping("/register/add") //�ű�ȸ�� ���� ȭ��
	public String register() {
		return "registerForm"; //WEB-INF/views/registerForm.jsp
	}

//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/add") // ������4.3���� ����
	public String save(@Valid User user, BindingResult result, Model m) throws Exception{
		System.out.println("user=" +user);
		
//		//���� ���� - Validator�� ���� �����ϰ� validate()�� ���� ȣ��
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); // BindingResult�� Error�� �ڼ�
		
		//User��ü�� ������ ��� ������ ������, RegisterForm�� �̿��ؼ� ������ ������� ��.
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		
		
//		// 1. ��ȿ�� �˻�
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "redirect:/register/add";
////			return "redirect:/register/add?msg="+msg; // URL���ۼ�(rewriting)//�� �����̶� ��ɰ���
//		}
		
		// 2.DB�� �ű�ȸ�� ������ ����
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
}
}
