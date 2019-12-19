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
	
	public int accountCheck(BankDTO bDto) {
		int result = 0;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * "
					   + "FROM tbl_bank "
					   + "WHERE bno = ? AND pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getBno());
			pstmt.setString(2, bDto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return result;
	}
	
	public int printMoney(BankDTO bDto) {
		int money = 0;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * "
					   + "FROM tbl_bank "
					   + "WHERE bno = ? AND pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getBno());
			pstmt.setString(2, bDto.getPw());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				money = rs.getInt("money");
				System.out.println("고객님의 현재 잔액은 " + money + "입니다.");
			}
		} catch (Exception e) {
			
		} finally {
			
		}
		return money;
	}
	
	public void withdraw(BankDTO bDto) {
		// 1.계좌번호 패스워드 입력받고
		// 2.DB정보와 일치하는지 확인
		// 3.값없으면 출력하고 break, 값있으면 계좌잔액출력
		// 4.출금액이 계좌잔액 오버하면 금액부족 출력
		// 5.출금액이 계좌잔액 오버하지 않으면 업데이트하고 출금되었다 출력
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
