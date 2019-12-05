package problem;

import java.util.Scanner;

public class Bubble {
	static int[] data = new int[5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp;
		
		// 임의의 수 5개 입력
		System.out.println("임의의 수 5개를 입력하세요");
		for(int i=0; i<data.length; i++) {
			System.out.print((i+1) + "번째 수 >> ");
			data[i] = sc.nextInt();
			duplicate(i);
		}
		
		// 입력받은 수 확인
		System.out.print("입력받은 수는 >> ");
		viewData();
		System.out.println();
		
		// 버블정렬 작업 수행
		for(int i=0; i<data.length-1; i++) {
			for(int j=i+1; j<data.length; j++) {
				if(data[i] > data[j]) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		
		// 정렬결과 출력
		System.out.print("버블정렬 결과 >> ");
		viewData();
	}
	
	// 중복검사
	public static void duplicate(int i) {
		Scanner sc = new Scanner(System.in);
		// 중복된 값이 입력될 경우 다시 입력
		if(i != 0) {
			for(int j=0; j<i; j++) {
				while(true) {
					if(data[i] == data[j]) {
						System.out.println("동일한 값이 존재합니다. 값을 다시 입력하세요");
						System.out.print((i+1) + "번째 수 >> ");
						data[i] = sc.nextInt();
						continue;
					} else {
						break;
					}
				}
			}
		}
	}
	
	// 데이터출력
	public static void viewData() {
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
		
	}
}
