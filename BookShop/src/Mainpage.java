import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage frame = new Mainpage();
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
	public Mainpage() {
		setBounds(100, 100, 475, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUserAdd = new JButton("User add");
		btnUserAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellers newpage=new sellers();
				newpage.setVisible(true);
				dispose();
			}
		});
		btnUserAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUserAdd.setBounds(161, 157, 153, 36);
		contentPane.add(btnUserAdd);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bookadd newpage=new Bookadd();
				newpage.setVisible(true);
				dispose();
			}
		});
		btnAddBook.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddBook.setBounds(161, 246, 153, 36);
		contentPane.add(btnAddBook);
		
		JButton btnNewButton_1_2 = new JButton("Log Out\r\n");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login newpage=new login();
				newpage.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_1_2.setBounds(181, 354, 114, 23);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblAdminPage = new JLabel("Admin Page");
		lblAdminPage.setFont(new Font("Tw Cen MT", Font.BOLD, 43));
		lblAdminPage.setBounds(115, 22, 266, 61);
		contentPane.add(lblAdminPage);
	}

}
