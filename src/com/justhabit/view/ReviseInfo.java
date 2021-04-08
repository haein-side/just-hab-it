package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReviseInfo extends JPanel {
	
	private ReviseInfo reviseInfo;
	
	public ReviseInfo() {
		
		this.reviseInfo = this;
		
		this.setLayout(null);
		this.setBounds(0, 100, 900, 462);
		this.setBackground(Color.lightGray);
		this.setVisible(true);
		
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
		
		this.add(id);
		this.add(userName);
		this.add(email);
		this.add(levelExp);
		
		JTextField idBox = new JTextField(17);
		JTextField usernameBox = new JTextField(17);
		JTextField emailBox = new JTextField(17);
		idBox.setBounds(580, 170, 220, 30);
		usernameBox.setBounds(580, 210, 220, 30);
		emailBox.setBounds(580, 250, 220, 30);
		this.add(usernameBox);
		this.add(emailBox);
		this.add(idBox);
		
		
		JButton exit = new JButton("회원정보 수정 완료");
		exit.setSize(180,40);
		exit.setLocation(365, 390);
		this.add(exit);
		
//		JButton revise = new JButton("회원정보수정");
//		revise.setSize(130,40);
//		revise.setLocation(670, 60);
//		this.add(revise);
		
		
		Image level = new ImageIcon("image/turtle1.jpeg").getImage().getScaledInstance(250, 250, 0);
		
		JLabel levelImg = new JLabel(new ImageIcon(level));
		levelImg.setBounds(80,60,300,300);
		this.add(levelImg);
		
		
		
		
		
	}
	
	
}