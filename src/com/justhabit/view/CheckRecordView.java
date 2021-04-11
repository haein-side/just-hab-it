package com.justhabit.view;

import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.justhabit.model.controller.HaeSeungController;
import com.justhabit.model.controller.PanelChangeControl;
import com.justhabit.model.dto.HaeseungRecordDTO;
import com.justhabit.model.dto.HaesungInfoDTO;

public class CheckRecordView extends JFrame{
	
	/**
	 * 체크박스 기록페이지
	 */
	
	private HaeSeungController habitInfoController = new HaeSeungController();
	private HaeseungRecordDTO checkRecord = new HaeseungRecordDTO(); //습관 기록전달DTO
	private HaesungInfoDTO registInfo = new HaesungInfoDTO(); //습관등록정보전달DTO
	private int checkCount = 0; // 체크박스카운트용
	private Date todayDate= new Date(); // 오늘 날짜
	private String today = ""; //날짜 문자열로 변환
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
		center.setBackground(new Color(246,245,245));
		
		//등록된 습관정보 불러오기
//		registInfo.setHabitID(MainPage.userhabitid);
		//TODO 삭제예정: 테스트용
		registInfo.setHabitID(1); 
		registInfo = habitInfoController.selectHabitInfo(registInfo);
		
		//습관상단바
		JPanel habitTop = new JPanel();
		habitTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		habitTop.setBounds(43, 20, 800, 50);
		
		//습관상단바 - 습관명
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0,0,200,50);
		namePanel.setBackground(new Color(211,224,234));
		JLabel nameLabel = new JLabel(registInfo.getHabitName());
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		

		//폰트설정
		nameLabel.setFont(new Font("D2Coding",Font.PLAIN,20));
		namePanel.add(nameLabel);
		
		habitTop.add(namePanel);
		
		//습관 상단바 - 횟수
		JPanel habitCheck =  new JPanel();
		habitCheck.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//횟수표시 및 증가버튼
		JLabel habitCount = new JLabel("      목표 : "+ registInfo.getHabitGoal() + "회 / 현재 : 0회      ");
		habitCount.setFont(new Font("D2Coding", Font.BOLD, 20));
		habitCheck.add(habitCount);
		JButton doIt = new JButton("실시");
		habitCheck.add(doIt);
		habitTop.add(habitCheck);
		doIt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkCount == registInfo.getHabitGoal()) {
					JOptionPane.showMessageDialog(mf, "최대치입니다.");
				} else {
					checkCount++;
					habitCount.setText("      목표 : "+ registInfo.getHabitGoal() + "회 / 현재 : "+checkCount + "회      ");
				}
			}
		});
//		habitCheck.setBounds(220,0,550,50);
		
//		JButton doButton = new JButton("1회실행");
//		doButton.setLocation(400,0);
//		habitCheck.add(doButton);
		
		
//		//체크박스 생성
//		JCheckBox[] buttons = new JCheckBox[registInfo.getHabitGoal()];
//		
//		for(int i = 0; i < buttons.length; i++) {
//			JCheckBox box = new JCheckBox((i+1)+"회");
//			box.setFont(new Font("D2Coding",Font.PLAIN,15));
//			buttons[i] = box;
//			habitCheck.add(buttons[i]);
//		}
//		
//		//체크 횟수 기록
//		for(int i = 0; i < buttons.length; i++ ) {
////			checkcount = new HashMap<>();
//			buttons[i].addItemListener(new ItemListener() {
//				@Override
//				public void itemStateChanged(ItemEvent e) {
//					checkCount = 0;
//					for(int i = 0; i < buttons.length; i++) {
//						if(buttons[i].isSelected()) {
////							checkcount.put(i,buttons[i].getText());
//							checkCount++;
//						}
//					}
//				}
//			});
//		}
		
		

		//습관기록저장
		JButton recordButton = new JButton("저장");

		recordButton.setBounds(823,128, 60, 30);

		recordButton.addActionListener(/**
		 * @author user
		 * 저장버튼 클릭 시 일치하는 날짜 검색->update 없으면 insert;
		 */
		new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat todayDateFormat = new SimpleDateFormat("yy/MM/dd");
				
				if(checkCount == 0) {
					JOptionPane.showMessageDialog(mf, "등록할 기록 없음");
				} else {
					today = todayDateFormat.format(todayDate);
					Date test = new Date(2021,3,8);
					String testDate = todayDateFormat.format(test);
					checkRecord.setUserId(registInfo.getUserID());
					checkRecord.setHabitId(registInfo.getHabitID());
					//테스트용
					checkRecord.setDoDate(today);
//				checkRecord.setDoDate(testDate);
					checkRecord.setCheck(checkCount);
					int result = habitInfoController.dateSelectController(checkRecord);
					if(result==0){
						habitInfoController.insertCheckController(checkRecord);
						JOptionPane.showMessageDialog(mf, "기록등록 성공");
					} else {
						habitInfoController.updateCheckController(checkRecord);
						JOptionPane.showMessageDialog(mf, "기록 갱신 성공");
					}
				}
			}
		});
		
		
		habitTop.add(recordButton);
		
		
		
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
			menuButton[i].setBackground(new Color(211,224,234));
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
