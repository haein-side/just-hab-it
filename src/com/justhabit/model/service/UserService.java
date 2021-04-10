package com.justhabit.model.service;

import static com.justhabit.common.JDBC_EC2.getConnection;
import static com.justhabit.common.JDBC_EC2.close;


import java.sql.Connection;

import com.justhabit.model.dao.UserDAO;
import com.justhabit.model.dto.UserDTO;

public class UserService {
	
	private UserDAO userDAO = new UserDAO();

	public boolean login(String loginId, String loginPwd) {

		Connection con = getConnection();
		
		boolean IsloggedIn = userDAO.selectUser(con, loginId, loginPwd );
		
		close(con);
		
		return IsloggedIn;
	}

	public boolean userIdCheck(String signup_name) {

		Connection con = getConnection();
		
		boolean isAvailableID = userDAO.checkID(con, signup_name);
		
		close(con);
		
		return isAvailableID;
		
		
	}

	public boolean register(UserDTO registerUser) {
		
		Connection con = getConnection();
		
		boolean isRegistered = userDAO.registerUser(con, registerUser);
		
		close(con);
		
		return isRegistered;
	}

}
