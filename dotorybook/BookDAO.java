package problem.dotorybook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BookDTO> list = new ArrayList<>();
	
	public void bookInsert(BookDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_book(bno, bname, price, company, writer) "
		               + "VALUES(seq_book.NEXTVAL, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setInt(2, bDto.getPrice());
			pstmt.setString(3, bDto.getCompany());
			pstmt.setString(4, bDto.getWriter());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println(bDto.getBname() + " 도서 등록에 성공하였습니다.");
			} else {
				System.out.println("도서 등록에 실패하였습니다. 다시 입력해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	public void bookUpdate(BookDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_book "
					   + "SET bname = ?, "
					       + "price = ?, "
					       + "company = ?, "
					       + "writer = ? "
					   + "WHERE bno = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setInt(2, bDto.getPrice());
			pstmt.setString(3, bDto.getCompany());
			pstmt.setString(4, bDto.getWriter());
			pstmt.setString(5, bDto.getBno());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println(bDto.getBname() + " 도서 수정에 성공하였습니다.");
			} else {
				System.out.println("도서 수정에 실패하였습니다. 도서번호를 확인해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void bookDelete(String bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_book WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println(bno + "번 도서 삭제에 성공하였습니다.");
			} else {
				System.out.println("도서 삭제에 실패하였습니다. 도서번호를 확인해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	public void bookSelect() {
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT * FROM tbl_book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bno = rs.getString("bno");
				String bname = rs.getString("bname");
			    int price = rs.getInt("price");
			    String company = rs.getString("company");
			    String writer = rs.getString("writer");
			    Date regdate = rs.getDate("regdate");
			    BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
			    list.add(bDto);
			}
			
			for (BookDTO line : list) {
				System.out.println(line.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
	public void bookSearch(String bname) {
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT * FROM tbl_book "
					+ "WHERE bname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bname+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bno = rs.getString("bno");
				bname = rs.getString("bname");
			    int price = rs.getInt("price");
			    String company = rs.getString("company");
			    String writer = rs.getString("writer");
			    Date regdate = rs.getDate("regdate");
			    BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
			    list.add(bDto);
			}
			
			for (BookDTO line : list) {
				System.out.println(list.toString());
			}
			
		} catch (Exception e) {
			
		} finally {
			
		}
		
	}
	public void madeBy() {}
	
}
