package com.JH.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.JH.util.DBConnector;

public class DBConnectTest {

	@Test
	public void test() throws Exception {
		Connection con = DBConnector.getConnect();
		assertNotNull(con);
	}

}
