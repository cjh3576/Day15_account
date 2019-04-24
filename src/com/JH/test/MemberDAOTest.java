package com.JH.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.JH.member.MemberDAO;
import com.JH.member.MemberDTO;
import com.JH.util.DBConnector;

public class MemberDAOTest {

	@Test
	public void test() throws Exception {
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		Connection con = DBConnector.getConnect();
		
		dto.setName("JH");
		dto.setId("CJH");
		dto.setPw("CJH");
		dto.setPhone("01099644774");
		dto.setEmail("1234@1234");
		int result = dao.memberInsert(dto, con);
		assertEquals(1, result);
		
		
	}

}
