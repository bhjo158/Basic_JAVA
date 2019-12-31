package problem.board;

import java.sql.Date;
import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO();
		int code = 0; // 사용자가 선택한 프로그램 번호
		
		while(true) { // 전체 프로그램 while
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("★★ 게시판 프로그램 ver1.3");
			bDao.boardSelect();
			System.out.println("★★ 1.게시글작성");
			System.out.println("★★ 2.게시글수정");
			System.out.println("★★ 3.게시글삭제");
			System.out.println("★★ 4.게시글조회");
			System.out.println("★★ 5.게시글검색");
			System.out.println("★★ 6.게시글정렬");
			System.out.println("★★ 7.상세 게시글");
			System.out.println("★★ 8.만든이");
			System.out.println("★★ 9.프로그램 종료");
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			
			while(true) { // 번호 입력받는 부분 while
				System.out.print("★★ 번호 >> ");
				code = sc.nextInt();
				if(code >= 1 && code <= 9) {
					break;
				} else {
					System.out.println("1~9까지만 입력하세요.");
					continue;
				}
			}
			
			if(code == 1) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 게시글을 작성합니다.");
				System.out.print("★★ 제목 >> ");
				sc.nextLine();
			    String title = sc.nextLine();
			    System.out.print("★★ 내용 >> ");
			    String content = sc.nextLine();
			    System.out.print("★★ 작성자 >> ");
			    String writer = sc.nextLine();
			    bDao.boardInsert(title, content, writer);
			} else if(code == 2) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 수정할 게시글 번호를 입력하세요");
				System.out.print("★★ 게시글 번호 >> ");
				int bno = sc.nextInt();
				System.out.println("★★ 게시글을 수정해주세요.");
				System.out.print("★★ 제목 >> ");
				sc.nextLine();
			    String title = sc.nextLine();
			    System.out.print("★★ 내용 >> ");
			    String content = sc.nextLine();
			    System.out.print("★★ 작성자 >> ");
			    String writer = sc.nextLine();
			    bDao.boardUpdate(bno, title, content, writer);
			} else if(code == 3) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 작성된 게시글을 삭제합니다.");
				System.out.print("★★ 게시글 번호 입력 >> ");
				int bno = sc.nextInt();
				bDao.boardDelete(bno);
			} else if(code == 4) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 작성된 게시글을 조회합니다.");
				bDao.boardSelect();
			} else if(code == 5) {
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
				System.out.println("★★ 작성된 게시글을 검색합니다.");
				System.out.print("★★ 검색할 키워드를 입력하세요 >> ");
				sc.nextLine();
				String keyword = sc.nextLine();
				bDao.boardSearch(keyword);
			} else if(code == 6) {
				
			} else if(code == 7) {
				
			} else if(code == 8) {
				
			} else if(code == 9) {
				
			}
			
//			if(code == 1) {
//				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
//				System.out.println("★★ 게시글을 작성합니다.");
//				System.out.print("★★ 제목 입력 >> ");
//				sc.nextLine();
//			    String title = sc.nextLine();
//			    System.out.print("★★ 내용 입력 >> ");
//			    String content = sc.nextLine();
//			    System.out.print("★★ 작성자 입력 >> ");
//			    String writer = sc.nextLine();
//				BoardDTO bDto = new BoardDTO(title, content, writer);
//				bDao.boardInsert(bDto);
//				
//			} else if(code == 2) {
//				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
//				System.out.println("★★ 작성된 게시글을 수정합니다.");
//				System.out.print("★★ 게시글 번호 입력 >> ");
//				int bno = sc.nextInt();
//				System.out.println("★★ 게시글을 수정해주세요.");
//				System.out.print("★★ 제목 입력 >> ");
//				sc.nextLine();
//			    String title = sc.nextLine();
//			    System.out.print("★★ 내용 입력 >> ");
//			    String content = sc.nextLine();
//			    System.out.print("★★ 작성자 입력 >> ");
//			    String writer = sc.nextLine();
//				BoardDTO bDto = new BoardDTO(bno, title, content, writer);
//				bDao.boardUpdate(bDto);
//				
//			} else if(code == 3) {
//				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
//				System.out.println("★★ 작성된 게시글을 삭제합니다.");
//				System.out.print("★★ 게시글 번호 입력 >> ");
//				int bno = sc.nextInt();
//				bDao.boardDelete(bno);
//				
//			} else if(code == 4) {
//				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
//				System.out.println("★★ 작성된 게시글을 조회합니다.");
//				bDao.boardSelect();
//				
//			} else if(code == 5) {
//				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
//				System.out.println("★★ 작성된 게시글을 검색합니다.");
//				System.out.print("★★ 검색할 키워드를 입력하세요 >> ");
//				sc.nextLine();
//				String keyword = sc.nextLine();
//				bDao.boardSearch(keyword);
//				
//			} else if(code == 6) {
//				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
//				System.out.println("★★ 조회수 순으로 작성된 게시글을 정렬합니다.");
//				bDao.boardSort();
//				
//			} else if(code == 7) {
//				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
//				System.out.println("★★ 보고싶은 게시글번호를 입력하세요.");
//				System.out.println("★★ 게시글번호 >> ");
//				int bno = sc.nextInt();
//				bDao.boardView(bno);
//				
//			} else if(code == 8) {
//				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
//				System.out.println("★★ Name: Board Program");
//				System.out.println("★★ Version: 1.3");
//				System.out.println("★★ Use: JAVA, ORACLE");
//				System.out.println("★★ Date: 2019.12.17");
//				System.out.println("★★ made by bhjo92");
//				System.out.println("★★ ivy9230@gmail.com");
//			} else if(code == 9) {
//				System.out.println("★★★★ [프로그램 종료] ★★★★");
//				System.exit(0);
//			}
			
		}
		
	}

}
