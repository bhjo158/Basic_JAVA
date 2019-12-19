package problem.bank;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		BankDTO bDto;
		int code = 0;
		
		// 1.프로그램 전체반복
		// 2.1~6번까지 번호만 허용(나머지는 무한반복 다시 입력)
		// 3.계좌 개설 만들기(INSERT)
		// 4.계좌 조회 만들기(SELECT, 전체조회)
		// 5.사용자 검색 만들기(이름으로)
		// 6.프로그램 종료기능 만들기
		
		while(true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■ 은행 프로그램 ver1.3");
			System.out.println("■■ 1.계좌개설");
			System.out.println("■■ 2.입금");
			System.out.println("■■ 3.출금");
			System.out.println("■■ 4.계좌조회");
			System.out.println("■■ 5.사용자검색");
			System.out.println("■■ 6.프로그램 종료");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			
			while(true) {
				System.out.print("■■ 번호 >> ");
				code = sc.nextInt();
				
				if(code >= 1 && code <= 6) {
					break;
				} else {
					System.out.println("■■ 1~6까지만 입력하세요.");
					continue;
				}
				
			}
			
			if(code == 1) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 계좌를 개설합니다.");
				System.out.println("■■ 개설하시는 분의 이름을 입력하세요.");
				System.out.print("■■ 예금주 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.println("■■ 계좌의 비밀번호를 입력하세요.");
				System.out.print("■■ 비밀번호 >> ");
				String pw = sc.nextLine();
				bDto = new BankDTO(bname, pw);
				bDao.createAccount(bDto);
				
			} else if(code == 2) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 입금할 계좌번호를 입력해주세요.");
				System.out.print("■■ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.println("■■ 입금할 액수를 입력해주세요.");
				System.out.print("■■ 금액 >> ");
				int money = sc.nextInt();
				bDto = new BankDTO(bno, money);
				bDao.deposit(bDto);
				
			} else if(code == 3) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 출금할 계좌번호를 입력해주세요.");
				System.out.print("■■ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.println("■■ 출금할 계좌의 비밀번호를 입력해주세요.");
				System.out.print("■■ 비밀번호 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				bDto = new BankDTO(bno, pw);
				int result = bDao.accountCheck(bDto);
				if(result > 0) {
					int gold = bDao.printMoney(bDto);
					System.out.println("■■ 출금할 액수를 입력해주세요.");
					System.out.print("■■ 금액 >> ");
					int money = sc.nextInt();
					if(gold >= money) {
						bDto = new BankDTO(bno, pw, money);
						bDao.withdraw(bDto);
					} else {
						System.out.println("■■ 잔액이 부족합니다.");
					}
					
				} else {
					System.out.println("■■ 없는 계좌이거나 암호가 틀렸습니다.");
				}
				
				
			} else if(code == 4) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 전체 계좌를 조회합니다.");
				bDao.selectAccount();
				
			} else if(code == 5) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■ 사용자를 검색합니다.");
				System.out.print("■■ 예금주 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				bDao.search(bname);
				
			} else if(code == 6) {
				System.out.println("[프로그램을 종료합니다]");
				System.exit(0);
			}
			
		}

	}

}
