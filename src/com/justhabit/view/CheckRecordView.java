package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.justhabit.model.controller.HaeSeungController;
import com.justhabit.model.controller.PanelChangeControl;
import com.justhabit.model.dto.HaeseungRecordDTO;
import com.justhabit.model.dto.HaesungInfoDTO;

public class CheckRecordView extends JFrame{
	
	
	private HaeSeungController habitInfoController = new HaeSeungController();
//	Map<Integer,String> checkcount = null;//체크박스 카운트용
	
	int checkCount = 0; // 체크박스카운트용
	int i = 0;
	Date todayDate= new Date(); // 오늘 날짜
	String today = ""; //날짜 문자열로 변환
	HaeseungRecordDTO checkRecord = new HaeseungRecordDTO();
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
		
		//등록된 습관정보 불러오기
		int HabbitID = 1;
		HaesungInfoDTO habitInfo = habitInfoController.selectHabitInfo(HabbitID);
		
		//습관상단바
		JPanel habitTop = new JPanel();
		habitTop.setLayout(null);
		habitTop.setBounds(43, 20, 780, 50);
		
		//습관상단바 - 습관명
		JPanel namePanel = new JPanel();
		namePanel.setBounds(10,0,200,50);
		namePanel.setBackground(new Color(51,153,51));
		String habitName = habitInfo.getHabitName();
		JLabel nameLabel = new JLabel(habitName);

		//폰트설정
		nameLabel.setFont(new Font("D2Coding",Font.PLAIN,20));
		namePanel.add(nameLabel);
		
		habitTop.add(namePanel);
		
		//습관 상단바 - 체크박스
		JPanel habitCheck =  new JPanel();
		habitCheck.setLayout(new GridLayout());
		habitCheck.setBounds(220,0,550,50);
		
		//체크박스 생성
		JCheckBox[] buttons = new JCheckBox[habitInfo.getHabitGoal()];
		
		for(int i = 0; i < buttons.length; i++) {
			JCheckBox box = new JCheckBox((i+1)+"회");
			box.setFont(new Font("D2Coding",Font.PLAIN,15));
			buttons[i] = box;
			habitCheck.add(buttons[i]);
		}
		
		
		

		//체크 횟수 기록
		for(int i = 0; i < buttons.length; i++ ) {
//			checkcount = new HashMap<>();
			buttons[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					checkCount = 0;
					for(int i = 0; i < buttons.length; i++) {
						if(buttons[i].isSelected()) {
//							checkcount.put(i,buttons[i].getText());
							checkCount++;
						}
					}
				}
			});
		}
		
		


		//저장버튼 클릭 시 일치하는 날짜 검색-> 있으면 update 없으면 insert;
		JButton recordButton = new JButton("저장");

		recordButton.setBounds(823,128, 60, 30);
		
		SimpleDateFormat todayDateFormat = new SimpleDateFormat("yy/MM/dd");
		today = todayDateFormat.format(todayDate);
		checkRecord.setUserId(habitInfo.getUserID());
		checkRecord.setHabitId(habitInfo.getHabitID());
		checkRecord.setDoDate(todayDateFormat.format(todayDate));
		recordButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkRecord.setCheck(checkCount);
				if(today.equals(habitInfoController.dateSelectController(checkRecord.getHabitId()))){
					habitInfoController.updateTimerController(checkRecord);
				} else {
					System.out.println(habitInfoController.dateSelectController(checkRecord.getHabitId()));
					habitInfoController.insertTimerController(checkRecord);
				}
			}
		});
		
		
		this.add(recordButton);
		
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
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		
		String day = dateFormat.format(todayDate);
		//달력표시
		JPanel calendar = new JPanel();
		calendar.setBounds(0, 80, 350, 250);
		calendar.setBackground(new Color(255,204,153));
		GridLayout gridLayout = new GridLayout(calArr.size()/7+1,7,5,5);
		calendar.setLayout(gridLayout);
		
		JButton[] dayButton = new JButton[calArr.size()]; 
		for(int i = 0; i < calArr.size();i++) {
			
			if(i<9) {
				
				dayButton[i] = new JButton("0"+calArr.get(i));			
				dayButton[i].setHorizontalAlignment(JLabel.CENTER);
				dayButton[i].setVerticalAlignment(JLabel.CENTER);
				dayButton[i].setBackground(Color.white);
				calendar.add(dayButton[i]);
			} else {
				
				dayButton[i] = new JButton(calArr.get(i)+"");			
				dayButton[i].setHorizontalAlignment(JLabel.CENTER);
				dayButton[i].setVerticalAlignment(JLabel.CENTER);
				dayButton[i].setBackground(Color.white);
				calendar.add(dayButton[i]);
			}
			
			if(dayButton[i].getText().equals(today)) {
				dayButton[i].setBackground(Color.yellow);
			} else {
				dayButton[i].setBackground(Color.green);
			}
			
			
		}
		calendarPanel.add(calendar);
		
		//문구 표시
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBounds(420, 95, 420, 340);
		JTextArea infoText = new JTextArea();
		infoText.setBounds(10,10,400,320);
		infoText.setFont(new Font("D2Coding",Font.PLAIN,20));
		infoText.setText("여기에 \n \n어떻게 \n \n넣을것인가..");
		infoPanel.add(infoText);
		
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
		
		
		
		
		
		center.add(infoPanel);
		center.add(calendarPanel);
		center.add(habitTop);
		this.add(center);
	}
}
