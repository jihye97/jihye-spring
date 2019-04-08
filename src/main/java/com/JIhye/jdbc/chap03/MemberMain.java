package com.JIhye.jdbc.chap03;

public class MemberMain {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		MemberRegisterService regService = new MemberRegisterService(memberDao);

		// registerRequest 초기화
		RegisterRequest req = new RegisterRequest();
		req.setEmail("lmh6479@naver.com");
		req.setPassword("xxxx");
		req.setName("JIhye");

		// 회원 등록
		regService.regist(req);
	}
}