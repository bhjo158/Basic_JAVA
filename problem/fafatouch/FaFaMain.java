package problem.fafatouch;

import java.util.Scanner; // java에서 기본적으로 제공하는 클래스를 빌려오기 위해 import

public class FaFaMain {
	public static void main(String[] args) {
		/*
		 * 여러분들이 어떤 기능을 빌려서 사용하시면
		 * 반드시 반납을 하셔야 하는 경우가 있습니다.
		 * 1.파일 입력&출력 File I/O	(I:input / O:output)
		 * 2.데이터베이스 관련 작업
		 */
		Scanner sc = new Scanner(System.in); // 자원 쓰고나서 반납해야됨
		// 메인메뉴를 저장하는 5칸짜리 배열 생성
		String[][] mainMenu = new String[5][2]; // 담아서 쓰는 공간 = 실질적인 결과물
		// 오른쪽 그대로 써도 되긴 하지만 불편해서 담아서 쓴다
		// 리턴할때 담아서 리턴하는 것과 같은 원리
		// [5][2]
		// [5]는 메뉴 5개
		// [2]는 메뉴이름[0] / 메뉴가격[1]
		mainMenu[0][0] = "파파버거";
		mainMenu[1][0] = "맥치킨버거";
		mainMenu[2][0] = "와퍼버거";
		mainMenu[3][0] = "싸이버거";
		mainMenu[4][0] = "빅맥버거";
		mainMenu[0][1] = "4500";
		mainMenu[1][1] = "5500";
		mainMenu[2][1] = "6000";
		mainMenu[3][1] = "4700";
		mainMenu[4][1] = "5500";
		
		
		// 사이드메뉴를 저장하는 5칸짜리 배열 생성
		String[][] sideMenu = new String[5][2];
		sideMenu[0][0] = "감자튀김";
		sideMenu[1][0] = "양념감자";
		sideMenu[2][0] = "치즈스틱";
		sideMenu[3][0] = "맥너겟";
		sideMenu[4][0] = "스위트콘";
		sideMenu[0][1] = "1500";
		sideMenu[1][1] = "2000";
		sideMenu[2][1] = "2000";
		sideMenu[3][1] = "2500";
		sideMenu[4][1] = "1700";
		
		
		// 음료메뉴를 저장하는 5칸짜리 배열 생성
		String[][] drinkMenu = new String[5][2];
		drinkMenu[0][0] = "코카콜라";
		drinkMenu[1][0] = "스프라이트";
		drinkMenu[2][0] = "마운틴듀";
		drinkMenu[3][0] = "오렌지쥬스";
		drinkMenu[4][0] = "초코쉐이크";
		drinkMenu[0][1] = "1700";
		drinkMenu[1][1] = "1600";
		drinkMenu[2][1] = "1500";
		drinkMenu[3][1] = "1800";
		drinkMenu[4][1] = "2000";
		
		int mainNum;
		int sideNum;
		int drinkNum;
		
		
		while(true) {
			
			while(true) {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒ 파파터치 주문프로그램");
				System.out.println("▒▒ ==메인메뉴==");
				System.out.println("▒▒ 1.파파버거");
				System.out.println("▒▒ 2.맥치킨버거");
				System.out.println("▒▒ 3.와퍼버거");
				System.out.println("▒▒ 4.싸이버거");
				System.out.println("▒▒ 5.빅맥버거");
				System.out.print("▒▒ 번호 >> ");
				// 사용자가 주문한 메인메뉴 번호!
				mainNum = sc.nextInt()-1;
				if(mainNum >= 5 || mainNum <= -1) {
					System.out.println("▒▒ 메뉴는 1~5번 까지입니다.");
					System.out.println("▒▒ 다시 입력하세요.");
					continue;
				} else {
					break;
				}
			}
			
			
			while(true) {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒ ==사이드메뉴==");
				System.out.println("▒▒ 1.감자튀김");
				System.out.println("▒▒ 2.양념감자");
				System.out.println("▒▒ 3.치즈스틱");
				System.out.println("▒▒ 4.맥너겟");
				System.out.println("▒▒ 5.스위트콘");
				System.out.print("▒▒ 번호 >> ");
				// 사용자가 주문한 사이드메뉴 번호!
				sideNum = sc.nextInt()-1;
				if(sideNum >= 5 || sideNum <= -1) {
					System.out.println("▒▒ 메뉴는 1~5번 까지입니다.");
					System.out.println("▒▒ 다시 입력하세요.");
					continue;
				} else {
					break;
				}
			}
			
			
			while(true) {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒ ==음료==");
				System.out.println("▒▒ 1.코카콜라");
				System.out.println("▒▒ 2.스프라이트");
				System.out.println("▒▒ 3.마운틴듀");
				System.out.println("▒▒ 4.오렌지쥬스");
				System.out.println("▒▒ 5.초코쉐이크");
				System.out.print("▒▒ 번호 >> ");
				// 사용자가 주문한 음료메뉴 번호!
				drinkNum = sc.nextInt()-1;
				if(drinkNum >= 5 || drinkNum <= -1) {
					System.out.println("▒▒ 메뉴는 1~5번 까지입니다.");
					System.out.println("▒▒ 다시 입력하세요.");
					continue;
				} else {
					break;
				}
			}
			
			// 문자열타입에 있는 값을 숫자로 바꿔주는 것
			// 특별한점은 객체자료형을 기본자료형으로 바꿔주는 것
			int mPrice = Integer.parseInt(mainMenu[mainNum][1]);
			int sPrice = Integer.parseInt(sideMenu[sideNum][1]);
			int dPrice = Integer.parseInt(drinkMenu[drinkNum][1]);
			// 총주문금액 계산!
			int totPrice = mPrice + sPrice + dPrice;
			String order;
			String smallAns;
			
				// 출력!!
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒ 고객님께서 주문하신 메뉴는 ");
				System.out.println("▒▒ 1) " + mainMenu[mainNum][0]); // 메인메뉴
				System.out.println("▒▒ 2) " + sideMenu[sideNum][0]); // 사이드메뉴
				System.out.println("▒▒ 3) " + drinkMenu[drinkNum][0]); // 음료메뉴
				System.out.println("▒▒ 총 금액은 " + totPrice + "원 입니다.");
				System.out.print("▒▒ 주문하시겠습니까?(y/n)");
				// 엔터키는 2가지기능을 가지고 있음
				// 1.입력기능
				// 2.한줄개행(\n)
				// JAVA에서 엔터를 입력하면 1번과2번에 실행됨.
				// sc.nextInt()는 정수값만 받기 때문에 한줄개행
				// 코드를 무시하지만 sc.nextLine()은 문자열을
				// 입력받아 한줄개행코드를 입력으로 받음...
				// sc.nextLine()을 사용해서 한줄개행입력을
				// 대신 받아주는 부분이 필요함!!
				sc.nextLine(); // 한줄개행 받는 부분
			while(true) {	
				order = sc.nextLine();
				// order.toUpperCase(); // 대문자변환
				smallAns = order.toLowerCase();
				if(order.equals("y") || order.equals("n")) {
					break;
				} else {
					System.out.println("▒▒ y 또는 n으로 입력하세요.");
					continue;
				}
			}
			
			
			if(order.equals("y")) {
				while(true) {
					// 결제금액 입력
					System.out.print("▒▒ 결제금액>> ");
					int money = sc.nextInt();
					// 지불금액이 총구매액보다 작은 경우!!!
					if(totPrice > money) {
						System.out.println("금액이 부족합니다.");
						continue;
					} else {
						// 지불금액(10000) > 총구매액(5000)
						if(totPrice < money) {
							System.out.println((money-totPrice)+"원 거스름돈 받아가세요.");
						}
						// 지불금액 == 결제금액
						// 지불금액 > 결제금액(거스름돈 주고)
						break;
					}
				}
				System.out.println("▒▒ 결제완료! 맛있게 드세요:)");
				continue;
			} else {
				System.out.println("▒▒ 다시 주문하세요.");
				continue;
				// 시스템에 처음으로 돌아가세요!
			}
			
		}
		// sc.close(); // 사용한 자원 반납
		
	}
}
