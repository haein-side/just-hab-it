package com.justhabit.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginFrame {

	private JFrame frame;
	
	private Image ic_logo = new ImageIcon("images/login.png").getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	
	private int x, y;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		LoginPanel circlePanel = new LoginPanel(Color.LIGHT_GRAY, Color.DARK_GRAY);
		circlePanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getX() + e.getX() - x, frame.getY() + e.getY() - y);
			}
		});
		circlePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
			}
		});
		circlePanel.setBounds(0, 0, 400, 400);
		circlePanel.setArc(circlePanel.getWidth());
		circlePanel.setBorderColor(Color.white);
		circlePanel.setBorderWidth(2);
		frame.getContentPane().add(circlePanel);
		circlePanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ic_logo));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(78, 71, 234, 160);
		circlePanel.add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("W E L C O M E");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(78, 242, 234, 36);
		circlePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("JUST HAB IT");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(78, 290, 234, 36);
		circlePanel.add(lblNewLabel_1);
		
		LoginPanel contentPanel = new LoginPanel(Color.decode("#e65758"), Color.decode("#771d32"),LoginPanel.DIAGONAL_DOWN);
		contentPanel.setArc(10);
		contentPanel.setBorderColor(Color.white);
		contentPanel.setBorderWidth(2);
		contentPanel.setBounds(200, 50, 500, 320);
		frame.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(229, 87, 250, 50);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(10, 11, 230, 28);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.setBorder(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(229, 173, 250, 50);
		contentPanel.add(panel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(10, 11, 230, 28);
		panel_1.add(txtPassword);
		txtPassword.setBorder(null);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(229, 62, 250, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(229, 148, 250, 14);
		contentPanel.add(lblNewLabel_2_1);
		
		JButton loginButton = new JButton("LOG IN");
		loginButton.setBounds(220, 234, 130, 30);
		contentPanel.add(loginButton);
		
		JButton signupButton = new JButton("SIGN UP");
		signupButton.setBounds(355, 234, 130, 30);
		contentPanel.add(signupButton);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(229, 25, 115, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("X");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure to close this application ?") == 0)
					System.exit(0);
			}
		});
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(469, 11, 21, 28);
		contentPanel.add(lblNewLabel_3_1);
		
	}
	
}
