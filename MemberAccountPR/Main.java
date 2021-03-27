package IT210120;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.transform.Templates;

public class Main {
	//��� �޼��忡�� ����ϱ� ���� �޼ҵ� �ۿ� ����
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Member> listMember = new ArrayList<>(); //Ŭ���� ������� ��ü�� ����Ʈ�� ���
	public static ArrayList<Account> listAcc = new ArrayList<>();

	public static void main(String[] args) {
		�޴�(); //�޼��� ȣ�� //�޼����(�μ�);
	} //main �޼��� ��
	
	//�޴� �޼��� ����
	public static void �޴�() {
		while(true) {
			System.out.println("** ȸ���� ���� ���α׷� **");
			System.out.println("1. �α��� 2. ȸ�� ����");
			System.out.println("3. ��й�ȣ ã�� 4. ����");
			System.out.print("����: ");
			int ch = scan.nextInt();
			System.out.println();
			
			if(ch == 1) {
				login();	//login  �޼��� ȣ��
			}
			
			if(ch == 2) {
				signup();
			}
			
			if(ch == 3) {
				findpw();
			}
			
			if(ch == 4) {
				System.out.println("�̿��� �ּż� �����մϴ� ^��^");
				System.exit(0); //��� �ڵ� ����
			}
		}
	} //�޴�() ��
	
	public static void signup() {
		//�ӽ� ��ü ����
		Member temp = new Member();
		
		System.out.println("** ȸ������ â **");
		System.out.print("���̵�: ");
		temp.id = scan.next();
		
		//���� ������ ������ ���̵� �����ϸ� ���� X
		for(int i = 0; i < listMember.size(); i++) {
			if(temp.id.equals(listMember.get(i).id)) {
				System.out.println("������ ���̵� �����մϴ�.\n");
				return; //�޼��� ���� => �������� �ٽ� ���ư�
			}
		}		
		
		System.out.print("��й�ȣ: ");
		temp.pw = scan.next();
		
		System.out.print("����: ");
		temp.name = scan.next();
		System.out.println();
		
		temp.point = 10; //ȸ�� ���� �� 10��
		
		listMember.add(temp);
	} //signup ��
	
	
	public static void login() {
		System.out.println("** �α��� â **");
		System.out.print("���̵�: ");
		String id = scan.next();
		System.out.print("��й�ȣ: ");
		String pw = scan.next();
		
		int count = 0;
		
		for(int i = 0; i < listMember.size(); i++) {
			if(id.equals(listMember.get(i).id) && pw.equals(listMember.get(i).pw)) {
				count += 1;
				System.out.println("�α��� ����\n");
				memberMenu(i); //ȸ�� �޴� ȣ�� �� i �μ��� ���� �Ѱ� �ֱ�
				return; //�α׾ƿ�
			}
		}
		if(count == 0) {
			System.out.println("������ ���̵� Ȥ�� ��й�ȣ�� �������� �ʽ��ϴ�.\n");
			
		}
	
	} //login ��
	
	public static void findpw() {
		System.out.println("** ��й�ȣ ã�� â **");
		System.out.print("ã���� ��й�ȣ�� ���̵�: ");
		String id = scan.next();
		
		int count = 0;
		
		for(int i = 0; i < listMember.size(); i++) {
			if(id.equals(listMember.get(i).id)) {
				System.out.println("** �ش� ���̵��� ��й�ȣ: " + listMember.get(i).getpw() + "\n");
				count += 1;
				break;
			}
		}
		
		if(count == 0) {
			System.out.println("�˻��Ͻ� ���̵� �����ϴ�.\n");
		}
	} //findpw ��
	
	
	public static void memberMenu(int i) {
		System.out.println(listMember.get(i).name + " �� �ȳ��ϼ���\n");
		while(true) {
			System.out.println("** ���� ���� **");
			System.out.println("1. ���� ���� 2. �Ա�");
			System.out.println("3. ��� 4. �ܰ� 5. �α׾ƿ�");
			System.out.print("����: ");
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
				System.out.println("** �α׾ƿ��մϴ� **\n");
				return;
			}
		}
	}//memberMenu ��
	
	public static void makeAcc() {
		Account ac = new Account();
		System.out.println("** ���¸� �����մϴ� **");
		System.out.print("������ �Է�: ");
		ac.aname = scan.next();
		System.out.print("���¹�ȣ �Է�: ");
		ac.ano = scan.next();
		System.out.print("���� ��� ��ȣ �Է�: ");
		ac.apw = scan.next();
		System.out.println();
		listAcc.add(ac);
	}
	
	public static void deposit() {
		System.out.println("** �Ա� â�Դϴ� **");
		System.out.println("�Ա��Ͻ� ������ ���� ��ȣ�� �Է��� �ּ���.");
		System.out.print("�Է�: ");
		String anoin = scan.next();
		System.out.println("�Ա��Ͻ� ������ ���� ��� ��ȣ�� �Է��� �ּ���.");
		System.out.print("�Է�: ");
		String apwin = scan.next();
		
		int count = 0;
		
		for(int i = 0; i < listAcc.size(); i++) {
			if(anoin.equals(listAcc.get(i).ano) && apwin.equals(listAcc.get(i).apw)) {
				System.out.println("�ش� ���¿� �Ա��Ͻ� �ݾ��� �Է��� �ּ���");
				System.out.print("�Է�: ");
				int inMoney = scan.nextInt();
				System.out.println("\n** " + listAcc.get(i).aname + " ���� ���¿� " + inMoney + "���� ���������� �ԱݵǾ����ϴ�.\n");
				listAcc.get(i).money += inMoney;
				count += 1;
				break;
			}
		}
		if(count == 0) {
			System.out.println("\n�Է��Ͻ� ���� ��ȣ Ȥ�� ��� ��ȣ�� ���� �ʽ��ϴ�.\n");
		}
	}
	
	public static void withdraw() {
		System.out.println("** ��� â�Դϴ� **");
		System.out.println("����Ͻ� ������ ���� ��ȣ�� �Է��� �ּ���.");
		System.out.print("�Է�: ");
		String anoout = scan.next();
		System.out.println("����Ͻ� ������ ���� ��� ��ȣ�� �Է��� �ּ���.");
		System.out.print("�Է�: ");
		String apwout = scan.next();
		
		int count = 0;
		for(int i = 0; i < listAcc.size(); i++) {
			if(anoout.equals(listAcc.get(i).ano) && apwout.equals(listAcc.get(i).apw)) {
				System.out.println("�ش� ���¿��� ����Ͻ� �ݾ��� �Է��� �ּ���");
				System.out.print("�Է�: ");
				int outMoney = scan.nextInt();
				if(outMoney <= listAcc.get(i).money) {
					System.out.println("\n** " + listAcc.get(i).aname + " ���� ���¿��� " + outMoney + "���� ���������� ��ݵǾ����ϴ�.\n");
					listAcc.get(i).money -= outMoney;
					count += 1;
					break;	
				} else {
					System.out.println("�ܰ� �����Ͽ� ����� �� �����ϴ�.\n");
					count += 1;
					break;
				}
			}
		}
		if(count == 0) {
			System.out.println("\n�Է��Ͻ� ���� ��ȣ Ȥ�� ��� ��ȣ�� ���� �ʽ��ϴ�.\n");
		}
	}
	
	public static void balance() {
		System.out.println("** �ܰ� Ȯ�� â�Դϴ� **");
		System.out.println("�ܰ� Ȯ���Ͻ� ������ ���� ��ȣ�� �Է��� �ּ���.");
		System.out.print("�Է�: ");
		String anocheck = scan.next();
		System.out.println("�ܰ� Ȯ���Ͻ� ������ ���� ��� ��ȣ�� �Է��� �ּ���.");
		System.out.print("�Է�: ");
		String apwcheck = scan.next();
		
		int count = 0;
		for(int i = 0; i < listAcc.size(); i++) {
			if(anocheck.equals(listAcc.get(i).ano) && apwcheck.equals(listAcc.get(i).apw)) {
				System.out.println("===============================");
				System.out.println(listAcc.get(i).aname + " ���� �ܰ�� " + listAcc.get(i).money + "���Դϴ�.");
				System.out.println("===============================\n");
				count += 1;
				break;
			}
		}
		if(count == 0) {
			System.out.println("\n�Է��Ͻ� ���� ��ȣ Ȥ�� ��� ��ȣ�� ���� �ʽ��ϴ�.\n");
		}
	}
} //Ŭ���� ��
