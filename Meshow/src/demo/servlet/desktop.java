
package demo.servlet;  
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Servlet;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.json.*;
import utils.database;
public class desktop extends HttpServlet implements Servlet {

    @Override  
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {
	    	response.setCharacterEncoding("UTF-8");  
	        response.setContentType("application/json; charset=utf-8");  
	    	database b=new database();
	    	String[] args = null;
			try {
				JSONArray data=b.main(args);
				//System.out.println(data); 
				JSONObject json= new JSONObject(); 
				json.put("datas",data); 
				PrintWriter out = response.getWriter(); 
				out.println(json.toString());

			  // 	response.getWriter().append((CharSequence) data);
			   	//response.getWriter().print(getString(data));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println("wml");
    	
    }
}  