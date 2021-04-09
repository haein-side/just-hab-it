package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.justhabit.model.controller.PanelChangeControl;

public class MyPage extends JPanel {
	
	private MyPage myPage;
	
	public MyPage() {
		
		this.myPage = this;
		
		myPage.setLayout(null);
		myPage.setBounds(0, 100, 900, 462);
		myPage.setBackground(Color.lightGray);
		myPage.setVisible(true);
		
		JLabel id  = new JLabel("ID : ");
		JLabel userName  = new JLabel("닉네임 : ");
		JLabel email = new JLabel("이메일 : ");
		JLabel levelExp = new JLabel("레벨 : ");
	    id.setFont(new Font("a디딤돌",Font.BOLD,20));
	    userName.setFont(new Font("a디딤돌",Font.BOLD,20));
	    email.setFont(new Font("a디딤돌",Font.BOLD,20));
	    levelExp.setFont(new Font("a디딤돌",Font.BOLD,20));
	    
	    
		id.setBounds(500, 110, 150, 150);
		userName.setBounds(500, 150, 150, 150);
		email.setBounds(500, 190, 150, 150);
		levelExp.setBounds(130, 290, 150, 150);
		
		myPage.add(id);
		myPage.add(userName);
		myPage.add(email);
		myPage.add(levelExp);
			
		
		JButton revise = new JButton("회원정보 수정하기");
		revise.setSize(180,40);
		revise.setLocation(365, 390);
		myPage.add(revise);
		
		revise.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PanelChangeControl.changePanel(myPage , new ReviseInfo());
            }
         });
		
		
		JButton exit = new JButton("탈퇴하기");
		exit.setSize(130,40);
		exit.setLocation(670, 60);
		myPage.add(exit);
		
		
		
		Image level = new ImageIcon("image/turtle1.jpeg").getImage().getScaledInstance(250, 250, 0);
		
		JLabel levelImg = new JLabel(new ImageIcon(level));
		levelImg.setBounds(80,60,300,300);
		myPage.add(levelImg);
		
		
		
		
		
	}
	
	
}