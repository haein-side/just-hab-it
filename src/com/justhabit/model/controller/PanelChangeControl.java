package com.justhabit.model.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelChangeControl {

	public static JFrame mainFrame;
	
	
	   
    public static void changePanel(JPanel oldp, JPanel newp) {
      
      mainFrame.remove(oldp);
      mainFrame.add(newp);
      newp.revalidate();
      newp.repaint();
    }
   
    public static void changeFrame(JFrame oldf, JFrame newf) {
      oldf.setVisible(false);
      newf.dispose();
      newf.setVisible(true);
    }
	
}
