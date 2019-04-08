package com.JIhye.jdbc.chap08;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberMain {

	public static void main(String[] args) throws Exception {
		new MemberMain().go();
	}

	public void go() throws Exception {
		Properties props = new Properties();

		// 클래스패스에 있는 db.properties 파일에서 프라퍼티를 읽는다.
		InputStream in = getClass().getClassLoader()
				.getResourceAsStream("db.properties");
		props.load(in);

		// db.url 프라퍼티 값으로 데이터소스 초기화
		DataSource dataSource = new MariaDbDataSource(
				props.getProperty("db.url"));

		// dataSource를 jdbcTemplate에 넣는다. (Injection)
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);

		// jdbcTemplate을 memberDao에 넣는다. (Injection)
		MemberDaoImplUsingSpringJdbc memberDao = new MemberDaoImplUsingSpringJdbc();
		memberDao.setJdbcTemplate(jdbcTemplate);

		// memberDao를 memberService에 넣는다. (Injection)
		MemberService memberService = new MemberService();
		memberService.setMemberDao(memberDao);

		// 비즈니스 메서드 실행
		memberService.insertMember();
		memberService.selectAll();
	}
}