/**
 * 
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nesti.Check;
import nesti.Login;
import nesti.PasswordField;
import nesti.QueryUsers;
import nesti.TextField;
import nesti.Users;

/**
 * @author ahmed
 *
 */
public class RegisterListener implements ActionListener{
	TextField[] textField;
	PasswordField[] password;
	JFrame frame;
	public RegisterListener(TextField[] textField,PasswordField[] password,JFrame frame) {
		
		this.textField = textField;
		this.password = password;
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		String userName = textField[0].getText();
		String email = textField[1].getText();
		String password = String.valueOf(this.password[0].getPassword());
		String firstName = textField[2].getText();
		String lastName = textField[3].getText();
		String city = textField[4].getText();
		if (String.valueOf(this.password[0].getPassword()).equals(String.valueOf(this.password[1].getPassword()))) {

			if (!textField[0].getText().isEmpty() && !textField[1].getText().isEmpty()
					&& !String.valueOf(this.password[0].getPassword()).isEmpty()) {
				if (Check.isValidEmail(textField[1].getText())) {
					if (Check.calculatePasswordStrength(String.valueOf(this.password[0].getPassword())) >= 9) {
						Users newUser = new Users(userName, password, email, firstName, lastName, city);
						if (QueryUsers.register(newUser)) {
							JOptionPane.showMessageDialog(null, "Congratulation your account is already create");
							Login login = new Login();
							login.setVisible(true);
							this.frame.setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de la conection à la base de données");
						}

					} else if (Check
							.calculatePasswordStrength(String.valueOf(this.password[0].getPassword())) == 0) {
						JOptionPane.showMessageDialog(null, "password too short");
					} else {
						JOptionPane.showMessageDialog(null, "password too light");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter a valid email");
				}

			} else {
				JOptionPane.showMessageDialog(null, "One or more Required Field are empty");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Password Doesn't Match");
		}
	}
}
