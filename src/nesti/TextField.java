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

	public TextField(int x, int y, int heigth, int width,String value) {
		// TODO Auto-generated constructor stub
	
//		lblUsername.setLabelFor(textFieldUsername);
		
		this.setText(value);
		this.setBounds(x, y, heigth, width);
		
		this.setColumns(10);
	}
	

}
