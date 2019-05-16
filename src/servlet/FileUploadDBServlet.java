package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bean.ConnectionProvider;
 
@SuppressWarnings("serial")
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        String topic = request.getParameter("topic");
        String content = request.getParameter("content");
         
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("fname");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        Connection con = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            con = ConnectionProvider.getCon(); 
 
            // constructs SQL ps
            String sql = "INSERT INTO post (topic, content, image, time) values (?, ?, ?, ?)"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, topic);
			ps.setString(2, content); 
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
             
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
            	ps.setBinaryStream(3, inputStream,(int) filePart.getSize());
            }
 
            // sends the ps to the database server
            int row = ps.executeUpdate();

            if (row > 0) {
                message = "File uploaded and saved into database";
            }

        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            //sets the message in request scope
            request.setAttribute("Message", message);
             
            //forwards to the message page
            response.sendRedirect("/webapp/index.jsp");
        }
    }
}