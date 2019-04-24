package com.JH.input;

import java.util.Scanner;

import com.JH.accout.AccountDTO;

public class AccountInput {
	private Scanner sc;
	public AccountInput() {
		sc = new Scanner(System.in);
	}
	public AccountDTO setAccount() {
		AccountDTO dto = new AccountDTO();
		System.out.println("ID를 입력하세요");
		dto.setId(sc.next());
		System.out.println("통장 이름을 입력하세요");
		dto.setAname(sc.next());
		
		
		return dto;
	}
}
