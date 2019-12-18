package problem.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.common.DBManager;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	int result;
	ResultSet rs;
	ArrayList<BoardDTO> list = new ArrayList<>();
	BoardDTO bDto;
	
	public void boardInsert(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_board(bno, title, content, writer) "
					+ "VALUES(seq_board.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 작성을 완료했습니다.");
			} else {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 작성에 실패했습니다. 다시 작성해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	
	public void boardUpdate(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board "
					+ "SET title = ?, "
				    + "content = ?, "
					+ "writer = ? "
					+ "WHERE bno = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setInt(4, bDto.getBno());
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 수정을 완료했습니다.");
			} else {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 수정에 실패했습니다. 다시 작성해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void boardDelete(int bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_board WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 삭제를 완료했습니다.");
			} else {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 삭제에 실패했습니다. 게시글 번호를 확인해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void boardSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board "
					   + "ORDER BY bno DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate);
				list.add(bDto);
			}
			
			printQuery(list);			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void boardSearch(String keyword) {
		try {
			conn = DBManager.getConnection(); // 드라이버 로드 + Connection
			String sql = "SELECT * "
					   + "FROM tbl_board "
					   + "WHERE title LIKE ? OR "
					         + "content LIKE ?";
			pstmt = conn.prepareStatement(sql); // preparedStatement방식으로 sql문 실행하겠다
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			
			rs = pstmt.executeQuery(); // rs = database 관련 객체
			
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate);
				list.add(bDto); // java관련 객체인 list에 넣는다
			}
			
			System.out.println("★★ \""+keyword+"\"로 검색한 결과 총 "+list.size()+"건의 결과가 조회되었습니다.");
			// \"의 경우 문자열이 아니라 출력하는 텍스트임을 나타낸다
			printQuery(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void boardView(int bno) { // 하나의 게시글만 보겠다. 한건만 검색
		// 상세게시글 조회수 +1 증가
		int result = viewCntPlus(bno);
		if(!(result > 0)) {
			System.out.println("== 조회수 증가 실패, 관리자에게 문의하세요.");
			return;
		}
		
		// 상세게시글 출력
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * " + 
					     "FROM tbl_board " + 
					     "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno); // 개수 안맞으면 부적합한 열 인덱스 에러
			rs = pstmt.executeQuery();
			list.clear();
			while(rs.next()) {
				bno = rs.getInt("bno");
			    String title = rs.getString("title");
			    String content = rs.getString("content");
			    String writer = rs.getString("writer");
			    int viewcnt = rs.getInt("viewcnt");
			    Date regdate = rs.getDate("regdate");
			    bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
			}
			System.out.println("==============================================================");
			System.out.println("== 게시글 번호 : "+ bno);
			System.out.println("== 작성일자 : " + bDto.getRegdate());
			System.out.println("== 작성자 : " + bDto.getWriter());
			System.out.println("== 조회수 : " + bDto.getViewcnt());
			System.out.println("== 제목 : " + bDto.getTitle());
			System.out.println("== 내용 : " + bDto.getContent());
			System.out.println("==============================================================");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public void boardSort() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * "
					   + "FROM tbl_board "
					   + "ORDER BY viewcnt DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
			    String title = rs.getString("title");
			    String content = rs.getString("content");
			    String writer = rs.getString("writer");
			    int viewcnt = rs.getInt("viewcnt");
			    Date regdate = rs.getDate("regdate");
			    bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
			    list.add(bDto);
			}
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public int viewCntPlus(int bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board " + 
					     "   SET viewcnt = viewcnt + 1 " + 
					     "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return result;
		
	}
	
	// 조회된 결과를 출력하는 함수
		public void printQuery(ArrayList<BoardDTO> list) {
			System.out.println("==============================================================");
			System.out.println("== 번호 \t 제목 \t 내용 \t 작성자 \t 작성일자 \t ");
			System.out.println("==============================================================");
			for (BoardDTO line : list) {
				System.out.println("== "+line.toString());
			}
			System.out.println("==============================================================");
		}
	
}
