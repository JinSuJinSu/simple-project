package simpleProject;



import java.util.*;


// ���赵 �ۼ�
public interface PhoneBookDAO {
	public List<PhoneBookVO> getList(); //�ܼ� select
	public List<PhoneBookVO> search(String keyword); // like �˻�
	public boolean insert(PhoneBookVO vo); // INSERT
	public boolean delete(Long id); //pk�� ����
	

}