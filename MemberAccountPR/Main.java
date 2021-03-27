package IT210120;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.transform.Templates;

public class Main {
	//모든 메서드에서 사용하기 위해 메소드 밖에 선언
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Member> listMember = new ArrayList<>(); //클래스 기반으로 객체를 리스트에 담기
	public static ArrayList<Account> listAcc = new ArrayList<>();

	public static void main(String[] args) {
		메뉴(); //메서드 호출 //메서드명(인수);
	} //main 메서드 끝
	
	//메뉴 메서드 정의
	public static void 메뉴() {
		while(true) {
			System.out.println("** 회원제 계좌 프로그램 **");
			System.out.println("1. 로그인 2. 회원 가입");
			System.out.println("3. 비밀번호 찾기 4. 종료");
			System.out.print("선택: ");
			int ch = scan.nextInt();
			System.out.println();
			
			if(ch == 1) {
				login();	//login  메서드 호출
			}
			
			if(ch == 2) {
				signup();
			}
			
			if(ch == 3) {
				findpw();
			}
			
			if(ch == 4) {
				System.out.println("이용해 주셔서 감사합니다 ^ㅁ^");
				System.exit(0); //모든 코드 종료
			}
		}
	} //메뉴() 끝
	
	public static void signup() {
		//임시 객체 생성
		Member temp = new Member();
		
		System.out.println("** 회원가입 창 **");
		System.out.print("아이디: ");
		temp.id = scan.next();
		
		//만약 기존에 동일한 아이디가 존재하면 가입 X
		for(int i = 0; i < listMember.size(); i++) {
			if(temp.id.equals(listMember.get(i).id)) {
				System.out.println("동일한 아이디가 존재합니다.\n");
				return; //메서드 종료 => 메인으로 다시 돌아감
			}
		}		
		
		System.out.print("비밀번호: ");
		temp.pw = scan.next();
		
		System.out.print("성명: ");
		temp.name = scan.next();
		System.out.println();
		
		temp.point = 10; //회원 가입 시 10점
		
		listMember.add(temp);
	} //signup 끝
	
	
	public static void login() {
		System.out.println("** 로그인 창 **");
		System.out.print("아이디: ");
		String id = scan.next();
		System.out.print("비밀번호: ");
		String pw = scan.next();
		
		int count = 0;
		
		for(int i = 0; i < listMember.size(); i++) {
			if(id.equals(listMember.get(i).id) && pw.equals(listMember.get(i).pw)) {
				count += 1;
				System.out.println("로그인 성공\n");
				memberMenu(i); //회원 메뉴 호출 시 i 인수를 같이 넘겨 주기
				return; //로그아웃
			}
		}
		if(count == 0) {
			System.out.println("동일한 아이디 혹은 비밀번호가 존재하지 않습니다.\n");
			
		}
	
	} //login 끝
	
	public static void findpw() {
		System.out.println("** 비밀번호 찾기 창 **");
		System.out.print("찾으실 비밀번호의 아이디: ");
		String id = scan.next();
		
		int count = 0;
		
		for(int i = 0; i < listMember.size(); i++) {
			if(id.equals(listMember.get(i).id)) {
				System.out.println("** 해당 아이디의 비밀번호: " + listMember.get(i).getpw() + "\n");
				count += 1;
				break;
			}
		}
		
		if(count == 0) {
			System.out.println("검색하신 아이디가 없습니다.\n");
		}
	} //findpw 끝
	
	
	public static void memberMenu(int i) {
		System.out.println(listMember.get(i).name + " 님 안녕하세요\n");
		while(true) {
			System.out.println("** 계좌 관리 **");
			System.out.println("1. 계좌 생성 2. 입금");
			System.out.println("3. 출금 4. 잔고 5. 로그아웃");
			System.out.print("선택: ");
			int ch = scan.nextInt();
			System.out.println();
			
			if(ch == 1) {
				makeAcc();
			}
			
			if(ch == 2) {
				deposit();
			}
			if(ch == 3) {
				withdraw();
			}
			
			if(ch == 4) {
				
				
				balance();
			}
			
			if(ch == 5) {
				System.out.println("** 로그아웃합니다 **\n");
				return;
			}
		}
	}//memberMenu 끝
	
	public static void makeAcc() {
		Account ac = new Account();
		System.out.println("** 계좌를 생성합니다 **");
		System.out.print("계좌주 입력: ");
		ac.aname = scan.next();
		System.out.print("계좌번호 입력: ");
		ac.ano = scan.next();
		System.out.print("계좌 비밀 번호 입력: ");
		ac.apw = scan.next();
		System.out.println();
		listAcc.add(ac);
	}
	
	public static void deposit() {
		System.out.println("** 입금 창입니다 **");
		System.out.println("입금하실 계좌의 계좌 번호를 입력해 주세요.");
		System.out.print("입력: ");
		String anoin = scan.next();
		System.out.println("입금하실 계좌의 계좌 비밀 번호를 입력해 주세요.");
		System.out.print("입력: ");
		String apwin = scan.next();
		
		int count = 0;
		
		for(int i = 0; i < listAcc.size(); i++) {
			if(anoin.equals(listAcc.get(i).ano) && apwin.equals(listAcc.get(i).apw)) {
				System.out.println("해당 계좌에 입금하실 금액을 입력해 주세요");
				System.out.print("입력: ");
				int inMoney = scan.nextInt();
				System.out.println("\n** " + listAcc.get(i).aname + " 님의 계좌에 " + inMoney + "원이 정상적으로 입금되었습니다.\n");
				listAcc.get(i).money += inMoney;
				count += 1;
				break;
			}
		}
		if(count == 0) {
			System.out.println("\n입력하신 계좌 번호 혹은 비밀 번호가 옳지 않습니다.\n");
		}
	}
	
	public static void withdraw() {
		System.out.println("** 출금 창입니다 **");
		System.out.println("출금하실 계좌의 계좌 번호를 입력해 주세요.");
		System.out.print("입력: ");
		String anoout = scan.next();
		System.out.println("출금하실 계좌의 계좌 비밀 번호를 입력해 주세요.");
		System.out.print("입력: ");
		String apwout = scan.next();
		
		int count = 0;
		for(int i = 0; i < listAcc.size(); i++) {
			if(anoout.equals(listAcc.get(i).ano) && apwout.equals(listAcc.get(i).apw)) {
				System.out.println("해당 계좌에서 출금하실 금액을 입력해 주세요");
				System.out.print("입력: ");
				int outMoney = scan.nextInt();
				if(outMoney <= listAcc.get(i).money) {
					System.out.println("\n** " + listAcc.get(i).aname + " 님의 계좌에서 " + outMoney + "원이 정상적으로 출금되었습니다.\n");
					listAcc.get(i).money -= outMoney;
					count += 1;
					break;	
				} else {
					System.out.println("잔고가 부족하여 출금할 수 없습니다.\n");
					count += 1;
					break;
				}
			}
		}
		if(count == 0) {
			System.out.println("\n입력하신 계좌 번호 혹은 비밀 번호가 옳지 않습니다.\n");
		}
	}
	
	public static void balance() {
		System.out.println("** 잔고 확인 창입니다 **");
		System.out.println("잔고를 확인하실 계좌의 계좌 번호를 입력해 주세요.");
		System.out.print("입력: ");
		String anocheck = scan.next();
		System.out.println("잔고를 확인하실 계좌의 계좌 비밀 번호를 입력해 주세요.");
		System.out.print("입력: ");
		String apwcheck = scan.next();
		
		int count = 0;
		for(int i = 0; i < listAcc.size(); i++) {
			if(anocheck.equals(listAcc.get(i).ano) && apwcheck.equals(listAcc.get(i).apw)) {
				System.out.println("===============================");
				System.out.println(listAcc.get(i).aname + " 님의 잔고는 " + listAcc.get(i).money + "원입니다.");
				System.out.println("===============================\n");
				count += 1;
				break;
			}
		}
		if(count == 0) {
			System.out.println("\n입력하신 계좌 번호 혹은 비밀 번호가 옳지 않습니다.\n");
		}
	}
} //클래스 끝
