package nesti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField psw;
	private JPasswordField NPsw;
	private JPasswordField CNPsw;
	public static Users user;

	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(38, 0, 307, 82);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Change Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 11, 287, 60);
		panel_1.add(lblNewLabel_1);

		JLabel lblPassword = new JLabel("Current Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(49, 110, 162, 33);
		panel.add(lblPassword);

		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewPassword.setBounds(49, 172, 162, 33);
		panel.add(lblNewPassword);

		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password:");
		lblConfirmNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmNewPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConfirmNewPassword.setBounds(10, 230, 201, 33);
		panel.add(lblConfirmNewPassword);

		psw = new JPasswordField();
		psw.setBounds(221, 112, 238, 33);
		panel.add(psw);

		NPsw = new JPasswordField();
		NPsw.setBounds(221, 172, 238, 33);
		panel.add(NPsw);

		CNPsw = new JPasswordField();
		CNPsw.setBounds(221, 230, 238, 33);
		panel.add(CNPsw);

		JButton btnPswUpdate = new JButton("Update");
		btnPswUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(NPsw.getPassword()).equals(String.valueOf(CNPsw.getPassword()))) {
					if (String.valueOf(psw.getPassword()).equals(user.getPassword())) {
						if (Check.calculatePasswordStrength(String.valueOf(NPsw.getPassword())) >= 9) {
							user.setPassword(String.valueOf(NPsw.getPassword()));
							if(QueryUsers.updatePsw(user)) {
								System.out.println("ok");
								setVisible(false);
							}
							
						}else {
							System.out.println("trop faible mot de passe");
						}
					}else {
						System.out.println("verifier le mot de passe actuel");
					}
				}else {
					System.out.println("entrer deux mot de passe identique");
				}
			}
		});
		btnPswUpdate.setBackground(Color.GREEN);
		btnPswUpdate.setBounds(166, 296, 143, 43);
		panel.add(btnPswUpdate);
	}
}
