/**
 * 
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.lambdaworks.crypto.SCryptUtil;

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
	JDialog frame;
			public UpdatePassWordListener(PasswordField passWord[],JDialog changePassword) {
				
				this.passWord = passWord;
				this.frame =changePassword;
			}
	public void actionPerformed(ActionEvent e) {
		if (String.valueOf(passWord[1].getPassword()).equals(String.valueOf(passWord[2].getPassword()))) {
			boolean matched = SCryptUtil.check(String.valueOf(passWord[0].getPassword()), ChangePassword.user.getPassword());
			if (matched) {
				if (Check.calculatePasswordStrength(String.valueOf(passWord[1].getPassword())) >= 9) {
					ChangePassword.user.setPassword(String.valueOf(passWord[1].getPassword()));
					if(QueryUsers.updatePsw(ChangePassword.user)) {
						JOptionPane.showMessageDialog(null, "Password Update succesfull");
						frame.setVisible(false);
					}
					
				}else {
					System.out.println("Mot de passe trop faible");
				}
			}else {
				System.out.println("Verifier le mot de passe actuel");
			}
		}else {
			System.out.println("Entrer deux mot de passe identique");
		}
	}
}
