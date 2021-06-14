package simpleProject;

import java.sql.*;	//	JDBC API

public class ConnectionTest1 {

	public static void main(String[] args) {
		String dbuser = "c##bituser";
		String dbpass = "bituser";
		Connection conn = null;

		try {
			// Driver Load
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//	Connection 생성
			conn = DriverManager.getConnection(DBConfig1.DBURL,	//	db 접속 url
												dbuser,
												dbpass);
			System.out.println(conn);
			System.out.println("연결 성공!");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		} catch (SQLException e) {
			System.err.println("SQLError!");
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}