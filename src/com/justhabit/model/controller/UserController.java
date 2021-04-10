package com.justhabit.model.controller;

import com.justhabit.model.service.UserService;

public class UserController {

	private UserService userService = new UserService();
	
	public boolean loginCheck(String loginId, String loginPwd) {
		
		/* 유저가 입력한 로그인 아이디/패스워드 유효성 체크 */
		
		// 1. 입력한 정보가 공백으로 이루어진 경우 로그인 실패 
		if(loginId.trim().equals("") || loginPwd.trim().equals("")) {
			return false;
		} 
		
		
		
		
		return userService.login(loginId, loginPwd);
	}

}
