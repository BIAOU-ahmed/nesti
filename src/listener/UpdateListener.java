/**
 * 
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import nesti.Check;
import nesti.Informations;
import nesti.QueryUsers;
import nesti.TextField;
import nesti.Users;

/**
 * @author ahmed
 *
 */
public class UpdateListener implements ActionListener{
	TextField listTextField[];
	Users user;
	public UpdateListener(TextField listTextField[],Users user) {
		
		this.listTextField = listTextField;
		this.user = user;
	}
	
	public void actionPerformed(ActionEvent e) {

		if (listTextField[1].isEditable()) {

			if (!listTextField[1].getText().isEmpty()) {
				if (Check.isValidEmail(listTextField[1].getText())) {
					user = new Users(user.getUserName(), user.getPassword(), listTextField[1].getText(),
							listTextField[2].getText(), listTextField[3].getText(), listTextField[4].getText());
					if (QueryUsers.updateById(user)) {
						JOptionPane.showMessageDialog(null, "Update succesfull");
						listTextField[1].setEditable(false);
						listTextField[2].setEditable(false);
						listTextField[3].setEditable(false);
						listTextField[4].setEditable(false);
						Informations.user = this.user;
					} else {
						JOptionPane.showMessageDialog(null, "update fail");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter a valid email");
				}

			} else {
				JOptionPane.showMessageDialog(null, "One or more Required Field are empty");
			}
		} else {

			listTextField[1].setEditable(true);
			listTextField[2].setEditable(true);
			listTextField[3].setEditable(true);
			listTextField[4].setEditable(true);
		}
	}
	
}
