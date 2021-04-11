package com.justhabit.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

//import org.apache.log4j.chainsaw.Main;

import com.justhabit.model.controller.PanelChangeControl;

public class TodayWord extends JFrame {

  String text;
  String title;
  private Image back;
  private TodayWord todayWord = this;
	
	public TodayWord() {
		
		this.todayWord = this;
		
		todayWord.setLayout(null);
		todayWord.setSize(900, 700);
		todayWord.setBackground(Color.lightGray);
		todayWord.setLocationRelativeTo(null);
		todayWord.setVisible(true);
		
		
		String[] words = new String[7];
		words[0] = "<오늘의 명언>\n\n산다는 것, 그것은 치열한 전투이다.\n\n-로망로랑-";
		words[1] = "<오늘의 명언>\n\n삶이란 불충분에서\n 충분을 끌어내는 기술이다.\n\n-S.버틀러-";
		words[2] = "<오늘의 명언>\n\n용기가 있는 곳에 희망이 있다.\n\n-타키투스-";
		words[3] = "<오늘의 명언>\n\n습관이란 인간으로 하여금\n 어떤 일이든지 하게 만든다.\n\n-도스토예프스키-";
		words[4] = "<오늘의 명언>\n\n절대 어제를 후회하지 마라 .\n 인생은 오늘의 나 안에 있고\n 내일은 스스로 만드는 것이다.\n\n-L.론허바드-";
		words[5] = "<오늘의 명언>\n\n습관은 나무 껍질에 새겨놓은 문자 같아서\n 그 나무가 자라남에 따라 확대된다.\n\n-새뮤얼 스마일스-";
		words[6] = "<오늘의 명언>\n\n우리가 반복해서 하는 행동이 바로 우리이다.\n 그러므로 탁월함이란,\n 행동이 아니라 습관이다. \n\n-아리스토텔레스-";
		
		
		
		JTextPane textfield = new JTextPane();

		
		textfield.setText(words[(int)(Math.random()*7)]);
		
		SimpleAttributeSet aSet = new SimpleAttributeSet(); 
		StyleConstants.setFontFamily(aSet, "궁서");
		StyleConstants.setFontSize(aSet, 18);
		
		SimpleAttributeSet bSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
		StyleConstants.setFontFamily(bSet, "궁서");
		StyleConstants.setFontSize(bSet, 24);
		
		textfield.setEditable(false);
		textfield.setLocation(200,300);
		textfield.setSize(500,200);
		StyledDocument doc = textfield.getStyledDocument();
        doc.setCharacterAttributes(105, doc.getLength()-105, aSet, false);
        doc.setParagraphAttributes(0, 104, bSet, false);
        
		
		this.add(textfield);
		
		
		JButton first = new JButton("시작");
		first.setSize(70,40);
		first.setLocation(410, 560);
		this.add(first);
		
		

		Image level = new ImageIcon("image/오늘의명언배경.jpeg").getImage().getScaledInstance(900, 700, 0);
		
		JLabel levelImg = new JLabel(new ImageIcon(level));
		levelImg.setBounds(0,0,900,700);
		this.add(levelImg);
		
		
		first.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PanelChangeControl.changeFrame(todayWord , new MainPage());
            }
         });

			
		
	
	}
	

	  
}	
	
	
