package com.JH.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
	public static Connection getConnect() throws Exception {
		String user = "USER02";
		String password = "USER02";
		String url = "jdbc:oracle:thin:@211.238.142.25:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
		
	}
	
	public static void disConnect(PreparedStatement st, Connection con) throws SQLException {
		st.close();
		con.close();
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection con) throws Exception  {
		rs.close();
		st.close();
		con.close();
	}
}
