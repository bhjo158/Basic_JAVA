package chapter05;

import java.util.Scanner;

public class NumAdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 >> ");
		int num = sc.nextInt();
		int total = 0;
		
		while(num != 0) {
			total += (num % 10);
			num = num / 10;
		}
		
		System.out.println("결과 >> " + total);
	}

}
