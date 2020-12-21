/**
 * 
 */
package nesti;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author ahmed
 *
 */
public class Labels extends JLabel {

	public Labels(int x, int y,String value) {
		// TODO Auto-generated constructor stub
		
		this.setText(value);
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.setBounds(x, y, 116, 57);
		
	}
}
