package com.JH.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.JH.accout.AccountDAO;
import com.JH.accout.AccountDTO;
import com.JH.member.MemberDTO;
import com.JH.util.DBConnector;

public class IoDAO {

	//입금
	public int insert(IoDTO dto, Connection con,AccountDAO adao, AccountDTO adto) throws Exception {
		int result = 0;

		String sql = "insert into io values (io_seq.nextval,?,?,null, ?)";
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, dto.getIonum());
		st.setInt(2, dto.getIn_mon());
		st.setString(3, dto.getIodate());


		result = st.executeUpdate(); //입금 완료
		adao.update(adto, con);

		return result;
	}
	//출금
	public int outsert(IoDTO dto, Connection con,AccountDAO adao,AccountDTO adto) throws Exception {
		int result = 0;

		String sql = "insert into io values (io_seq.nextval,?,null,?,?)";
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, dto.getIonum());
		st.setInt(2, dto.getOut_mon());
		st.setString(3, dto.getIodate());

		result = st.executeUpdate();
		adao.outUpdate(dto.getOut_mon(), dto.getIonum(), adto, con);

		return result;
	}
	//전체출력
	public ArrayList<IoDTO> selectList(Connection con) throws Exception {
		ArrayList<IoDTO> ar = new ArrayList<IoDTO>();
		String sql = "select * from io order by iodate asc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			IoDTO dto = new IoDTO();
			dto.setNum(rs.getInt("num"));
			dto.setIonum(rs.getInt("ionum"));
			dto.setIn_mon(rs.getInt("in_mon"));
			dto.setOut_mon(rs.getInt("out_mon"));
			dto.setIodate(rs.getString("iodate"));
			ar.add(dto);
		}
		return ar;
	}
	//입금 내역
	public ArrayList<IoDTO> selectIn(Connection con) throws Exception {
		ArrayList<IoDTO> ar = new ArrayList<IoDTO>();
		String sql = "select * from io where out_mon is null order by iodate asc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			IoDTO dto = new IoDTO();
			dto.setNum(rs.getInt("num"));
			dto.setIonum(rs.getInt("ionum"));
			dto.setIn_mon(rs.getInt("in_mon"));
			dto.setIodate(rs.getString("iodate"));
			ar.add(dto);
		}
		
		return ar;
	}
	//출금 내역
	public ArrayList<IoDTO> selectOut(Connection con) throws Exception {
		ArrayList<IoDTO> ar = new ArrayList<IoDTO>();
		String sql = "select * from io where in_mon is null order by iodate asc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			IoDTO dto = new IoDTO();
			dto.setNum(rs.getInt("num"));
			dto.setIonum(rs.getInt("ionum"));
			dto.setOut_mon(rs.getInt("out_mon"));
			dto.setIodate(rs.getString("iodate"));
			ar.add(dto);
		}
		return ar;
	}
	//기간 조회
	public ArrayList<IoDTO> selectDuring(Connection con, int num) throws Exception {
		ArrayList<IoDTO> ar = new ArrayList<IoDTO>();
		String sql =" select * from io where iodate between sysdate - ? and sysdate order by iodate asc";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			IoDTO dto = new IoDTO();
			dto.setNum(rs.getInt("num"));
			dto.setIonum(rs.getInt("ionum"));
			dto.setIn_mon(rs.getInt("in_mon"));
			dto.setOut_mon(rs.getInt("out_mon"));
			dto.setIodate(rs.getString("iodate"));
			ar.add(dto);
		}
		return ar;
		
	}
}
