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

	public Labels(int x, int y,int heigth, int width,String value, Font font) {
		
		this.setText(value);
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setFont(font);
		this.setBounds(x, y, heigth, width);
		
	}
}
