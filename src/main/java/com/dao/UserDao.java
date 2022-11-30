package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dao.bean.User;



public class UserDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/SignUp","root","D.jane0463");
		}catch (Exception ex) {
			
			System.out.println(ex);
		}
		return con;	
	}
	
	public static int save(User u) {
		
		int status=0;
		
		try {
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into user (first_name,last_name,username,password) values (?,?,?,?)");
			pst.setString(1,u.getFirst_name());
			pst.setString(2,u.getLast_name());
			pst.setString(3,u.getUsername());
			pst.setString(4,u.getPassword());
			
			
			status=pst.executeUpdate();
			
		}catch (Exception ex) {
			
			System.out.println(ex);
		}return status;
		
	}
	
	public static int update (User u) {
		
		int status=0;
		
		try {
			
			Connection con=getConnection();
			PreparedStatement pst = con.prepareStatement("update user set first_name=?, last_anme=?, username=?, password=?, country=? where id=?");
			pst.setString(1,u.getFirst_name());
			pst.setString(2,u.getLast_name());
			pst.setString(3,u.getUsername());
			pst.setString(4,u.getPassword());			
			pst.setInt(5,u.getId());
			
			status=pst.executeUpdate();
			
		}catch (Exception ex) {
			
			System.out.println(ex);
		}return status;
		
	}
	
	public static int delete (User u) {
		int status= 0;
		try {
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("delete from user where id=?");
			pst.setInt(1, u.getId());
			status=pst.executeUpdate();
		}catch (Exception ex) {	
			System.out.println(ex);
		}return status;
	}
	
	public static List<User>getAllRecord(){
		
		List<User>list = new ArrayList<User>();
		
		try {
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from user");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setFirst_name(rs.getString("First_name"));
				u.setLast_name(rs.getString("Last_name"));
				u.setUsername(rs.getString("Username"));
				u.setPassword(rs.getString("Password"));
				
				list.add(u);
			}
			
		}catch (Exception ex) {	
			System.out.println(ex);
		}return list;
	}
	public static User getRecordbyId (int id) {
		User u = null;
		
		try {
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from user where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			u = new User(); 
			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setFirst_name(rs.getString("First_name"));
				u.setLast_name(rs.getString("Last_name"));
				u.setUsername(rs.getString("Username"));
				u.setPassword(rs.getString("Password"));
			}
			
			
		}catch (Exception ex) {	
			System.out.println(ex);
		}return u;
		
		
	}

	public static Boolean checkUser (User u) {
		
		Boolean status = false;
		
		String userName = u.getUsername(); //Assign user entered values to temporary variables.
	    String password = u.getPassword();
	  
		
		
		try {
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select username,password from user");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				if(userName.equals(rs.getString("Username"))&& password.equals(rs.getString("Password"))) {
					if(password.equals(rs.getString("Password"))) {
						status = true;
					}
				}
			}
			
			
			
			
		}catch (Exception ex) {	
			System.out.println(ex);
		}return status;
		
		
	}
	
	
}
