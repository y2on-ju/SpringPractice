package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch2") //지정된 패키지에서 발생한 예외처리
//@ControllerAdvice  // 모든 패키지에 적용
public class GlobalCatcher {
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
}
