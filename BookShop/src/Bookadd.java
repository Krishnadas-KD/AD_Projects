import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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

public class Bookadd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookadd frame = new Bookadd();
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
		    String csql="select * from booklist";
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
				String c5=rs.getString(5);
				String c6=rs.getString(6);
				String data[]= {c1,c2,c3,c4,c5,c6};
				
				tModel2.addRow(data);
			
			}
			
			con.close();
		}
		catch (Exception e2) {
			e2.printStackTrace();
			
			
		}
	}
	public Bookadd() {
		
		setBounds(100, 100, 687, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserDetails = new JLabel("Add Book");
		lblUserDetails.setFont(new Font("Tw Cen MT", Font.BOLD, 43));
		lblUserDetails.setBounds(237, 11, 257, 58);
		contentPane.add(lblUserDetails);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(259, 92, 394, 298);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Title", "Author", "Category", "Quantity", "Price"
			}
		));
		scrollPane_1.setViewportView(table);
		tloader();
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(92, 113, 130, 22);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(92, 149, 130, 22);
		contentPane.add(textField_1);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthor.setBounds(10, 146, 72, 25);
		contentPane.add(lblAuthor);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitle.setBounds(10, 110, 47, 25);
		contentPane.add(lblTitle);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title=textField.getText();
				String author=textField_1.getText();
				String catogory=textField_2.getText();
				String quantity=textField_4.getText();
				String price=textField_5.getText();

				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop",
		                    "root", "");
		                java.sql.Statement myStmt =connection.createStatement();
		                int rs = myStmt.executeUpdate("insert into booklist(title,author,category,quantity,price) values('"+title+"','"+author+"','"+catogory+"','"+quantity+"','"+price+"')");
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
		btnNewButton.setBounds(92, 320, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Mainpage newpage=new Mainpage();
				newpage.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(564, 426, 89, 23);
		contentPane.add(btnBack);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(92, 185, 130, 22);
		contentPane.add(textField_2);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategory.setBounds(10, 182, 72, 25);
		contentPane.add(lblCategory);
		
		JLabel lblCategory_1_1 = new JLabel("Quantity");
		lblCategory_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategory_1_1.setBounds(10, 218, 72, 25);
		contentPane.add(lblCategory_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(92, 221, 130, 22);
		contentPane.add(textField_4);
		
		JLabel lblCategory_1_1_1 = new JLabel("Price");
		lblCategory_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategory_1_1_1.setBounds(10, 254, 72, 25);
		contentPane.add(lblCategory_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(92, 257, 130, 22);
		contentPane.add(textField_5);
	}

}
