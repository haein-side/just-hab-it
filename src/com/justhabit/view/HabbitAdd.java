package com.justhabit.view;

import java.awt.BorderLayout;
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

public class HabbitAdd extends JFrame {

//	private JButton nextButton; // 다음버튼
//	private JButton preButton; //  이전버튼
//	private JLabel label; // 라벨
//	private JTextField text; // 텍스트 입력
	
	
   private HabbitAdd habbitAdd = this;
   

   public HabbitAdd() {

	habbitAdd.setLayout(null);
	habbitAdd.setSize(900, 462);
		
	   
	
	JPanel question = new JPanel();
	
//	question.setBounds(200,200,600,200);
//	question.setLayout(new BorderLayout());
	JLabel label1 = new JLabel("1번) 무슨 습관을 들이고 싶나요?");
   
	label1.setFont(new Font("Serif", Font.BOLD, 20));
	label1.setSize(400,200);
	label1.setLocation(300,0);
	habbitAdd.add(label1);
       

	JTextField text = new JTextField(15);
	text.setSize(400,120);
	text.setLocation(250, 150);
	text.setEditable(true);
	habbitAdd.add(text);
	question.validate();
  	
	JButton jbutton2 = new JButton("다음");
	jbutton2.setSize(80,50);
	jbutton2.setLocation(450, 280);
	habbitAdd.add(jbutton2);
      	


  	jbutton2.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        	
        	PanelChangeControl.changeFrame(habbitAdd , new HabbitAdd2());
        	System.out.println(text.getText());
        }
     });
  	
//  	this.add(question);
  	habbitAdd.setVisible(true);
  	habbitAdd.setResizable(false);
  	habbitAdd.setLocationRelativeTo(null); // 화면 가운데로
  	habbitAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   } 
}
