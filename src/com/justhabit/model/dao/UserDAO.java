package com.justhabit.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

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
			
			if(rset.next())
				result = rset.getInt(1);
				FirstFrame.loggedUserID = result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
		
		return result == 0 ? false: true;
	}

	

	
}
