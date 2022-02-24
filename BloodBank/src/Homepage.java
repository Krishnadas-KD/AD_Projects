import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Blood Bank");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(175, 46, 212, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Donor Edit\r\n\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonorPage newpage=new DonorPage();
                newpage.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(190, 147, 136, 58);
		contentPane.add(btnNewButton);
		
		JButton btnSearchDonor = new JButton("Search Donor ");
		btnSearchDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchDonor newpage=new SearchDonor();
                newpage.setVisible(true);
                dispose();
			}
		});
		btnSearchDonor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearchDonor.setBounds(190, 261, 136, 58);
		contentPane.add(btnSearchDonor);
		
		JButton btnStock = new JButton("Stock\r\n");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Stockview newpage=new Stockview();
                newpage.setVisible(true);
                dispose();
			}
		});
		btnStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStock.setBounds(190, 381, 136, 58);
		contentPane.add(btnStock);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login newpage=new Login();
                newpage.setVisible(true);
                dispose();
			}
		});
		btnNewButton_1.setBounds(214, 507, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
