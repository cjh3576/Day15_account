package com.JH.accout;

import java.util.Scanner;

import com.JH.member.MemberDTO;
import com.JH.util.DBConnector;
import com.JH.util.Session;

public class AccountService {
	private Scanner sc;
	private AccountDAO accountdao;
	public AccountService() {
		sc = new Scanner(System.in);
		accountdao = new AccountDAO();
	}
	public String insert() {
		String message = "계좌개설 성공";
		AccountDTO accountdto = new AccountDTO();
		System.out.println(" 계좌번호 입력");
		accountdto.setAnum(sc.nextInt());
		System.out.println("계좌명 입력");
		accountdto.setAname(sc.next());
		accountdto.setId(((MemberDTO)(Session.member)).getId());
		int result = 0;
		try {
			result = accountdao.accountInsert(accountdto, DBConnector.getConnect());
			if(result>1) {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "계좌 개설 실패";
		}
		return message;
	}
}
