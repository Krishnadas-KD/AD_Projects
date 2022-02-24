import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConverter = new JLabel("Converter");
		lblConverter.setForeground(Color.GRAY);
		lblConverter.setFont(new Font("Courier New", Font.BOLD, 42));
		lblConverter.setBounds(106, 32, 237, 48);
		contentPane.add(lblConverter);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(28, 112, 133, 48);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(28, 251, 133, 48);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add newpageAdd=new add();
				newpageAdd.setVisible(true);
			}
		});
		btnNewButton.setBounds(365, 338, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Float c1value = null,c2value = null;
				String C1=(String) comboBox.getSelectedItem();
				String C2=(String) comboBox_1.getSelectedItem();
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/currency",
	                    "root", "");
	                java.sql.Statement myStmt =connection.createStatement();
	                ResultSet rs = myStmt.executeQuery("Select * from currency where Cname='"+C1+"'");
	                
	                while(rs.next())
	   	         	{
	                	c1value=rs.getFloat(2);
	   	         	}
	                ResultSet rs2 = myStmt.executeQuery("Select * from currency where Cname='"+C2+"'");
	                while(rs2.next())
	   	         	{
	                	c2value=rs2.getFloat(2);
	   	         	}
	                Float exchangerate=c1value/c2value;
	                Float aFloat=Float.parseFloat(textField.getText());
	                Float covertedvalueFloat=exchangerate*aFloat;
	                textField_1.setText(covertedvalueFloat.toString());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		btnConvert.setBounds(259, 201, 89, 23);
		contentPane.add(btnConvert);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(259, 115, 143, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBounds(259, 251, 143, 48);
		contentPane.add(textField_1);
		
		
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/currency",
	                "root", "");
	         java.sql.Statement myStmt =connection.createStatement();
	         ResultSet rs = myStmt.executeQuery("Select * from currency");
	         while(rs.next())
	         {
	        	 comboBox.addItem(rs.getString(1));
	        	 comboBox_1.addItem(rs.getString(1));
	         }

	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
