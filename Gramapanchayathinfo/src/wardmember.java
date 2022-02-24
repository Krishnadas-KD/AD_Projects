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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class wardmember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_3;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JButton btnEdit;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_7_1_2;
	private JLabel lblNewLabel_6_1_2;
	private JTextField textField_6;
	static wardmember frame = new wardmember();
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
	public wardmember() {

		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWard = new JLabel("WARD\r\n MEMBER");
		lblWard.setForeground(Color.BLACK);
		lblWard.setFont(new Font("Goudy Old Style", Font.BOLD, 42));
		lblWard.setBounds(93, 42, 330, 48);
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
		textField_1.setBounds(257, 174, 197, 31);
		contentPane.add(textField_1);
		
		lblNewLabel_2 = new JLabel(":\r\n");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(219, 174, 28, 28);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Number");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(80, 174, 115, 28);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(257, 216, 197, 31);
		contentPane.add(textField_2);
		
		lblNewLabel_4 = new JLabel(":\r\n");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(219, 216, 28, 28);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(80, 216, 115, 28);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(257, 258, 197, 31);
		contentPane.add(textField_3);
		
		lblNewLabel_6 = new JLabel(":\r\n");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(219, 258, 28, 28);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(80, 258, 115, 28);
		contentPane.add(lblNewLabel_7);
		
		btnNewButton = new JButton("ADD\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String wardnumberString=textField.getText();
				String number=textField_1.getText();
				String name=textField_2.getText();
				String address=textField_3.getText();
				String category=textField_4.getText();
				String pension=textField_5.getText();
				String mobno=textField_6.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gramapanchayath",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                int rs = myStmt.executeUpdate("insert into wardmember values('"+wardnumberString+"','"+number+"','"+name+"','"+address+"','"+category+"','"+pension+"','"+mobno+"')");
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
				Viewwardmember paViewwardmember=new Viewwardmember();
				paViewwardmember.setVisible(true);
				 frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(409, 466, 96, 60);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Category");
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7_1.setBounds(80, 302, 115, 28);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_6_1 = new JLabel(":\r\n");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6_1.setBounds(219, 302, 28, 28);
		contentPane.add(lblNewLabel_6_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(257, 302, 197, 31);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Pension");
		lblNewLabel_7_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7_1_1.setBounds(80, 341, 115, 28);
		contentPane.add(lblNewLabel_7_1_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel(":\r\n");
		lblNewLabel_6_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6_1_1.setBounds(219, 341, 28, 28);
		contentPane.add(lblNewLabel_6_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(257, 341, 197, 31);
		contentPane.add(textField_5);
		
		lblNewLabel_7_1_2 = new JLabel("Mobile Number");
		lblNewLabel_7_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7_1_2.setBounds(80, 380, 115, 28);
		contentPane.add(lblNewLabel_7_1_2);
		
		lblNewLabel_6_1_2 = new JLabel(":\r\n");
		lblNewLabel_6_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6_1_2.setBounds(219, 380, 28, 28);
		contentPane.add(lblNewLabel_6_1_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(257, 380, 197, 31);
		contentPane.add(textField_6);
	}
}
