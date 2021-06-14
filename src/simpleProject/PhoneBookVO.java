package simpleProject;

public class PhoneBookVO {
	private Long id;
	private String name;
	private String hp;
	private String tel;
	
	
	// 생성자
	public PhoneBookVO() {
		
	}
	
	// 필수 필드 생성자
	public PhoneBookVO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// 전체 필드 생성자
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