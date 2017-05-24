package demo.conn;  
  
import java.sql.*;  
  
public class DBConn {  
    static {  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            System.out.println("�������سɹ���");  
        } catch (Exception ex) {  
            System.out.println("��������ʧ�ܣ�");  
            ex.printStackTrace();  
        }  
    }  
  
    public static Connection getConn() {  
        try {  
            String url = "jdbc:mysql://localhost:3306/firstdata?"  
                    + "user=root&password=wml123456&useUnicode=true&characterEncoding=utf8";  
            Connection conn = DriverManager.getConnection(url);  
            System.out.println("��ȡ���ݿ����ӳɹ�wo��"); 
            System.out.println("wml"+conn);
            return conn;  
        } catch (Exception ex) {  
            System.out.println("��ȡ���ݿ�����ʧ�ܣ�");  
            ex.printStackTrace();  
            return null;  
        }  
    }  
  
    public static void close(Connection conn, Statement st, ResultSet rs) {  
        if (rs != null) {  
            try {  
                rs.close();  
            } catch (SQLException ex) {  
            }  
        }  
        if (st != null) {  
            try {  
                st.close();  
            } catch (Exception ex) {  
            }  
        }  
        if (conn != null) {  
            try {  
                conn.close();  
            } catch (Exception ex) {  
            }  
        }  
    }  
  
}  