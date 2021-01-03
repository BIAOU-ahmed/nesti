package nesti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import listener.CheckPasswordListener;
import listener.ConfirmPaswordListener;
import listener.DragFrameListener;
import listener.UpdatePassWordListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JDialog {

	private JPanel contentPane;

	public static Users user;

	/**
	 * Create the frame.
	 */
	public ChangePassword(final JFrame parent) {

		super(parent, true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
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

		String values[] = { "Current Password:", "New Password:", "Confirm New Password:"};
		PasswordField passWord[] = new PasswordField[3];
		int x = 10;
		int y = 110;
		int xTesxtField = 234;
		int yTesxtField = 111;
		for (int i = 0; i < values.length; i++) {
			Labels newLab = new Labels(x, y, 201, 33, values[i], (new Font("Tahoma", Font.BOLD, 16)));
			newLab.setHorizontalAlignment(SwingConstants.RIGHT);

			
			PasswordField password = new PasswordField(xTesxtField,yTesxtField,238,33);
			passWord[i] = password;
			if (i == 1) {
				password.addKeyListener(new CheckPasswordListener(password));
			} else if (i == 2) {
				password.addKeyListener(new ConfirmPaswordListener(passWord[1],password));

			}
			panel.add(password);
			
			panel.add(newLab);
			y += 62;
			yTesxtField+=62;
		}
		
		JLabel lblNewLabel_1 = new JLabel("Change Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 11, 287, 60);
		panel_1.add(lblNewLabel_1);



		
	Buttons btn = new Buttons(166, 296, 143, 43,"Update",Color.GREEN);
		
		btn.addActionListener(new UpdatePassWordListener(passWord, this));
		
		
		panel.add(btn);
		
	}
}
