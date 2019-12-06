package chapter12;

import java.util.ArrayList;

public class ArrayList01 {

	public static void main(String[] args) {
		// CRUD 등록 조회 수정 삭제
		// add get set remove
		// 등록 index값 선택 그외전부 index값 필수
		// 주로 add랑 get만 사용한다
		ArrayList<String> list = new ArrayList<>();
		list.add("포도"); // 값 입력
		list.add("딸기"); // 값 입력
		list.add("사과"); // 값 입력	// append
		list.add(1, "수박"); // (index, value)	// insert
		list.set(3, "오렌지");
		list.remove(3);
		int[] array = new int[5];
		array[0] = 3;
		
		// 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)); // add는 값을 넣어라, get은 값을 꺼내와라
		}
		// 향상된for문, foreach(포이치)문
		// 전체 다 출력할때만 사용
		for (String val : list) {
			System.out.println(val);
		}
		
	}

}
