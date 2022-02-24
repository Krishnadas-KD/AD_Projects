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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Counting extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counting frame = new Counting();
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
	public Counting() {

		
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCounting = new JLabel("Counting");
		lblCounting.setFont(new Font("Cambria", Font.BOLD, 21));
		lblCounting.setBounds(239, 11, 124, 31);
		contentPane.add(lblCounting);
		
		JLabel lblPosts = new JLabel("Post's");
		lblPosts.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPosts.setBounds(21, 96, 80, 19);
		contentPane.add(lblPosts);
		
		JButton btnProcessed = new JButton("Processed");
		btnProcessed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tnameString=(String) comboBox.getSelectedItem();
				
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","");
			    Statement stm=con.createStatement();
			    DefaultTableModel tModel2=(DefaultTableModel)table.getModel();
			    tModel2.setRowCount(0);
			    
			    
			    if (tnameString=="chairman")
			    {
			    	String csql="select * from chairman";
				    PreparedStatement pst=con.prepareStatement(csql);
				    ResultSet rs= pst.executeQuery();	
				    while(rs.next())
					{
						String  c1=rs.getString(1);
						String  c2=rs.getString(2);

						
						String data[]= {c1,c2};
						
						tModel2.addRow(data);
					
					}
			    }
			    if (tnameString=="lvc")
			    {
			    	String csql="select * from lvc";
				    PreparedStatement pst=con.prepareStatement(csql);
				    ResultSet rs= pst.executeQuery();	
				    while(rs.next())
					{
						String  c1=rs.getString(1);
						String  c2=rs.getString(2);

						
						String data[]= {c1,c2};
						
						tModel2.addRow(data);
					
					}
			    }
			    if (tnameString=="Megazin editor")
			    {
			    	String csql="select * from meditor";
				    PreparedStatement pst=con.prepareStatement(csql);
				    ResultSet rs= pst.executeQuery();	
				    while(rs.next())
					{
						String  c1=rs.getString(1);
						String  c2=rs.getString(2);

						
						String data[]= {c1,c2};
						
						tModel2.addRow(data);
					
					}
			    }
			    if (tnameString=="pvc")
			    {
			    	String csql="select * from pvc";
				    PreparedStatement pst=con.prepareStatement(csql);
				    ResultSet rs= pst.executeQuery();	
				    while(rs.next())
					{
						String  c1=rs.getString(1);
						String  c2=rs.getString(2);

						
						String data[]= {c1,c2};
						
						tModel2.addRow(data);
					
					}
			    }
			    
			    if (tnameString=="Wise chairman")
			    {
			    	String csql="select * from wisechairman";
				    PreparedStatement pst=con.prepareStatement(csql);
				    ResultSet rs= pst.executeQuery();	
				    while(rs.next())
					{
						String  c1=rs.getString(1);
						String  c2=rs.getString(2);

						
						String data[]= {c1,c2};
						
						tModel2.addRow(data);
					
					}
			    }
			    
			    
			   
				
				con.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
				
				
			}
			}
				
		});
		btnProcessed.setBounds(363, 96, 97, 23);
		contentPane.add(btnProcessed);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"chairman", "lvc", "Megazin editor", "pvc", "Wise chairman"}));
		comboBox.setBounds(140, 96, 146, 22);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 160, 486, 148);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Votes Obtained"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main pageMain=new Main();
				pageMain.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_2.setBounds(464, 327, 89, 23);
		contentPane.add(btnNewButton_2);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
	}
}
