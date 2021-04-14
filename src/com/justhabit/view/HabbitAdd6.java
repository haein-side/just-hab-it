package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.justhabit.model.controller.PanelChangeControl;

public class HabbitAdd6 extends JFrame{
	
	private HabbitAdd6 habbitAdd6;
	
	   public HabbitAdd6() {

		   this.habbitAdd6 = this;
		   
		   habbitAdd6.setLayout(null);
		   habbitAdd6.setBounds(0, 100, 900, 462);
		   habbitAdd6.setBackground(Color.lightGray);
		   habbitAdd6.setLocationRelativeTo(null);
		   habbitAdd6.setVisible(true);


		   JLabel label1 = new JLabel("5번) 하루에 몇시간 할건가요?");
		   
		   label1.setFont(new Font("Serif", Font.BOLD, 30));
		   label1.setSize(500,200);
		   label1.setLocation(250,0);
		   habbitAdd6.add(label1);
	       

	       SpinnerNumberModel value = new SpinnerNumberModel(0,0,10,1);
	       JSpinner spin = new JSpinner(value);
	       spin.setFont(new Font("Serif", Font.BOLD, 30));
	       spin.setSize(250,50);
	       spin.setLocation(300,180);
	       habbitAdd6.add(spin);
	      	
	    	 JButton jbutton1 = new JButton("이전");
	         jbutton1.setSize(80,50);
	         jbutton1.setLocation(300, 280);
	         habbitAdd6.add(jbutton1);
	       
	      
	      JButton jbutton2 = new JButton("다음");
	      jbutton2.setSize(80,50);
	      jbutton2.setLocation(450, 280);
	      habbitAdd6.add(jbutton2);
	      	
	      	jbutton1.addMouseListener(new MouseAdapter() {
	      		
	      		
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	
	            	
	            	PanelChangeControl.changeFrame(habbitAdd6 , new HabbitAdd4());
	            }
	         }); 
	      	
	      	jbutton2.addMouseListener(new MouseAdapter() {
	      		
	      		
	      		@Override
	      		public void mouseClicked(MouseEvent e) {
	      			
//	      			HabbitAdd.habbitAddDTO.setHabitGoal();
	      			PanelChangeControl.changeFrame(habbitAdd6 , new MainPage());
	      			
	      		}
	      	}); 
	   }
}
