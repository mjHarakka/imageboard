package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ConnectionProvider;
 
@SuppressWarnings("serial")
@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    // content = blob, name = varchar(255) UNIQUE.
    private static final String SQL_FIND = "SELECT image FROM post WHERE id = ?";

    /*
    @Resource(name="jdbc/yourDB") // For Tomcat, define as <Resource> in context.xml and declare as <resource-ref> in web.xml.
    private DataSource dataSource;
	*/

    Connection con = null; // connection to the database
    String message = null;  // message will be sent back to client
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getPathInfo().substring(1);

        try {
        	Connection con = ConnectionProvider.getCon();
        	PreparedStatement statement = con.prepareStatement(SQL_FIND);
            statement.setString(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    byte[] content = resultSet.getBytes("image");
                    response.setContentType(getServletContext().getMimeType(id));
                    response.setContentLength(content.length);
                    response.getOutputStream().write(content);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
                }
            } catch (SQLException e) {
            	System.out.println(e.getMessage());
            } finally {}
        } catch (SQLException e) {
            throw new ServletException("Something failed at SQL/DB level.", e);
        }
    }

}