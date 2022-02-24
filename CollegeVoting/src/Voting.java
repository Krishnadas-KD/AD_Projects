import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Voting extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox,comboBox_1,comboBox_1_1,comboBox_1_1_1,comboBox_1_1_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voting frame = new Voting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Voting() {
		
		
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVoting = new JLabel("Voting");
		lblVoting.setFont(new Font("Cambria", Font.BOLD, 21));
		lblVoting.setBounds(271, 11, 124, 46);
		contentPane.add(lblVoting);
		
		JLabel lblRedNo = new JLabel("Red No");
		lblRedNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRedNo.setBounds(32, 96, 108, 19);
		contentPane.add(lblRedNo);
		
		JLabel lblNewLabel_1 = new JLabel(":\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(119, 98, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(175, 97, 174, 20);
		contentPane.add(textField);
		
		JButton btnProcessed = new JButton("Processed");
		btnProcessed.setBounds(538, 96, 97, 23);
		contentPane.add(btnProcessed);
		
		JLabel lblNewLabel = new JLabel("Chairman");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(32, 179, 108, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblWiseChairman = new JLabel("Wise Chairman");
		lblWiseChairman.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWiseChairman.setBounds(32, 248, 129, 19);
		contentPane.add(lblWiseChairman);
		
		JLabel lblLvc = new JLabel("LVC\r\n");
		lblLvc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLvc.setBounds(32, 321, 61, 19);
		contentPane.add(lblLvc);
		
		JLabel lblWiseChairman_1_1 = new JLabel("Magazin Editor");
		lblWiseChairman_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWiseChairman_1_1.setBounds(341, 179, 129, 19);
		contentPane.add(lblWiseChairman_1_1);
		
		JLabel lblWiseChairman_1_1_1 = new JLabel("PVC");
		lblWiseChairman_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWiseChairman_1_1_1.setBounds(341, 248, 75, 19);
		contentPane.add(lblWiseChairman_1_1_1);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBox.setBounds(160, 179, 146, 22);
		contentPane.add(comboBox);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBox_1.setBounds(160, 248, 146, 22);
		contentPane.add(comboBox_1);
		
		 comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBox_1_1.setBounds(160, 321, 146, 22);
		contentPane.add(comboBox_1_1);
		
		 comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBox_1_1_1.setBounds(462, 248, 146, 22);
		contentPane.add(comboBox_1_1_1);
		
		 comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {}));
		comboBox_1_1_1_1.setBounds(462, 179, 146, 22);
		contentPane.add(comboBox_1_1_1_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main pageMain=new Main();
				pageMain.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(448, 414, 89, 23);
		contentPane.add(btnNewButton);
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/voting",
	                "root", "");
	         java.sql.Statement myStmt =connection.createStatement();
	         ResultSet rschairman = myStmt.executeQuery("Select * from chairman");
	         while(rschairman.next())
	         {
	        	 comboBox.addItem(rschairman.getString(1));
	         }
	         ResultSet rswisechairman = myStmt.executeQuery("Select * from wisechairman");
	         while(rswisechairman.next())
	         {
	        	 comboBox_1.addItem(rswisechairman.getString(1));
	         }
	         ResultSet rslvc = myStmt.executeQuery("Select * from lvc");
	         while(rslvc.next())
	         {
	        	 comboBox_1_1.addItem(rslvc.getString(1));
	         }
	         ResultSet rsMeditor = myStmt.executeQuery("Select * from Meditor");
	         while(rsMeditor.next())
	         {
	        	 comboBox_1_1_1_1.addItem(rsMeditor.getString(1));
	         }
	         ResultSet rsPVC = myStmt.executeQuery("Select * from PVC");
	         while(rsPVC.next())
	         {
	        	 comboBox_1_1_1.addItem(rsPVC.getString(1));
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
