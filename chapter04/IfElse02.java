package chapter04;

import java.util.Scanner;

public class IfElse02 {
	
	public static void main(String[] args) {
		// 학점 계산 프로그램
		Scanner sc = new Scanner(System.in);
		int score = 0;
		// 파트1: 학생점수 입력받는 부분
		while(true) {
			System.out.print("학생점수>>");
			score = sc.nextInt();
			
			if(score > 100 || score < 0) {
				System.out.println("0~100: 다시 입력");
			} else {
				break; // 0~100 들어온 경우 반복문 빠져나감
			}
		}
		// 중첩if 사용할 것!
//		if() {
//			if() {
//				
//			}
//		}
		
		// A+: 100~96 / A: 95~90
		// B+: 89~86 / B: 85~80
		// C+: 79~76 / C: 75~70
		// D+: 69~66 / D: 65~60
		// 60점 미만 F등급
		// 파트2: 학점 등급 매기는 부분
		String grade = ""; // 학점 등급
		if(score >= 90 && score <= 100) {
			// 90~100점
			if(score >= 96) {
				grade = "A+";
			} else {
				grade = "A";
			}
		} else if(score >= 80 && score < 90) {
			if(score >= 86) {
				grade = "B+";
			} else {
				grade = "B";
			}
		} else if(score >= 70 && score < 80) {
			if(score >= 76) {
				grade = "C+";
			} else {
				grade = "C";
			}
		} else if(score >= 60 && score < 70) {
			if(score >= 66) {
				grade = "D+";
			} else {
				grade = "D";
			}
		} else if(score >= 0 && score < 60) {
			grade = "F";
		} else {
			System.out.println("0~100사이의 값을 입력해주세요.");
		}
		
		System.out.println("당신은 " + grade + "학점입니다.");
		
	}
	
}
