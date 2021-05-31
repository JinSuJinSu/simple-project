package simpleProject;

public class PhoneBookVO {
	private Long id;
	private String name;
	private String hp;
	private String tel;
	
	
	// ������
	public PhoneBookVO() {
		
	}
	
	// �ʼ� �ʵ� ������
	public PhoneBookVO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// ��ü �ʵ� ������
	public PhoneBookVO(Long id,String name, String hp, String tel) {
		this(id, name);
		this.hp = hp;
		this.tel = tel;
	}
	


	public long getId() {
		return id;
	}



	public String getName() {
		return name;
	}


	
	public String getHp() {
		return hp;
	}


	
	public String getTel() {
		return tel;
	}




	

	@Override
	public String toString() {
		return "PhoneBookVO [id=" + id + ", name=" + name + ", hp=" + hp + ",  tel=" + tel +"]";
	}
}
	