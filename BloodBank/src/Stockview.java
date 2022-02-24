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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stockview extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stockview frame = new Stockview();
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
	public Stockview() {

		
	
		
		
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDonorSearch = new JLabel("Stock View");
		lblDonorSearch.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDonorSearch.setBounds(211, 11, 212, 46);
		contentPane.add(lblDonorSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 105, 611, 273);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Blood Group", "Unit"
			}
		));
		try{
		      
		      Class.forName("com.mysql.jdbc.Driver");
		      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");
		        Statement stm=con.createStatement();
		        String csql="select * from blood";
		        PreparedStatement pst=con.prepareStatement(csql);
		        ResultSet rs= pst.executeQuery();  
		        DefaultTableModel tModel2=(DefaultTableModel)table.getModel();
		        tModel2.setRowCount(0);
		        while(rs.next())
		      {
		        	  String  c1=rs.getString(1);
				        String  c2=rs.getString(2);

			        String data[]= {c1,c2};
			        
			        tModel2.addRow(data);
		      
		      }
		      
		      con.close();
		    }
		    catch (Exception e2) {
		      e2.printStackTrace();
		      
		      
		    }
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage newpage=new Homepage();
                newpage.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setBounds(549, 413, 89, 23);
		contentPane.add(btnNewButton);
	}

}
