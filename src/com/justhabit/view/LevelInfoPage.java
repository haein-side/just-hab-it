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
		
	}
	
	
}
