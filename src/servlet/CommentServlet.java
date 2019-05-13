package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bean.Comment;
import bean.ConnectionProvider;
 
@SuppressWarnings("serial")
@WebServlet("/Post/*")
public class CommentServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request,
    	HttpServletResponse response) throws ServletException, IOException {
       
    	String content = request.getParameter("commentContent");
    	String id = request.getPathInfo().substring(1);
    	
    	try {
            // connects to the database
            Connection con = ConnectionProvider.getCon(); 
 
            // constructs SQL ps
            String sql = "INSERT INTO comment (postid, content) values (?,?)"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(id)); 
			ps.setString(2, content); 
             
            ps.executeUpdate();

            response.sendRedirect("/webapp/index.jsp");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}