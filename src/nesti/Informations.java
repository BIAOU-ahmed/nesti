package nesti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Informations extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldFName;
	private JTextField textFieldLName;
	private JTextField textFieldCity;
	private JButton btnUpdate;
	public static Users user;

	/**
	 * Create the frame.
	 */
	public Informations() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

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

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 39, 184, 34);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblUsername);

		textFieldUsername = new JTextField(user.getUserName());
		textFieldUsername.setEditable(false);

		lblUsername.setLabelFor(textFieldUsername);
		textFieldUsername.setBounds(204, 39, 347, 34);
		textFieldUsername.setColumns(10);
		panel_2.add(textFieldUsername);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(10, 84, 184, 34);
		panel_2.add(lblEmail);

		textFieldEmail = new JTextField(user.getEmail());
		textFieldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
				
				if (Check.isValidEmail(textFieldEmail.getText())) {
					labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green);
				}
				textFieldEmail.setBorder(labelBorder);
			}
		});
		
		textFieldEmail.setEditable(false);
		lblEmail.setLabelFor(textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(204, 84, 347, 34);
		panel_2.add(textFieldEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(10, 264, 184, 34);
		panel_2.add(lblPassword);

		JLabel lblFiestName = new JLabel("First Name:");
		lblFiestName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFiestName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFiestName.setBounds(10, 129, 184, 34);
		panel_2.add(lblFiestName);

		textFieldFName = new JTextField(user.getFirstName());
		textFieldFName.setEditable(false);
		lblFiestName.setLabelFor(textFieldFName);
		textFieldFName.setColumns(10);
		textFieldFName.setBounds(204, 129, 347, 34);
		panel_2.add(textFieldFName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(10, 174, 184, 34);
		panel_2.add(lblLastName);

		textFieldLName = new JTextField(user.getLastName());
		textFieldLName.setEditable(false);
		lblLastName.setLabelFor(textFieldLName);
		textFieldLName.setColumns(10);
		textFieldLName.setBounds(204, 174, 347, 34);
		panel_2.add(textFieldLName);

		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCity.setBounds(10, 219, 184, 34);
		panel_2.add(lblCity);

		textFieldCity = new JTextField(user.getCity());
		textFieldCity.setEditable(false);
		lblCity.setLabelFor(textFieldCity);
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(204, 219, 347, 34);
		panel_2.add(textFieldCity);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldEmail.isEditable()) {

					if (!textFieldEmail.getText().isEmpty()) {
						if (Check.isValidEmail(textFieldEmail.getText())) {
							user = new Users(user.getUserName(),user.getPassword(),textFieldEmail.getText(),textFieldFName.getText(),textFieldLName.getText(),textFieldCity.getText());
							if (QueryUsers.updateById(user)) {
								JOptionPane.showMessageDialog(null, "Update succesfull");
								textFieldEmail.setEditable(false);
								textFieldFName.setEditable(false);
								textFieldLName.setEditable(false);
								textFieldCity.setEditable(false);
							}else {
								JOptionPane.showMessageDialog(null, "update fail");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Please enter a valid email");
						}

					} else {
						JOptionPane.showMessageDialog(null, "One or more Required Field are empty");
					}
				} else {

					textFieldEmail.setEditable(true);
					textFieldFName.setEditable(true);
					textFieldLName.setEditable(true);
					textFieldCity.setEditable(true);
				}
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 24));
		btnUpdate.setBackground(new Color(0, 100, 0));
		btnUpdate.setBounds(350, 378, 200, 68);
		panel_2.add(btnUpdate);

		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword.user = user;
				ChangePassword changePassword = new ChangePassword();
				changePassword.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(204, 264, 347, 33);
		panel_2.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(107, 0, 235, 85);
		panel_1.add(panel_3);

		JLabel lblRegister = new JLabel("Informations");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Arial", Font.BOLD, 26));
		lblRegister.setBounds(20, 11, 205, 49);
		panel_3.add(lblRegister);
	}
}
