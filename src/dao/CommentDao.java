package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Comment;
import bean.ConnectionProvider;

public class CommentDao {

	public static List<Comment> getAllComments(int postId) {
		List<Comment> list = new ArrayList<Comment>();  
	
		Connection con = ConnectionProvider.getCon();
		
	    try {
	    	
	    	PreparedStatement ps = con.prepareStatement("select content, postid, id from comment where postid = " + postId);
	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {  
	        	Comment c = new Comment();
	            c.setContent(rs.getString(1));
	            c.setPostId(rs.getInt(2));
	            c.setId(rs.getInt(3));
	            list.add(c);  
	        } 
	        
	    } catch(Exception e) {
	    	System.out.println(e);
	    }

	    return list;  
	}
	
}
