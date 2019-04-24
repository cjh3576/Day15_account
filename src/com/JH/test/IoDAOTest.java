package com.JH.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.JH.accout.AccountDAO;
import com.JH.accout.AccountDTO;
import com.JH.io.IoDAO;
import com.JH.io.IoDTO;
import com.JH.util.DBConnector;

public class IoDAOTest {

	@Test
	public void test() throws Exception {
		IoDAO dao = new IoDAO();
		IoDTO dto = new IoDTO();
		Connection con = DBConnector.getConnect();
		AccountDTO adto = new AccountDTO();
		AccountDAO adao = new AccountDAO();
		dto.setIonum(1);
		dto.setIn_mon(30);
		
	}

}
