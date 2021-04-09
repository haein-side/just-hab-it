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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.justhabit.model.controller.PanelChangeControl;

public class TodayWord extends JFrame {

  String text;
  String title;
  private Image back;
  private TodayWord todayWord = this;
	
	public TodayWord() {
		
		this.setLayout(null);
		this.setSize(900, 462);
		this.setBackground(Color.LIGHT_GRAY);
		
		JPanel test = new JPanel();
		
		text = "커다란 고민도 작은 고민이 합쳐 만들어진 것이다";
		title = "<오늘의 명언>";
		

		
		JButton first = new JButton("시작");
		first.setSize(70,30);
		first.setLocation(410, 380);
		this.add(first);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		first.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PanelChangeControl.changeFrame(todayWord , new MainPage());
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
	    g.drawImage(back, 0, 0, null);
	    
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
	
	
