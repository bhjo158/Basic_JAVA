package problem;

public class TotalSum {
	public static void main(String[] args) {
		
		// 1~100중에 홀수,짝수 각각 더해서 출력하시오.
		// 시작값: 1
		// 종료값: 100
		// 계속 덧셈을 해서 누적: oddTotal, evenTotal
		int oddTotal = 0; // 홀수 덧셈 결과의 누적
		int evenTotal = 0; // 짝수 덧셈 결과의 누적
		
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				evenTotal += i;
			} else {
				oddTotal += i;
			}
		}
		System.out.println("1~100까지 홀수의 총합은 " + oddTotal);
		System.out.println("1~100까지 짝수의 총합은 " + evenTotal);
		
	}
	
	// 면접때 가장 많이 나오는 손코딩 문제
	// 1. 1부터 100까지 덧셈
	// 2. 구구단
}
