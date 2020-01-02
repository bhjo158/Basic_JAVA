package problem.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	List<BoardDTO> list;
	int result;
	
	public void boardInsert(String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);
		
		try {
			result = sqlSession.insert("boardInsert", map);
			if(result > 0) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 작성을 완료했습니다.");
			} else {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 작성에 실패했습니다. 관리자에게 문의하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardUpdate(int bno, String title, String content) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("title", title);
		map.put("content", content);
		
		try {
			result = sqlSession.update("boardUpdate", map);
			if(result > 0) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 수정을 완료했습니다.");
			} else {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 수정에 실패했습니다. 관리자에게 문의하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardDelete(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("boardDelete", bno);
			if(result > 0) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 삭제를 완료했습니다.");
			} else {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글 삭제에 실패했습니다. 관리자에게 문의하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardSelect() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("boardSelect");
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardSearch(String keyword) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("boardSearch", "%"+keyword+"%");
			System.out.println("★★ "+keyword+"로 검색 결과 총 "+list.size()+"건의 결과가 조회되었습니다.");
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardSort() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("boardSort");
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardView(int bno) {
		int result = viewCntPlus(bno);
		if(!(result > 0)) {
			System.out.println("★★ 조회수 증가 실패! 관리자에게 문의하세요.");
			return;
		}
		sqlSession = sqlSessionFactory.openSession();
		try {
			BoardDTO bDto = sqlSession.selectOne("boardView", bno);
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
			sqlSession.close();
		}
	}
	
	public int viewCntPlus(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.update("viewCntPlus", bno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public String getWriter(int bno) {
		String writer = "";
		sqlSession = sqlSessionFactory.openSession();
		try {
			writer = sqlSession.selectOne("board.getWriter", bno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return writer;
	}
	
}
