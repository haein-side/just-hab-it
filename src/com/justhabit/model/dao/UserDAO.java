package com.justhabit.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.justhabit.model.dto.UserDTO;
import com.justhabit.view.FirstFrame;

import static com.justhabit.common.JDBC_EC2.close;

public class UserDAO {

private Properties prop = new Properties();
	
	public UserDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean selectUser(Connection con, String loginId, String loginPwd) {

		PreparedStatement psmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("login");
		
		int result = 0;
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, loginId);
			psmt.setString(2, loginPwd);
			
			rset = psmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
				FirstFrame.loggedUserID = result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
		
		return result == 0 ? false: true;
	}

	public boolean checkID(Connection con, String signup_name) {

		PreparedStatement psmt = null;
		ResultSet rset = null;
		
		boolean available = true;
		
		String query = prop.getProperty("checkUsername");
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, signup_name);
			
			rset = psmt.executeQuery();
			
			if(rset.next())
				available = false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
		
		return available;
	}

	public boolean registerUser(Connection con, UserDTO registerUser) {

		PreparedStatement psmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("registerUser");
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, registerUser.getUserName());
			psmt.setString(2, registerUser.getUserPwd());
			psmt.setString(3, registerUser.getUserEmail());
			psmt.setInt(4, registerUser.getUserPin());
			
			result = psmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(psmt);
		}
		
		
		return result == 0 ? false : true;
	}

	public UserDTO myUser(Connection con, int loggedUserID) {

		PreparedStatement psmt = null;
		ResultSet rset = null;
		UserDTO user = null;
		
		String query = prop.getProperty("myUser");
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, loggedUserID);
			
			
			rset = psmt.executeQuery();
			if(rset.next()) {
				user = new UserDTO();
				user.setUserId(loggedUserID);
				user.setUserName(rset.getString("user_name"));
				user.setUserPwd(rset.getString("user_pwd"));
				user.setUserEmail(rset.getString("user_email"));
				user.setUserPin(rset.getInt("user_pin"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
		
		return user;
	}

	public boolean deleteUser(Connection con, int userId) {

		PreparedStatement psmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("deleteUser");
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, userId);
			
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(psmt);
		}
		
		return result == 0? false : true;
	}

	

	
}
