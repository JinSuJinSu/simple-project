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
			//	Connection ����
			conn = DriverManager.getConnection(DBConfig1.DBURL,	//	db ���� url
												dbuser,
												dbpass);
			System.out.println(conn);
			System.out.println("���� ����!");
		} catch (ClassNotFoundException e) {
			System.err.println("����̹� �ε� ����!");
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