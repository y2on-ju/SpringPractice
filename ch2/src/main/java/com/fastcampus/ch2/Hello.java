package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. ���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
public class Hello {
	int iv = 10;         // �ν��Ͻ� ����
	static int cv = 20; //  static ����
	// 2. URL�� �޼ҵ带 ����
	@RequestMapping("/hello")
	public void main() {
		System.out.println("Hello");
	}

}