package com.JH.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.JH.io.IoDTO;
import com.JH.member.MemberDTO;
import com.JH.util.Session;


public class View {

	public void view(String s) {
		System.out.println(s);
	}
	
	public void view() {
		//mypage
		MemberDTO dto = (MemberDTO)Session.member;
		System.out.println("ID : " + dto.getId());
		System.out.println("Name : " + dto.getName());
		System.out.println("Phone : " + dto.getPhone());
		System.out.println("Email : " + dto.getEmail());
		System.out.println("AccountName : " + dto.getAccountDTO().getAname());
		System.out.println("AccountNUM : " + dto.getAccountDTO().getAnum());
		System.out.println("Balance : " + dto.getAccountDTO().getBalance());
		System.out.println("Date : " + dto.getAccountDTO().getMakedate());
	}
	
	
	
	//전체내역
	public void view(ArrayList<IoDTO> ar) throws Exception {

		for(IoDTO dto : ar) {

			System.out.println("입금 액 : " + dto.getIn_mon());
			System.out.println("출금 액 : " + dto.getOut_mon());
			System.out.println(" 날짜 : " + dto.getIodate());
			System.out.println("========================");
		}
	}

	//입금 내역
	public void inView(ArrayList<IoDTO> ar) throws Exception {
		for(IoDTO dto : ar) {

			System.out.println("입금 액 : " + dto.getIn_mon());
			System.out.println(" 날짜 : " + dto.getIodate());
			System.out.println("========================");
		}
	}
	//출금 내역
	public void outView(ArrayList<IoDTO> ar) throws Exception {
		for(IoDTO dto : ar) {

			System.out.println("출금 액 : " + dto.getOut_mon());
			System.out.println(" 날짜 : " + dto.getIodate());
			System.out.println("========================");
		}
	}
	//기간 조회
	public void duringView(ArrayList<IoDTO> ar) throws Exception {
		for(IoDTO dto : ar) {

			System.out.println("입금 액 : " + dto.getIn_mon());
			System.out.println("출금 액 : " + dto.getOut_mon());
			System.out.println(" 날짜 : " + dto.getIodate());
			System.out.println("========================");
		}
	}
}
