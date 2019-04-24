package com.JH.input;

import java.util.Scanner;

import com.JH.io.IoDTO;


public class IoInput {
	private Scanner sc;
	public IoInput() {
		sc = new Scanner(System.in);
	}
//입금
	public IoDTO setInIO() {
		IoDTO dto = new IoDTO();
		System.out.println("통장 번호를 입력하세요");
		dto.setIonum(sc.nextInt());
		System.out.println("입금액을 입력하세요");
		dto.setIn_mon(sc.nextInt());
		System.out.println("날짜를 입력하세요");
		dto.setIodate(sc.next());
		
		return dto;
	}
	//출금
	public IoDTO setOutIO() {
		IoDTO dto = new IoDTO();
		System.out.println("통장 번호를 입력하세요");
		dto.setIonum(sc.nextInt());
		System.out.println("출금액을 입력하세요");
		dto.setOut_mon(sc.nextInt());
		System.out.println("날짜를 입력하세요");
		dto.setIodate(sc.next());
		
		return dto;
	}
	//기간조회
	public int num() {
		System.out.println("며칠전부터 볼까요");
		int n = sc.nextInt();
		return n;
	}
}
