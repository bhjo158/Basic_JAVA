package gugudan;

public class GuGuPrint {
	// 지정어(옵션) 생략
	public void guGuDan(int dansu) {
		int result; // 변수선언, 초기화x
		System.out.println("구구단 " + dansu + "단 출력");
		for(int i = 1; i <= 9; i++) {
			result = dansu * i; // 변수 선언과 초기화를 나누는 예
			System.out.println(dansu + " x " + i + " = " + result);
		}
	}
	// 메서드가 끝나는 시점 2가지
	// 1.중괄호가 끝났을 때
	// 2.리턴을 만났을 때
}
