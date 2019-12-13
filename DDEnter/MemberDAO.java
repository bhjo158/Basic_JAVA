package problem.DDEnter;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberDAO {	// 데이터베이스 작업하는 기능들 모아둠
	Connection conn;
	PreparedStatement pstmt;	// java가 객체자료형은 null로 초기화한다
	
	// 1.아티스트등록
	public void memInsert(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();	// MemberDAO클래스의 getConnection메서드를 가면요 static메서드구나
			String sql = "INSERT INTO tbl_enter(ano, aname, major, groupyn, groupnm, sal) "
			           + "VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▦▦ " + mDto.getAname() + " 아티스트와 계약을 체결하였습니다.");
			} else {
				System.out.println("▦▦ 등록에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
	}
	// 2.아티스트수정
	public void memUpdate(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_enter "
					   + "SET aname = ?, "
					   + "    major = ?, "
					   + "    groupyn = ?, "
					   + "    groupnm = ?, "
					   + "    sal = ?"
					   + "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			pstmt.setString(6, mDto.getAno());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▦▦ " + mDto.getAname() + " 아티스트의 정보를 수정하였습니다.");
			} else {
				System.out.println("▦▦ 수정에 실패하였습니다. 관리자에게 문의해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
	}
	// 3.아티스트삭제
	public void memDelete(String ano) {	// java로 할때는 자동으로 오토커밋 해준다
		try {
			// 1.드라이버 로드, 2.DB 연결
			conn = DBManager.getConnection();	// conn이 연결정보를 가지고있다
			// 3.SQL문 작성(PrepareStatement 방식)
			String sql = "DELETE FROM tbl_enter "
					   + "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);	// pstmt가 연결정보와 sql문이 생겼다
			// 3.1 미완성 SQL문 완성(바인딩변수 사용)
			pstmt.setString(1, ano);
			// 4.SQL문 실행!!
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("▦▦ " + ano + " 아티스트와 계약을 해지하였습니다.");
			} else {
				System.out.println("▦▦ 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	// 4.아티스트조회
	public void memSelect() {}	// 전체 아티스트 보여주는것
	// 5.아티스트검색
	public void memSearch() {}	// 원하는 아티스트만 보여주는것
}
