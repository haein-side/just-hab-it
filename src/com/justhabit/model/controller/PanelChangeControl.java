package com.justhabit.model.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelChangeControl {

	public static void changePanel(JFrame jf, JPanel oldp, JPanel newp) {
		jf.remove(oldp);
		jf.add(newp);
		jf.repaint();
	}
	
}
