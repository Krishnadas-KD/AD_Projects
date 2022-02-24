import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Viewwardmember extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static Viewwardmember frame = new Viewwardmember();
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
	public Viewwardmember() {

		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 74, 514, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ward Number", "Number", "Name", "Address", "Category", "Pension", "Mobile No."
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(131);
		scrollPane.setViewportView(table);
		
		
try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gramapanchayath","root","");
		    Statement stm=con.createStatement();
		    String csql="select * from wardmember";
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

				String data[]= {c1,c2,c3,c4,c5,c6,c7};
				
				tModel2.addRow(data);
			
			}
			
			con.close();
		}
		catch (Exception e2) {
			e2.printStackTrace();
			
			
		}
		
		JLabel lblView = new JLabel("View Detailes");
		lblView.setForeground(Color.BLACK);
		lblView.setFont(new Font("Goudy Old Style", Font.BOLD, 42));
		lblView.setBounds(183, 15, 276, 48);
		contentPane.add(lblView);
		
		JButton btnNewButton = new JButton("Back\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wardmember paWard=new wardmember();
				paWard.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(449, 527, 89, 23);
		contentPane.add(btnNewButton);
	}
}
