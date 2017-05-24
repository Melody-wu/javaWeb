
package demo.servlet;  
  
import java.io.IOException;  
import java.sql.Connection;  
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;  
import java.sql.Statement;  
  
import javax.servlet.Servlet;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import demo.conn.DBConn;  

public class login extends HttpServlet implements Servlet {  
    @Override  
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        doPost(request, response);  
    }  
  
    @Override  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        String result = "";  
        // 获取用户名  
        String sUserName = request.getParameter("txtUserName");  
        if (sUserName == "" || sUserName == null || sUserName.length() > 20) {  
            result = "请输入用户名（不超过20字符）！";  
            request.getSession().setAttribute("error", result);  
            response.sendRedirect("login.jsp");  
        }  
        // 获取密码  
        String sPasswd = request.getParameter("txtPassword");  
        if (sPasswd == "" || sPasswd == null || sPasswd.length() > 20) {  
            result = "请输入密码（不超过20字符）！";  
            request.getSession().setAttribute("error", result);  
            response.sendRedirect("login.jsp");  
        }  
  
        Statement st = null;  
        ResultSet rs = null;  
        Connection conn = null; 
       
        try {  
        	 String str="";
            conn = DBConn.getConn();  
            st = conn.createStatement();  
            // SQL语句  
            String sql = "select * from login_info where user_name='" + sUserName  
                    + "' and user_password = '" + sPasswd + "'";  
            rs = st.executeQuery(sql);// 返回查询结果
            ResultSetMetaData rsmd=rs.getMetaData();
            int colcount = rsmd.getColumnCount();
           if (rs.next())// 如果记录集非空，表明有匹配的用户名和密码，登陆成功  
            {  
                // 登录成功后将sUserName设置为session变量的UserName  
                // 这样在后面就可以通过 session.getAttribute("UserName") 来获取用户名，  
                // 同时这样还可以作为用户登录与否的判断依据  
            	str="";
            	for(int i=1;i<colcount+1;i++){
            		try { 
            			str += rs.getString(i) + ";"; 
            			} catch (NullPointerException e) { 
            			System.out.println(e.getMessage()); 
            			} 
                	//String colname = rsmd.getColumnName(i);//取得全部列名
                	//String colname = rsmd.getColumnLabel(i);
                	//System.out.println("列名称: "+ rsmd.getColumnName(i));
                	//String value =rs.getString(i);
                	//str+=value+',';
                	
                }
                request.getSession().setAttribute("UserName", sUserName);  
                response.sendRedirect("/Meshow/#/stage");  
            } 
           else {  
                // 否则登录失败  
                request.getSession().setAttribute("error", "用户名或密码错误！");  
                response.sendRedirect("login_failure.jsp");  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            // 最终关闭连接  
            DBConn.close(conn, st, rs);  
        }  
    }  
}  