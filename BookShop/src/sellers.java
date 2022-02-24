import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class sellers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sellers frame = new sellers();
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
	public void tloader()
	{
try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","");
		    Statement stm=con.createStatement();
		    String csql="select * from userdetails";
		    PreparedStatement pst=con.prepareStatement(csql);
		    ResultSet rs= pst.executeQuery();	
		    DefaultTableModel tModel2=(DefaultTableModel)table.getModel();
		    tModel2.setRowCount(0);
		    while(rs.next())
			{
				String  c1=Integer.toString(rs.getInt(1));
				String  c2=rs.getString(2);
				String c3=rs.getString(3);
				String c4=rs.getString(4);
				String data[]= {c1,c2,c3,c4};
				
				tModel2.addRow(data);
			
			}
			
			con.close();
		}
		catch (Exception e2) {
			e2.printStackTrace();
			
			
		}
	}
	
	
	public sellers() {

		setBounds(100, 100, 716, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserDetails = new JLabel("User details");
		lblUserDetails.setFont(new Font("Tw Cen MT", Font.BOLD, 43));
		lblUserDetails.setBounds(253, 11, 257, 58);
		contentPane.add(lblUserDetails);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(47, 110, 47, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(129, 113, 130, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(129, 179, 130, 22);
		contentPane.add(textField_1);
		
		JLabel lblPhoneno = new JLabel("PhoneNo");
		lblPhoneno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneno.setBounds(47, 176, 72, 25);
		contentPane.add(lblPhoneno);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(47, 244, 72, 25);
		contentPane.add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 237, 142, 110);
		contentPane.add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=textField.getText();
				String phone=textField_1.getText();
				String addressString=editorPane.getText();
				String passwordString=textField_2.getText();
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                int rs = myStmt.executeUpdate("insert into userdetails(uname,uphone,uaddress,password) values('"+name+"','"+phone+"','"+addressString+"','"+passwordString+"')");
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
				tloader();
				
			}
		});
		btnNewButton.setBounds(134, 396, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(329, 92, 361, 298);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Phone no", "Address"
			}
		));
		tloader();
		scrollPane_1.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpage newpage=new Mainpage();
				newpage.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(575, 401, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(47, 358, 72, 25);
		contentPane.add(lblPassword);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(129, 361, 130, 22);
		contentPane.add(textField_2);
	}
}
