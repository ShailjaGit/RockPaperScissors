package com.sp.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;


public class RSPFrame extends JFrame {

	private JPanel contentPane;
	private String[] arr = {"Rock","Paper","Scissors"};
	Random index = new Random();
	

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) {
	 * System.out.println("RSPFrame.main()"); EventQueue.invokeLater(new Runnable()
	 * { public void run() { try { RSPFrame frame = new RSPFrame();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */
	/**
	 * Create the frame.
	 */
	public RSPFrame() {
		setBackground(Color.GREEN);	
		System.out.println("RSPFrame.RSPFrame()");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 338);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome :) "+RegisterFrame.userName);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 39, 424, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Your Choice");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(146, 179, 168, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Rock");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(127, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int computerChoice = index.nextInt(arr.length); 
				System.out.println(computerChoice);
				if(computerChoice==0) {
					JOptionPane.showMessageDialog(btnNewButton, "You chosen Rock and computer chosen Rock\nboth palyers selected same it's die!");
				}
				if(computerChoice==1) {
					JOptionPane.showMessageDialog(btnNewButton, "You chosen Rock and computer chosen Paper\nPaper covers rock! You lose");
				}	
				if(computerChoice==2) {
					JOptionPane.showMessageDialog(btnNewButton, "You chosen Rock and computer chosen Scirros\nRock smashes scissors! You win!");
				}
			}
		});
		btnNewButton.setBounds(59, 204, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Paper");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int computerChoice = index.nextInt(arr.length); 
				System.out.println(computerChoice);
				if(computerChoice==0) {
					JOptionPane.showMessageDialog(btnNewButton, "You chosen Paper and computer chosen Rock\nPaper covers rock! You win!!");
				}
				if(computerChoice==1) {
					JOptionPane.showMessageDialog(btnNewButton, "You chosen Paper and computer chosen Paper\nboth palyers selected same it's die!!");
				}	
				if(computerChoice==2) {
					JOptionPane.showMessageDialog(btnNewButton, "You chosen Paper and computer chosen Scissors\nScissors cuts paper! You lose");
				}
			}
		});
		btnNewButton_1.setBounds(180, 252, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Scissors");
		btnNewButton_2.setBackground(new Color(255, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int computerChoice = index.nextInt(arr.length); 
				System.out.println(computerChoice);
				if(computerChoice==0) {
					JOptionPane.showMessageDialog(btnNewButton, "You chosen Scissors and computer chosen Rock\nRock smashes scirrors! you lose");
				}
				if(computerChoice==1) {
					JOptionPane.showMessageDialog(btnNewButton, "You chosen Scissors and computer chosen Paper\nScissors cuts paper! You win!");
				}	
				if(computerChoice==2) {
					JOptionPane.showMessageDialog(btnNewButton, "You chosen Scissors and computer chosen Scissors\nboth palyers selected same it's die!!");
				}
			}
		});
		btnNewButton_2.setBounds(304, 204, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JTextPane txtpnTheRulesAre = new JTextPane();
		txtpnTheRulesAre.setEditable(false);
		txtpnTheRulesAre.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnTheRulesAre.setBackground(Color.BLACK);
		txtpnTheRulesAre.setForeground(new Color(255, 165, 0));
		txtpnTheRulesAre.setText("The Rules Are Straightforward:\r\n====================\r\n\t1.rock smashes scissors.\r\n\t2.paper covers rock.\r\n\t3.scissors cuts paper.");
		txtpnTheRulesAre.setBounds(94, 64, 299, 88);
		contentPane.add(txtpnTheRulesAre);
		
	}
}
