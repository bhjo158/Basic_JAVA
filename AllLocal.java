package chapter05;

public class AllLocal {
	// 전역변수는 Class내에서 모두 사용 가능
	static int num = 5; // 전역변수
	
	public static void main(String[] args) {
		System.out.println(num); // 전역 찾아감
		// 지역변수는 지역내에서만 사용 가능
		int num = 10; // 지역변수
		System.out.println(num); // 지역 먼저 찾아감
	}

}
