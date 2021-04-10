package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.justhabit.model.controller.PanelChangeControl;
import com.justhabit.model.controller.UserController;
import com.justhabit.model.dto.UserDTO;

public class MyPage extends JFrame {
	
	private MyPage myPage;
	private UserController userController = new UserController();
	
	
	public MyPage() {
		
		this.myPage = this;
		
		myPage.setLayout(null);
		myPage.setSize(900, 700);
		myPage.setBackground(Color.lightGray);
		myPage.setLocationRelativeTo(null);
		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel top = new TopPanel();
		myPage.add(top);
		
		
		
		//가운데 화면
		JPanel userPanel = new JPanel();
		userPanel.setLayout(null);
		userPanel.setBounds(0,80,900,480);
		userPanel.setBackground(Color.white);
		this.add(userPanel);
		
		
		JLabel label_username  = new JLabel("Username : ");
		JLabel label_email  = new JLabel("Email : ");
		JLabel label_password = new JLabel("Password : ");
		JLabel label_pin = new JLabel("PIN : ");
//		JLabel levelExp = new JLabel("레벨 : ");
		label_username.setFont(new Font("a디딤돌",Font.BOLD,20));
		label_email.setFont(new Font("a디딤돌",Font.BOLD,20));
		label_password.setFont(new Font("a디딤돌",Font.BOLD,20));
		label_pin.setFont(new Font("a디딤돌",Font.BOLD,20));
//	    levelExp.setFont(new Font("a디딤돌",Font.BOLD,20));
	    
	    
	    label_username.setBounds(500, 110, 150, 150);
	    label_email.setBounds(500, 150, 150, 150);
	    label_password.setBounds(500, 190, 150, 150);
	    label_pin.setBounds(500, 230, 150, 150);
//		levelExp.setBounds(130, 290, 150, 150);
		
		userPanel.add(label_username);
		userPanel.add(label_email);
		userPanel.add(label_password);
		userPanel.add(label_pin);
//		userPanel.add(levelExp);
		
		
		UserDTO myUser = userController.userInfo(FirstFrame.loggedUserID);
		String pwd = "";
		for(int i = 0; i < myUser.getUserPwd().length(); i++) {
			if(i == 0)
				pwd += myUser.getUserPwd().charAt(0);
			else
				pwd += "*";
		}
		
		String pin = ""; 
		for(int i = 0; i < 4; i++ ) {
			if(i == 0)
				pin += Integer.toString(myUser.getUserPin()).charAt(0);
			else
				pin += '*';
		}
			
		
		
		JLabel myUser_name  = new JLabel(myUser.getUserName());
		JLabel myUser_email = new JLabel(myUser.getUserEmail());
		JLabel myUser_pwd  = new JLabel(pwd);
		JLabel myUser_pin = new JLabel(pin);
		myUser_name.setFont(new Font("a디딤돌",Font.BOLD,20));
		myUser_email.setFont(new Font("a디딤돌",Font.BOLD,20));
		myUser_pwd.setFont(new Font("a디딤돌",Font.BOLD,20));
		myUser_pin.setFont(new Font("a디딤돌",Font.BOLD,20));
		
		
		myUser_name.setBounds(550, 110, 150, 150);
		myUser_email.setBounds(550, 150, 150, 150);
		myUser_pwd.setBounds(550, 190, 150, 150);
		myUser_pin.setBounds(550, 230, 150, 150);
		
		userPanel.add(myUser_name);
		userPanel.add(myUser_email);
		userPanel.add(label_password);
		userPanel.add(myUser_pin);
		
		
		
		
		
		
		JButton revise = new JButton("회원정보 수정하기");
		revise.setSize(180,40);
		revise.setLocation(365, 390);
		userPanel.add(revise);
		
		revise.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PanelChangeControl.changeFrame(myPage , new ReviseInfo());
            }
         });
		
		
		JButton exit = new JButton("탈퇴하기");
		exit.setSize(130,40);
		exit.setLocation(670, 60);
		userPanel.add(exit);
		
		
		
		Image level = new ImageIcon("image/turtle1.jpeg").getImage().getScaledInstance(250, 250, 0);
		
		JLabel levelImg = new JLabel(new ImageIcon(level));
		levelImg.setBounds(80,60,300,300);
		userPanel.add(levelImg);
		
		//메뉴패널추가
		JPanel botPan = new JPanel();
		botPan.setLayout(new GridLayout(1,6));
		botPan.setSize(900, 100);
		botPan.setLocation(0, 562);
		botPan.setBackground(Color.GREEN);
		this.add(botPan);
		//메뉴목록
		String[] menu = {"Main", "습관등록", "mypage", "횟수보기","타이머보기"};
		
		//버튼추가
		JButton[] menuButton = new JButton[menu.length];
		for(int i =0; i <menu.length; i++) {
			
			menuButton[i] = new JButton(menu[i]);
			menuButton[i].setBackground(Color.pink);
			botPan.add(menuButton[i]);
		}
		menuButton[0].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(myPage, new MainPage());
	          }
	       });
		menuButton[1].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(myPage, new HabbitAdd());
	          }
	       });
		
		menuButton[2].setEnabled(false);
		
		menuButton[3].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(myPage, new CheckRecordView());
	          }
	       });
		
		menuButton[4].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(myPage, new TimeRecordView());
	          }
	       });
		
		
		
		
		
		
		
	}
	
	
}