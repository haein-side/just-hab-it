package com.justhabit.view;

import javax.swing.JFrame;

public class LevelInfoPage extends JFrame {

	public JFrame level = null;
	public JFrame my = this;
	
	
	public LevelInfoPage(MyPage myPage) {
		this.level = this;
		my = myPage;
		
		this.setLayout(null);
		this.setSize(600,500);
		this.setVisible(true);
		
		//로케이션 잡기. 사진 올리기. 유저정보 가져오기 마이페이지에 만들어놓은거 가져오기
		
	}
	
	
}
