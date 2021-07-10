package com.miniprj.test;

import java.util.Scanner;

import com.miniprj.dao.MemberDAO;
import com.miniprj.dto.MemberDTO;

public class MemberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		MemberDAO dao=new MemberDAO();
		
		while(true) {
			System.out.println("1.회원가입");
			System.out.println("2.회원수정");
			System.out.println("3.회원삭제");
			System.out.println("4.회원보기");
			System.out.println("5.전체보기");
			String ch=sc.nextLine();
			
			switch(ch) {
			case"1":
				System.out.println("아이디를 입력하세요");
				String id=sc.nextLine();
		
					System.out.println("패스워드를 입력하세요");
					String pwd=sc.nextLine();
					System.out.println("이름을 입력하세요");
					String name=sc.nextLine();
					System.out.println("이메일을 입력하세요");
					String email=sc.nextLine();
					
					dao.insert(id,pwd,name,email); 
					System.out.println("회원가입완료");
				break;
			case"2":
				System.out.println("수정할 아이디를 입력하세요");
				id=sc.nextLine();
		
					System.out.println("수정할 패스워드를 입력하세요");
					pwd=sc.nextLine();
					System.out.println("수정할 이메일을 입력하세요");
					email=sc.nextLine();
					
					dao.update(id,pwd,email);
					System.out.println("수정완료");
				break;
			case"3":
				System.out.println("삭제할 아이디를 입력하세요");
				id=sc.nextLine();
	
				dao.delete(id);
					System.out.println("삭제 성공");
				break;
				
			case"4":
				System.out.println("조회할 아이디를 입력하세요");
				id=sc.nextLine();
				
	
				dao.selectOne(id);
				 System.out.println("조회완료");
				 break;
				 
			case"5":
				System.out.println("memberno\t id\t pwd\t name\t email\t mdate");
				dao.getAll();
				
				break;
				
			default:
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}

}
