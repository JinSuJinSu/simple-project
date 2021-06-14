package simpleProject;

import java.sql.*;

public class DBConfig1 {
	public static String DBURL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String DBUSER = "c##bituser";
	public static String DEPASS = "bituser";
	
	
	
	static Connection getConnection() throws SQLException{
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DBURL,DBUSER,DEPASS);
		}
		catch(ClassNotFoundException e){
			System.err.println("에러가 발생했습니다!!");
			
		}
		
		return conn;
		
}
}