package com.justhabit.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.justhabit.model.controller.HaeSeungController;
import com.justhabit.model.controller.PanelChangeControl;
import com.justhabit.model.dto.HaeseungMonthTotalDTO;
import com.justhabit.model.dto.HaeseungRecordDTO;
import com.justhabit.model.dto.HaesungInfoDTO;

public class TimeRecordView extends JFrame{

	/**
	 * 타이머 기록페이지
	 */
	
	private HaeSeungController habitInfoController = new HaeSeungController();
	private HaeseungRecordDTO timerRecord = new HaeseungRecordDTO(); //습관 기록전달DTO
	private HaesungInfoDTO registInfo = new HaesungInfoDTO(); //습관등록정보전달DTO
	private HaeseungMonthTotalDTO totalRecord = new HaeseungMonthTotalDTO();
	private Date todayDate= new Date(); // 오늘 날짜
	private String today = ""; //날짜 문자열로 변환
	private int totalDate =0; //습관실시 일수
	private int totalTimer=0;//기록된 습관 총 수
	private String thisMonth = "" ;//이번달 "00월"
	JFrame mf = this;
	int test = 5;
	
	public TimeRecordView() {
		
		this.setLayout(null);
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel top = new TopPanel();
		this.add(top);
		
		JPanel center = new JPanel();
		center.setBounds(0, 100, 900, 462);
		center.setLayout(null);
		center.setBackground(new Color(246,245,245));
		
		
		//등록된 습관정보 불러오기
//		registInfo.setHabitID(MainPage.userhabitid);
		//TODO 삭제예정: 테스트용
		registInfo.setHabitID(2); 
		registInfo = habitInfoController.selectHabitInfo(registInfo);
		//습관상단바
		JPanel habitTop = new JPanel();
		habitTop.setLayout(new FlowLayout(FlowLayout.CENTER));
//		habitTop.setBackground(new Color(51,153,51));
		habitTop.setBounds(43, 20, 800, 50);
		
		//습관상단바 - 습관명
		JPanel habitName = new JPanel();
//		habitName.setBounds(0,0,200,50);
		habitName.setBackground(new Color(211,224,234));
		JLabel nameLabel = new JLabel(registInfo.getHabitName());
		nameLabel.setHorizontalAlignment(JLabel.CENTER);

		//폰트설정
		nameLabel.setFont(new Font("D2Coding",Font.BOLD,20));
		habitName.add(nameLabel);
		
		habitTop.add(habitName);
		
		//습관목표출력
		JLabel habitGoal = new JLabel("목표 : "+registInfo.getHabitGoal()+"시간 /");
		habitGoal.setFont(new Font("D2Coding",Font.PLAIN,15));
		habitTop.add(habitGoal);
		
		//습관 상단바 - 타이머
		JPanel timer=  new timerPanel();
		timer.setBounds(270, 0,400,50);
		habitTop.add(timer);
		
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
		
		thisMonth = "";
		if(month < 9) {
			thisMonth = "0"+(month+1);
		} else {
			thisMonth = month+1+"";
		}
		
		JLabel monthName = new JLabel(thisMonth+"월");
		monthName.setFont(new Font("D2Coding",Font.BOLD,20));
		
		monthPrint.add(monthName);
		calendarPanel.add(monthPrint);
		
		//달력표시
		JPanel calendar = new JPanel();
		calendar.setBounds(0, 80, 350, 250);
		calendar.setBackground(new Color(255,204,153));
		GridLayout gridLayout = new GridLayout(calArr.size()/7+1,7,2,2);
		calendar.setLayout(gridLayout);
		
		//오늘날짜 확인
		Date todayDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		today = dateFormat.format(todayDate);
				
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
			
//			if(0<test && test<5) {
//				day[i].setBackground(Color.yellow);
//			} else if(test<=5) {
//				day[i].setBackground(Color.green);
//			}
			//TODO 신호등 만들기(테스트중)
			if(day[i].getText().equals(today)) {
				day[i].setBackground(Color.yellow);
			} else {
				day[i].setBackground(Color.green);
			}
		}
		calendarPanel.add(calendar);
		
		//날짜 클릭시 그날 info 출력..진행중
		Dialog dayInfo = new Dialog(mf,"day Info");
		JButton closeButton = new JButton("닫기");
		JLabel topDialog = new JLabel();
		topDialog.setHorizontalAlignment(JLabel.CENTER);;
		JLabel mainDialog = new JLabel();
		
		dayInfo.add(closeButton,"South");
		dayInfo.add(topDialog,"North");
		dayInfo.add(mainDialog,"Center");
		
		//날짜 색 변경
//		for(i = 0; i < calArr.size(); i++) {
//			if(day[i].getText().equals(today)) {
//				
//				dayInfo.setBounds(350,250,150,150);
//					}
//				});
//			}
//		}
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dayInfo.dispose();
			}
		});		
		
		//문구 표시
		JPanel habitInfo = new JPanel();
		habitInfo.setLayout(null);
		habitInfo.setBounds(420, 95, 420, 340);
		JTextArea info = new JTextArea();
		info.setBounds(10,10,400,320);
		info.setFont(new Font("D2Coding",Font.PLAIN,20));
		
		//출력할정보를 검색
		totalRecord.setHabitId(registInfo.getHabitID());
		totalRecord.setTodayMonth(thisMonth);
		totalRecord = habitInfoController.monthTimerTotalController(totalRecord);
		//습관 실시한 일수
		totalDate = totalRecord.getDateCount();
		//습관 총 횟수
		totalTimer = totalRecord.getRecordSum();
		info.setText("\n \n \n 이번달 기록 \n \n 실시한 일수 : " + totalDate + "일 \n \n 총시간 : " + totalTimer + "시간");
		habitInfo.add(info);
		
		//저장 버튼 
		JButton recordButton = new JButton("저장");
		habitTop.add(recordButton);
		
		recordButton.addActionListener(/**
				 * @author user
				 * 저장버튼 클릭 시 일치하는 날짜 검색->update 없으면 insert;
				 * total 출력 문구 바뀜
				 */
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						SimpleDateFormat todayDateFormat = new SimpleDateFormat("yy/MM/dd");
						double div = 60*60*100;
						double hbtTimer = timerPanel.t / div;
						double test = timerPanel.t % div;
						System.out.println(hbtTimer);
						System.out.println(test);
						if(hbtTimer == 0) {
							JOptionPane.showMessageDialog(mf, "등록할 기록 없음");
						} else {
							
							//습관기록을위한 기본정보(유저ID,습관ID,오늘날짜)
							timerRecord.setUserId(registInfo.getUserID()); //유저아이디
							timerRecord.setHabitId(registInfo.getHabitID()); //습관아이디
							timerRecord.setTimer(hbtTimer); //기록시간
							today = todayDateFormat.format(todayDate);
							timerRecord.setDoDate(today);  // 오늘날짜
							//테스트용
//							Date test = new Date(2021,3,8);
//							String testDate = todayDateFormat.format(test);
//							checkRecord.setDoDate(testDate);
							int result = habitInfoController.dateTimerSelectController(timerRecord);
							if(result==0){
								habitInfoController.insertTimerController(timerRecord);
								JOptionPane.showMessageDialog(mf, "기록 저장 성공");
							} else {
								habitInfoController.updateTimerController(timerRecord);
								JOptionPane.showMessageDialog(mf, "기록 갱신 성공");
							}
							//출력할정보를 검색
							totalRecord.setHabitId(registInfo.getHabitID());
							totalRecord.setTodayMonth(thisMonth);
							totalRecord = habitInfoController.monthTimerTotalController(totalRecord);
							totalDate = totalRecord.getDateCount();
							totalTimer = totalRecord.getRecordSum();
							info.setText("\n \n \n 이번달 기록 \n \n 실시한 일수 : " + totalDate + "일 \n \n 총시간 : " + totalTimer + "시간");
						}
					}
				});
		

		
		
		
		//하단패널
		JPanel botPan = new JPanel();
		botPan.setLayout(new GridLayout(1,6));
		botPan.setSize(900, 100);
		botPan.setLocation(0, 562);
		botPan.setBackground(Color.GREEN);
		this.add(botPan);
		// 메뉴목록
		String[] menu = {"Main", "습관등록", "mypage", "횟수보기","타이머보기"};
		//버튼추가
				JButton[] menuButton = new JButton[menu.length];
				for(int i =0; i <menu.length; i++) {
					
					menuButton[i] = new JButton(menu[i]);
					menuButton[i].setBackground(new Color(211,224,234));
					botPan.add(menuButton[i]);
				}
		
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
		
		menuButton[3].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(mf, new CheckRecordView());
	          }
	       });
		
		menuButton[4].setEnabled(false);
		
		
		
		center.add(habitInfo);
		center.add(calendarPanel);
		center.add(habitTop);
		
		this.add(center);
		
	}
}
