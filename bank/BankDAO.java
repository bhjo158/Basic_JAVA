package problem.bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.dotorybook.DBManager;

public class BankDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	ArrayList<BankDTO> list = new ArrayList<>();
	BankDTO bDto;
	
	public void createAccount(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_bank(bno, bname, pw) "
					   + "VALUES(seq_bank.NEXTVAL, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getPw());
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("■■ 계좌개설이 완료되었습니다.");
			} else {
				System.out.println("■■ 계좌개설에 실패했습니다. 이름과 비밀번호를 확인하세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
	public void deposit(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank "
					   + "SET money = money + ? "
					   + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getMoney());
			pstmt.setInt(2, bDto.getBno());
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("■■ 입금이 완료되었습니다.");
			} else {
				System.out.println("■■ 입금에 실패했습니다. 계좌번호를 확인하세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public void withdraw(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank "
					   + "SET money = money - ? "
					   + "WHERE bno = ? AND pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getMoney());
			pstmt.setInt(2, bDto.getBno());
			pstmt.setString(3, bDto.getPw());
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("■■ 출금이 완료되었습니다.");
			} else {
				System.out.println("■■ 출금에 실패했습니다. 계좌번호와 비밀번호를 확인하세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
	public void selectAccount() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * "
					   + "FROM tbl_bank";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
			    String bname = rs.getString("bname");
			    String pw = rs.getString("pw");
			    int money = rs.getInt("money");
			    Date regdate = rs.getDate("regdate");
			    bDto = new BankDTO(bno, bname, pw, money, regdate);
			    list.add(bDto);
			}
			for (BankDTO line : list) {
				System.out.println(line.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
	public void search(String bname) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * "
					   + "FROM tbl_bank "
					   + "WHERE bname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bname+"%");
			rs = pstmt.executeQuery();
			
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
			    bname = rs.getString("bname");
			    String pw = rs.getString("pw");
			    int money = rs.getInt("money");
			    Date regdate = rs.getDate("regdate");
			    bDto = new BankDTO(bno, bname, pw, money, regdate);
			}
			System.out.println(bDto.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
		
	}

	
}
