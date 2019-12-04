package chapter08;

// 자식클래스
// : JAVA는 단일상속만 가능!
public class DmbCellPhone extends CellPhone {	// extends라는 예약어
	// extends는 상속하겠다고 명시만할뿐 객체생성 하지는않음
	int channel;
	
	public DmbCellPhone(String model, String color, int channel) {
		// super(); => 부모생성자 호출(부모 객체 생성)
		// 부모객체생성 후 자식객체가 생성됨!!!
		super(); // == CellPhone();
		// 생략가능 부모객체생성 맨위에써야됨
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	public void turnOnDmb() {
		System.out.println("채널" + channel + "번 DMB 방송 수신을 시작합니다.");
	}
	public void ChangeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널" + channel + "번으로 변경합니다.");
	}
	public void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
}
