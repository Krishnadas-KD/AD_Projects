import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellingPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_2;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellingPage frame = new SellingPage();
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
	
	
	public void tloader(String typer)
	{
		try{
		      
		      Class.forName("com.mysql.jdbc.Driver");
		      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","");
		        Statement stm=con.createStatement();
		        System.out.println(typer);
		        String csql="select * from booklist where title='"+typer+"'";
		        PreparedStatement pst=con.prepareStatement(csql);
		        ResultSet rs= pst.executeQuery();  
		        DefaultTableModel tModel2=(DefaultTableModel)table.getModel();
		        tModel2.setRowCount(0);
		        while(rs.next())
		      {
		        String  c1=rs.getString(1);
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
	public void trefresh() {
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
		        	  String  c1=rs.getString(1);
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
	
	
	
	public SellingPage() {
		setBounds(100, 100, 844, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSell = new JLabel("SELL");
		lblSell.setFont(new Font("Tw Cen MT", Font.BOLD, 43));
		lblSell.setBounds(289, 11, 98, 39);
		contentPane.add(lblSell);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(34, 121, 394, 250);
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
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(34, 78, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(94, 75, 142, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("S");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tloader(textField.getText());
			}
		});
		btnNewButton.setBounds(261, 74, 52, 23);
		contentPane.add(btnNewButton);
		
		JButton btnR = new JButton("R");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trefresh();
			}
		});
		btnR.setBounds(335, 74, 52, 23);
		contentPane.add(btnR);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(541, 207, 72, 25);
		contentPane.add(lblId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(623, 209, 130, 22);
		contentPane.add(textField_2);
		
		JLabel lblBilling = new JLabel("Billing");
		lblBilling.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblBilling.setBounds(622, 90, 82, 39);
		contentPane.add(lblBilling);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(30, 382, 533, 126);
		contentPane.add(scrollPane_1_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Title", "Author", "Quantity", "Price"
			}
		));
		
		scrollPane_1_1.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(599, 291, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Print total");
		btnNewButton_1_1.setBounds(623, 407, 111, 46);
		contentPane.add(btnNewButton_1_1);
		trefresh();
		JButton btnNewButton_1_2 = new JButton("Back");
		btnNewButton_1_2.setBounds(729, 485, 89, 23);
		contentPane.add(btnNewButton_1_2);
	}

}
