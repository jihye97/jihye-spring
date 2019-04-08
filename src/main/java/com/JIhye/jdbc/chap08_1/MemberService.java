package com.JIhye.jdbc.chap08_1;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JIhye.jdbc.chap03.Member;
@Service
public class MemberService {

	Logger logger = LogManager.getLogger();
	
	@Autowired
	MemberDao memberDao;



	public void selectAll() {
		List<Member> members = memberDao.selectAll(0, 100);
		logger.debug(members);
	}

	public void updateMember() {
		Member member = memberDao.selectByEmail("lmh64799@naver.com");
		member.setPassword("b");
		memberDao.update(member);
		logger.debug("Update complete.");
	}

	public void insertMember() {
		Member member = new Member();
		member.setEmail("lmh64799@naver.com");
		member.setPassword("a");
		member.setName("JIhye");
		memberDao.insert(member);
		logger.debug("Insert complete.");
	}
}