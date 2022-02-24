import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ward extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblWardName;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNumberOfHouse;
	private JTextField textField_3;
	private JLabel lblNewLabel_6;
	private JLabel lblTotalMembers;
	private JButton btnNewButton;
	private JButton btnEdit;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_1;
	static ward frame = new ward();
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
	public ward() {
	
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWard = new JLabel("WARD\r\n");
		lblWard.setForeground(Color.BLACK);
		lblWard.setFont(new Font("Goudy Old Style", Font.BOLD, 42));
		lblWard.setBounds(197, 42, 147, 48);
		contentPane.add(lblWard);
		
		textField = new JTextField();
		textField.setBounds(257, 132, 197, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ward Number");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(80, 132, 115, 28);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(":\r\n");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(219, 132, 28, 28);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(257, 210, 197, 31);
		contentPane.add(textField_1);
		
		lblNewLabel_2 = new JLabel(":\r\n");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(219, 210, 28, 28);
		contentPane.add(lblNewLabel_2);
		
		lblWardName = new JLabel("Ward Name");
		lblWardName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblWardName.setBounds(80, 210, 115, 28);
		contentPane.add(lblWardName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(257, 287, 197, 31);
		contentPane.add(textField_2);
		
		lblNewLabel_4 = new JLabel(":\r\n");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(219, 287, 28, 28);
		contentPane.add(lblNewLabel_4);
		
		lblNumberOfHouse = new JLabel("Number of House");
		lblNumberOfHouse.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNumberOfHouse.setBounds(80, 287, 129, 28);
		contentPane.add(lblNumberOfHouse);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(257, 378, 197, 31);
		contentPane.add(textField_3);
		
		lblNewLabel_6 = new JLabel(":\r\n");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(219, 378, 28, 28);
		contentPane.add(lblNewLabel_6);
		
		lblTotalMembers = new JLabel("Total members");
		lblTotalMembers.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTotalMembers.setBounds(80, 378, 115, 28);
		contentPane.add(lblTotalMembers);
		
		btnNewButton = new JButton("ADD\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String wardnumberString=textField.getText();
				String wardname=textField_1.getText();
				String housenumbers=textField_2.getText();
				String totalnumber=textField_3.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gramapanchayath",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                int rs = myStmt.executeUpdate("insert into ward values('"+wardnumberString+"','"+wardname+"',"+housenumbers+","+totalnumber+")");
		                if(rs==1)
		                {
		                
		                    JOptionPane.showMessageDialog(null, "Row added successfully");

		                }else {
		                    JOptionPane.showMessageDialog(null, "Wrong input");}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(64, 466, 87, 23);
		contentPane.add(btnNewButton);
		
		btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEdit.setBounds(197, 466, 87, 23);
		contentPane.add(btnEdit);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(64, 516, 87, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpage page= new Mainpage();
                page.setVisible(true);
                dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(197, 516, 87, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_1 = new JButton("View\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Viewward paWard=new Viewward();
				paWard.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(409, 466, 96, 60);
		contentPane.add(btnNewButton_1);
	}
}
