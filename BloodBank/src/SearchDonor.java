import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchDonor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDonor frame = new SearchDonor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public void tloader(String typer)
	{
		try{
		      
		      Class.forName("com.mysql.jdbc.Driver");
		      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
		        Statement stm=con.createStatement();
		        System.out.println(typer);
		        String csql="select * from donerdetails where bloodgroup='"+typer+"'";
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
		        String c7=rs.getString(7);
		        String c8=rs.getString(8);
		        String c9=rs.getString(9);
		        String c10=rs.getString(10);
		        String data[]= {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};
		        
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
		      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
		        Statement stm=con.createStatement();
		        String csql="select * from donerdetails";
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
				        String c7=rs.getString(7);
				        String c8=rs.getString(8);
				        String c9=rs.getString(9);
				        String c10=rs.getString(10);
			        String data[]= {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};
			        
			        tModel2.addRow(data);
		      
		      }
		      
		      con.close();
		    }
		    catch (Exception e2) {
		      e2.printStackTrace();
		      
		      
		    }
	}
	public SearchDonor() {
		
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDonorSearch = new JLabel("Donor Search");
		lblDonorSearch.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDonorSearch.setBounds(211, 11, 212, 46);
		contentPane.add(lblDonorSearch);
		
		textField = new JTextField();
		textField.setBounds(114, 86, 321, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tloader(textField.getText().toString());
			}
		});
		btnNewButton.setBounds(461, 85, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 144, 611, 273);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Full Name", "Father Name", "Mother Name", "DOB", "Mobile No", "Gender", "Email", "BloodGroup", "City", "Address"
			}
		));
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Blood Group");
		lblNewLabel.setBounds(41, 89, 63, 14);
		contentPane.add(lblNewLabel);
		trefresh();
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				trefresh();
			}
		});
		btnNewButton_1.setBounds(585, 85, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage newpage=new Homepage();
                newpage.setVisible(true);
                dispose();
			}
		});
		btnNewButton_2.setBounds(585, 428, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
