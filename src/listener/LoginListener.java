/**
 * 
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nesti.Informations;
import nesti.PasswordField;
import nesti.QueryUsers;
import nesti.TextField;
import nesti.Users;

/**
 * @author ahmed
 *
 */
public class LoginListener implements ActionListener{
	TextField text;
	PasswordField password;
	JFrame frame;
	
	public LoginListener(TextField text,PasswordField password,JFrame frame) {
		
		this.text = text;
		this.password = password;
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent e) {
		String username = text.getText();
		String passwords = String.valueOf(password.getPassword());
		if(QueryUsers.login(username, passwords)) {
			Users user = QueryUsers.readBy(username);
			Informations.user = user;
			Informations informations = new Informations();
			informations.setVisible(true);
			
			
			frame.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "Invalid informations");
		}
	}
}
