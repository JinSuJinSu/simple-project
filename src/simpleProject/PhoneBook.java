package simpleProject;



import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class PhoneBook {

	public static void main(String[] args) {
		
		startingFormat();
		// TODO Auto-generated method stub
		
		boolean running = true;
		
		while(running) {
			System.out.println();
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			for(int i=0; i<40; i++) {
				System.out.print("-");
			}
			System.out.println();
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print(">메뉴번호: ");
			
			
			int number = scan.nextInt();

			
			
			switch(number) {
				case 1:
				selectAll();
				break;
				
				case 2:
					insertInformation();
					break;
					
				case 3:
					deleteInfomation();
					break;
					
				case 4:
					searchInformation();
					break;
					
				case 5:
					endingFormat();
					running = false;
					break;
					
				default:
					System.out.println("[다시입력해주세요]");
					
				
			}
			
			

			
		}
		
	
		
		

	}
	
	private static void startingFormat() {
		for(int i=0; i<40; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		
		System.out.print("*           전화번호 관리 프로그램          *");
		
		System.out.println();
		
		
		
		
		for(int i=0; i<40; i++) {
			System.out.print("*");
		}
		
		System.out.println();
		
		
	}
	
	private static void endingFormat() {
		for(int i=0; i<40; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		
		System.out.print("*               감사합니다.              *");
		
		System.out.println();
		
		
		
		
		for(int i=0; i<40; i++) {
			System.out.print("*");
		}
		
		System.out.println();
		
		
	}
	

	
	
	private static void selectAll() {
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		List<PhoneBookVO> list = dao.getList();
		
		
		
		//Iterator
		Iterator<PhoneBookVO> it = list.iterator();
		
		System.out.println("<1.리스트>");
		
		while(it.hasNext()) {
			PhoneBookVO item = it.next(); // iterator에서 요소 추출
			System.out.printf("%d\t%s\t%s\t%s%n",item.getId(), item.getName(), item.getHp(), item.getTel());
		}
	}
	
	
	private static void searchInformation() {
		//	Scanner에서 키워드 입력 -> 부분 검색
//		selectAll();
		Scanner scanner = new Scanner(System.in);
		System.out.print("4.검색");
		String keyword = scanner.nextLine();

		PhoneBookDAO dao = new PhoneBookDAOImpl();
		List<PhoneBookVO> list = dao.search(keyword);

		Iterator<PhoneBookVO> it = list.iterator();

		while(it.hasNext()) {
			PhoneBookVO vo = it.next();
			System.out.printf("%d\t%s\t%s%n", 
					vo.getId(),
					vo.getName(),
					vo.getHp(),
					vo.getTel());
		}
		
		
		
	}
	
	
	private static void deleteInfomation() {
		// scanner에서 저작 PK 입력 받아 delete한다.
		Scanner scanner = new Scanner(System.in);

		System.out.println("<3.삭제>");
		System.out.print(">번호 :");
		
		int id = scanner.nextInt();
		
		
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		
		boolean sucess = dao.delete(Long.valueOf(id));
		
		
		selectAll();
		
	}
	


	private static void insertInformation() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("<2.등록>");
		
		
		System.out.print(">이름: ");
		String name = scanner.nextLine();
		
		
		
		System.out.print(">휴대전화: ");
		String hp = scanner.nextLine();;
		
		System.out.print(">집전화: ");
		String tel = scanner.nextLine();
		
		

		
		
		PhoneBookVO vo = new PhoneBookVO(null, name, hp, tel);
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		
		boolean sucess = dao.insert(vo);
		
		
		System.out.println(sucess? "[등록되었습니다]":"에러 발생 에러 발생");
		
		selectAll();

		
		
	}
	


}