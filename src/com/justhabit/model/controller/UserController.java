package com.justhabit.model.controller;

import com.justhabit.model.dto.UserDTO;
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

	public String signupCheck(String signup_name, String pwd1, String pwd2,
			String email, String pin) {

		/* 유저가 입력한 회원가입용 데이터 유효성 체크 */
		
		//1. 모든 입력값 공백으로 이루어졌는지 확인
		if(signup_name.trim().equals("") || pwd1.trim().equals("") ||
				pwd2.trim().equals("") || email.trim().equals("")||
				pin.trim().equals(""))
			return "모든 필요한 정보가 채워지지 않았습니다";
		
		//2. 입력한 두번의 패스워드가 일치하는지 확인.
		if(!pwd1.equals(pwd2))
			return "입력하신 두 패스워드가 일치하지 않습니다";
		
		//3. 입력한 아이디가 이미 존재하는지 확인
		if(!userService.userIdCheck(signup_name)) 
			return "이미 존재하는 유저입니다";
		
		/* UserDTO를 생성하여 service호출 */
		UserDTO registerUser = new UserDTO();
		registerUser.setUserName(signup_name);
		registerUser.setUserPwd(pwd1);
		registerUser.setUserEmail(email);
		registerUser.setUserPin(Integer.parseInt(pin));
		
		
		/* 회원가입 */ 
		
		boolean isRegistered = userService.register(registerUser);
		
		
		return isRegistered == true ? "회원가입이 성공적으로 완료되었습니다 :)" : "에러발생";
		
	}

	public UserDTO userInfo(int loggedUserID) {
		
		/* 로그인 된 유저의 정보 가져오기 */
		return userService.userInfo(loggedUserID);
	}

	public boolean deleteUser(UserDTO myUser) {
		
		/* 시스템 계정 삭제를 못하게 막는다. */
		if(myUser.getUserId() < 10) {
			return false;
		}
		
		return userService.deleteUser(myUser.getUserId());
	}

	public String updateUser(UserDTO myUser) {

		String result = "";
		
		/* 유저가 입력한 값 유효성 검사 */
		
		// 1. 시스템 계정 수정을 못하게 막는다. 
		if(myUser.getUserId() < 10) {
			result = "시스템계정은 수정할 수 없습니다";
		}
		
		// 2. 입력값이 빈값인지 체크.
		else if(myUser.getUserName().trim().equals("") || myUser.getUserPwd().trim().equals("")
				|| myUser.getUserEmail().trim().equals("")) {
			result = "빈칸을 모두 채워주세요";
		}

		// 3. username 중복인지 확인 -> 위에 만든 userIdCheck() 사용
		else if(!userService.userIdCheck(myUser.getUserName())) {
			result = "입력한 아이디가 이미 존재하는 아이디입니다";
		}
		
		// 4. 회원정보 수정 
		else {
			result = userService.userUpdate(myUser);
		}
		
		
		
		
		
		
		
		return result;
	}

}
