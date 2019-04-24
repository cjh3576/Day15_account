package com.JH.accout;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.JH.util.DBConnector;

public class AccountDAO {
	//통장개설
	public int accountInsert(AccountDTO dto, Connection con) throws Exception {
		int result = 0;
		String sql = "insert into account values(?,?,sysdate,?, 0)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, dto.getAnum());
		st.setString(2, dto.getId());
		st.setString(3, dto.getAname());
		
		result = st.executeUpdate();
		st.close();
		
		return result;
	}
	//입금 업데이트
	public int update( AccountDTO dto, Connection con) throws Exception {
		int result = 0;
		String sql = "update account set balance = ? where anum = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getBalance());
		st.setInt(2, dto.getAnum()); //dto.getpnum
		
		result = st.executeUpdate();
		st.close();
		return result;
	}
	//출금업데이트
	public int outUpdate(int balance, int anum, AccountDTO dto, Connection con) throws Exception {
		int result = 0;
		String sql = "update account set balance = balance - ? where anum = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getBalance()+ balance); 
		st.setInt(2, anum); //dto.getpnum
		
		result = st.executeUpdate();
		
		return result;
	}
}
