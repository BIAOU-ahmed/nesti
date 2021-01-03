package nesti;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import listener.CloseListener;
import listener.DragFrameListener;
import listener.LoginListener;
import listener.MinimizeListener;
import listener.RegisterLabelListener;


import javax.swing.BorderFactory;

import java.awt.Color;


import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        

		
		TextField textField = new TextField(166,47, 301, 50,"");
		panel_2.add(textField);
		PasswordField password = new PasswordField(166,122,301,57);
		panel_2.add(password);

		
		String values[] = { "Username:","Password:"};
		
		// it's the loop that creates all my label
		int x = 40;
		int y = 47;
		for (int i = 0; i < values.length; i++) {
			Labels newLab = new Labels(x,y,116,57,values[i],(new Font("Tahoma", Font.BOLD, 20)));
			panel_2.add(newLab);
			y+=75;
		}
		String btnValue[] = { "Cancel","Login"};
		
		// it's the loop that creates all my label
		int xbtn = 82;
		int ybtn = 220;
		for (int i = 0; i < btnValue.length; i++) {
			Color btnColor = new Color(0, 100, 0);
			Buttons btn;
			if(i==0) {
				btnColor =Color.RED;
			}
			btn = new Buttons(xbtn,ybtn,156,57,btnValue[i],btnColor);
			if(i==1) {
				btn.addActionListener(new LoginListener(textField,password,this));
			}else {
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
			}
			panel_2.add(btn);
			xbtn+=229;
		}
		
		
		
		Labels lblRegister = new Labels(136,299,301,26,"Click here to create a new account",(new Font("Tahoma", Font.PLAIN, 18)));
		lblRegister.setForeground(Color.LIGHT_GRAY);
		panel_2.add(lblRegister);
		Register register = new Register();
		lblRegister.addMouseListener(new RegisterLabelListener(lblRegister,this,"register"));
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(115, 0, 235, 85);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		

		Font font = new Font("Arial", Font.BOLD, 36);
		Labels newLab = new Labels(70,11,104,49,"Login",font);
		panel_3.add(newLab);
		
		Border labelBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);

		
		
		Labels closeLbl = new Labels(497,11,36,40,"x",(new Font("Tahoma", Font.BOLD, 40)));
		closeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(closeLbl);
		closeLbl.addMouseListener(new CloseListener(closeLbl));
		closeLbl.setBorder(labelBorder);
		
		Labels minimizeLbl = new Labels(446,11,36,40,"-",(new Font("Tahoma", Font.BOLD, 40)));
		minimizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeLbl.addMouseListener(new MinimizeListener(minimizeLbl,this));
		minimizeLbl.setBorder(labelBorder);
		panel_1.add(minimizeLbl);
		
		

		this.setLocationRelativeTo(null);
	}
}
