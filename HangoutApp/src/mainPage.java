import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class mainPage {

	private JFrame frame;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage window = new mainPage();
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
	public mainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 418, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGhmjk = new JLabel("");
		lblGhmjk.setBounds(164, 15, 0, 0);
		lblGhmjk.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblGhmjk);
		
		JLabel lblNewLabel = new JLabel("UserID");
		lblNewLabel.setBounds(59, 101, 64, 21);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane idd = new JTextPane();
		idd.setBounds(149, 101, 185, 21);
		frame.getContentPane().add(idd);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(59, 163, 64, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnSignIn = new JButton("Sign-In");
		btnSignIn.setBounds(48, 247, 141, 35);
		frame.getContentPane().add(btnSignIn);
		btnSignIn.doClick();
		
		JButton login = new JButton("Log-in");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","1234");
					Statement stmt= con.createStatement();
					String sql = "select userId from table1 where userId='"+idd.getText();
				    String sql2 = "select pass from table1 where pass='"+pass.getText();
				    ResultSet rs =stmt.executeQuery(sql);
				    ResultSet rs2 = stmt.executeQuery(sql2);
				    if(rs.next()&& rs2.next())
				    	JOptionPane.showMessageDialog(null, "logged in");
				    else
				    	JOptionPane.showMessageDialog(null, "wrong pass or id");
				    con.close();
							
					
					
					
					
					
				}
					catch(Exception e) {System.out.println(e);}
				}
			
		});
		login.setBounds(210, 247, 141, 35);
		frame.getContentPane().add(login);
		
		pass = new JTextField();
		pass.setBounds(148, 163, 186, 24);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
	}
}
