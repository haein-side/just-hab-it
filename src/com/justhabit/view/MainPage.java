package com.justhabit.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.justhabit.model.controller.HaeinController;
import com.justhabit.model.controller.PanelChangeControl;

public class MainPage extends JFrame{
	
	private HaeinController habitDayController = new HaeinController();
	
 
	JFrame mf = this;
	public MainPage() {
		
		this.setLayout(null);
		this.setSize(900, 700);
		
		this.add(new TopPanel());
		
		//가운데 패널
		JPanel center = new JPanel();
		center.setBounds(0, 100, 900, 462);
		center.setLayout(null);
		center.setBackground(new Color(246,245,245));
		
		
		//습관 버튼
		JButton first = new JButton("습관 1");
		first.setSize(100,80);
		first.setLocation(150, 300);
		
		center.add(first);
		
		JButton second = new JButton("습관 2");
		second.setSize(100,80);
		second.setLocation(400, 300);
		center.add(second);
		
		JButton third = new JButton("습관 3");
		third.setSize(100,80);
		third.setLocation(650, 300);
		center.add(third);
		
		
		//오늘의 각오
		JLabel promise = new JLabel("오늘의 각오를 입력해주세요!");
//		promise.setFont(new Font("Serif", Font.BOLD, 30));
	    promise.setSize(promise.getPreferredSize());
	    promise.setLocation(370, 200);
	    center.add(promise);
		
		
		JTextArea chat = new JTextArea();
		chat.setSize(400, 200);
		chat.setLocation(250, 30);
		chat.setEditable(true);
		center.add(chat);
		center.validate();
		
		JPanel botPan = new JPanel();
		botPan.setLayout(new GridLayout(1,6));
		botPan.setSize(900, 100);
		botPan.setLocation(0, 562);
		botPan.setBackground(Color.GREEN);
		
		//메뉴목록
		String[] menu = {"Main", "습관등록", "mypage", "횟수보기","타이머보기"};
		
		//버튼추가
		JButton[] menuButton = new JButton[menu.length];
		for(int i =0; i <menu.length; i++) {
			
			menuButton[i] = new JButton(menu[i]);
			menuButton[i].setBackground(new Color(211,224,234));
			botPan.add(menuButton[i]);
		}
		menuButton[0].setEnabled(false);
		menuButton[1].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(mf, new HabbitAdd());
	          }
	       });
		
		menuButton[2].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(mf, new MyPage());
	          }
	       });
		
		menuButton[3].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(mf, new CheckRecordView());
	          }
	       });
		
		menuButton[4].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(mf, new TimeRecordView());
	          }
	       });
		
		
		
		
		
		
		this.add(botPan);
		
		
		this.add(center);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null); // 화면 가운데로
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
	}
		
	}
	