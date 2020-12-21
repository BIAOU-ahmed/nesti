package nesti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
//	private JTextField textFieldUsername;
//	private JPasswordField passwordField;
	Users user;
	

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 505);
		//setResizable(false);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 560, 506);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(10, 11, 543, 481);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 124, 543, 357);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		
		this.setLocationRelativeTo(null);
        DragFrameListener dragListener= new DragFrameListener(this);
        this.addMouseListener(dragListener);
        this.addMouseMotionListener(dragListener);
        
//		JLabel lblUsername = new JLabel("Username:");
//		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
//		lblUsername.setBounds(40, 47, 116, 50);
//		panel_2.add(lblUsername);
		
//		textFieldUsername = new JTextField();
////		lblUsername.setLabelFor(textFieldUsername);
//		textFieldUsername.setBounds(166, 47, 301, 50);
//		panel_2.add(textFieldUsername);
//		textFieldUsername.setColumns(10);
		
		TextField textField = new TextField(166,47,"Username");
		panel_2.add(textField);
//		JLabel lblPassword = new JLabel();
//		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
//		lblPassword.setBounds(40, 122, 116, 57);
//		panel_2.add(lblPassword);
		
		String values[] = { "Username:","Password:"};
		
		// it's the loop that creates all my label
		int x = 40;
		int y = 47;
		for (int i = 0; i < values.length; i++) {
			Labels newLab = new Labels(x,y,values[i]);
			panel_2.add(newLab);
			y+=75;
		}
		
		PasswordField password = new PasswordField(166,122);
		panel_2.add(password);
		
//		passwordField = new JPasswordField();
////		lblPassword.setLabelFor(passwordField);
//		passwordField.setBounds(166, 122, 301, 57);
//		panel_2.add(passwordField);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.RED);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 24));
		btnCancel.setBounds(82, 220, 156, 57);
		panel_2.add(btnCancel);
		
		
				
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String passwords = String.valueOf(password.getPassword());
				if(QueryUsers.login(username, passwords)) {
					user = QueryUsers.readBy(username);
					Informations.user = user;
					Informations informations = new Informations();
					informations.setVisible(true);
					
					
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnLogin.setFont(new Font("Arial", Font.BOLD, 24));
		btnLogin.setBackground(new Color(0, 100, 0));
		btnLogin.setBounds(311, 220, 156, 57);
		panel_2.add(btnLogin);
		
		JLabel lblRegister = new JLabel("Click here to create a new account");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegister.setForeground(Color.GRAY);
				lblRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRegister.setForeground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Register register = new Register();
				register.setVisible(true);
				setVisible(false);
				
			}
		});
		lblRegister.setForeground(Color.LIGHT_GRAY);
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegister.setBounds(136, 299, 301, 26);
		panel_2.add(lblRegister);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(115, 0, 235, 85);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTitle = new JLabel("Login");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
		lblTitle.setBounds(70, 11, 104, 49);
		panel_3.add(lblTitle);
		
		Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		JLabel lblClose = new JLabel("x");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				lblClose.setBorder(labelBorder);
				lblClose.setForeground(Color.white);
				lblClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblClose.setBorder(labelBorder);
				lblClose.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblClose.setBorder(labelBorder);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblClose.setBounds(497, 11, 36, 40);
		panel_1.add(lblClose);
		
		JLabel lblMinimize = new JLabel("-");
		lblMinimize.setBorder(labelBorder);
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				lblMinimize.setBorder(labelBorder);
				lblMinimize.setForeground(Color.white);
				lblMinimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblMinimize.setBorder(labelBorder);
				lblMinimize.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblMinimize.setBounds(446, 11, 36, 40);
		panel_1.add(lblMinimize);
		this.setLocationRelativeTo(null);
	}
}
