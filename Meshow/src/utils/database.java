
package utils;  
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.json.*;
//import org.json.JSONObject;
import utils.common;
import utils.properties;   
public class database{
	private static String username; //用户名
	private static String password; //密码
	private static String dataBaseName; //数据库名
	private static String sql; //sql语句
	public static JSONArray main(String args[]) throws SQLException{
		
		Statement st = null;  
        ResultSet rs = null;
        Connection conn=null;
        String str="";
        JSONArray  array= new JSONArray ();
		Properties p = properties.config("jbdc.properties");
		username = p.getProperty("db.username");
	    password = p.getProperty("db.password");
	    dataBaseName = p.getProperty("db.dataBaseName");
	    sql=p.getProperty("db.sql");
	    conn=common.getConnection(dataBaseName, username, password);
	    st=conn.createStatement();
		rs = st.executeQuery(sql);
		ResultSetMetaData rsmd=rs.getMetaData();
		int colcount = rsmd.getColumnCount();
		 while(rs.next()){
			 str="";
			 JSONObject jsonObj = new JSONObject();
         	for(int i=1;i<=colcount;i++){
         		try { 
         			str += rs.getString(i) + ";"; 
         			String colname = rsmd.getColumnLabel(i);
         			String value=rs.getString(colname);
         			 jsonObj.put(colname, value); 
         			
         			} catch (NullPointerException e) { 
         			System.out.println(e.getMessage()); 
         			} 
 
             	
             }
         	array.put(jsonObj);
		 }
          return array;
	}
}
