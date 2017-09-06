package org.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection conn ;
	static final String URL ="jdbc:oracle:thin:@localhost:1521:orcl";
	static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	static final String namne = "scott";
	static final String password = "tiger";
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, namne, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
