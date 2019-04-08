package com.JIhye.jdbc.chap04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.JIhye.jdbc.chap03.DuplicateMemberException;
import com.JIhye.jdbc.chap03.Member;
import com.JIhye.jdbc.chap03.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;

	static Logger logger = LogManager.getLogger();

	/**
	 * 회원 등록
	 * 
	 * @param req 사용자가 입력한 회원 정보
	 * @throws DuplicateMemberException 이메일이 중복될 경우에 발생
	 */
	public void regist(RegisterRequest req) {
		logger.debug(req);
		Member member = memberDao.selectByEmail(req.getEmail());

		// 회원이 이미 존재하면 예외 발생
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복 " + req.getEmail());
		}

		// 회원정보 저장
		Member newMember = new Member(req.getEmail(), req.getPassword(),
				req.getName());
		memberDao.insert(newMember);
		logger.debug("회원 정보를 저장했습니다.");
	}
}