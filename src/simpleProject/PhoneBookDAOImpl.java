package simpleProject;


import java.util.*;
import java.sql.*;

public class PhoneBookDAOImpl implements PhoneBookDAO {
	
	//���� ���� �޼ҵ�
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			// ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl,"C##bituser","bituser");
			
		}
		catch(ClassNotFoundException e) {
			System.err.println("����̹� �ε� ����!!");
		}
		
		return conn;
	}
	
	@Override
	public List<PhoneBookVO> getList() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		
		
		//select
		ResultSet rs = null;
		
		//��� ��ü
		List<PhoneBookVO> list = new ArrayList<>();

		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			//���� �ۼ�
			String sql = "select id, name, hp, tel from phoneBooKList";
			
			//���� ����
			rs = stmt.executeQuery(sql);
			
			
			//ResultSet�� �ڹ� ��ü�� ��ȯ
			while(rs.next()) {
				long id = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				
				//DTO ��ü
				PhoneBookVO vo = new PhoneBookVO(id, name, hp, tel);
				list.add(vo);	
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(Exception e) {
				System.err.println("����! ����!");
				
			}
			
		
		
	}
		
		return list;
		
	}

	

	@Override
	public List<PhoneBookVO> search(String keyword) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<PhoneBookVO> list = new ArrayList<>();

		String sql = "select id, name, hp, tel from phoneBooKList" +
					" WHERE name LIKE ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + keyword + "%");

			//	���� ����
			rs = pstmt.executeQuery();

			//	��ȯ 
			while(rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String tel = rs.getString("tel");

				//	VO ��ü
				PhoneBookVO vo = new PhoneBookVO(id, name, hp, tel);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return list;
	}

	

	@Override
	public boolean insert(PhoneBookVO vo) {
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement pstmt = null;
				int insertedCount = 0;
				
				try {
					conn = getConnection();
					// ���� ����
					String sql = "insert into phoneBooKList values(SEQ_PHONE_BOOK_PK.nextval,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					// ������ ���ε�
					pstmt.setString(1, vo.getName());
					pstmt.setString(2, vo.getHp());
					pstmt.setString(3, vo.getTel());
					
					
					
					//���� ����
					insertedCount = pstmt.executeUpdate();
				}
					
					catch(SQLException e) {
						e.printStackTrace();
					}
					finally {
						try {
							pstmt.close();
							conn.close();
							
						}
						catch(Exception e) {
							e.printStackTrace();
						}
					}
					
				
				
			
			
				
				return 1== insertedCount;
			}


	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		
		try {
			conn = getConnection();
			// ���� ��ȹ
			String sql = "delete from phoneBooKList where id=?";
			pstmt = conn.prepareStatement(sql);
			// �Ķ���� ���ε�
			pstmt.setLong(1, id);
			
			
			deletedCount = pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return 1==deletedCount;
	}





	

}
	
