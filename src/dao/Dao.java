package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.User;

import java.util.ArrayList;

public class Dao { 

	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement stmtPrep = null; 
	private String sql;
	
	private Connection yhdista(){
    	Connection con = null;    	        	
    	String JDBCAjuri = "org.mariadb.jdbc.Driver";
    	String url = "jdbc:mariadb://localhost:3306/bgg316";        	
    	try {
	         Class.forName(JDBCAjuri);
	         con = DriverManager.getConnection(url,"bgg316", "reRY5T33r");	        
	     } catch (Exception e){	         
	        e.printStackTrace();	         
	     }
	     return con;
	}

	public ArrayList<User> listaaKaikki(){
		ArrayList<User> users = new ArrayList<User>();
		sql = "SELECT * FROM user;";       

		try {
			con = yhdista();
			if (con != null) { //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql);        		
        		rs = stmtPrep.executeQuery();   
				if(rs != null){ //jos kysely onnistui
					con.close();					
					while(rs.next()){
						User user = new User();
						user.setUsername(rs.getString(1));
						user.setPassword(rs.getString(2));
						users.add(user);
					}					
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
}