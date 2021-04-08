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

public class HabbitAdd2 extends JPanel {
	
	
	private HabbitAdd2 habbitAdd2;

   public HabbitAdd2(JFrame mf) {
	   
	   this.habbitAdd2 = this;

       this.setLayout(null);
       this.setBounds(0, 100, 900, 462);
       this.setBackground(Color.lightGray);
       this.setVisible(true);


	   JLabel label1 = new JLabel("2번) 몇일에 한번 습관을 들이고 싶나요?");
	   
	   label1.setFont(new Font("Serif", Font.BOLD, 30));
	   label1.setSize(600,230);
	   label1.setLocation(180,0);
       this.add(label1);
       
       
       SpinnerNumberModel value = new SpinnerNumberModel(0,0,365,1);
       JSpinner spin = new JSpinner(value);
       spin.setFont(new Font("Serif", Font.BOLD, 30));
       spin.setSize(200,50);
       spin.setLocation(300,170);
       this.add(spin);
       
       
       
       JButton jbutton1 = new JButton("이전");
       jbutton1.setSize(80,50);
       jbutton1.setLocation(300, 280);
       	this.add(jbutton1); 
      	
       JButton jbutton2 = new JButton("다음");
      jbutton2.setSize(80,50);
      jbutton2.setLocation(450, 280);
      	this.add(jbutton2);
      	
      	jbutton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               ChangePanel.changePanel(mf, habbitAdd2 , new HabbitAdd(mf));
            }
         }); 
      	
      	
      	jbutton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               ChangePanel.changePanel(mf, habbitAdd2 , new HabbitAdd3(mf));
            }
         });  	
   }
}
