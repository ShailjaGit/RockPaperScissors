package com.sp.game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class RegisterFrame {
	static String userName=null;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.out.println("RegisterFrame.main(...).new Runnable() {...}.run()");
				try {
					RegisterFrame window = new RegisterFrame();
					window.frame.setVisible(true);
					window.frame.setTitle("RockPaperScirros");
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterFrame() {
		System.out.println("RegisterFrame.RegisterFrame() construtor");
		initialize();
		intializeJDBC();
	}
	
	/**
	 * Initialize JDBC
	 */
	 
	private void intializeJDBC() {
		System.out.println("RegisterFrame.intializeJDBC() JDBC");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system", "manager");	
			if(con!=null)
				System.out.println("sucessfully connected");
			else
				System.out.println("Not Sucessfully");
			
			st = con.createStatement();
			if(st!=null)
				System.out.println("sucessfully statement craeted");
			else
				System.out.println("Not Sucessfully");
			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if(rs!=null)
						rs.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
				try {
					if(st!=null)
						st.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
				try {
					if(con!=null)
						con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		});
	
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rock:Paper:Scissors");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(130, 22, 169, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(57, 81, 125, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(57, 131, 125, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(192, 79, 107, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 129, 107, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		 //Login Button
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("RegisterFrame.initialize().new ActionListener() {...}.actionPerformed() LogIn");

				//get user details
				String username = textField.getText();
				String password = textField_1.getText();
				try {
					userName = username;
					//change input values as required for SQL query
					username = "'"+username+"'";
					password = "'"+password+"'";
					
					String LOGIN_USER_QUERY = "SELECT COUNT(*) FROM RSP_USER_TABLE WHERE USERNAME="+username+" AND PASSWORD="+password;
					System.out.println(LOGIN_USER_QUERY);
					
					
					if(st!=null)
						rs = st.executeQuery(LOGIN_USER_QUERY);
					
					//process result set object	
					if(rs!=null)
						rs.next();
						int count = rs.getInt(1);
					
					
						if(count==0) {
							System.out.println("INVALID CREDENTIALS");
							//pop up message performed 
							JOptionPane.showMessageDialog(btnNewButton, "Fisrt SingIn this user doesn't exits or\n check your username and password");
							
						}
						else {
							System.out.println("VALID CREDENTIALS");
							//create object for RSPFrame
							frame.setVisible(false);
							RSPFrame frame =  new RSPFrame();
							frame.setVisible(true);
							frame.setLocationRelativeTo(null);
							//pop up message performed 
							JOptionPane.showMessageDialog(btnNewButton, "you're sucessfully LogIn");
						}
					}
					
				catch (SQLException se) {
					se.printStackTrace();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setToolTipText("if you are already register enter you username and password to continue");
		btnNewButton.setBounds(94, 197, 89, 23);
		frame.getContentPane().add(btnNewButton);
	   
		//Register Button
		JButton btnNewButton_1 = new JButton("SignIn");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("RegisterFrame.initialize().new ActionListener() {...}.actionPerformed() SIGNIN");
				
				try {
					//get user name
					String username = textField.getText();
					String password = textField_1.getText();
					
					//change input values as required for SQL query
					username = "'"+username+"'";
					password = "'"+password+"'";
					
					String SIGNIN_USER_QUERY = "INSERT INTO RSP_USER_TABLE VALUES(RSP_SEQ.NEXTVAL,"+username+","+password+")";
					System.out.println(SIGNIN_USER_QUERY);
					
					int result = 0;
					//execute SQL query 
					if(st!=null)
						 result = st.executeUpdate(SIGNIN_USER_QUERY);
					  
					 //process execution result of pre_compied SQL query 
					  if(result==0)
						  System.out.println(" Details are not inserted");
					  else {
						  System.out.println(" Details are inserted");
					      //pop up message performed
						  JOptionPane.showMessageDialog(btnNewButton_1, "you're sucessfully SignIn \n LogIn and Cotinue...");
					  }	
				
					
				} 
				catch (SQLException se) {
					
					if(se.getErrorCode()>=1400 && se.getErrorCode()<=2800) {
						JOptionPane.showMessageDialog(btnNewButton_1, "You Not Entered \n username and password !!");
						System.out.println("You Not Enter username and password !!");
					}
					else if(se.getErrorCode()==12899) {
						JOptionPane.showMessageDialog(btnNewButton_1, "Do not insert more than column size data\n to username and password");
					}	
						se.printStackTrace();
				}
				catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setToolTipText("if you are new user first register yourself  to continue...");
		btnNewButton_1.setBounds(229, 197, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}
