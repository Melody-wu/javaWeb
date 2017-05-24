
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
        // ��ȡ�û���  
        String sUserName = request.getParameter("txtUserName");  
        if (sUserName == "" || sUserName == null || sUserName.length() > 20) {  
            result = "�������û�����������20�ַ�����";  
            request.getSession().setAttribute("error", result);  
            response.sendRedirect("login.jsp");  
        }  
        // ��ȡ����  
        String sPasswd = request.getParameter("txtPassword");  
        if (sPasswd == "" || sPasswd == null || sPasswd.length() > 20) {  
            result = "���������루������20�ַ�����";  
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
            // SQL���  
            String sql = "select * from login_info where user_name='" + sUserName  
                    + "' and user_password = '" + sPasswd + "'";  
            rs = st.executeQuery(sql);// ���ز�ѯ���
            ResultSetMetaData rsmd=rs.getMetaData();
            int colcount = rsmd.getColumnCount();
           if (rs.next())// �����¼���ǿգ�������ƥ����û��������룬��½�ɹ�  
            {  
                // ��¼�ɹ���sUserName����Ϊsession������UserName  
                // �����ں���Ϳ���ͨ�� session.getAttribute("UserName") ����ȡ�û�����  
                // ͬʱ������������Ϊ�û���¼�����ж�����  
            	str="";
            	for(int i=1;i<colcount+1;i++){
            		try { 
            			str += rs.getString(i) + ";"; 
            			} catch (NullPointerException e) { 
            			System.out.println(e.getMessage()); 
            			} 
                	//String colname = rsmd.getColumnName(i);//ȡ��ȫ������
                	//String colname = rsmd.getColumnLabel(i);
                	//System.out.println("������: "+ rsmd.getColumnName(i));
                	//String value =rs.getString(i);
                	//str+=value+',';
                	
                }
                request.getSession().setAttribute("UserName", sUserName);  
                response.sendRedirect("/Meshow/#/stage");  
            } 
           else {  
                // �����¼ʧ��  
                request.getSession().setAttribute("error", "�û������������");  
                response.sendRedirect("login_failure.jsp");  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            // ���չر�����  
            DBConn.close(conn, st, rs);  
        }  
    }  
}  