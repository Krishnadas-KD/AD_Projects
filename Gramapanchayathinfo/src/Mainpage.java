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
	static Mainpage frame = new Mainpage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					try {
						try {
							frame.setVisible(true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		
        
		
		
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGramapanchayath = new JLabel("Gramapanchayath");
		lblGramapanchayath.setForeground(Color.BLACK);
		lblGramapanchayath.setFont(new Font("Goudy Old Style", Font.BOLD, 42));
		lblGramapanchayath.setBounds(55, 29, 320, 48);
		contentPane.add(lblGramapanchayath);
		
		JButton btnNewButton = new JButton("WARD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ward paWard=new ward();
				paWard.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(141, 157, 153, 36);
		contentPane.add(btnNewButton);
		
		JButton btnWardMember = new JButton("WARD MEMBER\r\n");
		btnWardMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wardmember paWard=new wardmember();
				paWard.setVisible(true);
				frame.setVisible(false);
				dispose();
			}
		});
		btnWardMember.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnWardMember.setBounds(141, 246, 153, 36);
		contentPane.add(btnWardMember);
		
		JButton btnNewButton_1_2 = new JButton("Log Out\r\n");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Login page= new Login();
                page.setVisible(true); 
                dispose();
                
                
			}
		});
		btnNewButton_1_2.setBounds(161, 354, 114, 23);
		contentPane.add(btnNewButton_1_2);
	}

}
