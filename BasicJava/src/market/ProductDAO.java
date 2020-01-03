package market;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ProductDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<ProductDTO> list;
	boolean flag; // default: false
	
	public void salePdt(int pno, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("pno", pno);
		map.put("cnt", cnt);
		
		try {
			result = sqlSession.update("pdt.sale", map);
			if(result > 0) {
				System.out.print("♥♥ 구매 완료");
			} else {
				System.out.print("♥♥ 구매 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 제품 등록&추가 기능 작동시 기존에 등록된 제품인지 최초입고 제품인지 판별하는 기능
	public boolean pdtAlready(String pname) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.selectOne("pdt.already", pname);
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
	
	public void cntPlusPdt(String pname, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("cnt", cnt);
		
		try {
			result = sqlSession.update("pdt.cntPlus", map);
			if(result > 0) {
				System.out.print("♥♥ " + pname + " " + cnt + "개 추가가 완료되었습니다.");
			} else {
				System.out.print("♥♥ " + pname + " " + cnt + "개 추가에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertPdt(ProductDTO pDto) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("pdt.insert", pDto);
			if(result > 0) {
				System.out.print("♥♥ " + pDto.getPname() + " 등록이 완료되었습니다.");
			} else {
				System.out.print("♥♥ " + pDto.getPname() + " 등록에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void updatePdt(ProductDTO pDto) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.update("pdt.update", pDto);
			if(result > 0) {
				System.out.print("♥♥ " + pDto.getPname() + " 수정이 완료되었습니다.");
			} else {
				System.out.print("♥♥ " + pDto.getPname() + " 수정에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void deletePdt(String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("pdt.delete", pname);
			if(result > 0) {
				System.out.print("♥♥ " + pname + " 삭제가 완료되었습니다.");
			} else {
				System.out.print("♥♥ " + pname + " 삭제에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void selectPdt() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("pdt.select");
			for (ProductDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void searchPdt(String keyword) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("pdt.search", "%"+keyword+"%");
			System.out.println(keyword + "로 검색 결과 총 "+ list.size() +"건이 조회되었습니다.");
			for (ProductDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 재고가 1 이상인 상품만 조회
	public void saleSelectPdt() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("pdt.saleSelect");
			for (ProductDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 가격을 알려주는 메서드
	public int tpricePdt(int pno, int cnt) {
		int tprice = 0;
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, Integer> map = new HashMap<>();
		map.put("pno", pno);
		map.put("cnt", cnt);
		
		try {
			tprice = sqlSession.selectOne("pdt.tprice", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return tprice;
	}
	
}
