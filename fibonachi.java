package problem;

import java.util.Scanner;

public class fibonachi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = 1;
		int num2 = 1;
		int sum = 0;
		int depth;
		int temp;
		System.out.print("수열의 depth 입력 >> ");
		depth = sc.nextInt();
		System.out.println("수열의 깊이 " + depth + "의 피보나치 수열은");
		System.out.printf("%d\t%d\t",num1,num2);
		for(int i = 2; i <= depth; i++) {
			// 다음수 출력
			sum = num1 + num2;
			System.out.printf("%d\t",sum);
			// 숫자교환
			temp = num2;
			num2 = sum;
			num1 = temp;
		}
		
	}

}
