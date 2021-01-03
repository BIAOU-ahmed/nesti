package nesti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import listener.CheckEmailListener;
import listener.CheckPasswordListener;
import listener.CloseListener;
import listener.ConfirmPaswordListener;
import listener.DragFrameListener;
import listener.MinimizeListener;
import listener.RegisterLabelListener;
import listener.RegisterListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setUndecorated(true);

		this.setLocationRelativeTo(null);
		DragFrameListener dragListener = new DragFrameListener(this);
		this.addMouseListener(dragListener);
		this.addMouseMotionListener(dragListener);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(10, 11, 578, 730);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 143, 578, 593);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		String values[] = { "Username:", "*Email:", "*Password:", "*Confirm Password:", "First Name:", "Last Name:",
				"City:" };

		// it's the loop that creates all my label
		int x = 10;
		int y = 39;
		for (int i = 0; i < values.length; i++) {

			Labels newLab = new Labels(x, y, 210, 34, values[i], (new Font("Tahoma", Font.BOLD, 20)));
			panel_2.add(newLab);
			y += 45;
		}

		// it's the loop that creates all my label

		TextField[] textFieldTable = new TextField[5];
		PasswordField[] passwordTable = new PasswordField[2];
		int textCount = 0;
		int passCount = 0;
		int xTesxtField = 220;
		int yTesxtField = 39;
		for (int i = 0; i < values.length; i++) {
			if (i == 2 || i == 3) {

				PasswordField password = new PasswordField(xTesxtField, yTesxtField, 347, 34);

				if (i == 2) {
					password.addKeyListener(new CheckPasswordListener(password));
				} else {
					password.addKeyListener(new ConfirmPaswordListener(passwordTable[0],password));

				}

				passwordTable[passCount] = password;
				passCount++;
				panel_2.add(password);

			} else {
				TextField textField = new TextField(xTesxtField, yTesxtField, 347, 34, "");
				textFieldTable[textCount] = textField;
				if (i == 1) {
					textField.addKeyListener(new CheckEmailListener(textField));
				}
				textCount++;
				panel_2.add(textField);
			}

			yTesxtField += 45;
		}



		Buttons btn = new Buttons(201, 438, 200, 68, "Register", (new Color(0, 100, 0)));

		btn.addActionListener(new RegisterListener(textFieldTable, passwordTable,this));

		panel_2.add(btn);



		Labels lblLogin = new Labels(186, 530, 184, 26, "Click here to login", (new Font("Tahoma", Font.PLAIN, 18)));
		lblLogin.setForeground(Color.LIGHT_GRAY);
		panel_2.add(lblLogin);

		lblLogin.addMouseListener(new RegisterLabelListener(lblLogin, this, "login"));



		Labels infoLbl = new Labels(25, 380, 194, 26, "*Required Camp", (new Font("Tahoma", Font.BOLD, 18)));

		infoLbl.setForeground(Color.RED);
		panel_2.add(infoLbl);


		Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		Labels closeLbl = new Labels(532, 11, 36, 40, "x", (new Font("Tahoma", Font.BOLD, 40)));
		closeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(closeLbl);
		closeLbl.addMouseListener(new CloseListener(closeLbl));
		closeLbl.setBorder(labelBorder);

		Labels minimizeLbl = new Labels(481, 11, 36, 40, "-", (new Font("Tahoma", Font.BOLD, 40)));
		minimizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeLbl.addMouseListener(new MinimizeListener(minimizeLbl, this));
		minimizeLbl.setBorder(labelBorder);
		panel_1.add(minimizeLbl);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(107, 0, 235, 85);
		panel_1.add(panel_3);

		JLabel lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Arial", Font.BOLD, 26));
		lblRegister.setBounds(70, 11, 104, 49);
		panel_3.add(lblRegister);
	}
}
