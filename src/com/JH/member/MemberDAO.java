package com.JH.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.JH.accout.AccountDTO;
import com.JH.util.DBConnector;

public class MemberDAO {
	//회원가입
	public int memberInsert(MemberDTO dto) throws Exception {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		String sql = "insert into member values(?,?,?,?,?)";
		Connection con = DBConnector.getConnect();
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		st.setString(3, dto.getName());
		st.setString(4, dto.getPhone());
		st.setString(5, dto.getEmail());
		
		result = st.executeUpdate();
		
		
		
		return result;
	}
	//로그인
	public MemberDTO login(MemberDTO dto) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from member join account using (id) where id=? and pw = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			AccountDTO accountdto = new AccountDTO();
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			accountdto.setAname(rs.getString("aname"));
			accountdto.setAnum(rs.getInt("anum"));
			accountdto.setBalance(rs.getInt("balance"));
			accountdto.setMakedate(rs.getString("makedate"));
			dto.setAccountDTO(accountdto);
		}else {
			dto = null;
		}
		return dto;
	}
}
