import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DonorPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorPage frame = new DonorPage();
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
	public DonorPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDonorDetailes = new JLabel("Donor Detailes");
		lblDonorDetailes.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDonorDetailes.setBounds(242, 38, 212, 46);
		contentPane.add(lblDonorDetailes);
		
		JLabel lblNewLabel = new JLabel("Full Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(49, 156, 78, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(152, 154, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFatherName.setBounds(49, 199, 93, 14);
		contentPane.add(lblFatherName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 197, 144, 20);
		contentPane.add(textField_1);
		
		JLabel lblMotherName = new JLabel("Mother Name");
		lblMotherName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMotherName.setBounds(49, 240, 93, 14);
		contentPane.add(lblMotherName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(152, 238, 144, 20);
		contentPane.add(textField_2);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDob.setBounds(49, 291, 78, 14);
		contentPane.add(lblDob);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(152, 289, 144, 20);
		contentPane.add(textField_3);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMobileNo.setBounds(49, 341, 78, 14);
		contentPane.add(lblMobileNo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(152, 339, 144, 20);
		contentPane.add(textField_4);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setBounds(49, 391, 78, 14);
		contentPane.add(lblGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(366, 158, 78, 14);
		contentPane.add(lblEmail);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(469, 156, 144, 20);
		contentPane.add(textField_6);
		
		JLabel lblBloodgroup = new JLabel("BloodGroup");
		lblBloodgroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBloodgroup.setBounds(366, 201, 78, 14);
		contentPane.add(lblBloodgroup);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(469, 199, 144, 20);
		contentPane.add(textField_7);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCity.setBounds(366, 242, 78, 14);
		contentPane.add(lblCity);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(469, 240, 144, 20);
		contentPane.add(textField_8);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(366, 287, 78, 14);
		contentPane.add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(469, 291, 130, 90);
		contentPane.add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(152, 388, 130, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=textField.getText();
				String fathername=textField_1.getText();
				String mothername=textField_2.getText();
				String dob=textField_3.getText();
				String mobileno=textField_4.getText();
				String gender=comboBox.getSelectedItem().toString();
				String email=textField_6.getText();
				String bloodgroup=textField_7.getText();
				String city=textField_8.getText();
				String address=editorPane.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                int rs = myStmt.executeUpdate("insert into donerdetails values('"+fname+"','"+fathername+"','"+mothername+"','"+dob+"','"+mobileno+"','"+gender+"','"+email+"','"+bloodgroup+"','"+city+"','"+address+"')");
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
		btnNewButton.setBounds(53, 482, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(207, 482, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				comboBox.setSelectedIndex(0);
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				editorPane.setText("");
				
			}
		});
		btnReset.setBounds(365, 482, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage newpage=new Homepage();
                newpage.setVisible(true);
                dispose();
			}
		});
		btnBack.setBounds(510, 482, 89, 23);
		contentPane.add(btnBack);
	}
}
