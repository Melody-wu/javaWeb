package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class common {
	public static Connection getConnection(String dataBaseName,String username,String password){
	    Connection connection = null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBaseName+"?useUnicode=true&characterEncoding=utf8",username,password);
	        System.out.println("获取数据库连接成功wow！"); 
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return connection;
	}
}
