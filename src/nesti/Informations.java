package nesti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Informations extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldFName;
	private JTextField textFieldLName;
	private JTextField textFieldCity;
	private JPasswordField passwordField;
	private JPasswordField cPasswordField;
	private JButton btnUpdate;
	public static Users user ;

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
		textFieldEmail.setEditable(false);
		lblEmail.setLabelFor(textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(204, 84, 347, 34);
		panel_2.add(textFieldEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(10, 129, 184, 34);
		panel_2.add(lblPassword);

		JLabel lblPasswordRetry = new JLabel("Confirm Password:");
		lblPasswordRetry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswordRetry.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPasswordRetry.setBounds(0, 172, 194, 34);
		panel_2.add(lblPasswordRetry);

		JLabel lblFiestName = new JLabel("First Name:");
		lblFiestName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFiestName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFiestName.setBounds(10, 217, 184, 34);
		panel_2.add(lblFiestName);

		textFieldFName = new JTextField(user.getFirstName());
		textFieldFName.setEditable(false);
		lblFiestName.setLabelFor(textFieldFName);
		textFieldFName.setColumns(10);
		textFieldFName.setBounds(204, 217, 347, 34);
		panel_2.add(textFieldFName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(10, 262, 184, 34);
		panel_2.add(lblLastName);

		textFieldLName = new JTextField(user.getLastName());
		textFieldLName.setEditable(false);
		lblLastName.setLabelFor(textFieldLName);
		textFieldLName.setColumns(10);
		textFieldLName.setBounds(204, 262, 347, 34);
		panel_2.add(textFieldLName);

		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCity.setBounds(10, 307, 184, 34);
		panel_2.add(lblCity);

		textFieldCity = new JTextField(user.getCity());
		textFieldCity.setEditable(false);
		lblCity.setLabelFor(textFieldCity);
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(204, 307, 347, 34);
		panel_2.add(textFieldCity);

		passwordField = new JPasswordField();
		lblPassword.setLabelFor(passwordField);
		passwordField.setBounds(204, 129, 347, 34);
		panel_2.add(passwordField);

		cPasswordField = new JPasswordField();
		lblPasswordRetry.setLabelFor(cPasswordField);
		cPasswordField.setBounds(204, 172, 347, 34);
		panel_2.add(cPasswordField);

		btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 24));
		btnUpdate.setBackground(new Color(0, 100, 0));
		btnUpdate.setBounds(350, 378, 200, 68);
		panel_2.add(btnUpdate);

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