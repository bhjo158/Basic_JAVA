package problem.bank;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BankDAO {
	// MyBatis 세팅값 호출
	// Session을 생성하는 공장을 만드는 과정
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
	// mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;
	
	List<BankDTO> list;
	int result;
	
	// 1.신규계좌 개설
	public void insertBank(String bname, String pw) {
		// true : 자동커밋을 해달라는 얘기(insert,update,delete)
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			BankDTO bDto = new BankDTO(bname, pw);
			result = sqlSession.insert("insertBank", bDto);
			// sqlSession.commit();
			if(result > 0) {
				System.out.println("■■ " + bname + "님 신규계좌를 개설하였습니다.");
			} else {
				System.out.println("■■ 계좌개설에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 2.입금
	public void deposit(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Integer> map = new HashMap<>();
		// primative type : 기본 자료형
		// reference type : 객체 자료형
		// 기본자료형을 객체자료형으로 만드는게 랩퍼 클래스(wrapper class)
		// 랩으로 싼다는 의미
		map.put("bno", bno);
		map.put("money", money);
		map.put("flag", 1); // 동적쿼리(입금 or 출금 유무)
		
		try {
			result = sqlSession.update("changeMoney", map);
			if(result > 0) {
				System.out.println("■■ " + money + "원 입금에 성공하였습니다.");
				System.out.println("■■ 현재 계좌 잔액은 " + balanceMoney(bno) + "원 입니다.");
			} else {
				System.out.println("■■ 입금에 실패하였습니다. 계좌번호와 패스워드를 확인하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 3.출금
	public void withdraw(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bno", bno);
		map.put("money", money);
		map.put("flag", 0);
		
		try {
			result = sqlSession.update("changeMoney", map);
			if(result > 0) {
				System.out.println("■■ " + money + "원 출금에 성공하였습니다.");
				System.out.println("■■ 현재 계좌 잔액은 " + balanceMoney(bno) + "원 입니다.");
			} else {
				System.out.println("■■ 출금에 실패하였습니다. 계좌번호와 패스워드를 확인하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	
	// 4.전체고객조회
	public void selectBank() {
		// 공장한테 나 sql문 써야되니까 일할녀석 하나 만들어줘 하는 것
		// 만들어진 Factory를 통해서 Session을 하나 만드는 것
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			// select하는 일을 시키고싶다 = select
			// 단건일때만 selectOne
			// 다건일때는 selectList
			// insert update delete의 경우는 단건 다건 구분없이 똑같다
			list = sqlSession.selectList("selBank");
			
			for (BankDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 5.계좌잔액조회
	public void selectAccount(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			BankDTO bDto = new BankDTO(bno, pw);
			bDto = sqlSession.selectOne("selectAccount", bDto);
			
			// SelectOne => DTO
			// SelectList => LIST or DTO 
			
			if(bDto == null) {
				System.out.println("■■ 존재하지 않는 계좌번호이거나 암호가 틀렸습니다.");
				return;
			} else {
				System.out.println("■■ " + bno + "계좌의 총 금액은 " + bDto.getMoney() + "입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 6.계좌해지
		public void deleteBank(int bno, String pw) {
			// DB관련된 일을 할 세션을 하나 만든다
			sqlSession = sqlSessionFactory.openSession(true);
			
			// (key, value)
			HashMap<String, Object> map = new HashMap<>();
			map.put("bno", bno);
			map.put("pw", pw);
			
			try {
				result = sqlSession.delete("deleteBank", map);
				if(result > 0) {
					System.out.println("■■ " + bno + " 계좌를 해지하였습니다.");
				} else {
					System.out.println("■■ 계좌해지에 실패하였습니다. 관리자에게 문의해주세요.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
		}
	
	// 계좌 잔액 조회
	public int balanceMoney(int bno) {
		sqlSession = sqlSessionFactory.openSession();
		int money = 0;
		try {
			money = sqlSession.selectOne("balanceMoney", bno);
			System.out.println(">>>>>>> " + money);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return money;
	}
	
	// 사용자확인
	public boolean checkUser(int bno, String pw) {
		boolean flag = false;
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("pw", pw);
		try {
			result = sqlSession.selectOne("checkUser", map);
			if(result > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return flag;
	}
	
}
