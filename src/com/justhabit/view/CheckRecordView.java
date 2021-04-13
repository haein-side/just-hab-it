package com.justhabit.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

public class CheckRecordView extends JFrame{
	
	/**
	 * 체크박스 기록페이지
	 */
	
	private HaeSeungController habitInfoController = new HaeSeungController();
	private HaeseungRecordDTO checkRecord = new HaeseungRecordDTO(); //습관 기록전달DTO
	private HaesungInfoDTO registInfo = new HaesungInfoDTO(); //습관등록정보전달DTO
	private HaeseungMonthTotalDTO totalRecord = new HaeseungMonthTotalDTO();
	List<HaeseungRecordDTO> recordAndGoalList = null;
	private int checkCount = 0; // 체크박스카운트용
	private Date todayDate= new Date(); // 오늘 날짜
	private String today = ""; //날짜 문자열로 변환
	private int totalDate =0; //습관실시 일수
	private int totalCheck=0;//기록된 습관 총 수 
	private String thisMonth = "" ;//이번달 "00월"
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
		registInfo.setHabitID(MainPage.userhabitid);
		//TODO 삭제예정: 테스트용
//		registInfo.setHabitID(1); 
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
		JButton doIt = new JButton(" + ");
		doIt.setSize(60,40);
		habitCheck.add(doIt);
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

		JButton minus = new JButton(" - ");
		minus.setSize(60,40);
		habitCheck.add(minus);
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkCount == 0) {
					JOptionPane.showMessageDialog(mf, "0보다 작을 수 없습니다.");
				} else {
					checkCount--;
					habitCount.setText("      목표 : "+ registInfo.getHabitGoal() + "회 / 현재 : "+checkCount + "회      ");
				}
			}
		});
		
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
		
		if(month < 9) {
			thisMonth = "0"+(month+1);
		} else {
			thisMonth = month+1+"";
		}
		JLabel monthName = new JLabel(thisMonth+"월");
		monthName.setFont(new Font("D2Coding",Font.BOLD,20));
		
		monthPrint.add(monthName);
		calendarPanel.add(monthPrint);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		
		String day = dateFormat.format(todayDate);
		//달력표시
		JPanel calendar = new JPanel();
		calendar.setBounds(0, 80, 350, 250);
		calendar.setBackground(new Color(255,204,153));
		GridLayout gridLayout = new GridLayout(calArr.size()/7+1,7,2,2);
		calendar.setLayout(gridLayout);
		
		JButton[] dayButton = new JButton[calArr.size()]; 
		for(int i = 0; i < calArr.size();i++) {
			String CalenderDate = "";
			if(i<9) {
				CalenderDate ="0"+calArr.get(i);
				dayButton[i] = new JButton(CalenderDate);			
				dayButton[i].setHorizontalAlignment(JLabel.CENTER);
				dayButton[i].setVerticalAlignment(JLabel.CENTER);
				dayButton[i].setBackground(Color.white);
				calendar.add(dayButton[i]);
			} else {
				CalenderDate = calArr.get(i)+"";
				dayButton[i] = new JButton(CalenderDate);			
				dayButton[i].setHorizontalAlignment(JLabel.CENTER);
				dayButton[i].setVerticalAlignment(JLabel.CENTER);
				dayButton[i].setBackground(Color.white);
				calendar.add(dayButton[i]);
			}
		}
		
		//달성 여부에 따라 신호등 만들기
		checkRecord.setHabitId(MainPage.userhabitid);
		checkRecord.setRecordType(registInfo.getHabitType());
		recordAndGoalList = habitInfoController.selectRecordGoal(checkRecord);
		SimpleDateFormat yearMonth = new SimpleDateFormat("yy/MM");
		String checkYearMonth = yearMonth.format(todayDate);
		System.out.println(checkYearMonth);
		String searchDate =  "";
		for(int i = 0; i < calArr.size(); i++) {
			
			searchDate = checkYearMonth+"/"+dayButton[i].getText();
			for(int j = 0; j < recordAndGoalList.size(); j++) {
				
				if(searchDate.equals(recordAndGoalList.get(j).getDoDate())) {
					int goal = recordAndGoalList.get(j).getHabitGoal();
					int record = recordAndGoalList.get(j).getCheck();
					if(goal == record) {
						dayButton[i].setBackground(Color.green);
					} else if(record > 0 ){
						dayButton[i].setBackground(Color.yellow);
					}
				}
			}
		}
		
		//클릭시 그날 기록 출력하기,기록있는날만 나옴  
		for(int i = 0; i < calArr.size(); i++) {
			searchDate = checkYearMonth+"/"+dayButton[i].getText();
			for(int j = 0; j < recordAndGoalList.size(); j++) {
				int a = j;
				String b = searchDate;
					dayButton[i].addActionListener(new ActionListener() {
						boolean ade = false;
						@Override
						public void actionPerformed(ActionEvent e) {
							if(b.equals(recordAndGoalList.get(a).getDoDate())) {
								JOptionPane.showMessageDialog(mf, b +"\n\n"+recordAndGoalList.get(a).getCheck() + " / " + recordAndGoalList.get(a).getHabitGoal());
							} 
						}	
					});
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

		//출력할 정보를 검색
		totalRecord.setHabitId(registInfo.getHabitID());
		totalRecord.setTodayMonth(thisMonth);
		totalRecord = habitInfoController.monthTotalController(totalRecord);
		//습관 실시한 일수
		totalDate = totalRecord.getDateCount();
		//습관 총 횟수
		totalCheck = (int)totalRecord.getRecordSum();
		infoText.setText("\n \n \n 이번달 기록 \n \n 실시한 일수 : " + totalDate + "일 \n \n 실시한 횟수 : " + totalCheck + "회");
		infoPanel.add(infoText);
		
		//습관기록저장
		JButton recordButton = new JButton("저장");

		recordButton.setBounds(823,128, 60, 40);
		recordButton.addActionListener(/**
		 * @author user
		 * 저장버튼 클릭 시 일치하는 날짜 검색->update 없으면 insert;
		 * total 출력 문구 바뀜
		 */
			new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					SimpleDateFormat todayDateFormat = new SimpleDateFormat("yy/MM/dd");
					
					
					if(checkCount == 0) {
						JOptionPane.showMessageDialog(mf, "등록할 기록 없음");
					} else {
						
						//습관기록을위한 기본정보(유저ID,습관ID,오늘날짜)
						checkRecord.setUserId(registInfo.getUserID());  //유저아이디
						checkRecord.setHabitId(registInfo.getHabitID()); // 습관아이디
						checkRecord.setCheck(checkCount); // 체크횟수
						today = todayDateFormat.format(todayDate);
						checkRecord.setDoDate(today);   // 오늘날짜
						
						//출력문구 변화를 위한 값 받기
						int result = habitInfoController.dateSelectController(checkRecord);
						if(result==0){
							habitInfoController.insertCheckController(checkRecord);
							JOptionPane.showMessageDialog(mf, "기록등록 성공");
						} else {
							habitInfoController.updateCheckController(checkRecord);
							JOptionPane.showMessageDialog(mf, "기록 갱신 성공");
						}
						totalRecord.setHabitId(registInfo.getHabitID());
						totalRecord.setTodayMonth(thisMonth);
						totalRecord = habitInfoController.monthTotalController(totalRecord);
						totalDate = totalRecord.getDateCount();
						totalCheck = (int)totalRecord.getRecordSum();
						infoText.setText("\n \n \n 이번달 기록 \n \n 실시한 일수 : " + totalDate + "일 \n \n 실시한 횟수 : " + totalCheck + "회");
						
						checkRecord.setHabitId(MainPage.userhabitid);
						checkRecord.setRecordType(registInfo.getHabitType());
						recordAndGoalList = habitInfoController.selectRecordGoal(checkRecord);
						SimpleDateFormat yearMonth = new SimpleDateFormat("yy/MM");
						String checkYearMonth = yearMonth.format(todayDate);
						System.out.println(checkYearMonth);
						String searchDate =  "";
						for(int i = 0; i < calArr.size(); i++) {
							
							searchDate = checkYearMonth+"/"+dayButton[i].getText();
							System.out.println("비교할 날짜 : " +  searchDate);
							for(int j = 0; j < recordAndGoalList.size(); j++) {
								
								if(searchDate.equals(recordAndGoalList.get(j).getDoDate())) {
									int goal = recordAndGoalList.get(j).getHabitGoal();
									int record = recordAndGoalList.get(j).getCheck();
									
									if(goal == record) {
										dayButton[i].setBackground(Color.green);
									} else if(record > 0 ){
										dayButton[i].setBackground(Color.yellow);
									}
								}
							}
						}
					}
				}
			});
				
		habitTop.add(recordButton);
		
		//하단패널
		JPanel botPan = new JPanel();
		botPan.setLayout(new GridLayout(1,6));
		botPan.setSize(900, 100);
		botPan.setLocation(0, 562);
		botPan.setBackground(Color.GREEN);
		
		this.add(botPan);
		//메뉴목록
		String[] menu = {"Main", "습관등록", "mypage"};
		
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
		
		center.add(infoPanel);
		center.add(calendarPanel);
		center.add(habitTop);
		this.add(center);
	}
}
