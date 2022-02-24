import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("College Election Voting");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 21));
		lblNewLabel.setBounds(108, 36, 237, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Add Person");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPerson pageAddPerson=new AddPerson();
				pageAddPerson.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(150, 149, 144, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Voting");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Voting newpage = null;
				newpage = new Voting();
				newpage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(150, 230, 144, 46);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Counting");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counting newpage=new Counting();
				newpage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1_1_1.setBounds(150, 313, 144, 46);
		contentPane.add(btnNewButton_1_1_1);
	}

}
