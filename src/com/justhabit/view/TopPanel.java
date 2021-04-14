package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.justhabit.model.controller.UserController;
import com.justhabit.model.dto.UserLevelDTO;

public class TopPanel extends JPanel{
	
	private UserController userController = new UserController();
	
	public TopPanel() {
		//상단바
		this.setLocation(0, 0);
		this.setSize(900, 100);
		this.setLayout(null);
		this.setBackground(new Color(211,224,234));
		
		JLabel Title = new JLabel("JUST HAB' IT");
		Title.setFont(new Font("D2Coding", Font.BOLD,50));
		Title.setBounds(300,20,500,70);
		Title.setVisible(true);
		this.add(Title);
		
		
		UserLevelDTO user = null;
		user = userController.userLevel(FirstFrame.loggedUserID);
		

		String level_image = "";
		switch(user.getUserLevel()) {
			case 1 : level_image = "1렙계란.PNG"; break;
			case 2 : level_image = "2렙계란.PNG"; break;
			case 3 : level_image = "3렙계란.PNG"; break;
			case 4 : level_image = "4렙계란.PNG"; break;
			case 5 : level_image = "5렙계란.PNG"; break;
		}
		
		
		//좌측이미지
		Image leftImage = new ImageIcon("image/" + level_image).getImage().getScaledInstance(100, 70, 0);
		
		JLabel leftLabel = new JLabel(new ImageIcon(leftImage));
		

		leftLabel.setBounds(10, 0, 80, 80);

		this.add(leftLabel);
	
		//오늘날짜 출력
		Date today = new Date();
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		JLabel dayPrint = new JLabel(dayFormat.format(today));
		dayPrint.setBounds(680,0, 200, 50);
		dayPrint.setFont(new Font("D2Coding",Font.BOLD,15));
		dayPrint.setVisible(true);
		this.add(dayPrint);
	}
			
}
