package chapter05;

public class MemberDAO {
	// 데이터베이스
	String id = "admin";
	String pw = "1234";
	
	// 로그인시 회원 유무 판별기능
	int result = 0; // 로그인 성공유무 (0:실패, 1:성공)
	public int loginCheck(MemberDTO mDto) {
		if(id.equals(mDto.id) && pw.equals(mDto.pw)) {
			result = 1;
		}
		return result; // 메서드가 끝나는 두가지 1.중괄호닫혔을때 2.return을만났을때
	}
}
