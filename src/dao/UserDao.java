package dao;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;

import bean.ConnectionProvider;
import bean.User;  
public class UserDao {  
 
static Connection getConnection() {
	return ConnectionProvider.getCon();
} 
	
public static int save(User u){  
    int status = 0;  
    try{  
        Connection con = getConnection();  
        PreparedStatement ps  =  con.prepareStatement(  
        "insert into user(name,password,email,sex,country) values(?,?,?,?,?)");
        ps.setString(1,u.getUsername());
        ps.setString(2,u.getPassword());  
        status = ps.executeUpdate();  
    } catch(Exception e){System.out.println(e);}   
    return status;  
}   
public static int update(User u){  
    int status = 0;  
    try{  
        Connection con = getConnection();  
        PreparedStatement ps = con.prepareStatement(  
"update user set name = ?,password = ?,email = ?,sex = ?,country = ? where id = ?");  
        ps.setString(1,u.getUsername());
        ps.setString(2,u.getPassword());  
        ps.setInt(6,u.getId());  
        status = ps.executeUpdate();  
    } catch(Exception e){System.out.println(e);}   
    return status;  
}   
public static int delete(User u){  
    int status = 0;  
    try{  
        Connection con = getConnection();  
        PreparedStatement ps = con.prepareStatement("delete from user where id = ?");  
        ps.setInt(1,u.getId());  
        status = ps.executeUpdate();  
    } catch(Exception e){System.out.println(e);}   
  
    return status;  
}   
public static List<User> getAllRecords(){  
    List<User> list = new ArrayList<User>();  
      
    try{  
        Connection con = getConnection();  
        PreparedStatement ps = con.prepareStatement("select * from user");  
        ResultSet rs = ps.executeQuery();  
        while(rs.next()){  
            User u = new User();  
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getPassword());  
            list.add(u);  
        }   
    } catch(Exception e){System.out.println(e);}   
    return list;  
}   
public static User getRecordById(int id){  
    User u = null;  
    try{  
        Connection con = getConnection();  
        PreparedStatement ps = con.prepareStatement("select * from user where id = ?");  
        ps.setInt(1,id);  
        ResultSet rs = ps.executeQuery();  
        while(rs.next()){  
            u = new User();  
            u.setId(rs.getInt("id"));  
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getPassword());  
        }   
    } catch(Exception e){System.out.println(e);}   
    return u;  
}   
}   