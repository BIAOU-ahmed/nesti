/**
 * 
 */
package nesti;

import javax.swing.JTextField;

/**
 * @author ahmed
 *
 */
public class TextField extends JTextField {

	public TextField(int x, int y,String name) {
		// TODO Auto-generated constructor stub
	
//		lblUsername.setLabelFor(textFieldUsername);
		this.setName(name);
		this.setBounds(x, y, 301, 50);
		
		this.setColumns(10);
	}
	

}
