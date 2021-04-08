package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.justhabit.model.controller.PanelChangeControl;

public class HabbitAdd extends JPanel {

//	private JButton nextButton; // 다음버튼
//	private JButton preButton; //  이전버튼
//	private JLabel label; // 라벨
//	private JTextField text; // 텍스트 입력
	
	
   private HabbitAdd habbitAdd;
   

public HabbitAdd() {

	   this.habbitAdd = this;
	   
	   
       this.setLayout(null);
       this.setBounds(0, 100, 900, 462);
       this.setBackground(Color.lightGray);
       this.setVisible(true);


	   JLabel label1 = new JLabel("1번) 무슨 습관을 들이고 싶나요?");
	   
	   label1.setFont(new Font("Serif", Font.BOLD, 30));
	   label1.setSize(500,200);
	   label1.setLocation(230,0);
       this.add(label1);
       

      JTextField text = new JTextField(15);
      text.setSize(250,50);
      text.setLocation(300, 180);
      text.setEditable(true);
      this.add(text);
      this.validate();
      	
      JButton jbutton2 = new JButton("다음");
      jbutton2.setSize(80,50);
      jbutton2.setLocation(450, 280);
      	this.add(jbutton2);
      	
      	jbutton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PanelChangeControl.changePanel(habbitAdd , new HabbitAdd2());
            }
         });
   } 
}
