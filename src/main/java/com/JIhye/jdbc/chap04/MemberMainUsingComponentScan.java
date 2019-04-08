package com.JIhye.jdbc.chap04;

import com.JIhye.jdbc.chap03.RegisterRequest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMainUsingComponentScan {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				"chap04.xml");
		MemberRegisterService regService = ctx.getBean("memberRegisterService",
				MemberRegisterService.class);
		
		// registerRequest 초기화
		RegisterRequest req = new RegisterRequest();
		req.setEmail("lmh6479@naver.com");
		req.setPassword("xxxx");
		req.setName("JIhye");

		// 회원 등록
		regService.regist(req);
		ctx.close();
	}
}