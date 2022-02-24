import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(156, 78, 185, 30);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 141, 185, 30);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password\r\n");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setBounds(34, 148, 97, 14);
		contentPane.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUsername.setBounds(34, 86, 97, 14);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 42));
		lblNewLabel.setBounds(170, 11, 138, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user=textField.getText();
				String passString=passwordField.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank",
		                    "root", "");
		            java.sql.Statement myStmt =connection.createStatement();
		            ResultSet rs = myStmt.executeQuery("Select * from log where username='"+user+"' and password='"+passString+"'");
		                if(rs.next())
		                {
		                
		                    JOptionPane.showMessageDialog(null, "You have successfully logged in");
		                    Homepage newpage=new Homepage();
		                    newpage.setVisible(true);
		                    dispose();
		    
		                }else {
		                    JOptionPane.showMessageDialog(null, "Wrong Username & Password");}
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
		btnNewButton.setBounds(156, 215, 132, 35);
		contentPane.add(btnNewButton);
	}
}
