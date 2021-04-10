package com.justhabit.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.justhabit.model.controller.PanelChangeControl;
import com.justhabit.model.controller.UserController;

public class FirstFrame {
	
	UserController userController = new UserController();
	public static int loggedUserID;

   private JFrame frame ;
   private LoginPanel login;
   
   private Image ic_logo = new ImageIcon("images/login.png").getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
   private JTextField txtUsername;
   private JPasswordField txtPassword;
      
   private int x, y;
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               FirstFrame window = new FirstFrame();
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
   public FirstFrame() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {

      /* FIRST FRAME FOR LOGIN AND SIGNUP */
      frame = new JFrame();
      frame.setBounds(100, 100, 700, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setUndecorated(true);
      frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
      frame.getContentPane().setLayout(null);
      frame.setLocationRelativeTo(null);

///////////////////////////////////////////////////////////////////////////////////
      /* CIRCLEPANEL AT LEFT */
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
      
      
      /* 오른쪽에 붙이는 로그인 패널*/
      login = new LoginPanel(Color.decode("#e65758"), Color.decode("#771d32"),LoginPanel.DIAGONAL_DOWN);
      login.setArc(10);
      login.setBorderColor(Color.white);
      login.setBorderWidth(2);
      login.setBounds(200, 50, 500, 320);
      frame.getContentPane().add(login);
      login.setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      panel.setBounds(229, 87, 250, 50);
      login.add(panel);
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
      login.add(panel_1);
      
      txtPassword = new JPasswordField();
      txtPassword.setBounds(10, 11, 230, 28);
      panel_1.add(txtPassword);
      txtPassword.setBorder(null);
      
      JLabel lblNewLabel_2 = new JLabel("Username");
      lblNewLabel_2.setForeground(Color.WHITE);
      lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblNewLabel_2.setBounds(229, 62, 250, 14);
      login.add(lblNewLabel_2);
      
      JLabel lblNewLabel_2_1 = new JLabel("Password");
      lblNewLabel_2_1.setForeground(Color.WHITE);
      lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblNewLabel_2_1.setBounds(229, 148, 250, 14);
      login.add(lblNewLabel_2_1);
      
      JButton loginButton = new JButton("LOG IN");
      loginButton.setBounds(220, 234, 130, 30);
      login.add(loginButton);
     
      
      loginButton.addActionListener(new ActionListener() {
    	  
    	  @Override
    	  public void actionPerformed(ActionEvent e) {
    		  
//    		  System.out.println(new String(txtPassword.getPassword()));
    		  
    		  if(userController.loginCheck(txtUsername.getText().toLowerCase(), 
    				  new String(txtPassword.getPassword()))) {
    			    
        		  	PanelChangeControl.changeFrame(frame, new TodayWord());
    		  } else {
    			  //login failed
//    			  System.out.println("id or password wrong");
    			  JOptionPane.showMessageDialog(login, "ID or Password wrong\nPlease try again :)");
    			  txtUsername.setText("");
    			  txtPassword.setText("");
    		  }
    		  
    	  }
      });
      
      
      JButton signupButton = new JButton("SIGN UP");
      signupButton.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            PanelChangeControl.changePanel(frame, login, new SignupPanel() );
         }
      });
      
      signupButton.setBounds(355, 234, 130, 30);
      login.add(signupButton);
      
      JLabel lblNewLabel_3 = new JLabel("LOGIN");
      lblNewLabel_3.setForeground(Color.WHITE);
      lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
      lblNewLabel_3.setBounds(229, 25, 115, 14);
      login.add(lblNewLabel_3);
      
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
      login.add(lblNewLabel_3_1);
      
   }
   
   public class SignupPanel extends JPanel {
      
      private JTextField sign_username;
      private JPasswordField sign_pwd;
      private JPasswordField sign_pwd_check;
      private JTextField sign_email;
      private JTextField sign_PIN;
      
      public SignupPanel() {
         /* 오른쪽에 붙이는 로그인 패널*/
         LoginPanel signup = new LoginPanel(Color.decode("#e65758"), Color.decode("#771d32"),LoginPanel.DIAGONAL_DOWN);
         signup.setArc(10);
         signup.setBorderColor(Color.white);
         signup.setBorderWidth(2);
         signup.setBounds(200, 50, 500, 320);
         frame.getContentPane().add(signup);
         signup.setLayout(null);
         

         
         sign_username = new JTextField();
         sign_username.setBackground(Color.WHITE);
         sign_username.setBounds(330, 60, 120, 20);
         signup.add(sign_username);
         txtUsername.setColumns(5);
         sign_username.setBorder(null);
         

         sign_pwd = new JPasswordField();
         sign_pwd.setBounds(330, 90, 120, 20);
         signup.add(sign_pwd);
         sign_pwd.setBorder(null);
         
         sign_pwd_check = new JPasswordField();
         sign_pwd_check.setBounds(330, 120, 120, 20);
         signup.add(sign_pwd_check);
         sign_pwd_check.setBorder(null);
         
         sign_email = new JPasswordField();
         sign_email.setBounds(330, 150, 120, 20);
         signup.add(sign_email);
         sign_email.setBorder(null);
         
         sign_PIN = new JPasswordField();
         sign_PIN.setBounds(330, 180, 120, 20);
         signup.add(sign_PIN);
         sign_PIN.setBorder(null);
         
         
         
         
         
         JLabel name_label = new JLabel("Username");
         name_label.setForeground(Color.WHITE);
         name_label.setFont(new Font("Tahoma", Font.BOLD, 16));
         name_label.setBounds(229, 60, 250, 14);
         signup.add(name_label);
         
         JLabel pass_label = new JLabel("Password");
         pass_label.setForeground(Color.WHITE);
         pass_label.setFont(new Font("Tahoma", Font.BOLD, 16));
         pass_label.setBounds(229, 90, 250, 14);
         signup.add(pass_label);
         
         JLabel re_label = new JLabel("Re-enter");
         re_label.setForeground(Color.WHITE);
         re_label.setFont(new Font("Tahoma", Font.BOLD, 16));
         re_label.setBounds(229, 120, 250, 14);
         signup.add(re_label);
         
         
         JLabel email_label = new JLabel("Email");
         email_label.setForeground(Color.WHITE);
         email_label.setFont(new Font("Tahoma", Font.BOLD, 16));
         email_label.setBounds(229, 150, 250, 14);
         signup.add(email_label);
         
         JLabel pin_label = new JLabel("PIN(4digits)");
         pin_label.setForeground(Color.WHITE);
         pin_label.setFont(new Font("Tahoma", Font.BOLD, 16));
         pin_label.setBounds(229, 185, 250, 14);
         signup.add(pin_label);
         
         
         
         
         
         
         
         
         JButton backButton = new JButton("<- BACK");
         backButton.setBounds(220, 234, 80, 30);
         signup.add(backButton);
         backButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               PanelChangeControl.changePanel(frame, signup, login );
            }
         });
         
         
         
         JButton registerButton = new JButton("REGISTER");
         registerButton.setBounds(310, 234, 140, 30);
         signup.add(registerButton);
         registerButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               PanelChangeControl.changePanel(frame, signup, login);
            }
         });
         
         
         
         JLabel register_label = new JLabel("REGISTER");
         register_label.setForeground(Color.WHITE);
         register_label.setFont(new Font("Tahoma", Font.BOLD, 20));
         register_label.setBounds(229, 25, 115, 14);
         signup.add(register_label);
         
         JLabel x_label = new JLabel("X");
         x_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if(JOptionPane.showConfirmDialog(null, "Are you sure to close this application ?") == 0)
                  System.exit(0);
            }
         });
         x_label.setHorizontalAlignment(SwingConstants.CENTER);
         x_label.setForeground(Color.WHITE);
         x_label.setFont(new Font("Tahoma", Font.BOLD, 20));
         x_label.setBounds(469, 11, 21, 28);
         signup.add(x_label);
      }
   }
}