package com.justhabit.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TodayWord extends JPanel {

  String text;
  String title;
  private Image back;
  private TodayWord todayWord;
	
	public TodayWord(JFrame mf) {
		this.todayWord = this;
		
		this.setLayout(null);
		this.setBounds(0, 100, 900, 462);
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
		
		
		text = "커다란 고민도 작은 고민이 합쳐 만들어진 것이다";
		title = "<오늘의 명언>";
		

		
		JButton first = new JButton("시작");
		first.setSize(70,30);
		first.setLocation(410, 380);
		this.add(first);
		
		first.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               ChangePanel.changePanel(mf, todayWord , new MainPage());
            }
         });

				
	
	}
	


	
	 @Override
	  public Dimension getPreferredSize() {
	    return new Dimension(200, 200);
	  }


	 
	  @Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
//	    g.drawImage(back, 0, 0, null);
	    
	    Graphics2D g2d = (Graphics2D) g.create();

	    g2d.drawRoundRect(250,110,400,200,50,50);
	    g2d.setColor(Color.ORANGE);
	    g2d.drawRoundRect(250,110,400,200,50,50);
	    g2d.fillRoundRect(250,110,400,200,50,50);
	    

	    Font font = new Font("궁서", Font.BOLD, 15);
	    g2d.setFont(font);
	    FontMetrics fm = g2d.getFontMetrics();
	    int x = ((getWidth() - fm.stringWidth(text)) / 2);
	    int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();

	    g2d.setColor(Color.BLACK);
	    g2d.drawString(title, 405, 150);
	    g2d.drawString(text, x, y);

	    g2d.dispose();
	  }
	  

}	
	
	
