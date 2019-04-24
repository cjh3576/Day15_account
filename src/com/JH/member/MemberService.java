package com.JH.member;

import java.util.Scanner;

import com.JH.util.Session;

public class MemberService {
	private Scanner sc;
	private MemberDAO memberdao;
	public MemberService() {
		sc = new Scanner(System.in);
		memberdao = new MemberDAO();
	}
	public String login() {
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("ID : ");
		memberDTO.setId(sc.next());
		System.out.println("PW : ");
		memberDTO.setPw(sc.next());
		String message="로그인 실패";
		try {
			memberDTO = memberdao.login(memberDTO);
			Session.member=memberDTO;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(memberDTO != null) {
			message="로그인 성공";
		}
		return message;
	}
	
	public String insert() {
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("ID : ");
		memberDTO.setId(sc.next());
		System.out.println("PW : ");
		memberDTO.setPw(sc.next());
		System.out.println("Name : ");
		memberDTO.setName(sc.next());
		System.out.println("Phone : ");
		memberDTO.setPhone(sc.next());
		System.out.println("Email : ");
		memberDTO.setEmail(sc.next());
		int result=0;
		String message="회원가입 성공";
		try {
			result = memberdao.memberInsert(memberDTO);
			if(result<1) {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message="회원가입 실패";
		}
		return message;
		
	}
	
}
