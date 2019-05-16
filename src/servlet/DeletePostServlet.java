package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ConnectionProvider;
 
@SuppressWarnings("serial")
@WebServlet("/deletepost/*")
public class DeletePostServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request,
    	HttpServletResponse response) throws ServletException, IOException {
       
    	String id = request.getPathInfo().substring(1);
    	
    	try {
            Connection con = ConnectionProvider.getCon(); 
 
            String sql = "DELETE FROM post where id = ?"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(id));
             
            ps.executeUpdate();

            response.sendRedirect("/webapp/adminpage.jsp");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}