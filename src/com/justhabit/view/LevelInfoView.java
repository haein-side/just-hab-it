package com.justhabit.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelInfoView extends JPanel {

	public static void main(String[] args) {
		
		JFrame fm = new JFrame();
		fm.setLayout(null);
		
		fm.add(new LevelInfoView());
		fm.setSize(900, 700);
		fm.setLocationRelativeTo(null);
		fm.setVisible(true);
		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public LevelInfoView() {
		this.setLayout(null);
		this.setBounds(0, 100, 900, 462);
		this.setBackground(Color.white);
		
		
		//레벨이미지 추가
		JPanel level = new JPanel();
		level.setBounds(63, 100, 800, 300);
		level.setLayout(new GridLayout(1,5,10,0));
		level.setBackground(Color.white);
		
		Image levelImg = new ImageIcon("image/레벨설명.PNG").getImage().getScaledInstance(900, 250, 0);
		
//		ImageIcon levelInfo = new ImageIcon("image/레벨설명.PNG");
//		levelInfo.
		JLabel label = new JLabel(new ImageIcon(levelImg));
		level.add(label);
		
		
//		JPanel chobo = new JPanel();
//		ImageIcon choboimage = new ImageIcon("image/1렙계란.PNG");
//		JPanel jungsu = new JPanel();
//		ImageIcon jungsuimage = new ImageIcon("image/2렙계란.PNG");
//		JPanel gosu = new JPanel();
//		ImageIcon gosuimage = new ImageIcon("image/3렙계란.PNG");
//		JPanel chogosu = new JPanel();
//		ImageIcon chogosuimage = new ImageIcon("image/4렙계란.PNG");
//		JPanel god = new JPanel();
//		ImageIcon godimage = new ImageIcon("image/5렙계란.PNG");
//		
//		JPanel[] levelinfo = {chobo,jungsu,gosu,chogosu,god};
//		ImageIcon[] levelIcon = {choboimage,jungsuimage,gosuimage,chogosuimage,godimage};
//		
//		
//		
//		for(int i = 0; i < levelinfo.length; i++) {
//			JLabel levelLabel = new JLabel(levelIcon[i]);
//			levelinfo[i].add(levelLabel);
//			levelinfo[i].setSize(50, 50);
//			levelinfo[i].setBackground(Color.white);
//			level.add(levelinfo[i]);
//		}
		this.add(level);
		
	}
}
