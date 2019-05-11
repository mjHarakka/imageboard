package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String sql = "SELECT * from user;";
        
        try (Connection conn = ConnectionProvider.getCon();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("name") + "\t" + 
                				   rs.getString("email") + "\t" + 
                                   rs.getString("pass"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

}
