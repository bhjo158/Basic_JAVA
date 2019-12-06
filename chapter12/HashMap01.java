package chapter12;

import java.util.HashMap;

public class HashMap01 {

	public static void main(String[] args) {
		// Object : Java의 모든 값을 받겠다
		HashMap<String, Object> map = new HashMap<>();
		map.put("선생님", "초롱"); // 값 넣을때만 put, 나머진 ArrayList와 동일
		map.put("강아지", "체리");
		System.out.println(map.get("선생님"));
		
	}

}
