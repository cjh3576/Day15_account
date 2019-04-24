package com.JH.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.JH.accout.AccountDAO;
import com.JH.accout.AccountDTO;
import com.JH.util.DBConnector;

public class AccountDAOTest {

	@Test
	public void test() throws Exception {
	AccountDAO dao = new AccountDAO();
	AccountDTO dto = new AccountDTO();
	
	Connection con = DBConnector.getConnect();
	
	
	dto.setId("kmj");
	dto.setMakedate("2019/04/23");
	dto.setAname("내꺼");
	int result = dao.accountInsert(dto, con);
	assertEquals(1,result);
	
	}

}
