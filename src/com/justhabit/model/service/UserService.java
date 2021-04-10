package com.justhabit.model.service;

import static com.justhabit.common.JDBC_EC2.getConnection;

import java.sql.Connection;

import com.justhabit.model.dao.UserDAO;

public class UserService {
	
	private UserDAO userDAO = new UserDAO();

	public boolean login(String loginId, String loginPwd) {

		Connection con = getConnection();
		
		boolean IsloggedIn = userDAO.selectUser(con, loginId, loginPwd );
		
		return IsloggedIn;
	}

}
