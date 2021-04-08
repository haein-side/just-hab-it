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

public class HabbitAdd5 extends JPanel {

//	private JButton nextButton; // 다음버튼
//	private JButton preButton; //  이전버튼
//	private JLabel label; // 라벨
//	private JTextField text; // 텍스트 입력
	
	
	private HabbitAdd5 habbitAdd5;
   public HabbitAdd5(JFrame mf) {

	   this.habbitAdd5 = this;
	   
       this.setLayout(null);
       this.setBounds(0, 100, 900, 462);
       this.setBackground(Color.lightGray);
       this.setVisible(true);


	   JLabel label1 = new JLabel("5번) 하루에 몇번 할건가요?");
	   
	   label1.setFont(new Font("Serif", Font.BOLD, 30));
	   label1.setSize(500,200);
	   label1.setLocation(250,0);
       this.add(label1);
       

       SpinnerNumberModel value = new SpinnerNumberModel(0,0,10,1);
       JSpinner spin = new JSpinner(value);
       spin.setFont(new Font("Serif", Font.BOLD, 30));
       spin.setSize(250,50);
       spin.setLocation(300,180);
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
               ChangePanel.changePanel(mf, habbitAdd5 , new HabbitAdd4(mf));
            }
         }); 
      	
      	
   }
}
