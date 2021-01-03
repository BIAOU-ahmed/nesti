package nesti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import listener.CheckEmailListener;
import listener.CloseListener;
import listener.DragFrameListener;
import listener.MinimizeListener;
import listener.UpdateListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Informations extends JFrame {

	private JPanel contentPane;

	public static Users user;

	/**
	 * Create the frame.
	 */
	public Informations() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 671);
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
		panel_1.setBounds(10, 11, 578, 642);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 143, 578, 498);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		String values[] = { "Username:", "Email:", "First Name:", "Last Name:", "City:", "Password:" };
		String data[] = { user.getUserName(), user.getEmail(), user.getFirstName(), user.getLastName(),
				user.getCity() };
		TextField listTextField[] = new TextField[5];

		int x = 10;
		int y = 39;
		int xTesxtField = 204;
		int yTesxtField = 39;
		for (int i = 0; i < values.length; i++) {
			Labels newLab = new Labels(x, y, 184, 34, values[i], (new Font("Tahoma", Font.BOLD, 20)));
			if (i != values.length - 1) {
				TextField textField = new TextField(xTesxtField, yTesxtField, 347, 34, data[i]);
				textField.setEditable(false);
				textField.setColumns(10);
				if (i == 1) {
					textField.addKeyListener(new CheckEmailListener(textField));
				}

				listTextField[i] = textField;
				panel_2.add(textField);
			} else {
				Buttons btnChange = new Buttons(204, 264, 347, 33, "Change Password", (new Color(240, 240, 240)));

				btnChange.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ChangePassword.user = user;
						ChangePassword changePassword = new ChangePassword(Informations.this);
						changePassword.setVisible(true);
					}
				});

				panel_2.add(btnChange);
			}

			panel_2.add(newLab);
			y += 45;
			yTesxtField += 45;
		}



		Buttons btn = new Buttons(350, 378, 200, 68, "Update", (new Color(0, 100, 0)));

		btn.addActionListener(new UpdateListener(listTextField, user));

		panel_2.add(btn);


		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(107, 0, 235, 85);
		panel_1.add(panel_3);



		Labels frameTitle = new Labels(20, 11, 205, 49, "Informations", (new Font("Arial", Font.BOLD, 26)));
		frameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(frameTitle);

		Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);

		Labels lblMinimize = new Labels(481, 11, 36, 40, "-", (new Font("Tahoma", Font.BOLD, 40)));
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.addMouseListener(new MinimizeListener(lblMinimize, this));


		lblMinimize.setBorder(labelBorder);
		panel_1.add(lblMinimize);


		Labels lblClose = new Labels(532, 11, 36, 40, "x", (new Font("Tahoma", Font.BOLD, 40)));
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.addMouseListener(new CloseListener(lblClose));


		lblClose.setBorder(labelBorder);
		panel_1.add(lblClose);
		
		
		ImageIcon icon = new ImageIcon("C:\\Users\\ahmed\\eclipse-workspace\\nesti\\src\\images\\logout.png");
		System.out.println(icon);
		JLabel lblLogout = new JLabel();
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Login login = new Login();
			login.setVisible(true);
			setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblLogout.setIcon(new ImageIcon(Informations.class.getResource("/images/2529508.png")));
		lblLogout.setBounds(0, 0, 54, 58);
		panel_1.add(lblLogout);
	}
}
