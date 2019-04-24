package com.JH.input;

import java.util.Scanner;

import com.JH.member.MemberDAO;
import com.JH.member.MemberDTO;
import com.JH.util.Session;

public class MemberInput {
	private Scanner sc;
	private MemberDAO dao;
	public MemberInput() {
		sc = new Scanner(System.in);
		dao = new MemberDAO();

	}
	public String setMember() {
		MemberDTO dto = new MemberDTO();
		System.out.println("ID 입력");
		dto.setId(sc.next());
		System.out.println("PW 입력");
		dto.setPw(sc.next());
		System.out.println("Name 입력");
		dto.setName(sc.next());
		System.out.println("Phone 입력");
		dto.setPhone(sc.next());
		System.out.println("Email 입력");
		dto.setEmail(sc.next());
		int result = 0;
		String message = "회원가입 성공";
		try {
			result = dao.memberInsert(dto);
			if(result <1) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "회원가입 실패";
		}
		return message;
	}
	public String login() {
		MemberDTO dto = new MemberDTO();
		
		System.out.println("ID를 입력하세요");
		dto.setId(sc.next());
		System.out.println("PW를 입력하세요");
		dto.setPw(sc.next());
		String message = "로그인 실패";
		try {
			dto = dao.login(dto);
			Session.member = dto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dto != null) {
			message = "로그인 실패";
		}
		
		return message;
	}
}