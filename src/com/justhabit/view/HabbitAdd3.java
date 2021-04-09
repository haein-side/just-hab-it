package com.justhabit.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.justhabit.model.controller.PanelChangeControl;

public class HabbitAdd3 extends JPanel {

	private HabbitAdd3 habbitAdd3;
	
   public HabbitAdd3() {
	   
	   this.habbitAdd3 = this;

	   habbitAdd3.setLayout(null);
	   habbitAdd3.setBounds(0, 100, 900, 462);
	   habbitAdd3.setBackground(Color.lightGray);
	   habbitAdd3.setVisible(true);


	   JLabel label1 = new JLabel("3번) 어떤 요일에 하고 싶나요?");
	   
	   label1.setFont(new Font("Serif", Font.BOLD, 30));
	   label1.setSize(500,200);
	   label1.setLocation(240,0);
	   habbitAdd3.add(label1);
       
       JPanel checkPanel = new JPanel();
       checkPanel.setSize(350,50);
       checkPanel.setLocation(250,170);
       
       JCheckBox jcb[] = new JCheckBox[7];

		jcb[0] = new JCheckBox("월");
		jcb[1] = new JCheckBox("화");
		jcb[2] = new JCheckBox("수");
		jcb[3] = new JCheckBox("목");
		jcb[4] = new JCheckBox("금");
		jcb[5] = new JCheckBox("토");
		jcb[6] = new JCheckBox("일");
	


		for (int i = 0; i < jcb.length; i++) {
		    checkPanel.add(jcb[i]);
		}
		
		habbitAdd3.add(checkPanel);
		
	   JButton jbutton1 = new JButton("이전");
       jbutton1.setSize(80,50);
       jbutton1.setLocation(300, 280);
       habbitAdd3.add(jbutton1);	
       
      JButton jbutton2 = new JButton("다음");
      jbutton2.setSize(80,50);
      jbutton2.setLocation(450, 280);
      habbitAdd3.add(jbutton2);
      	
      	jbutton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PanelChangeControl.changePanel(habbitAdd3 , new HabbitAdd());
            }
         }); 
      	
      	jbutton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PanelChangeControl.changePanel(habbitAdd3 , new HabbitAdd4());
            }
         });
      	     
   }
}

