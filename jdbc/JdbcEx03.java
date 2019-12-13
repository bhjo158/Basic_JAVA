package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호:");
		int num = sc.nextInt();
		System.out.print("이름:");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("나이:");
		int age = sc.nextInt();
		
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
//		String user = "java";
//		String password = "1234";
		
		try {
			
			Connection conn = DBManager.getConnection();
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			// OracleDriver를 사용한다고 명시했다
			// Oracle을 쓴다고 java에게 알려줌
			
//			Connection conn = DriverManager.getConnection(url, user, password);
			// Connection conn : java랑 db랑 손잡고있음
			
			String sql = "INSERT INTO tbl_study VALUES(?, ?, ?)";
			// sql문을 담았음
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// PreparedStatement문 : 값을 동적으로 바꿀수있음
			// java가 db에게 명령할 준비 완료
			
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			// java가 PreparedStatement문 방식으로 sql문 완성
			
			int result = pstmt.executeUpdate();
			// executeUpdate가 실행하는 방식
			// 어떤거를? pstmt를 실행하래
			
			if(result > 0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
			// result = 1 : 성공
			// result = 0 : 실패
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
}
