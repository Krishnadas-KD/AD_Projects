import java.awt.Dimension;


import java.awt.EventQueue;



import javax.swing.JFrame;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.lang.model.util.AbstractAnnotationValueVisitor14;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JDesktopPane;
import java.sql.*;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.SystemColor;

public class mainpage {

	JFrame frame;
	private JTextField Textname;
	private JTextField textage;
	private JButton P_entername;
	private JLabel M_name;
	private JTextField textmedicname;
	private JLabel M_quntity;
	private JTextField textitemquntity;
	private JButton medicin_enter;
	private JButton total_bill;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel Lb_name,Lb_age,Lb_date;
	private static double billprice=0;
	private JLabel billamount;
	private JList list ;
	private int ct=0;
	private static int counter=1;
	private double total=0;
	private String tablename,Vdate,Vtime;
	private int day,mont,year,sec,min,hou;
	private JTextField placename;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage window = new mainpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setEnabled(true);
	
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(42, 156, 71, 22);
		lblNewLabel.setAlignmentY(0.0f);
		
		
			Calendar calendar=new GregorianCalendar();
			 day=calendar.get(Calendar.DAY_OF_MONTH);
			 mont=calendar.get(Calendar.MONTH)+1;
			 year=calendar.get(Calendar.YEAR);
		 sec=calendar.get(Calendar.SECOND);
		 min=calendar.get(Calendar.MINUTE);
		 hou=calendar.get(Calendar.HOUR);
		Vtime=hou+":"+min+":"+sec;
		Vdate=day+"/"+mont+"/"+year;
		Textname = new JTextField();
		Textname.setBounds(111, 156, 401, 22);
		Textname.setColumns(10);
		
		JLabel P_age = new JLabel("Age");
		P_age.setBounds(530, 156, 30, 22);
		
		textage = new JTextField();
		textage.setBounds(564, 158, 104, 20);
		textage.setColumns(10);
		

		Lb_name = new JLabel("");
		Lb_age = new JLabel("");
		Lb_date = new JLabel("");
		
		
		P_entername = new JButton("create");
		P_entername.setBounds(530, 196, 89, 23);
		P_entername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar calendar=new GregorianCalendar();
				
				Lb_name.setText(Textname.getText());
				Lb_age.setText(textage.getText());
				
				Lb_date.setText(Vdate);
				try {                    
					tablename="patient0"+counter;
					
				Class.forName("com.mysql.jdbc.Driver");
				Connection conT=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondetilse","root","");
				DatabaseMetaData dbm = conT.getMetaData();
				ResultSet tables;
				int i=0;
				
				while (i==0) {
					tables = dbm.getTables(null, null, tablename, null);
		            if (tables.next()) {
		            	counter=counter+1;
		            	tablename="patient0"+counter;

		            }
		            else {
		            	
		            	break;
		            }
				}
					PreparedStatement ps= conT.prepareStatement("Create table "+tablename+"(medcin_name varchar(20),qunatity int(5),totalprice double,Mdateofbuy varchar(11),Mtimeofbuy varchar(11))");
					ps.executeUpdate();
				}
				
		
				catch (Exception e4) {
					// TODO: handle exception
				}
				
			}
		});
			
		JScrollPane listscroll=new JScrollPane();
		listscroll.setViewportView(list);
		listscroll.setVisible(true);
		
		M_name = new JLabel("Medicin name");
		M_name.setBounds(47, 247, 139, 22);
		
		textmedicname = new JTextField();
		textmedicname.setBounds(166, 248, 417, 20);
		textmedicname.setAlignmentY(Component.TOP_ALIGNMENT);
		textmedicname.setColumns(10);
	textmedicname.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
			
				try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicins","root","");
						PreparedStatement ps= con.prepareStatement("select Medicin_Name from medic where Medicin_Name like'"+textmedicname.getText()+"%'");
						ResultSet rs=ps.executeQuery();
						 DefaultListModel value= new DefaultListModel();
						 while (rs.next()) {
							value.addElement(rs.getString("Medicin_Name"));
						}
						 
						list.setModel(value);
						
						ps.close();
						rs.close();
						
					
				} catch (Exception e4) {
					e4.printStackTrace();
				}
					
				}
		});
		
		M_quntity = new JLabel("Quntity");
		M_quntity.setBounds(51, 337, 78, 22);
		
		textitemquntity = new JTextField();
		textitemquntity.setBounds(166, 337, 416, 22);
		textitemquntity.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				list.setVisible(false);
			}
		});
		textitemquntity.setColumns(10);
		
		medicin_enter = new JButton("Enter");
		medicin_enter.setBounds(166, 377, 89, 23);
		medicin_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
					
				}
			
		});
		
		total_bill = new JButton("total Bill");
		total_bill.setBounds(494, 377, 89, 23);
		total_bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(42, 418, 697, 50);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 486, 691, 62);
		
		JLabel lblNewLabel_2 = new JLabel("Bill amount:");
		lblNewLabel_2.setBounds(51, 554, 78, 14);
		
		 billamount = new JLabel("0Rs");
		 billamount.setBounds(147, 554, 108, 14);
		
		JButton btnNewButton = new JButton("Print bill");
		btnNewButton.setBounds(51, 576, 78, 21);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setToolTipText("To show Printing page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				
				if(textage.getText().trim().isEmpty() || Textname.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Specify person name and age");
					if(ct==0) {
						JOptionPane.showMessageDialog(null, "specify the medicins");
					}
				}
				else {

					try {
						
							Class.forName("com.mysql.jdbc.Driver");
							Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondetilse","root","");
							PreparedStatement ps4=con1.prepareStatement("insert into "+tablename+" (medcin_name,totalprice,Mdateofbuy,Mtimeofbuy) values('Total bill=',"+billprice+",'"+Vdate+"','"+Vtime+"')");
							ps4.execute();
							
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/persionmedicins","root","");
							PreparedStatement ps= con.prepareStatement("insert into persion values('"+Textname.getText()+"','"+placename.getText()+"',"+textage.getText()+",'"+day+"/"+mont+"/"+year+"','"+hou+":"+min+":"+sec+"','"+tablename+"')");
							ps.execute();
							
						
					} catch (Exception e4) {
						e4.printStackTrace();
					}

					int i=1;
				
					printpage newwindowAdd= new printpage(Textname.getText(),textage.getText(),placename.getText(),Vtime,Vdate,tablename);
					newwindowAdd.setVisible(true);
				
				}
				
				
			}
		});
		
		btnNewButton_1 = new JButton("Buyer");
		btnNewButton_1.setBounds(696, 83, 71, 22);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_1.setToolTipText("Button\r\n:View the patient details.");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\New folder (2)\\icons8-view-6424.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyerdeatils newwindowAdd= new buyerdeatils();
				newwindowAdd.setVisible(true);
			}
		});
		
		btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setBounds(605, 85, 78, 22);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_2.setToolTipText("Button:\r\nAdd,Edit and Remove Medicins details\r\n");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\New folder (2)\\icons8-add-column-6411.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				viewadddelete newwindowAdd= new viewadddelete();
				newwindowAdd.setVisible(true);
			}
		});
		
		 list = new JList();
		 list.setBounds(166, 270, 417, 61);
		 list.setForeground(SystemColor.text);
		 list.setEnabled(false);
		 list.addMouseListener(new MouseAdapter() {
		 	public void mouseClicked(MouseEvent e) {
		 		textmedicname.setText(String .valueOf((list.getSelectedValue())));
		 	}
		 });
		
		JLabel lblNewLabel_1 = new JLabel("Place");
		lblNewLabel_1.setBounds(42, 198, 59, 19);
		
		placename = new JTextField();
		placename.setBounds(111, 196, 401, 23);
		placename.setColumns(10);
		
	
		list.setVisible(false);

		table = new JTable();
		table.setDragEnabled(false);
		table.setCellSelectionEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "quntity", "price of one", "total price", "stock"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(238);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1_2 = new JLabel("Age");
		
		lblNewLabel_5 = new JLabel("Name");
		
		lblNewLabel_6 = new JLabel("Date");
		
		
		
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Lb_date, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addComponent(Lb_name, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Lb_age, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(Lb_age)
						.addComponent(lblNewLabel_5)
						.addComponent(Lb_name))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Lb_date)
						.addComponent(lblNewLabel_6))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		desktopPane.setLayout(gl_desktopPane);
		
		lblNewLabel_4 = new JLabel("PHARMEASY ASSIST");
		lblNewLabel_4.setBounds(147, 11, 472, 76);
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Garamond", Font.BOLD, 34));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 784, 611);
		lblNewLabel_3.setBackground(SystemColor.controlHighlight);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\New folder (2)\\26358.jpg"));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(desktopPane);
		frame.getContentPane().add(M_name);
		frame.getContentPane().add(list);
		frame.getContentPane().add(textage);
		frame.getContentPane().add(textmedicname);
		frame.getContentPane().add(M_quntity);
		frame.getContentPane().add(placename);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(P_entername);
		frame.getContentPane().add(btnNewButton_2);
		frame.getContentPane().add(billamount);
		frame.getContentPane().add(Textname);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(P_age);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(medicin_enter);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(total_bill);
		frame.getContentPane().add(textitemquntity);
		frame.getContentPane().add(lblNewLabel_4);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblNewLabel_3);
		frame.setBounds(100, 100, 800, 670);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mntmNewMenuItem = new JMenuItem("Clear");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textage.setText(null);
				textitemquntity.setText(null);
				textmedicname.setText(null);
				Textname.setText(null);
				placename.setText(null);
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Name", "quntity", "price of one", "total price", "stock"
						}
					) {
						boolean[] columnEditables = new boolean[] {
							false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntmNewMenuItem_1);

		
		
		
		
	}

	private Dimension Dimension() {
		// TODO Auto-generated method stub
		return null;
	}


}
