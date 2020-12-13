package nesti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldFName;
	private JTextField textFieldLName;
	private JTextField textFieldCity;
	private JPasswordField passwordField;
	private JPasswordField cPasswordField;



	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 801);
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
		panel_1.setBounds(10, 11, 578, 730);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 143, 578, 593);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblUsername = new JLabel("*Username:");
		lblUsername.setBounds(10, 39, 184, 34);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblUsername);
		
		textFieldUsername = new JTextField();
		lblUsername.setLabelFor(textFieldUsername);
		textFieldUsername.setBounds(204, 39, 347, 34);
		textFieldUsername.setColumns(10);
		panel_2.add(textFieldUsername);
		
		JLabel lblEmail = new JLabel("*Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(10, 84, 184, 34);
		panel_2.add(lblEmail);
		
		textFieldEmail = new JTextField();
		lblEmail.setLabelFor(textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(204, 84, 347, 34);
		panel_2.add(textFieldEmail);
		
		JLabel lblPassword = new JLabel("*Password:");
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
		
		textFieldFName = new JTextField();
		lblFiestName.setLabelFor(textFieldFName);
		textFieldFName.setColumns(10);
		textFieldFName.setBounds(204, 217, 347, 34);
		panel_2.add(textFieldFName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(10, 262, 184, 34);
		panel_2.add(lblLastName);
		
		textFieldLName = new JTextField();
		lblLastName.setLabelFor(textFieldLName);
		textFieldLName.setColumns(10);
		textFieldLName.setBounds(204, 262, 347, 34);
		panel_2.add(textFieldLName);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCity.setBounds(10, 307, 184, 34);
		panel_2.add(lblCity);
		
		textFieldCity = new JTextField();
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
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textFieldUsername.getText();
				String email = textFieldEmail.getText();
				String password = String.valueOf(passwordField.getPassword());
				String firstName = textFieldFName.getText();
				String lastName = textFieldLName.getText();
				String city = textFieldCity.getText();
				if(String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField.getPassword()))) {
					
					if(!textFieldUsername.getText().isEmpty()&&!textFieldEmail.getText().isEmpty()&&!String.valueOf(passwordField.getPassword()).isEmpty()) {
						if(Check.isValidEmail(textFieldEmail.getText())){
							if(Check.calculatePasswordStrength(String.valueOf(passwordField.getPassword()))>=9) {
								Users newUser = new Users(userName, password, email,  firstName, lastName, city);
								if(QueryUsers.register(newUser)) {
									JOptionPane.showMessageDialog(null, "Congratulation your count is already create");
								}
								
							}else if(Check.calculatePasswordStrength(String.valueOf(passwordField.getPassword()))==0) {
								JOptionPane.showMessageDialog(null, "password too short");
							}
							else {
								JOptionPane.showMessageDialog(null, "password too light");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Please enter a valid email");
						}
						
						
						
					}else {
						JOptionPane.showMessageDialog(null, "One or more Required Field are empty");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Password Doesn't Match");
				}
			}
		});
		btnRegister.setFont(new Font("Arial", Font.BOLD, 24));
		btnRegister.setBackground(new Color(0, 100, 0));
		btnRegister.setBounds(201, 438, 200, 68);
		panel_2.add(btnRegister);
		
		JLabel lblClickHereTo = new JLabel("Click here to login");
		lblClickHereTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				//setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblClickHereTo.setForeground(Color.GRAY);
				lblClickHereTo.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblClickHereTo.setForeground(Color.LIGHT_GRAY);
			}
		});
		lblClickHereTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickHereTo.setForeground(Color.LIGHT_GRAY);
		lblClickHereTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClickHereTo.setBounds(186, 530, 184, 26);
		panel_2.add(lblClickHereTo);
		
		JLabel lblNewLabel = new JLabel("*Required Camp");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(25, 380, 194, 26);
		panel_2.add(lblNewLabel);
		
		JLabel lblMinimize = new JLabel("-");
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblMinimize.setBounds(481, 11, 36, 40);
		panel_1.add(lblMinimize);
		
		JLabel lblClose = new JLabel("x");
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblClose.setBounds(532, 11, 36, 40);
		panel_1.add(lblClose);
		
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
