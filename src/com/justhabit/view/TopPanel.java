package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel{
	
	public TopPanel() {
		//상단바
		this.setLocation(0, 0);
		this.setSize(900, 100);
		this.setLayout(null);
		this.setBackground(new Color(211,224,234));
		
		//TODO Title(JUSTHABBIT)추가
		
		
		//상단바 좌측
		JPanel topPanLeft = new JPanel();
		topPanLeft.setSize(100, 100);
		//topPanLeft.setBackground(Color.W);
		
		//좌측이미지
		Image leftImage = new ImageIcon("image/turtle1.jpeg").getImage().getScaledInstance(100, 100, 0);
		
		JLabel leftLabel = new JLabel(new ImageIcon(leftImage));
		
		Date today = new Date();
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		JLabel dayPrint = new JLabel(dayFormat.format(today));
		dayPrint.setBounds(740,0, 200, 50);
		dayPrint.setVisible(true);
		this.add(dayPrint);
		
		leftLabel.setBounds(0, 0, 80, 80);
		topPanLeft.add(leftLabel);
		this.add(topPanLeft);
	}
			
}
