package com.JH.control;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.JH.accout.AccountDAO;
import com.JH.accout.AccountDTO;
import com.JH.input.AccountInput;
import com.JH.input.IoInput;
import com.JH.input.MemberInput;
import com.JH.io.IoDAO;
import com.JH.io.IoDTO;
import com.JH.member.MemberDAO;
import com.JH.member.MemberDTO;
import com.JH.util.DBConnector;
import com.JH.util.Session;
import com.JH.view.View;

public class MemberController {
	AccountDAO accountdao = null;
	AccountDTO accountdto = null;
	IoDAO iodao = null;
	IoDTO iodto = null;
	MemberDAO memberdao = null;
	MemberDTO memberdto = null;
	Scanner sc = null;
	ArrayList<AccountDTO> ar = null;
	Connection con = null;
	View iv = null;
	MemberInput mi = null;
	AccountInput ai = null;
	IoInput ii = null;
	ArrayList<IoDTO> ioar = null;
	private AccountController accountController;
	public MemberController () {
		accountdao = new AccountDAO();
		accountdto = new AccountDTO();
		ai = new AccountInput();
		iodao = new IoDAO();
		iodto = new IoDTO();
		memberdao = new MemberDAO();
		memberdto = new MemberDTO();
		sc = new Scanner(System.in);
		ar = new ArrayList<AccountDTO>();
		iv = new View();
		mi = new MemberInput();
		ii = new IoInput();
		ioar = new ArrayList<IoDTO>();
		accountController = new AccountController();
	}


	public void start() {
		boolean check = true;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			String message = null;
			
			while(check) {
				if(Session.member != null) {
					System.out.println("1. MyPage   2.  Logout 3. 계좌관리");
					int select = sc.nextInt();
					if(select == 1) {
						iv.view();
					} else if(select ==2){
						Session.member = null;
					} else {
						accountController.start();
					}
					
					
					
					
				} else {
					System.out.println("1. 회원가입 2. 로그인 3. 종료");
					int num = sc.nextInt();
				switch(num) {
				case 1: 
					message = mi.setMember();
					iv.view(message);
					break;
				
				case 2: 
					message = mi.login();
					iv.view(message);
					break;
				default : 
					System.out.println("프로그램을 종료합니다");
					check = !check;
					break;
				}
				
			
				} // switch
			}//while	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}



	}
}
