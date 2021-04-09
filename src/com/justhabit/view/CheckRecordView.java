package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.justhabit.model.controller.PanelChangeControl;

public class CheckRecordView extends JFrame{
	

	int count = 0; //체크박스 카운트용
	int i = 0;
	Map<Integer,String> checkcount = null;
	/**
	 * 체크박스 기록페이지
	 */
	JFrame mf = this;
	public CheckRecordView() {
		
		this.setLayout(null);
		
		
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(new TopPanel());
		JPanel center = new JPanel();
		center.setBounds(0, 100, 900, 462);
		center.setLayout(null);
		center.setBackground(Color.white);
		
		//습관상단바
		JPanel habitTop = new JPanel();
		habitTop.setLayout(null);
		habitTop.setBounds(43, 20, 800, 50);
		
		//습관상단바 - 습관명
		JPanel habitName = new JPanel();
		habitName.setBounds(10,0,200,50);
		habitName.setBackground(new Color(51,153,51));
		JLabel nameLabel = new JLabel("물마시기");

		//폰트설정
		nameLabel.setFont(new Font("D2Coding",Font.BOLD,30));
		habitName.add(nameLabel);
		
		habitTop.add(habitName);
		
		//습관 상단바 - 체크박스
		JPanel habitCheck =  new JPanel();
		habitCheck.setLayout(new GridLayout());
		habitCheck.setBounds(220,0,570,50);
		
		//체크박스 생성
		JCheckBox[] buttons = new JCheckBox[5];
		
		for(int i = 0; i < buttons.length; i++) {
			JCheckBox box = new JCheckBox((i+1)+"회");
			box.setFont(new Font("D2Coding",Font.PLAIN,15));
			buttons[i] = box;
			habitCheck.add(buttons[i]);
		}
		
		
		
		for(int i = 0; i < buttons.length; i++ ) {
			checkcount = new HashMap<>();
			buttons[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					
					for(int i = 0; i < buttons.length; i++) {
						if(buttons[i].isSelected()) {
							checkcount.put(i,buttons[i].getText());
							System.out.println(checkcount);
							System.out.println(checkcount.size());
						} else {
							checkcount.remove(i);
							System.out.println(checkcount);
							System.out.println(checkcount.size());
						}
					}
				}
			});
		}

		habitTop.add(habitCheck);
		
		//달력
		JPanel calendarPanel = new JPanel();
		calendarPanel.setBounds(43, 95, 350, 340);
		calendarPanel.setLayout(null);
		calendarPanel.setBackground(new Color(255,204,153));
		
		//달력 날짜 입력
		ArrayList<Integer>calArr = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		for(int i = 0; i <lastDay; i++) {
			calArr.add(i+1);
		}
		
		//월표시
		JPanel monthPrint = new JPanel();
		monthPrint.setBounds(80,15,200,50);
		monthPrint.setBackground(new Color(255,204,153));
		
		JLabel monthName = new JLabel(month+1+"월");
		monthName.setFont(new Font("D2Coding",Font.BOLD,20));
		
		monthPrint.add(monthName);
		calendarPanel.add(monthPrint);
		
		Date todayDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		
		String today = dateFormat.format(todayDate);
		//달력표시
		JPanel calendar = new JPanel();
		calendar.setBounds(0, 80, 350, 250);
		calendar.setBackground(new Color(255,204,153));
		GridLayout gridLayout = new GridLayout(calArr.size()/7+1,7,5,5);
		calendar.setLayout(gridLayout);
		
		JButton[] day = new JButton[calArr.size()]; 
		for(int i = 0; i < calArr.size();i++) {
			
			if(i<9) {
				
				day[i] = new JButton("0"+calArr.get(i));			
				day[i].setHorizontalAlignment(JLabel.CENTER);
				day[i].setVerticalAlignment(JLabel.CENTER);
				day[i].setBackground(Color.white);
				calendar.add(day[i]);
			} else {
				
				day[i] = new JButton(calArr.get(i)+"");			
				day[i].setHorizontalAlignment(JLabel.CENTER);
				day[i].setVerticalAlignment(JLabel.CENTER);
				day[i].setBackground(Color.white);
				calendar.add(day[i]);
			}
			
			if(day[i].getText().equals(today)) {
				day[i].setBackground(Color.yellow);
			} else {
				day[i].setBackground(Color.green);
			}
			
			
		}
		calendarPanel.add(calendar);
		
		//문구 표시
		JPanel habitInfo = new JPanel();
		habitInfo.setLayout(null);
		habitInfo.setBounds(420, 95, 420, 340);
		JTextArea info = new JTextArea();
		info.setBounds(10,10,400,320);
		info.setFont(new Font("D2Coding",Font.PLAIN,20));
		info.setText("여기에 \n \n어떻게 \n \n넣을것인가..");
		habitInfo.add(info);
		
		//하단패널
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
		//메뉴버튼추가
		
		menuButton[0].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(mf, new MainPage());
	          }
	       });
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
		
		menuButton[3].setEnabled(false);
		
		menuButton[4].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(mf, new TimeRecordView());
	          }
	       });
		
		
		
		
		
		center.add(habitInfo);
		center.add(calendarPanel);
		center.add(habitTop);
		this.add(center);
	}
}
