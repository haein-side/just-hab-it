package com.justhabit.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class timerPanel extends JPanel{
	
	JButton start, reset, pause;
	Thread display;
	JLabel w1;
	JLabel w2;
	JLabel w3;
	JLabel w4;
	int hr;
	int mm;
	int ss;
	int ms;
	int t= 360000;
	static int count = 0; //시간 카운트용
	
	public timerPanel() {
		//타이머화면
		JPanel p =new JPanel(new GridLayout(1,2));
		JPanel bp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel wp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel c1 = new JLabel(" : ");
		JLabel c2 = new JLabel(" : ");
		JLabel c3 = new JLabel(" : ");
		w1 = new JLabel("00");
		w2 = new JLabel("00");
		w3 = new JLabel("00");
		w4 = new JLabel("00");
		
		start = new JButton("START");
		reset = new JButton("RESET");
		pause = new JButton("PAUSE");
		bp.add(start);
		bp.add(pause);
		bp.add(reset);
		
		wp.add(w1);
		wp.add(c1);
		wp.add(w2);
		wp.add(c2);
		wp.add(w3);
		wp.add(c3);
		wp.add(w4);
		
		p.add(wp, BorderLayout.CENTER);
		p.add(bp, BorderLayout.SOUTH);
		add(p);

		pause.setEnabled(false);
		reset.setEnabled(false);
		
		start.addActionListener(new ButtonListener());
		pause.addActionListener(new ButtonListener());
		reset.addActionListener(new ButtonListener());
		
		
	}

	
	
	/**
	 * @author 
	 * 타이머 시작,정지,종료
	 */
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			
			if(s.equals("START")) {
				start.setEnabled(false);
				pause.setEnabled(true);
				reset.setEnabled(false);
				
				display = new Thread(new Runnable() {
					
					@Override
					public void run() {
						mm = Integer.parseInt(w1.getText());
						ss = Integer.parseInt(w1.getText());
						ms = Integer.parseInt(w1.getText());
						
						
						while(display == Thread.currentThread()) {
							
							
							
							//hr은..흠...
//							mm = t / (1000*60);
//							ss = t % (1000*60) / 60 % 60;
//							ms = t % 100;
							hr = t / (60*60*100) % 24;
							mm = t /(60*100) % 60;
							ss = t / 100 % 60;
							ms = t % 100;
//							mm = (t / 1000) / 3600;
//							ss = ((t/1000) % 3600) /60 ;
//							ms = (t/1000) % 60;
							 
							try {
								Thread.sleep(10);
								
								w4.setText(String.format("%02d", ms));
								w3.setText(String.format("%02d", ss));
								w2.setText(String.format("%02d", mm));
								w1.setText(String.format("%02d", hr));
								t++;
								count++;
							} catch(InterruptedException e1) {
							}
						}
					}
				});
				
				display.start();
			}
			else if(s.equals("PAUSE")) {
				start.setEnabled(true);
				pause.setEnabled(false);
				reset.setEnabled(true);
				
				display = null;
			} else if(s.equals("RESET")) {
				start.setEnabled(true);
				pause.setEnabled(false);
				reset.setEnabled(false);
				
				w4.setText("00");
				w3.setText("00");
				w2.setText("00");
				w1.setText("00");
				
				t=0;
				
			}System.out.println(count);
		}
	}
	
	

	public static void main(String[] args) {
		new timerPanel();
	}
}
