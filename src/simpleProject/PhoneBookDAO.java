package simpleProject;



import java.util.*;


// 설계도 작성
public interface PhoneBookDAO {
	public List<PhoneBookVO> getList(); //단순 select
	public List<PhoneBookVO> search(String keyword); // like 검색
	public boolean insert(PhoneBookVO vo); // INSERT
	public boolean delete(Long id); //pk로 삭제
	

}