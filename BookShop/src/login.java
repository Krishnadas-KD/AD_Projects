import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setBounds(100, 100, 536, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 43));
		lblNewLabel.setBounds(186, 11, 113, 58);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "sellers"}));
		comboBox.setBounds(199, 93, 80, 22);
		contentPane.add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 189, 185, 30);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password\r\n");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setBounds(95, 196, 97, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(217, 126, 185, 30);
		contentPane.add(textField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUsername.setBounds(95, 134, 97, 14);
		contentPane.add(lblUsername);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user=textField.getText();
				String passString=passwordField.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                ResultSet rs;
		                if(comboBox.getSelectedItem().toString().equals("Admin"))
		                {
		                 rs = myStmt.executeQuery("Select * from admin where Uadmin='"+user+"' and Padmin='"+passString+"'");
		                 
		                 if(rs.next())
			                {
			                
			                    JOptionPane.showMessageDialog(null, "You have successfully logged in");
			                    Mainpage newpage=new Mainpage();
								newpage.setVisible(true);
								dispose();
			                   
			    
			                }else {
			                    JOptionPane.showMessageDialog(null, "Wrong Username & Password");}
		                 
		                }
		                else {
		                	rs = myStmt.executeQuery("Select * from userdetails where uname='"+user+"' and password='"+passString+"'");
		                	
		                	 if(rs.next())
				                {
				                
				                    JOptionPane.showMessageDialog(null, "You have successfully logged in");
				                    SellingPage newpage=new SellingPage();
									newpage.setVisible(true);
									dispose();
				                   
				    
				                }else {
				                    JOptionPane.showMessageDialog(null, "Wrong Username & Password");}
		                	
		                	
						}
		               
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(186, 259, 132, 35);
		contentPane.add(btnNewButton);
	}
}
