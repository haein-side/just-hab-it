package com.justhabit.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.justhabit.model.controller.PanelChangeControl;

public class BotMenuPanel extends JPanel{
	public BotMenuPanel() {}
	
	public BotMenuPanel(JFrame mf) {
		
		String[] menu = {"Main", "습관등록", "습관삭제","mypage"};
//		JFrame[] page = {new MainPage(), new HabbitAdd(), new DeleteHabit(), new MyPage()}; 
		this.setLocation(0, 562);
		this.setSize(800, 100);
		this.setLayout(new GridLayout(1,4));
		this.add(new JButton(menu[0]));
		//버튼추가
//		JButton[] menuButton = new JButton[menu.length];
//		for(int i =0; i <menu.length; i++) {
//			
//			menuButton[i] = new JButton(menu[i]);
//			menuButton[i].setBackground(new Color(211,224,234));
//			this.add(menuButton[i]);
//			int pageNo = i;
//			if(mf == page[i]) {
//				menuButton[i].setEnabled(false);
//			} else {
//				menuButton[i].addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						PanelChangeControl.changeFrame(mf, page[pageNo]);
//					}
//				});
//			}
//		}
		this.setVisible(true);
		
//		menuButton[0].addActionListener(new ActionListener() {
//	          
//	          @Override
//	          public void actionPerformed(ActionEvent e) {
//	             PanelChangeControl.changeFrame(mf, new MainPage());
//	             if(mf==new MainPage()){
//	            	 menuButton[0].setEnabled(false);
//	             }
//	          }
//	       });
//		menuButton[1].addActionListener(new ActionListener() {
//	          
//	          @Override
//	          public void actionPerformed(ActionEvent e) {
//	             PanelChangeControl.changeFrame(mf, new HabbitAdd());
//	          }
//	       });
//		
//		menuButton[2].addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				PanelChangeControl.changeFrame(mf, new DeleteHabit());
//			}
//		});
//		
//		menuButton[3].addActionListener(new ActionListener() {
//	          
//	          @Override
//	          public void actionPerformed(ActionEvent e) {
//	             PanelChangeControl.changeFrame(mf, new MyPage());
//	          }
//	       });
		
	}
}