package gugudan;

import java.util.Scanner;

public class GuGuMain {
	public static void main(String[] args) { // main함수는 컨트롤타워 역할
											// 몸통은 메인 다른건 다 빌려쓰는 것
		// JAVA는 프로그램 실행시 무조건
		// Main 메서드부터 시작!
		
		// 구구단 2단 출력
		// 2 x 1 = 2
		// 2 x 2 = 4
		// 2 x 3 = 6
		// 2 x 4 = 8
		// 2 x 5 = 10
		// 2 x 6 = 12
		// 2 x 7 = 14
		// 2 x 8 = 16
		// 2 x 9 = 18
		// 3 x 1 = 3
		// 3 x 2 = 6
		// ...
		// 3 x 9 = 27
		// 4 x 1 = 4
		// ...
		
		// 1. 사용자에게 단수를 입력받는 부분
		// 2. 구구단을 출력하는 부분
		
//		System.out.println("구구단 2단 출력");
//		for(int i = 1; i <= 9; i++) {
//			int result = 2 * i; // 변수 선언과 초기화를 나누는 예
			// result를 9번 선언하고 9번 초기화한다...
//			System.out.println("2 x " + i + " = " + result);
//		}
		
		// java가 library(도서관)에 사용자가 자주쓰는 기능들을 만들어놨다
		// Scanner가 어딧는지 알려주는게 import
		// 내가 만든게 아니고 도서관에서 빌려쓸거야
		Scanner sc = new Scanner(System.in); // 객체 생성
		System.out.print("단수>>");
		int dansu = sc.nextInt(); // 인스턴스 사용,단수 입력
		
		GuGuPrint ggp = new GuGuPrint();
		ggp.guGuDan(dansu); // 갈때는 호출문이었다가 올때는 변수로 바뀐다.
		// 변수로 쓰기에 길이가 너무 길기 때문에 보통 대입해 변수명을 줄여서 쓴다.
		// 리턴된 변수 자체로 써도 되지만 가독성이 떨어지기 때문
		// 갔다가 다시 오라고 하는 것. 가서 코드가 끝나는 게 아님!
		// 이 개념이 잡혀야 return을 알 수 있다.
	}
}
