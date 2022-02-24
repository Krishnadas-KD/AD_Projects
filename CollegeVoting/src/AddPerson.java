import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddPerson extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPerson frame = new AddPerson();
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
	public AddPerson() {

		setBounds(100, 100, 550, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Add Person");
		lblAddPerson.setFont(new Font("Cambria", Font.BOLD, 21));
		lblAddPerson.setBounds(201, 11, 124, 46);
		contentPane.add(lblAddPerson);
		
		JLabel lblNewLabel = new JLabel("Chairman");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(27, 83, 108, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblWiseChairman = new JLabel("Wise Chairman");
		lblWiseChairman.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWiseChairman.setBounds(27, 122, 129, 19);
		contentPane.add(lblWiseChairman);
		
		JLabel lblLvc = new JLabel("LVC\r\n");
		lblLvc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLvc.setBounds(27, 166, 129, 19);
		contentPane.add(lblLvc);
		
		JLabel lblWiseChairman_1_1 = new JLabel("Magazin Editor");
		lblWiseChairman_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWiseChairman_1_1.setBounds(27, 207, 129, 19);
		contentPane.add(lblWiseChairman_1_1);
		
		JLabel lblWiseChairman_1_1_1 = new JLabel("PVC");
		lblWiseChairman_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWiseChairman_1_1_1.setBounds(27, 248, 129, 19);
		contentPane.add(lblWiseChairman_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel(":\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(185, 83, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(":\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(185, 124, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(":\r\n");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(185, 168, 46, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(":\r\n");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(185, 209, 46, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel(":\r\n");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(185, 250, 46, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(220, 84, 174, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(220, 123, 174, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(220, 167, 174, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(220, 208, 174, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(220, 249, 174, 20);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Add\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user=textField.getText();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/voting",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                int rs = myStmt.executeUpdate("Insert into chairman values('"+user+"',0)");
		                	
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
				
			}
			
		});
		btnNewButton.setBounds(419, 83, 72, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textField_1.getText();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/voting",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                int rs = myStmt.executeUpdate("Insert into wisechairman values('"+user+"',0)");
		                	
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
				
			}

		});
		btnNewButton_1.setBounds(419, 122, 72, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Add\r\n");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textField_2.getText();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/voting",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                int rs = myStmt.executeUpdate("Insert into lvc values('"+user+"',0)");
		                	
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
				
			}
		
		});
		btnNewButton_1_1.setBounds(419, 166, 72, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Add\r\n");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user=textField_3.getText();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/voting",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                int rs = myStmt.executeUpdate("Insert into Meditor values('"+user+"',0)");
		                	
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
				
			}
			
		});
		btnNewButton_1_1_1.setBounds(419, 207, 72, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Add\r\n");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textField_4.getText();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/voting",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                int rs = myStmt.executeUpdate("Insert into PVC values('"+user+"',0)");
		                	
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
				
			}
			
		});
		btnNewButton_1_1_1_1.setBounds(419, 248, 72, 23);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main pageMain=new Main();
				pageMain.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(402, 307, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
