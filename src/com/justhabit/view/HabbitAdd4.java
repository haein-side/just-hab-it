package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.justhabit.model.controller.PanelChangeControl;
import com.justhabit.model.dto.HabbitAddDTO;

public class HabbitAdd4 extends JFrame {

	private HabbitAdd4 habbitAdd4;

   public HabbitAdd4(HabbitAddDTO habbit) {
	   
	   this.habbitAdd4 = this;

	   habbitAdd4.setLayout(null);
	   habbitAdd4.setBounds(0, 100, 900, 462);
	   habbitAdd4.setBackground(Color.lightGray);
	   habbitAdd4.setLocationRelativeTo(null);
	   habbitAdd4.setVisible(true);


	   JLabel label1 = new JLabel("4번) 습관기록방식은 무엇인가요?");
	   
	   label1.setFont(new Font("Serif", Font.BOLD, 30));
	   label1.setSize(500,200);
	   label1.setLocation(200,0);
	   habbitAdd4.add(label1);
       
       JPanel radioPanel = new JPanel();
       radioPanel.setSize(200,50);
       radioPanel.setLocation(320,160);
       
      JRadioButton time = new JRadioButton("횟수");
      JRadioButton timer = new JRadioButton("타이머");
       
       ButtonGroup recordType = new ButtonGroup();
       recordType.add(time);
       recordType.add(timer);
       
       radioPanel.add(time);
       radioPanel.add(timer);
       
       habbitAdd4.add(radioPanel);
      
   	  JButton jbutton1 = new JButton("이전");
      jbutton1.setSize(80,50);
      jbutton1.setLocation(300, 280);
      habbitAdd4.add(jbutton1);
      
//      JButton jbutton2 = new JButton("다음");
//      jbutton2.setSize(80,50);
//      jbutton2.setLocation(450, 280);
//      habbitAdd4.add(jbutton2);
      
      	time.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
//			저장은 c아니면 t로 저장되게
//			HabbitAdd.habbitAddDTO.setHabitType();
			
			//if (횟수)
			PanelChangeControl.changeFrame(habbitAdd4 , new HabbitAdd5());
			//else (체크)
			PanelChangeControl.changeFrame(habbitAdd4 , new HabbitAdd6());

		}
     });
     
      
      	
      	jbutton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PanelChangeControl.changeFrame(habbitAdd4 , new HabbitAdd3());
            }
         }); 

      	
      	


   } 
}
