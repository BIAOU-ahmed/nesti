/**
 * 
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nesti.ChangePassword;
import nesti.Check;
import nesti.PasswordField;
import nesti.QueryUsers;

/**
 * @author ahmed
 *
 */
public class UpdatePassWordListener implements ActionListener{
	PasswordField passWord[];
	JFrame frame;
			public UpdatePassWordListener(PasswordField passWord[],JFrame frame) {
				// TODO Auto-generated constructor stub
				this.passWord = passWord;
				this.frame =frame;
			}
	public void actionPerformed(ActionEvent e) {
		if (String.valueOf(passWord[1].getPassword()).equals(String.valueOf(passWord[2].getPassword()))) {
			if (String.valueOf(passWord[0].getPassword()).equals(ChangePassword.user.getPassword())) {
				if (Check.calculatePasswordStrength(String.valueOf(passWord[1].getPassword())) >= 9) {
					ChangePassword.user.setPassword(String.valueOf(passWord[1].getPassword()));
					if(QueryUsers.updatePsw(ChangePassword.user)) {
						JOptionPane.showMessageDialog(null, "Password Update succesfull");
						frame.setVisible(false);
					}
					
				}else {
					System.out.println("trop faible mot de passe");
				}
			}else {
				System.out.println("verifier le mot de passe actuel");
			}
		}else {
			System.out.println("entrer deux mot de passe identique");
		}
	}
}
