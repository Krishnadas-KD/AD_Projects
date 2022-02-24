import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
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
	static Login frame = new Login();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
		
        
        
        
        
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUsername.setBounds(27, 86, 97, 14);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(159, 79, 185, 30);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 141, 185, 30);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String user=textField.getText();
				String passString=passwordField.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gramapanchayath",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                ResultSet rs = myStmt.executeQuery("Select * from login where user='"+user+"' and password='"+passString+"'");
		                if(rs.next())
		                {
		                	
		                    JOptionPane.showMessageDialog(null, "You have successfully logged in");
		                    dispose();
		                    Mainpage page= new Mainpage();
		                    page.setVisible(true);
		                    frame.setVisible(false);
		    
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
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(169, 200, 132, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblPassword = new JLabel("Password\r\n");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setBounds(27, 148, 97, 14);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 42));
		lblNewLabel.setBounds(163, 11, 138, 48);
		contentPane.add(lblNewLabel);
	}
}
