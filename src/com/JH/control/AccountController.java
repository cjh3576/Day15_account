package com.JH.control;

import java.util.Scanner;

import com.JH.accout.AccountService;
import com.JH.view.View;

public class AccountController {
	private Scanner sc;
	private AccountService accountService;
	private View view;
	public AccountController() {
		sc = new Scanner(System.in);
		accountService = new AccountService();
		view = new View();
	}
	public void start() {
		boolean check = true;
		String message = null;
		while(check) {
			System.out.println("1.계좌 개설   2. 입금  3.  출금  4. 종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				message = accountService.insert();
				view.view(message);
				break;
				
				default:
					check =! check;
			}
		}
	}
}
