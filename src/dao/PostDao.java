package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bean.ConnectionProvider;
import bean.Post;

public class PostDao {

	public static Connection getCon() {
		return ConnectionProvider.getCon();
	}
	
	public static boolean save(Post p) {
		boolean status = false;
		
		try {
			Connection con = ConnectionProvider.getCon();
			PreparedStatement ps = con.prepareStatement(
					"insert into post(topic,content, date, image) values(?,?,?)"
					);
			ps.setString(1, p.getTopic());
			ps.setString(2, p.getContent());
			ps.setDate(3, new java.sql.Date(Calendar.getInstance().getTime().getTime())); 
			ps.setBlob(4, (Blob) p.getFile());
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return status;
	}
	
	public static List<Post> getAllPosts() {
		List<Post> list = new ArrayList<Post>();  
	
		Connection con = getCon();
		
	    try {
	    	if (con == null) {
	    		con = ConnectionProvider.getCon();
	    	}
	    	
	    	PreparedStatement ps = con.prepareStatement("select topic, content from post");  
	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {  
	            Post p = new Post(); 
	            p.setTopic(rs.getString(1));
	            p.setContent(rs.getString(2));
	            list.add(p);  
	        } 
	        
	    } catch(Exception e) {
	    	System.out.println(e);
	    }

	    return list;  
	}
}