package com.justhabit.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainPage extends JPanel{
 private JPanel mainPage;
 
	public MainPage() {
		
		
		this.setLayout(null);
		this.setBounds(0, 100, 900, 462);
		this.setBackground(Color.lightGray);
		this.setVisible(true);
		
		JButton first = new JButton("습관 1");
		first.setSize(100,80);
		first.setLocation(150, 300);
		this.add(first);
		
		JButton second = new JButton("습관 2");
		second.setSize(100,80);
		second.setLocation(400, 300);
		this.add(second);
		
		JButton third = new JButton("습관 3");
		third.setSize(100,80);
		third.setLocation(650, 300);
		this.add(third);
		
		JLabel promise = new JLabel("오늘의 각오를 입력해주세요!");
//		promise.setFont(new Font("Serif", Font.BOLD, 30));
	    promise.setSize(promise.getPreferredSize());
	    promise.setLocation(370, 200);
	    this.add(promise);
		
		
		JTextArea chat = new JTextArea();
		chat.setSize(400, 200);
		chat.setLocation(250, 30);
		chat.setEditable(true);
		this.add(chat);
		this.validate();
		
		

		
		
	}
		
	}
	