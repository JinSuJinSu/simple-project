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
			System.out.println("1.����Ʈ 2.��� 3.���� 4.�˻� 5.����");
			for(int i=0; i<40; i++) {
				System.out.print("-");
			}
			System.out.println();
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print(">�޴���ȣ: ");
			
			
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
					System.out.println("[�ٽ��Է����ּ���]");
					
				
			}
			
			

			
		}
		
	
		
		

	}
	
	private static void startingFormat() {
		for(int i=0; i<40; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		
		System.out.print("*           ��ȭ��ȣ ���� ���α׷�          *");
		
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
		
		
		System.out.print("*               �����մϴ�.              *");
		
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
		
		System.out.println("<1.����Ʈ>");
		
		while(it.hasNext()) {
			PhoneBookVO item = it.next(); // iterator���� ��� ����
			System.out.printf("%d\t%s\t%s\t%s%n",item.getId(), item.getName(), item.getHp(), item.getTel());
		}
	}
	
	
	private static void searchInformation() {
		//	Scanner���� Ű���� �Է� -> �κ� �˻�
//		selectAll();
		Scanner scanner = new Scanner(System.in);
		System.out.print("4.�˻�");
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
		// scanner���� ���� PK �Է� �޾� delete�Ѵ�.
		Scanner scanner = new Scanner(System.in);

		System.out.println("<3.����>");
		System.out.print(">��ȣ :");
		
		int id = scanner.nextInt();
		
		
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		
		boolean sucess = dao.delete(Long.valueOf(id));
		
		
		selectAll();
		
	}
	


	private static void insertInformation() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("<2.���>");
		
		
		System.out.print(">�̸�: ");
		String name = scanner.nextLine();
		
		
		
		System.out.print(">�޴���ȭ: ");
		String hp = scanner.nextLine();;
		
		System.out.print(">����ȭ: ");
		String tel = scanner.nextLine();
		
		

		
		
		PhoneBookVO vo = new PhoneBookVO(null, name, hp, tel);
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		
		boolean sucess = dao.insert(vo);
		
		
		System.out.println(sucess? "[��ϵǾ����ϴ�]":"���� �߻� ���� �߻�");
		
		selectAll();

		
		
	}
	


}