package com.justhabit.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.log4j.chainsaw.Main;

import com.justhabit.model.controller.HaeinController;
import com.justhabit.model.controller.PanelChangeControl;
import com.justhabit.model.dto.AllHabitDTO;

public class MainPage extends JFrame{
	
	private HaeinController habitDayController = new HaeinController();
	private AllHabitDTO allHabitDTO = new AllHabitDTO();
	public static int userhabitid;
	int h = 0;
 
	JFrame mf = this;
	public MainPage() {
		
		this.setLayout(null);
		this.setSize(900, 700);
		
		
		
		
		this.add(new TopPanel());
		
		//가운데 패널
		JPanel center = new JPanel();
		center.setBounds(0, 100, 900, 462);
//		center.setLocation(0, 100);
		center.setPreferredSize(new Dimension(900,462));
		center.setLayout(null);
//		center.setBackground(new Color(246,245,245));
		
		
//		ImageIcon icon = new ImageIcon(imgURL); 
//		JLabel thumb = new JLabel();
//		thumb.setIcon(icon);
		

		
//	int userid = 1;
		
//		List<AllHabitDTO> allhabitList = habitDayController.selectAllHabitBy(userid);
//		JButton[] habitButtons = new JButton[allhabitList.size()];
	
		List<AllHabitDTO> allhabitList = habitDayController.selectAllHabitBy(FirstFrame.loggedUserID);
//		JButton[] habitButtons = new JButton[allhabitList.size()];
		
		JPanel right = new JPanel();
		right.setBounds(400, 100, 500, 462);
		right.setLayout(null);
		
		for(h = 0; h < allhabitList.size(); h++) {
				JButton box = new JButton();
				box.setSize(400, 60);
				box.setLocation(400, 180 + 100 * (h-1));	
				box.setText(allhabitList.get(h).getHabitName());
				
				// 버튼 이미지 넣으려고 했으나 실패
//				box.setOpaque(false);
//				box.setContentAreaFilled(false);
//				box.setBorderPainted(false);
				
//				Image button = new ImageIcon("button1/diary.jpg").getImage();
//				JLabel button1 = new JLabel(new ImageIcon(button));
//				button1.setBounds(400,60,400,180 + 100 * (h-1));
//				
//				center.add(button1);
//				
				
				int i = h;
				box.setText(allhabitList.get(h).getHabitName());
				box.addActionListener(new ActionListener() {
					
			          @Override
			          public void actionPerformed(ActionEvent e) {
			      
			        	  userhabitid = allhabitList.get(i).getHabitID();
			        	  System.out.println("------------------------------"+userhabitid);
			        	  if(allhabitList.get(i).getHabitType().equals("c")) {
			        		  PanelChangeControl.changeFrame(mf, new CheckRecordView());
			        		  
			        	  } else {
			        		  PanelChangeControl.changeFrame(mf, new TimeRecordView());
			        	  }
			          }
			       });
				center.add(box);
		}
		
		
        // 스크롤
        JScrollPane scrollbar = new JScrollPane(center);
        scrollbar.setPreferredSize(new Dimension(900,600));
        scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        int width = scrollbar.getPreferredSize().width;
        int height = scrollbar.getPreferredSize().height;
        scrollbar.setBounds(850,100,width,height);
        scrollbar.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
//        scrollbar.setBackground(Color.pink);
        this.add(scrollbar);
        
        // 스크롤
//        JScrollPane scrollbar = new JScrollPane(middlePanel);
//        scrollbar.setPreferredSize(new Dimension(685,700));
//        scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        int width = scrollbar.getPreferredSize().width;
//        int height = scrollbar.getPreferredSize().height;
//        scrollbar.setBounds(0,100,width,height);
//        scrollbar.setBorder(pinkborder);
//        scrollbar.setBackground(Color.pink);
//        this.getContentPane().add(scrollbar);

		
		
		//오늘의 일기
		JLabel promise = new JLabel("<오늘의 일기>");
		
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		promise.setFont(font);
	
	    promise.setSize(300,50);
	    promise.setLocation(60, 15);
	    center.add(promise);
	    
	    JLabel habit = new JLabel("<오늘의 습관>");
	    habit.setFont(font);
	
	    habit.setSize(300,50);
	    habit.setLocation(400, 15);
	    center.add(habit);
	    
	    JTextArea chat = new JTextArea();
	    chat.setBounds(50,60,300,300);
	    chat.setEditable(true);
	    
	    Font font1 = new Font("맑은 고딕", Font.PLAIN, 15);
		chat.setFont(font1);
		
	    
	    chat.setOpaque(false);
	    chat.setBorder(BorderFactory.createEmptyBorder());
	    chat.setBackground(new Color(0,0,0,0));
	    center.add(chat);
	    center.validate();
	    
        Image diary = new ImageIcon("image/diary.jpg").getImage().getScaledInstance(300, 300, 0);
		JLabel yellow = new JLabel(new ImageIcon(diary));
		yellow.setBounds(50,60,300,300);
		center.add(yellow);
		
		
		
	    JButton save = new JButton("일기 감춰놓기");
	    JButton open = new JButton("일기 불러오기");
	    
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
			       
				 FileDialog dialog = new FileDialog(mf, "저장", FileDialog.SAVE);
				    dialog.setFile("*.txt;");
	                dialog.setVisible(true);    
	                String path = dialog.getDirectory() + dialog.getFile();
	                
	                try {
	                   FileWriter w = new FileWriter( path );
	                   String s = chat.getText();
	                   s = s.replace("\n","\r\n");
	                   w.write( s  ); 
	                   w.close();
	                } catch (Exception e2) {
	                    System.out.println("저장오류"+e2);
	                }  
				
			}
		
		});
		
		open.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                   FileDialog dialog = new FileDialog(mf, "열기", FileDialog.LOAD);
                   dialog.setFile("*.txt;");
                   dialog.setVisible(true);        
                   
                   String path = dialog.getDirectory() + dialog.getFile();                 
                   String s ="";
                   
                   if( dialog.getFile() == null ) return;
                   try {
                      FileReader r = new FileReader( path );
                      int k;              
                      for( ;  ; ) {
                          k = r.read();
                          if( k == -1) break;
                          s += (char)k;               
                      }           
                      r.close();
                   } catch (Exception e2) {
                       System.out.println("오류"+e);
                   } 
                   chat.setText(s);   
            }            
        }); 
		
		
		
		
//		save.setLocation(370,100);
		save.setBounds(65, 380, 120, 40);
		open.setBounds(215, 380, 120, 40);
		center.add(save);
		center.add(open);
	    
	    
	    
//		Image back = new ImageIcon("image/resizedbackground1.jpg").getImage().getScaledInstance(900, 700, 0);
//		JLabel backImg = new JLabel(new ImageIcon(back));
//		backImg.setBounds(0,0,900,462);
//		center.add(backImg);
		
		
		
		JPanel botPan = new JPanel();
		botPan.setLayout(new GridLayout(1,6));
		botPan.setSize(900, 100);
		botPan.setLocation(0, 562);
		botPan.setBackground(Color.GREEN);
		
		//메뉴목록
		String[] menu = {"Main", "습관등록", "습관삭제", "mypage"};
		
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
//	             PanelChangeControl.changeFrame(mf, new DeleteHabit());
	        	  new DeleteHabit();
	          }
	       });
		
		menuButton[3].addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             PanelChangeControl.changeFrame(mf, new MyPage());
	          }
	       });
		
		this.add(botPan);
		
		Image button = new ImageIcon("button1/diary.jpg").getImage().getScaledInstance(900, 700, 0);
		JLabel button1 = new JLabel(new ImageIcon(button));
		button1.setBounds(0,0,400,80);
		
		center.add(button1);
		
//		Image back = new ImageIcon("image/resizedbackground1.jpg").getImage().getScaledInstance(900, 700, 0);
//		JLabel backImg = new JLabel(new ImageIcon(back));
//		backImg.setBounds(0,0,900,462);
//		center.add(backImg);
		
		
		
		
		this.add(center);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null); // 화면 가운데로
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
	}
		
	
//	public void displayHabit(){
////		int userid = 1;
//		
//		FirstFrame.loggedUserID = 1;
//		
//		List<AllHabitDTO> allhabitList = habitDayController.selectAllHabitBy(FirstFrame.loggedUserID);
//		JButton[] habitButtons = new JButton[allhabitList.size()];
//		for(int i = 0; i < allhabitList.size(); i++) {
//				JButton box = new JButton();
//				box.setSize(100, 80);
//				box.setLocation(150* + 100*(i-1), 300);
//				box.setText(allhabitList.get(i).getHabitName());
//				this.add(box);
//			
//		}
//		for(int i = 0; i < allhabitList.size(); i++) {
//			System.out.println(allhabitList.get(i).getHabitID() + "/" + allhabitList.get(i).getHabitName() );
//		}
//	}
	
	}
	