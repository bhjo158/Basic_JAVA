package problem;

import java.util.Scanner;

public class ReversePrint {
	// 조건
	// 1. 사용자가 임의의 정수를 입력
	// 2. 사용자가 입력한 정수를 역으로 1까지 출력
	// 출력 예제
	// 입력>> 5
	// 5
	// 4
	// 3
	// 2
	// 1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력>> ");
		// num = 키보드로 입력한 정수값
		int num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			System.out.println(num-i);
		}
		
		for(int i=num; i>=1; i--) {
			System.out.println(i);
		}
		
	}
}
