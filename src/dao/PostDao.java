package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ConnectionProvider;
import bean.Post;

public class PostDao {

	public static List<Post> getAllPosts() {
		List<Post> list = new ArrayList<Post>();  
	
		Connection con = ConnectionProvider.getCon();
		
	    try {
	    	
	    	PreparedStatement ps = con.prepareStatement("select id, topic, content, time from post");  
	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {  
	            Post p = new Post(); 
	            p.setId(rs.getInt(1));
	            p.setTopic(rs.getString(2));
	            p.setContent(rs.getString(3));
	            p.setTimestamp(rs.getTimestamp(4));
	            list.add(p);  
	        } 
	        
	    } catch(Exception e) {
	    	System.out.println(e);
	    }

	    return list;  
	}
}