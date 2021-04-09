package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.justhabit.model.controller.PanelChangeControl;

public class HabbitAdd2 extends JFrame {
	
	
	private HabbitAdd2 habbitAdd2 = this;
	
//	JFrame mf = new MainView();

   public HabbitAdd2() {
	   

	   habbitAdd2.setLayout(null);
	   habbitAdd2.setBounds(0, 100, 900, 462);
	   habbitAdd2.setBackground(Color.lightGray);
	   habbitAdd2.setLocationRelativeTo(null);
	   habbitAdd2.setVisible(true);


	   JLabel label1 = new JLabel("2번) 몇일에 한번 습관을 들이고 싶나요?");
	   
	   label1.setFont(new Font("Serif", Font.BOLD, 30));
	   label1.setSize(600,230);
	   label1.setLocation(180,0);
	   habbitAdd2.add(label1);
       
       
       SpinnerNumberModel value = new SpinnerNumberModel(0,0,365,1);
       JSpinner spin = new JSpinner(value);
       spin.setFont(new Font("Serif", Font.BOLD, 30));
       spin.setSize(200,50);
       spin.setLocation(300,170);
       habbitAdd2.add(spin);
       
       
       
       JButton jbutton1 = new JButton("이전");
       jbutton1.setSize(80,50);
       jbutton1.setLocation(300, 280);
       habbitAdd2.add(jbutton1); 
      	
       JButton jbutton2 = new JButton("다음");
      jbutton2.setSize(80,50);
      jbutton2.setLocation(450, 280);
      habbitAdd2.add(jbutton2);
      	
      	jbutton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PanelChangeControl.changeFrame(habbitAdd2 , new HabbitAdd());
            }
         }); 
      	
      	
      	jbutton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PanelChangeControl.changeFrame(habbitAdd2 , new HabbitAdd3());
            }
         });  	
   }
}
