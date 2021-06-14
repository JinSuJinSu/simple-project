package simpleProject;


import java.util.*;
import java.sql.*;

public class PhoneBookDAOImpl implements PhoneBookDAO {
	
	//공통 접속 메소드
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl,"C##bituser","bituser");
			
		}
		catch(ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!!");
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
		
		//결과 객체
		List<PhoneBookVO> list = new ArrayList<>();

		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			//쿼리 작성
			String sql = "select id, name, hp, tel from phoneBooKList";
			
			//쿼리 실행
			rs = stmt.executeQuery(sql);
			
			
			//ResultSet을 자바 객체로 변환
			while(rs.next()) {
				long id = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				
				//DTO 객체
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
				System.err.println("에러! 에러!");
				
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

			//	쿼리 수행
			rs = pstmt.executeQuery();

			//	변환 
			while(rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String tel = rs.getString("tel");

				//	VO 객체
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
					// 실행 쿼리
					String sql = "insert into phoneBooKList values(SEQ_PHONE_BOOK_PK.nextval,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					// 데이터 바인딩
					pstmt.setString(1, vo.getName());
					pstmt.setString(2, vo.getHp());
					pstmt.setString(3, vo.getTel());
					
					
					
					//쿼리 실행
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
			// 실행 계획
			String sql = "delete from phoneBooKList where id=?";
			pstmt = conn.prepareStatement(sql);
			// 파라미터 바인딩
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
	