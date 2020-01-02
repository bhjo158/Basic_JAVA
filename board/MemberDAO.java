package problem.board;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	// 로그인 기능
	public void login(String id, String pw) { // 3개이상 : DTO사용, 2개까지 : 낱개로
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		System.out.println(map.get("id") + ", " + map.get("pw"));
		try {
			// mybatis sql 깔끔하게 사용하는 방법
			// 예시
			// 회원탈퇴
			// sqlSession.delete("member.delete");
			// 상품삭제
			// sqlSession.delete("delete");
			
			int flag = sqlSession.selectOne("member.login", map);
			
			if(flag > 0) { // 로그인 성공
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 반갑습니다. " + id + "님");
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				BoardMain.session = "YES";
				BoardMain.userid = id;
			} else { // 로그인 실패
				System.out.println("★★ ID 또는 PW가 틀렸습니다. 확인해주세요.");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 로그아웃 기능
	public void logout() {
		
	}
	
	// 회원가입
	// 회원수정
	// 회원삭제
	// 회원검색
	// 회원조회
	
}
