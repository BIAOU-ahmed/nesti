/**
 * 
 */
package nesti;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * @author ahmed
 *
 */
public class Buttons extends JButton{

	public Buttons(int x, int y, int heigth, int width,String text,Color font) {
		
		
		this.setText(text);
		this.setBackground(font);
		this.setFont(new Font("Arial", Font.BOLD, 24));
		this.setBounds(x, y, heigth, width);
		
	}
}
