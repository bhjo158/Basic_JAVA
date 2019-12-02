package chapter05;

public class SingletonMain {

	public static void main(String[] args) {
		// SingletonTest st1 = new SingletonTest(); // 객체생성을 따로 한 것
		// SingletonTest st2 = new SingletonTest();
		SingletonTest st1 = SingletonTest.getInstance(); // 객체생성된 걸 빌려쓴 것
		SingletonTest st2 = SingletonTest.getInstance();
		
		System.out.println(st1 == st2);
	}

}
